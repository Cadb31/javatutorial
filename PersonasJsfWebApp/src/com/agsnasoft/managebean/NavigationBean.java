package com.agsnasoft.managebean;

import java.io.Serializable;

public class NavigationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String PAGE_INSERTAR = "/Insertar.xhtml";
	public static final String PAGE_CONSULTAR = "/Consultar.xhtml";
	public static final String PAGE_MODIFICAR = "/Modificar.xhtml";
	public static final String PAGE_ELIMINAR = "/Eliminar.xhtml";
	
	private static final String PAGE_OK = "/PageOK.xhtml";
	private static final String PAGE_KO = "/PageKO.xhtml";
	private static final String PAGE_LISTAR_PERSONA = "/ListarPersona.xhtml";
	private static final String PAGE_MODIFICAR_PERSONA = "/ModificarPersona.xhtml";
	private static final String PAGE_ELIMINAR_PERSONA = "/EliminarPersona.xhtml";

	public String toPageInsertar() {
		return PAGE_INSERTAR;
	}

	public String toPageConsultar() {
		return PAGE_CONSULTAR;
	}

	public String toPageModificar() {
		return PAGE_MODIFICAR;
	}
	
	public String toPageEliminar() {
		return PAGE_ELIMINAR;
	}
	
	public String toPageOK() {
		return PAGE_OK;
	}

	public String toPageKO() {
		return PAGE_KO;
	}

	public String toListarPersona() {
		return PAGE_LISTAR_PERSONA;
	}

	public String toModificarPersona() {
		return PAGE_MODIFICAR_PERSONA;
	}

	public String toEliminarPersona() {
		return PAGE_ELIMINAR_PERSONA;
	}
}
