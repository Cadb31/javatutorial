package com.springboot.rest.model;

import java.util.List;

public interface ReciboDao {
	
	public List<CabeceraRecibo> getCabeceraAll();
	
	public List<Recibo> getRecibosAll();

}
