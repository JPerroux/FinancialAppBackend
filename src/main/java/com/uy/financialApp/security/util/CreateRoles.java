package com.uy.financialApp.security.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.uy.financialApp.security.entity.User;
//import com.uy.financialApp.security.entity.Rol;
//import com.uy.financialApp.security.enums.RolName;
import com.uy.financialApp.security.service.RolService;
import com.uy.financialApp.security.service.UserService;

@Component
public class CreateRoles implements CommandLineRunner {

	@Autowired
	RolService rolService;
	
	@Autowired
	UserService userService;
	
	@Override
	public void run(String... args) throws Exception {
		//User admin = new User("a@a.a", "admin", "password", "Admin");
//		Rol rolUser = new Rol(RolName.ROLE_USER); hello
//		
		//userService.save(admin);
//		rolService.save(rolUser);
	}
}