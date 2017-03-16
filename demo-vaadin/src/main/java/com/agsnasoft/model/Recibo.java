package com.agsnasoft.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Recibo {

	private String numRecibo;
	private String importe;
	private String mc;
	private String fEmision;
	private String fEfecto;
	private String situacion;
	private String fSituacion;

	public Recibo() {
		super();
	}

	public Recibo(String numRecibo, String importe, String mc, String fEmision, String fEfecto, String situacion,
			String fSituacion) {
		super();
		this.numRecibo = numRecibo;
		this.importe = importe;
		this.mc = mc;
		this.fEmision = fEmision;
		this.fEfecto = fEfecto;
		this.situacion = situacion;
		this.fSituacion = fSituacion;
	}

	public String getNumRecibo() {
		return numRecibo;
	}

	public void setNumRecibo(String numRecibo) {
		this.numRecibo = numRecibo;
	}

	public String getImporte() {
		return importe;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public String getfEmision() {
		return fEmision;
	}

	public void setfEmision(String fEmision) {
		this.fEmision = fEmision;
	}

	public String getfEfecto() {
		return fEfecto;
	}

	public void setfEfecto(String fEfecto) {
		this.fEfecto = fEfecto;
	}

	public String getSituacion() {
		return situacion;
	}

	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}

	public String getfSituacion() {
		return fSituacion;
	}

	public void setfSituacion(String fSituacion) {
		this.fSituacion = fSituacion;
	}

}
