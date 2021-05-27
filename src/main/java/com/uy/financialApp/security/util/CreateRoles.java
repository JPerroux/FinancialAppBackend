package com.uy.financialApp.security.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//import com.uy.financialApp.security.entity.Rol;
//import com.uy.financialApp.security.enums.RolName;
import com.uy.financialApp.security.service.RolService;

@Component
public class CreateRoles implements CommandLineRunner {

	@Autowired
	RolService rolService;
	
	@Override
	public void run(String... args) throws Exception {
//		Rol rolAdmin = new Rol(RolName.ROLE_ADMIN);
//		Rol rolUser = new Rol(RolName.ROLE_USER);
//		
//		rolService.save(rolAdmin);
//		rolService.save(rolUser);
	}
}