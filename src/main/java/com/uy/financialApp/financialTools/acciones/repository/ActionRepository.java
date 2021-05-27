package com.uy.financialApp.financialTools.acciones.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uy.financialApp.financialTools.acciones.entity.Action;

@Repository
public interface ActionRepository extends JpaRepository<Action, Integer>{
	
	Optional<Action> findByUrl(String name);
	Optional<Action> findById(int id);
	
	boolean existsByUrl(String url);
	boolean existsById(int id);
	boolean existsByName(String name);
}