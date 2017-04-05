package com.agsnasoft.managebean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agsnasoft.java.dao.PersonaDao;
import com.agsnasoft.java.dao.PersonaDaoImpl;
import com.agsnasoft.java.model.Persona;

public class ControllerManageBean {

	private String idBusqueda;
	private NavigationBean navigationBean;
	private PersonaDao personaDao;
	private Persona persona;
	private List<Persona> personas;
	private String pagina;

	public ControllerManageBean() {
		initializeConnection();
	}

	public String insertarPersona() {		
		pagina = navigationBean.toPageKO();
		if (personaDao.insertarPersona(persona)) {
			pagina = navigationBean.toPageOK();
		}
		return pagina;
	}

	public String consultarPersona() {
		pagina = navigationBean.toPageKO();
		personas = new ArrayList<Persona>();
		
		if (idBusqueda.equals("*")) {
			personas = personaDao.consultarPersonas();
			if (personas.size() > 0) {
				pagina = navigationBean.toListarPersona();
			}
		} else {
			personas.add(personaDao.consultarPersona(new Persona(Integer.valueOf(idBusqueda), "", "", "", 0, "")));
			if (personas.size() > 0) {
				pagina = navigationBean.toListarPersona();
			}
		}

		for (Persona p : personas) {
			System.out.println(p.toString());
		}
		
		return pagina;
	}	
	
	public String consultarEliminarPersona(){
		pagina = navigationBean.toPageKO();
		persona = personaDao.consultarPersona(new Persona(Integer.valueOf(idBusqueda), "", "", "", 0, ""));
		if(persona != null){
			pagina = navigationBean.toEliminarPersona();
		}
		return pagina;
	}

	public String consultarModificarPersona(){
		pagina = navigationBean.toPageKO();
		persona = personaDao.consultarPersona(new Persona(Integer.valueOf(idBusqueda), "", "", "", 0, ""));
		if(persona != null){
			pagina = navigationBean.toModificarPersona();
		}
		return pagina;
	}
	
	public String eliminarPersona(){
		pagina = navigationBean.toPageKO();		
		if(personaDao.eliminarPersona(persona)){
			pagina = navigationBean.toPageOK();
		}
		return pagina;
	}

	public String modificarPersona(){
		pagina = navigationBean.toPageKO();		
		if(personaDao.eliminarPersona(persona)){
			pagina = navigationBean.toPageOK();
		}
		return pagina;
	}
	
	public String getIdBusqueda() {
		return idBusqueda;
	}

	public void setIdBusqueda(String idBusqueda) {
		this.idBusqueda = idBusqueda;
	}

	public NavigationBean getNavigationBean() {
		return navigationBean;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	private void initializeConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/personas", "root", "root");
			personaDao = new PersonaDaoImpl(connection);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
