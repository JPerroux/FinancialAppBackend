package com.uy.financialApp.financialTools.acciones.external.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.uy.financialApp.financialTools.acciones.external.cotiza.ArrayOfint;
import com.uy.financialApp.financialTools.acciones.external.cotiza.Datoscotizaciones;
import com.uy.financialApp.financialTools.acciones.external.cotiza.DatoscotizacionesDato;
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

		Wsultimocierre cierre = new Wsultimocierre();
		WsultimocierreSoapPort servicio1 = cierre.getWsultimocierreSoapPort();
		WsultimocierreExecuteResponse resp1 = servicio1.execute(null);
		Wsultimocierreout out1 = resp1.getSalida();

		Wsbcucotizaciones cotizaciones = new Wsbcucotizaciones();
		WsbcucotizacionesSoapPort servicio3 = cotizaciones.getWsbcucotizacionesSoapPort();

		Wsbcucotizacionesin entrada2 = new Wsbcucotizacionesin();
		ArrayOfint array = new ArrayOfint();
		array.getItem().add((short) 0);
		entrada2.setMoneda(array);
		entrada2.setFechaDesde(out1.getFecha());
		entrada2.setFechaHasta(out1.getFecha());
		entrada2.setGrupo((byte) 2);
		WsbcucotizacionesExecute parameter2 = new WsbcucotizacionesExecute();
		parameter2.setEntrada(entrada2);
		WsbcucotizacionesExecuteResponse resp3 = servicio3.execute(parameter2);
		Wsbcucotizacionesout out3 = resp3.getSalida();
		if (out3 != null) {
			Datoscotizaciones data = out3.getDatoscotizaciones();
			List<DatoscotizacionesDato> list = data.getDatoscotizacionesDato();
			for (DatoscotizacionesDato dato : list) {
				MonedaDTO monedaDTO = new MonedaDTO();
				monedaDTO.setCodigo(dato.getMoneda());
				monedaDTO.setNombre(dato.getNombre());
				monedaDTO.setCompra(dato.getTCC());
				monedaDTO.setVenta(dato.getTCV());
				response.add(monedaDTO);
			}
		}
		return response;
	}
}