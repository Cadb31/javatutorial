package com.agsnasoft.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersonaJPAMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaJPA");
		EntityManager em = emf.createEntityManager();

		//Persona p = new Persona("Jose", "Mota", "Casa N10", 45, "j.mota@email.com");
		
		em.getTransaction().begin();
		//em.persist(p);
		Persona personas = em.find(Persona.class, 49);
		System.out.println(personas.toString());
		em.getTransaction().commit();		
		em.close();
		emf.close();
	}

}
