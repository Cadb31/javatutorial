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

// TODO: Auto-generated Javadoc
/**
 * Unit test for simple PersonaBBDDTest.
 */
/**
 * @author c.diaz
 *
 */
/**
 * @author c.diaz
 *
 */
public class PersonaBBDDTest extends TestCase {

	/** The persona dao. */
	private PersonaDao personaDao;

	/**
	 * Create the test case.
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
	 * Suite.
	 *
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(PersonaBBDDTest.class);
	}

	/**
	 * Test consultar all.
	 */
	public void testConsultarAll() {
		List<Persona> personas = personaDao.consultarPersonas();
		if (personas != null) {
			for (Persona persona : personas) {
				System.out.println(persona.toString());
			}
			assertTrue(true);
		} else {
			assertFalse(true);
		}
	}

	/**
	 * Test consultar persona.
	 */
	public void testConsultarPersona() {
		List<Persona> personas = personaDao.consultarPersona(new Persona(49, "", "", "", 0, ""));
		if (personas != null) {
			for (Persona persona : personas) {
				System.out.println(persona.toString());
			}
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

	/**
	 * Test insertar persona.
	 */
	public void testInsertarPersona() {
		if (personaDao.insertarPersona(new Persona("Armando", "Hoyos", "Casa N15", 35, "a.hoyos@email.com"))) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

	/**
	 * Test actualizar persona.
	 */
	public void testActualizarPersona() {
		Persona pActual = new Persona(136, "Armando", "Hoyos", "Casa N15", 35, "a.hoyos@email.com");
		Persona pModificada = new Persona(136, "Armando", "Hoyos", "Casa N30", 35, "a.hoyos@email.com");

		if (personaDao.actualizarPersona(pActual, pModificada)) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}

	}

	/**
	 * Test eliminar persona.
	 */
	public void testEliminarPersona() {
		if (personaDao.eliminarPersona(new Persona(138, "", "", "", 0, ""))) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}
}
