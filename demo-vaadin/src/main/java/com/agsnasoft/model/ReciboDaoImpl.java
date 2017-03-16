package com.agsnasoft.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class ReciboDaoImpl implements ReciboDao {

	RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Override
	public List<Recibo> getAll() {
		RestTemplate restTemplate = restTemplate(restTemplateBuilder);
		
		@SuppressWarnings("unchecked")
		List<LinkedHashMap<String, String>> recibos = restTemplate.getForObject(
				"http://localhost:8080/recibos", List.class);
		
		List<Recibo> recibosList = new ArrayList<Recibo>();				
		for (int i = 0; i < recibos.size(); i++) {
			LinkedHashMap<String , String> c = recibos.get(i);
			recibosList.add(new Recibo(c.get("numRecibo"), c.get("importe"), c.get("mc"), c.get("fEmision"), c.get("fEfecto"), c.get("situacion"), c.get("fSituacion")));
		}
		return recibosList;
	}

	@Override
	public List<CabeceraRecibo> getAllCabecera() {
		RestTemplate restTemplate = restTemplate(restTemplateBuilder);
		
		@SuppressWarnings("unchecked")
		List<LinkedHashMap<String, String>> cabecera = restTemplate.getForObject(
				"http://localhost:8080/cabecera", List.class);
		
		List<CabeceraRecibo> cabeceraList = new ArrayList<CabeceraRecibo>();		
		for (int i = 0; i < cabecera.size(); i++) {
			LinkedHashMap<String , String> c = cabecera.get(i);
			cabeceraList.add(new CabeceraRecibo(c.get("nombreCabecera"), c.get("descripcionCabecera")));
		}

		return cabeceraList;
	}
}
