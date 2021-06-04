package com.uy.financialApp.financialTools.acciones.external.services;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.uy.financialApp.financialTools.acciones.dto.ActionDTO;
import com.uy.financialApp.financialTools.acciones.external.dto.ActionInfoDTO;

@Service
public class WebScrapService {

	@Value("${app.scrap.url}")
	private String urlBase;

	public String getActionValue(String token) throws IOException {
		Document doc = Jsoup.connect(urlBase + token).timeout(6000).get();
		Element actionValue = doc.select("div.YMlKec.fxKBKc").first();
		if (actionValue == null)
			return null;
		String av = actionValue.text().substring(1);
		return av;
	}

	public ActionInfoDTO getActionInfo(String token) throws IOException {
		ActionInfoDTO res = new ActionInfoDTO();
		Document doc = Jsoup.connect(urlBase + token).timeout(6000).get();
		Element actionValue = doc.select("div.YMlKec.fxKBKc").first();
		if (actionValue == null)
			return null;
		for (int i = 5; i < 14; i++) {
			Element cierreElement = doc.select("div.P6K39C").get(i);
			res.setValues(i, cierreElement.text());
		}
		return res;
	}

	public boolean checkUrl(String token) throws IOException {
		boolean res = false;
		try {
			Document doc = Jsoup.connect(urlBase + token).timeout(6000).get();
			Element actionValue = doc.select("div.YMlKec.fxKBKc").first();
			if (actionValue != null)
				res = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public ActionDTO updateActionByValue(ActionDTO actionDTO) {

		try {
//			if (actionDTO.getStatus().equals("ABIERTA")) {
				String value = "";
				Float builtInValue = (float) 0.0;
				Float position = (float) 0.0;
				Float spread = (float) 0.0;
				value = getActionValue(actionDTO.getUrl());
				actionDTO.setActualValue(value);
				if (actionDTO.getPurchaseValue() != null && !actionDTO.getPurchaseValue().equals("")) {
					builtInValue = Float.valueOf(actionDTO.getPurchaseValue()) * actionDTO.getQuantity();
				}
				actionDTO.setBuiltInValue(builtInValue);
				if (value != null && !value.equals("")) {
					value = value.replace(",", "");
					position = Float.valueOf(value) * actionDTO.getQuantity();
				}
				actionDTO.setPosition(position);
				if ((value != null && !value.equals(""))
						&& (actionDTO.getPurchaseValue() != null && !actionDTO.getPurchaseValue().equals(""))) {
					spread = actionDTO.getQuantity()
							* (Float.valueOf(value) - Float.valueOf(actionDTO.getPurchaseValue()));
				}
				actionDTO.setSpread(spread);
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return actionDTO;
	}
}