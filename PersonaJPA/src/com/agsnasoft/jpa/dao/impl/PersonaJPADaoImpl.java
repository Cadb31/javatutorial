package com.agsnasoft.jpa.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.agsnasoft.jpa.dao.PersonaJPADao;
import com.agsnasoft.jpa.model.Persona;

public class PersonaJPADaoImpl implements PersonaJPADao {

	private EntityManagerFactory emf;
	private EntityManager em;

	public PersonaJPADaoImpl() {
		super();
	}

	public PersonaJPADaoImpl(EntityManagerFactory emf) {
		super();
		this.emf = emf;
		this.em = emf.createEntityManager();
	}

	@Override
	public boolean insertarPersona(Persona p) {
		boolean isOk = false;
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		isOk = true;
		em.close();
		emf.close();
		return isOk;
	}

	@Override
	public boolean actualizarPersona(Persona p) {
		boolean isOk = false;
		em.getTransaction().begin();		
		Persona persona =  em.find(Persona.class,p.getId());

		if(!(persona.getNombre().equals(p.getNombre()))){
			persona.setNombre(p.getNombre());	
		}

		if(!(persona.getApellidos().equals(p.getApellidos()))){
			persona.setApellidos(p.getApellidos());	
		}
		
		if(!(persona.getDireccion().equals(p.getDireccion()))){
			persona.setDireccion(p.getDireccion());	
		}
		
		if(!(persona.getEdad() == p.getEdad())){
			persona.setEdad(p.getEdad());	
		}

		if(!(persona.getEmail().equals(p.getEmail()))){
			persona.setEmail(p.getEmail());	
		}
		em.getTransaction().commit();
		isOk = true;
		em.close();
		emf.close();
		
		return isOk;
	}

	@Override
	public boolean eliminarPersona(Persona p) {
		boolean isOk = false;
		em.getTransaction().begin();		
		Persona persona =  em.find(Persona.class,p.getId());
		em.remove(persona);
		em.getTransaction().commit();
		isOk = true;
		em.close();
		emf.close();
		return isOk;
	}

	@Override
	public List<Persona> consultarPersonas() {
		em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Persona> personas =  em.createQuery("Select t from " + Persona.class.getSimpleName() + " t").getResultList();
		em.getTransaction().commit();		
		em.close();
		emf.close();
		return personas;
	}

	@Override
	public List<Persona> consultarPersona(Persona p) {
		em.getTransaction().begin();		
		Persona persona =  em.find(Persona.class,p.getId());
		em.getTransaction().commit();		
		em.close();
		emf.close();
		List<Persona> personas = new ArrayList<Persona>();
		personas.add(persona);
		return personas;
	}

}
