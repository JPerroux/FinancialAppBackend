package com.uy.financialApp.financialTools.acciones.external.dto;

public class MonedaDTO {
	
	private short codigo;
	private String nombre;
	private double venta;
	private double compra;
	
	public MonedaDTO() {
	}

	public MonedaDTO(short codigo, String nombre, double venta, double compra) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.venta = venta;
		this.compra = compra;
	}

	public short getCodigo() {
		return codigo;
	}

	public void setCodigo(short codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getVenta() {
		return venta;
	}

	public void setVenta(double venta) {
		this.venta = venta;
	}

	public double getCompra() {
		return compra;
	}

	public void setCompra(double compra) {
		this.compra = compra;
	}

	@Override
	public String toString() {
		return "Codigo: " + this.codigo + " Nombre: " + this.nombre + 
				" Compra: " + this.compra + " Venta: " + this.venta;
	}
	
	
}
