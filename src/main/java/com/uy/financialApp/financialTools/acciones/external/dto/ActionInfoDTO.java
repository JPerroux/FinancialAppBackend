package com.uy.financialApp.financialTools.acciones.external.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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