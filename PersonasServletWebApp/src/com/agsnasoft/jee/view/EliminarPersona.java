package com.agsnasoft.jee.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.agsnasoft.java.model.Persona;

public class EliminarPersona {
	HttpServletResponse response;
	
	public EliminarPersona(HttpServletResponse response){
		this.response = response;
	}
	
	public void drawView(Persona persona) throws IOException{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset=\"ISO-8859-1\">");
		pw.println("<title>Modificar Persona</title>");
		pw.println("</head>");
		
		pw.println("<body>");
		pw.println("<form action=\"controllerServlet\" method=\"post\">");
		pw.println("<input type=\"hidden\" name=\"navigation\" value=\"eliminar\">");
		pw.println("<table>");
		pw.println("<thead>");
		pw.println("<tr>");
		pw.println("<th colspan=\"6\">Eliminación de Personas</th>");
		pw.println("</tr>");
		pw.println("</thead>");
		pw.println("<tbody>");

		pw.println("<tr>");		
		pw.println("<td><label>Nombre:</label></td>");		
		pw.println("<td><label>" + persona.getNombre() + "</label></td>");
		pw.println("</tr>");

		pw.println("<tr>");		
		pw.println("<td><label>Apellidos:</label></td>");		
		pw.println("<td><label>" + persona.getApellidos() + "</label></td>");
		pw.println("</tr>");

		pw.println("<tr>");		
		pw.println("<td><label>Dirección:</label></td>");		
		pw.println("<td><label>" + persona.getDireccion() + "</label></td>");
		pw.println("</tr>");		

		pw.println("<tr>");		
		pw.println("<td><label>Edad:</label></td>");		
		pw.println("<td><label>" + persona.getEdad() + "</label></td>");
		pw.println("</tr>");

		pw.println("<tr>");		
		pw.println("<td><label>Email:</label></td>");		
		pw.println("<td><label>" + persona.getEmail() + "</label></td>");
		pw.println("</tr>");

		pw.println("</tbody>");
		pw.println("</table>");
		
		pw.println("<tfoot>");
		pw.println("<tr>");
		pw.println("<td><input type=\"submit\" value=\"Cancelar\" /></td>");
		pw.println("<td><input type=\"submit\" value=\"Aceptar\" /></td>");
		pw.println("</tr>");
		pw.println("</tfoot>");
		pw.println("</form>");
		
		pw.println("<a href=\"Index.html\">Regreso a Inicio</a>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
