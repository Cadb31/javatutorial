package com.agsnasoft.jpa.dao;

import java.util.List;

import com.agsnasoft.jpa.dao.impl.PersonaJPADaoImpl;
import com.agsnasoft.jpa.model.Persona;

public class Main {

	public static void main(String[] args) {

		PersonaJPADao personaJpaDao = new PersonaJPADaoImpl("PersonaJPA");
		personaJpaDao.getEntityManager().getTransaction().begin();

		personaJpaDao.insertarPersona(new Persona("Jhon", "Smiths", "Casa N0", 40, "j.smith@email.com"));

		personaJpaDao.actualizarPersona(new Persona(165, "Juan", "Ramirez", "Casa N0", 40, "j.ramirez@email.com"));

		List<Persona> personas = personaJpaDao.consultarPersona(new Persona(145));
		for (Persona persona : personas) {
			System.out.println(persona.toString());
		}

		List<Persona> personass = personaJpaDao.consultarPersonas();
		for (Persona persona : personass) {
			System.out.println(persona.toString());
		}

		personaJpaDao.eliminarPersona(new Persona(153));
		personaJpaDao.getEntityManager().getTransaction().commit();

		personaJpaDao.getEntityManager().close();
		personaJpaDao.getEntityManagerFactory().close();

	}

}
