package com.uy.financialApp.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uy.financialApp.security.entity.Rol;
import com.uy.financialApp.security.enums.RolName;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
	Optional<Rol> findByRolName(RolName rolName);
}