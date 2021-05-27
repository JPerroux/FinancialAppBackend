package com.uy.financialApp.financialTools.acciones.external.dto;

public class ActionInfoDTO {
	
	private String cierreAnterior;
	private String intervaloDelDia;
	private String intervaloAnual;
	private String capitalBursatil;
	private String volumen;
	private String relPrecioBeneficio;
	private String rendPorDividendos;
	private String califClimatica;
	private String mercadoPrimario;

	public ActionInfoDTO() {
	}

	public ActionInfoDTO(String cierreAnterior, String intervaloDelDia, String intervaloAnual, String capitalBursatil,
			String volumen, String relPrecioBeneficio, String mercadoPrimario, String califClimatica, String rendPorDividendos) {
		this.cierreAnterior = cierreAnterior;
		this.intervaloDelDia = intervaloDelDia;
		this.intervaloAnual = intervaloAnual;
		this.capitalBursatil = capitalBursatil;
		this.volumen = volumen;
		this.relPrecioBeneficio = relPrecioBeneficio;
		this.mercadoPrimario = mercadoPrimario;
		this.califClimatica = califClimatica;
		this.rendPorDividendos = rendPorDividendos;
	}

	public String getCierreAnterior() {
		return cierreAnterior;
	}

	public void setCierreAnterior(String cierreAnterior) {
		this.cierreAnterior = cierreAnterior;
	}

	public String getIntervaloDelDia() {
		return intervaloDelDia;
	}

	public void setIntervaloDelDia(String intervaloDelDia) {
		this.intervaloDelDia = intervaloDelDia;
	}

	public String getIntervaloAnual() {
		return intervaloAnual;
	}

	public void setIntervaloAnual(String intervaloAnual) {
		this.intervaloAnual = intervaloAnual;
	}

	public String getCapitalBursatil() {
		return capitalBursatil;
	}

	public void setCapitalBursatil(String capitalBursatil) {
		this.capitalBursatil = capitalBursatil;
	}

	public String getVolumen() {
		return volumen;
	}

	public void setVolumen(String volumen) {
		this.volumen = volumen;
	}

	public String getRelPrecioBeneficio() {
		return relPrecioBeneficio;
	}

	public void setRelPrecioBeneficio(String relPrecioBeneficio) {
		this.relPrecioBeneficio = relPrecioBeneficio;
	}

	public String getMercadoPrimario() {
		return mercadoPrimario;
	}

	public void setMercadoPrimario(String mercadoPrimario) {
		this.mercadoPrimario = mercadoPrimario;
	}

	public String getCalifClimatica() {
		return califClimatica;
	}

	public void setCalifClimatica(String califClimatica) {
		this.califClimatica = califClimatica;
	}

	public String getRendPorDividendos() {
		return rendPorDividendos;
	}

	public void setRendPorDividendos(String rendPorDividendos) {
		this.rendPorDividendos = rendPorDividendos;
	}
	
	public void setValues(int index, String value) {
		switch (index) {
		case 5:
			this.setCierreAnterior(value);
			break;
		case 6:
			this.setIntervaloDelDia(value);
			break;
		case 7:
			this.setIntervaloAnual(value);
			break;
		case 8:
			this.setCapitalBursatil(value);
			break;
		case 9:
			this.setVolumen(value);
			break;
		case 10:
			this.setRelPrecioBeneficio(value);
			break;
		case 11:
			this.setRendPorDividendos(value);
			break;
		case 12:
			this.setCalifClimatica(value);
			break;
		case 13:
			this.setMercadoPrimario(value);
			break;	
		default:
			System.out.println("Te has pasado");
			break;
		}
	}
}