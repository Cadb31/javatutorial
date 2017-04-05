package com.agsnasoft.jee.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.agsnasoft.java.model.Persona;

public class ConsultarPersona {
	
	HttpServletResponse response;
	
	public ConsultarPersona(HttpServletResponse response){
		this.response = response;
	}
	
	public void drawView(List<Persona> personas) throws IOException{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset=\"ISO-8859-1\">");
		pw.println("<title>Consultar Persona</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<table>");
		pw.println("<thead>");
		pw.println("<tr>");
		pw.println("<th colspan=\"6\">Listado de Personas</th>");
		pw.println("</tr>");
		pw.println("</thead>");
		pw.println("<tbody>");
		pw.println("<tr>");
		pw.println("<td><label>Id</label></td>");
		pw.println("<td><label>Nombre</label></td>");
		pw.println("<td><label>Apellidos</label></td>");
		pw.println("<td><label>Dirección</label></td>");
		pw.println("<td><label>Edad</label></td>");
		pw.println("<td><label>Email</label></td>");
		pw.println("</tr>");
		for (Persona persona : personas) {
			pw.println("<tr>");
			
			pw.println("<td><label>"+ persona.getId() +"</label></td>");
			pw.println("<td><label>"+ persona.getNombre() +"</label></td>");
			pw.println("<td><label>"+ persona.getApellidos() +"</label></td>");
			pw.println("<td><label>"+ persona.getDireccion() +"</label></td>");
			pw.println("<td><label>"+ persona.getEdad() +"</label></td>");
			pw.println("<td><label>"+ persona.getEmail() +"</label></td>");

			pw.println("</tr>");
		}
		pw.println("</tbody>");
		pw.println("</table>");
		pw.println("<a href=\"Index.html\">Regreso a Inicio</a>");		
		pw.println("</html>");
	}
	
}
