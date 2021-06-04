package com.uy.financialApp.financialTools.acciones.external.services;

import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Service;

import com.uy.financialApp.financialTools.acciones.external.cotiza.ArrayOfint;
import com.uy.financialApp.financialTools.acciones.external.cotiza.Wsbcucotizaciones;
import com.uy.financialApp.financialTools.acciones.external.cotiza.WsbcucotizacionesExecute;
import com.uy.financialApp.financialTools.acciones.external.cotiza.WsbcucotizacionesExecuteResponse;
import com.uy.financialApp.financialTools.acciones.external.cotiza.WsbcucotizacionesSoapPort;
import com.uy.financialApp.financialTools.acciones.external.cotiza.Wsbcucotizacionesin;
import com.uy.financialApp.financialTools.acciones.external.cotiza.Wsbcucotizacionesout;
import com.uy.financialApp.financialTools.acciones.external.cotiza.Wsultimocierre;
import com.uy.financialApp.financialTools.acciones.external.cotiza.WsultimocierreExecuteResponse;
import com.uy.financialApp.financialTools.acciones.external.cotiza.WsultimocierreSoapPort;
import com.uy.financialApp.financialTools.acciones.external.cotiza.Wsultimocierreout;
import com.uy.financialApp.financialTools.acciones.external.dto.MonedaDTO;

@Service
public class CotizationService {
	// Regresa dolar y unidad indexada
	public List<MonedaDTO> getCotization() {
		List<MonedaDTO> response = new ArrayList<MonedaDTO>();

		
		Wsbcucotizaciones cotizaciones = new Wsbcucotizaciones();
		WsbcucotizacionesSoapPort servicio = cotizaciones.getWsbcucotizacionesSoapPort();

		Wsbcucotizacionesin entrada = new Wsbcucotizacionesin();
		
		ArrayOfint array = new ArrayOfint();
		array.getItem().add((short) 2225);
		array.getItem().add((short) 9800);
		entrada.setMoneda(array);
		XMLGregorianCalendar fecha = this.getCierre();
		entrada.setFechaDesde(fecha);
		entrada.setFechaHasta(fecha);
		entrada.setGrupo((byte) 2);
		
		WsbcucotizacionesExecute parameter = new WsbcucotizacionesExecute();
		parameter.setEntrada(entrada);
		
		WsbcucotizacionesExecuteResponse resp = servicio.execute(parameter);
		Wsbcucotizacionesout out = resp.getSalida();
		out.getDatoscotizaciones().getDatoscotizacionesDato().forEach(data -> {
			response.add(new MonedaDTO(data.getMoneda(), data.getNombre(), data.getTCV(), data.getTCV()));
		});
		return response;
	}
	
	private XMLGregorianCalendar getCierre() {
		Wsultimocierre cierre = new Wsultimocierre();
		WsultimocierreSoapPort servicio = cierre.getWsultimocierreSoapPort();
		WsultimocierreExecuteResponse resp = servicio.execute(null);
		Wsultimocierreout out = resp.getSalida();
		
		return out.getFecha();
	}
}