package com.agsnasoft.jpa;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.agsnasoft.jpa.dao.PersonaJPADao;
import com.agsnasoft.jpa.dao.impl.PersonaJPADaoImpl;
import com.agsnasoft.jpa.model.Persona;

public class PersonaJPAMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaJPA");
		PersonaJPADao personaDao = new PersonaJPADaoImpl(emf);
		//personaDao.insertarPersona(new Persona("Juan Rogelio","Perez","Casa N1",25,"jr.p@email.com"));
		//personaDao.actualizarPersona(new Persona(144, "Juan","Perez","Casa N1",25,"jr.p@email.com"));
		List<Persona> personas = personaDao.consultarPersonas();
		for (Persona persona : personas) {
			System.out.println(persona.toString());
		}
	}
}
