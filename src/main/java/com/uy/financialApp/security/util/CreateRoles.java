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
import com.uy.financialApp.security.service.RolService;
import com.uy.financialApp.security.service.UserService;

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
		Action xleess = new Action("XLE Energy select sector", "XLE:NYSEARCA", (float) 0.0, 
				"28-5-2021", "31");
		/*Action pev = new Action("Parque eolico valentines", actionDTO.getUrl(), actionDTO.getQuantity(), 
				actionDTO.getPurchaseDate(), actionDTO.getPurchaseValue());*/
		Action xlffss = new Action("XLF Finance select sector", "XLF:NYSEARCA", (float) 70.0, 
				"28-5-2021", "31");
		Action ewsmscibcetf = new Action("EWZ MSCI Brazil Capped ETF", "EWZS:NASDAQ", (float) 83.0, 
				"28-5-2021", "31");
		/*Action etoro = new Action("E toro", actionDTO.getUrl(), actionDTO.getQuantity(), 
				actionDTO.getPurchaseDate(), actionDTO.getPurchaseValue());*/
		Action pinterest = new Action("Pinterest", "PINS:NYSE", (float) 10.0, 
				"28-5-2021", "31");
		Action petrobras = new Action("Petrobras 1", "PBR:NYSE", (float) 500.0, 
				"28-5-2021", "31");
		Action hhtzgq = new Action("Hertz HTZGQ", "HTZGQ:OTMKTS", (float) 70.0, 
				"28-5-2021", "31");
		actionService.save(xleess);
		//actionService.save(pev);
		actionService.save(xlffss);
		actionService.save(ewsmscibcetf);
		//actionService.save(etoro);
		actionService.save(pinterest);
		actionService.save(petrobras);
		actionService.save(hhtzgq);
	}
}