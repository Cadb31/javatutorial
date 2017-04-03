package com.agsnasoft.jee;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agsnasoft.java.dao.PersonaDao;
import com.agsnasoft.java.dao.PersonaDaoImpl;
import com.agsnasoft.java.model.Persona;

public class ControllerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PersonaDao personaDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		try {
			response.sendRedirect("");
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		
		String navigation = request.getParameter("navigation"); 
		System.out.println("navigation: " + navigation);
		Persona persona = getPersona(request);
		System.out.println(persona.toString());
		initializeConnection();
		
		try {
			switch (navigation) {
			case "insertar":				
				if(personaDao.insertarPersona(persona)){
					response.sendRedirect("PageOk.html");
				}
				break;
			case "consultar":
				break;
			case "modificar":
				break;
			case "eliminar":
				break;				
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Persona getPersona(HttpServletRequest request){
		
		Persona persona = new Persona();
		persona.setNombre(request.getParameter("nombre"));
		persona.setApellidos(request.getParameter("apellidos"));
		persona.setDireccion(request.getParameter("direccion"));
		persona.setEdad(Integer.parseInt(request.getParameter("edad")));
		persona.setEmail(request.getParameter("email"));

		return persona;
	}
	
	private void initializeConnection(){
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
}


