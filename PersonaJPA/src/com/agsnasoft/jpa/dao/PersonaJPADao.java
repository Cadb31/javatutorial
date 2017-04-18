package com.agsnasoft.jpa.dao;

import java.util.List;

import com.agsnasoft.jpa.model.Persona;

public interface PersonaJPADao {
	
	public boolean insertarPersona(Persona p);
	
	public boolean actualizarPersona(Persona p);

	public boolean eliminarPersona(Persona p);
	
	public List<Persona> consultarPersonas();
	
	public List<Persona> consultarPersona(Persona p);


}
