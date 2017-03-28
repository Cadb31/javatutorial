package com.agsnasoft.java.dao;

import java.util.ArrayList;
import java.util.List;

import com.agsnasoft.java.model.Persona;

public interface PersonaFileDao {
	
	public static List<Persona> personas = new ArrayList<Persona>();
	
	public boolean insertarPersona(Persona p);
	
	public boolean actualizarPersona(Persona pActual, Persona pModificada);

	public boolean eliminarPersona(Persona p);
	
	public List<Persona> consultarPersonas();
	
	public Persona consultarPersona(Persona p);

}
