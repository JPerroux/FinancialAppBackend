package com.uy.financialApp.security.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uy.financialApp.security.dto.JwtDTO;
import com.uy.financialApp.security.dto.NewUserDTO;
import com.uy.financialApp.security.dto.UserLoginDTO;
import com.uy.financialApp.security.entity.Rol;
import com.uy.financialApp.security.entity.Usuario;
import com.uy.financialApp.security.enums.RolName;
import com.uy.financialApp.security.jwt.JwtProvider;
import com.uy.financialApp.security.service.RolService;
import com.uy.financialApp.security.service.UserService;
import com.uy.financialApp.util.MessageDTO;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserService userService;
	
	@Autowired
	RolService rolService;
	
	@Autowired 
	JwtProvider jwtProvider;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/create")
	public ResponseEntity<?> nuevo(@Valid @RequestBody NewUserDTO newUser, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return new ResponseEntity(new MessageDTO("Campos mal puestos o email invalido"), HttpStatus.BAD_REQUEST);
		if(userService.existsByUserName(newUser.getUserName()))
			return new ResponseEntity(new MessageDTO("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
		if(userService.existsByEmail(newUser.getEmail()))
			return new ResponseEntity(new MessageDTO("Ese email ya existe"), HttpStatus.BAD_REQUEST);
		Usuario user = new Usuario(newUser.getName(), newUser.getUserName(), newUser.getEmail(),
				passwordEncoder.encode(newUser.getPassword()));
		Set<Rol> roles = new HashSet<>();
		roles.add(rolService.getByRolName(RolName.ROLE_USER).get());
		System.out.println(newUser.getRoles());
		if(newUser.getRoles().contains("admin"))
			roles.add(rolService.getByRolName(RolName.ROLE_ADMIN).get());
		user.setRoles(roles);
		userService.save(user);
		return new ResponseEntity(new MessageDTO("Usuario guardado"), HttpStatus.CREATED);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody UserLoginDTO userLogin, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return new ResponseEntity(new MessageDTO("Campos mal puestos"), HttpStatus.BAD_REQUEST);
		try {
			Authentication authentication =
					authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUserName(), userLogin.getPassword()));	
				SecurityContextHolder.getContext().setAuthentication(authentication);
				String jwt = jwtProvider.generateToken(authentication);
				UserDetails userDetails = (UserDetails) authentication.getPrincipal();
				JwtDTO jwtDTO = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
				return new ResponseEntity(jwtDTO, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new MessageDTO("Usuario o contraseña incorrectos"), HttpStatus.UNAUTHORIZED);
		}
		
	}
}