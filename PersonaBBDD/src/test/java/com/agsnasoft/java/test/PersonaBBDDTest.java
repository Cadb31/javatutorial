package com.agsnasoft.java.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.agsnasoft.java.dao.PersonaDao;
import com.agsnasoft.java.dao.PersonaDaoImpl;
import com.agsnasoft.java.model.Persona;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple PersonaBBDDTest.
 */
public class PersonaBBDDTest extends TestCase {

	private PersonaDao personaDao;

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public PersonaBBDDTest(String testName) {
		super(testName);
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

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(PersonaBBDDTest.class);
	}

	public void testConsultarAll() {
		List<Persona> personas = personaDao.consultarPersonas();
		if(personas != null){
			for (Persona persona : personas) {
				System.out.println(persona.toString());
			}
			assertTrue(true);
		}else{
			assertFalse(true);
		}
	}

	public void testConsultarPersona() {
		List<Persona> personas = personaDao.consultarPersona(new Persona(48, "", "", "", 0, ""));
		if(personas != null){
			for (Persona persona : personas) {
				System.out.println(persona.toString());
			}
			assertTrue(true);
		}else{
			assertTrue(false);
		}
	}

	public void testInsertarPersona(){		
		if(personaDao.insertarPersona(new Persona("Armando", "Hoyos", "Casa N15", 35, "a.hoyos@email.com"))){
			assertTrue(true);
		}else{
			assertTrue(false);
		}
	}
	
	public void testActualizarPersona(){
		assertTrue(true);
	}
	
	public void testEliminarPersona(){
		assertTrue(true);
	}
}
