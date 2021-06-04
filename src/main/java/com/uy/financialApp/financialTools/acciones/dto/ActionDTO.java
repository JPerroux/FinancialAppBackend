package com.uy.financialApp.financialTools.acciones.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.uy.financialApp.financialTools.acciones.entity.Action;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
	private double builtInValue;
	private double position;
	private double spread;
	private double dividendos;
	
	public ActionDTO build(Action action) {
		ActionDTO actionDTO = new ActionDTO(action.getId(), action.getName(), action.getUrl(), action.getQuantity(),
				action.getPurchaseDate(), action.getPurchaseValue(), action.getStatus().toString(), 
				action.getMoneda().toString(), action.getDividendos());
		return actionDTO;
	}
	 
	public ActionDTO(int id, String name, String url, float quantity, String purchaseDate, String purchaseValue, String status,
			String moneda, double dividendos) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.quantity = quantity;
		this.purchaseDate = purchaseDate;
		this.purchaseValue = purchaseValue;
		this.status = status;
		this.moneda = moneda;
		this.dividendos = dividendos;
	}
}