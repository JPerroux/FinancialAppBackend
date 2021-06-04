package com.uy.financialApp.financialTools.acciones.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uy.financialApp.financialTools.acciones.entity.Action;
import com.uy.financialApp.financialTools.acciones.repository.ActionRepository;

@Service
@Transactional
public class ActionService {

	@Autowired
	ActionRepository actionRepository;
	
	public List<Action> list() {
		return actionRepository.findAll();
	}
	
	public Optional<Action> findById(int id) {
		return actionRepository.findById(id);
	}
	
	public Optional<Action> findByUrl(String url){
		return actionRepository.findByUrl(url);
	}
	
	public void save(Action action) {
		actionRepository.save(action);
	}
	
	public void delete(int id) {
		actionRepository.deleteById(id);
	}
	
	public boolean existsById(int id) {
		return actionRepository.existsById(id);
	}
	
	public boolean existsByUrl(String url) {
		return actionRepository.existsByUrl(url);
	}
	
	public boolean existsByName(String name) {
		return actionRepository.existsByName(name);
	}	
}