package com.agsnasoft.java.dao;

import java.util.List;

import com.agsnasoft.java.model.Persona;

public interface PersonaDao {
	
	public boolean insertarPersona(Persona p);
	
	public boolean actualizarPersona(Persona pActual, Persona pModificada);

	public boolean eliminarPersona(Persona p);
	
	public List<Persona> consultarPersonas();
	
	public List<Persona> consultarPersona(Persona p);

}
