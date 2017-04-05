package com.agsnasoft.jee;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agsnasoft.java.dao.PersonaDao;
import com.agsnasoft.java.dao.PersonaDaoImpl;
import com.agsnasoft.java.model.Persona;
import com.agsnasoft.jee.view.ConsultarPersona;
import com.agsnasoft.jee.view.EliminarPersona;
import com.agsnasoft.jee.view.ModificarPersona;

public class ControllerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PersonaDao personaDao;

	private Persona persona;
	
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
		initializeConnection();
		
		try {
			switch (navigation) {
			case "insertar":
				persona = getPersona(request);
				System.out.println(persona.toString());
				if(personaDao.insertarPersona(persona)){
					response.sendRedirect("PageOk.html");
				}else{
					response.sendRedirect("PageOk.html");
				}
				break;
			case "consultar":				
				List<Persona> personas = new ArrayList<Persona>();
				if(!request.getParameter("id").equals("*")){
					personas.add(personaDao.consultarPersona(getPersonaId(request)));
					
				}else{
					personas = personaDao.consultarPersonas();
				}	
				ConsultarPersona consultarPersonas = new ConsultarPersona(response);
				consultarPersonas.drawView(personas);				
				break;
				
			case "consultar_modificar":
				persona = personaDao.consultarPersona(getPersonaId(request));
				ModificarPersona modificarPersona = new ModificarPersona(response);
				modificarPersona.drawView(persona);		
				break;
				
			case "modificar":
				Persona personaModificada = getPersona(request);
				if(personaDao.actualizarPersona(persona, personaModificada)){					
					response.sendRedirect("PageOk.html");
				}else{
					response.sendRedirect("PageOk.html");
				}
				break;
			
			case "consultar_eliminar":
				persona = personaDao.consultarPersona(getPersonaId(request));
				EliminarPersona eliminarPersona = new EliminarPersona(response);
				eliminarPersona.drawView(persona);		
				break;
				
			case "eliminar":
				if(personaDao.eliminarPersona(persona)){					
					response.sendRedirect("PageOk.html");
				}else{
					response.sendRedirect("PageOk.html");
				}
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
	
	private Persona getPersonaId(HttpServletRequest request){
		
		Persona persona = new Persona(Integer.valueOf(request.getParameter("id")), "", "", "", 0,"");
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


