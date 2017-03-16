package com.springboot.rest.model;

public class CabeceraRecibo {

	private String nombreCabecera;
	private String descripcionCabecera;

	public CabeceraRecibo() {
		super();
	}

	public CabeceraRecibo(String nombreCabecera, String descripcionCabecera) {
		super();
		this.nombreCabecera = nombreCabecera;
		this.descripcionCabecera = descripcionCabecera;
	}

	public String getNombreCabecera() {
		return nombreCabecera;
	}

	public void setNombreCabecera(String nombreCabecera) {
		this.nombreCabecera = nombreCabecera;
	}

	public String getDescripcionCabecera() {
		return descripcionCabecera;
	}

	public void setDescripcionCabecera(String descripcionCabecera) {
		this.descripcionCabecera = descripcionCabecera;
	}

}
