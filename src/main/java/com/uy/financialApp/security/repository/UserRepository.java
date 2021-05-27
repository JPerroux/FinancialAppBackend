package com.uy.financialApp.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uy.financialApp.security.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUserName(String userName);
	boolean existsByUserName(String userName);
	boolean existsByEmail(String email);
}