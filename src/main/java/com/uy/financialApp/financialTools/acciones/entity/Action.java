package com.uy.financialApp.financialTools.acciones.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.uy.financialApp.financialTools.acciones.enums.Moneda;
import com.uy.financialApp.financialTools.acciones.enums.Status;

@Entity
public class Action {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(unique = true)
	private String name;
	
	@NotNull
	@Column(unique = true)
	private String url;
	
	@NotNull
	private Float quantity;
	
	@NotBlank
	private String purchaseDate;
	
	@NotBlank
	private String purchaseValue;
	
	private Status status;
	private String actualValue;
	private Moneda moneda;
	private double dividendos;
	
	public Action() {
	}

	public Action(@NotNull String name, @NotNull String url, @NotNull @Min(0) Float quantity,
			@NotBlank String purchaseDate, @NotBlank String purchaseValue) {
		this.name = name;
		this.url = url;
		this.quantity = quantity;
		this.purchaseDate = purchaseDate;
		this.purchaseValue = purchaseValue;
		this.status = Status.ABIERTA;
		this.moneda = Moneda.DOLAR;
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

	public Float getQuantity() {
		return quantity;
	}

	public void setQuantity(Float quantity) {
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getActualValue() {
		return actualValue;
	}

	public void setActualValue(String actualValue) {
		this.actualValue = actualValue;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public double getDividendos() {
		return dividendos;
	}

	public void setDividendos(double dividendos) {
		this.dividendos = dividendos;
	}
}