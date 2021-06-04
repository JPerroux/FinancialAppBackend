package com.uy.financialApp.financialTools.acciones.external.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonedaDTO {
	
	private short codigo;
	private String nombre;
	private double venta;
	private double compra;
}