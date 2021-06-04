package com.uy.financialApp.security.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class NewUserDTO {
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String userName;
	
	@Email
	private String email;
	
	@NotBlank
	private String password;
	
	private Set<String> roles = new HashSet<>();
}