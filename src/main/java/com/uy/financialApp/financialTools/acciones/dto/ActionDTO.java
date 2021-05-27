package com.uy.financialApp.financialTools.acciones.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.uy.financialApp.financialTools.acciones.entity.Action;

public class ActionDTO {
	
	private int id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String url;
	
	@Min(0)
	private float quantity;
	
	@NotBlank
	private String purchaseDate;
	
	@NotBlank
	private String purchaseValue;
	private String actualValue;
	private String status;
	private String moneda;
	private float builtInValue;
	private float position;
	private float spread;
	
	public ActionDTO build(Action action) {
		ActionDTO actionDTO = new ActionDTO(action.getId(), action.getName(), action.getUrl(), action.getQuantity(),
				action.getPurchaseDate(), action.getPurchaseValue(), action.getStatus().toString(), 
				action.getMoneda().toString());
		return actionDTO;
	}
	 
	public ActionDTO(int id, String name, String url, float quantity, String purchaseDate, String purchaseValue, String status,
			String moneda) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.quantity = quantity;
		this.purchaseDate = purchaseDate;
		this.purchaseValue = purchaseValue;
		this.status = status;
		this.moneda = moneda;
	}

	public ActionDTO() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getPurchaseValue() {
		return purchaseValue;
	}

	public void setPurchaseValue(String purchaseValue) {
		this.purchaseValue = purchaseValue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public float getBuiltInValue() {
		return builtInValue;
	}

	public void setBuiltInValue(float builtInValue) {
		this.builtInValue = builtInValue;
	}

	public float getPosition() {
		return position;
	}

	public void setPosition(float position) {
		this.position = position;
	}

	public float getSpread() {
		return spread;
	}

	public void setSpread(float spread) {
		this.spread = spread;
	}

	public String getActualValue() {
		return actualValue;
	}

	public void setActualValue(String actualValue) {
		this.actualValue = actualValue;
	}
}