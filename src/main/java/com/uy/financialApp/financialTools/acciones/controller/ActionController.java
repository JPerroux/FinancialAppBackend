package com.uy.financialApp.financialTools.acciones.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uy.financialApp.financialTools.acciones.dto.ActionDTO;
import com.uy.financialApp.financialTools.acciones.entity.Action;
import com.uy.financialApp.financialTools.acciones.enums.Moneda;
import com.uy.financialApp.financialTools.acciones.enums.Status;
import com.uy.financialApp.financialTools.acciones.external.dto.ActionInfoDTO;
import com.uy.financialApp.financialTools.acciones.external.dto.MonedaDTO;
import com.uy.financialApp.financialTools.acciones.external.services.CotizationService;
import com.uy.financialApp.financialTools.acciones.external.services.WebScrapService;
import com.uy.financialApp.financialTools.acciones.service.ActionService;
import com.uy.financialApp.util.MessageDTO;

@RestController
@RequestMapping("/action")
@CrossOrigin
public class ActionController {
	
	@Autowired
	ActionService actionService;
	
	@Autowired
	CotizationService cotizationService;
	
	@Autowired
	WebScrapService webScrapService;
	
	@GetMapping("/list")
	public ResponseEntity<List<ActionDTO>> list() {
		List<ActionDTO> list = new ArrayList<>();
		actionService.list().forEach(action -> list.add(new ActionDTO().build(action)));
		return new ResponseEntity<List<ActionDTO>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/action/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") int id){
		if(!actionService.existsById(id))
			return new ResponseEntity<MessageDTO>(new MessageDTO("No existe la accion"), HttpStatus.BAD_REQUEST);
		Action action = actionService.findById(id).get();
		return new ResponseEntity<ActionDTO>(new ActionDTO().build(action), HttpStatus.OK);
	}
	
	@PostMapping("/action")
	public ResponseEntity<?> create(@RequestBody ActionDTO actionDTO) {
		if(StringUtils.isBlank(actionDTO.getName()))
			return new ResponseEntity<MessageDTO>(new MessageDTO("obligatoryName"), HttpStatus.BAD_REQUEST);
		if(actionDTO.getQuantity() < 0)
			return new ResponseEntity<MessageDTO>(new MessageDTO("quantityMinus"), HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(actionDTO.getPurchaseValue()))
			return new ResponseEntity<MessageDTO>(new MessageDTO("nullValue"), HttpStatus.BAD_REQUEST);
		Action action = new Action(actionDTO.getName(), actionDTO.getUrl(), actionDTO.getQuantity(), 
				actionDTO.getPurchaseDate(), actionDTO.getPurchaseValue(), actionDTO.getCloseValue(), actionDTO.getLeverage()); 
		actionService.save(action);
		return new ResponseEntity<MessageDTO>(new MessageDTO("Accion creada"), HttpStatus.CREATED);
	}
	
	@PutMapping("/action/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ActionDTO actionDTO) {
		try {
			if(!actionService.existsById(id))
				return new ResponseEntity<MessageDTO>(new MessageDTO("No existe la accion"), HttpStatus.BAD_REQUEST);
			if(StringUtils.isBlank(actionDTO.getName()))
				return new ResponseEntity<MessageDTO>(new MessageDTO("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
			if(actionDTO.getQuantity() == 0 || actionDTO.getQuantity() < 0)
				return new ResponseEntity<MessageDTO>(new MessageDTO("La cantidad debe ser mayor a 0"), HttpStatus.BAD_REQUEST);
			if(StringUtils.isBlank(actionDTO.getPurchaseValue()))
				return new ResponseEntity<MessageDTO>(new MessageDTO("Debe ingresar el valor de la accion"), HttpStatus.BAD_REQUEST);
			if(actionService.existsByUrl(actionDTO.getUrl()) && actionService.findByUrl(actionDTO.getUrl()).get().getId() != id)
				return new ResponseEntity<MessageDTO>(new MessageDTO("Ya existe un accion con esta url"), HttpStatus.BAD_REQUEST);
			Action action = actionService.findById(id).get();
			action.setName(actionDTO.getName());
			action.setUrl(actionDTO.getUrl());
			action.setQuantity(actionDTO.getQuantity());
			action.setActualValue(actionDTO.getActualValue());
			action.setPurchaseDate(actionDTO.getPurchaseDate());
			action.setPurchaseValue(actionDTO.getPurchaseValue()); 
			action.setLeverage(actionDTO.getLeverage());
			String moneda = actionDTO.getMoneda().toUpperCase();
			action.setMoneda(Moneda.valueOf(moneda));
			action.setStatus(Status.valueOf(actionDTO.getStatus()));
			actionService.save(action);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<MessageDTO>(new MessageDTO("Accion actualizada"), HttpStatus.OK);
	}
	
	@PatchMapping("/action/{id}")
	public ResponseEntity<?> close(@PathVariable("id") int id, @RequestBody ActionDTO actionDTO) {
		try {
			if(!actionService.existsById(id))
				return new ResponseEntity<MessageDTO>(new MessageDTO("No existe la accion"), HttpStatus.BAD_REQUEST);
			if(StringUtils.isBlank(actionDTO.getName()))
				return new ResponseEntity<MessageDTO>(new MessageDTO("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
			if(actionDTO.getQuantity() == 0 || actionDTO.getQuantity() < 0)
				return new ResponseEntity<MessageDTO>(new MessageDTO("La cantidad debe ser mayor a 0"), HttpStatus.BAD_REQUEST);
			if(StringUtils.isBlank(actionDTO.getPurchaseValue()))
				return new ResponseEntity<MessageDTO>(new MessageDTO("Debe ingresar el valor de la accion"), HttpStatus.BAD_REQUEST);
			if(actionService.existsByUrl(actionDTO.getUrl()) && actionService.findByUrl(actionDTO.getUrl()).get().getId() != id)
				return new ResponseEntity<MessageDTO>(new MessageDTO("Ya existe un accion con esta url"), HttpStatus.BAD_REQUEST);
			Action action = actionService.findById(id).get();
			action.setDividendos(actionDTO.getDividendos());
			action.setStatus(Status.valueOf(actionDTO.getStatus()));
			action.setCloseValue(actionDTO.getCloseValue());
			actionService.save(action);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<MessageDTO>(new MessageDTO("Accion actualizada"), HttpStatus.OK);
	}
	
	@DeleteMapping("/action/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if(!actionService.existsById(id))
			return new ResponseEntity<MessageDTO>(new MessageDTO("No existe la accion"), HttpStatus.BAD_REQUEST);
		actionService.delete(id);
		return new ResponseEntity<MessageDTO>(new MessageDTO("Accion eliminada"), HttpStatus.OK);	
	}
	
	@GetMapping("/cotization")
	public ResponseEntity<List<MonedaDTO>> cotizations() {
		List<MonedaDTO> list = new ArrayList<>();
		list = cotizationService.getCotization();
		return new ResponseEntity<List<MonedaDTO>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/checkToken/{token}")
	public ResponseEntity<Boolean> check(@PathVariable("token") String token){
		boolean exists = false;
		try {
			exists = webScrapService.checkUrl(token);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return new ResponseEntity<Boolean>(exists, HttpStatus.OK);
	}
	
	@GetMapping("/info/{token}")
	public ResponseEntity<ActionInfoDTO> getActionInfo(@PathVariable("token") String token){
		ActionInfoDTO res = new ActionInfoDTO();
		try {
			res = webScrapService.getActionInfo(token);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return new ResponseEntity<ActionInfoDTO>(res, HttpStatus.OK);
	}
	
	@PostMapping("/value/{id}")
	public ResponseEntity<?> updateByValue(@PathVariable("id") int id, @RequestBody ActionDTO actionDTO) {
		if(!actionService.existsById(id))
			return new ResponseEntity<MessageDTO>(new MessageDTO("No existe la accion"), HttpStatus.BAD_REQUEST);
		ActionDTO res = webScrapService.updateActionByValue(actionDTO);
		return new ResponseEntity<ActionDTO>(res, HttpStatus.OK);
	}
	
	@PostMapping("/values")
	public ResponseEntity<?> updateByValues(@RequestBody List<ActionDTO> actionDTOs) {
		List<ActionDTO> res = new ArrayList<ActionDTO>();
		for(ActionDTO actionDTO: actionDTOs) {
			if(actionService.existsById(actionDTO.getId())) {
				res.add(webScrapService.updateActionByValue(actionDTO));
			}	
		}
		return new ResponseEntity<List<ActionDTO>>(res, HttpStatus.OK);
	}
}