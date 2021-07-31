package com.uy.financialApp.security.util;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.uy.financialApp.financialTools.acciones.entity.Action;
import com.uy.financialApp.financialTools.acciones.service.ActionService;
import com.uy.financialApp.security.entity.Rol;
import com.uy.financialApp.security.entity.Usuario;
import com.uy.financialApp.security.enums.RolName;
import com.uy.financialApp.security.entity.Rol;
import com.uy.financialApp.security.entity.Usuario;
import com.uy.financialApp.security.enums.RolName;
import com.uy.financialApp.security.service.RolService;
import com.uy.financialApp.security.service.UserService;

@SuppressWarnings("unused")
@Component
public class CreateRoles implements CommandLineRunner {

	@Autowired
	RolService rolService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ActionService actionService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	@Override
	public void run(String... args) throws Exception {
		Usuario admin = new Usuario();
		
		admin.setName("admin");
		admin.setUserName("admin");
		admin.setEmail("a@a.a");
		admin.setPassword(passwordEncoder.encode("password"));
		
		Set<Rol> roles = new HashSet<Rol>();
		Rol rolAdmin = new Rol(RolName.ROLE_ADMIN);
		Rol rolUser = new Rol(RolName.ROLE_USER);
		roles.add(rolAdmin);
		roles.add(rolUser);
		
		admin.setRoles(roles);
		
		rolService.save(rolAdmin);
		rolService.save(rolUser);
		
		userService.save(admin);
		Action coinbase = new Action("Coinbase", "COIN:NASDAQ", (float) 0.183864, 
				"13-5-2021", "31", 0.0, 0);
		Action xlffss = new Action("XLF Finance", "XLF:NYSEARCA", (float) 70.0, 
				"01-3-2019", "31", 0.0, 0);
		Action virgingalactic = new Action("Virgin galactic", "SPCE:NYSE", (float) 5.88, 
				"14-7-2021", "31", 0.0, 0);
		Action lyft = new Action("Lyft", "LYFT:NASDAQ", (float) 1.8, 
				"15-7-2021", "31", 0.0, 0);
		actionService.save(coinbase);
		actionService.save(xlffss);
		actionService.save(virgingalactic);
		actionService.save(lyft);
	}
}