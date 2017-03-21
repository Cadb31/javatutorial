package com.agsnasoft.java.dao;

import com.agsnasoft.java.model.Persona;

public interface PersonaDao {
	
	public boolean insertarPersona();
	
	public boolean actualizarPersona();

	public boolean eliminarPersona();
	
	public boolean consultarPersona(Persona p);
	
}
