package com.uy.financialApp.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uy.financialApp.security.entity.Usuario;
import com.uy.financialApp.security.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public Optional<Usuario> getByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
	
	public boolean existsByUserName(String userName) {
		return userRepository.existsByUserName(userName);
	}
	
	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}
	
	public void save(Usuario user) {
		userRepository.save(user);
	}
}