package com.uy.financialApp.security.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserLoginDTO {
	
	@NotBlank
	private String userName;
	
	@NotBlank
	private String password;
}