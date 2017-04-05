<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.agsnasoft.java.model.Persona"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Personas</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th colspan="6">Listado de Personas</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><label>Id</label></td>
				<td><label>Nombre</label></td>
				<td><label>Apellidos</label></td>
				<td><label>Dirección</label></td>
				<td><label>Edad</label></td>
				<td><label>Email</label></td>
			</tr>
			<%
				List<Persona> personas = (List<Persona>) request.getAttribute("personas");
				for (Persona persona : personas) {
			%>
			<tr>
				<td><label><%=persona.getId()%></label></td>
				<td><label><%=persona.getNombre()%></label></td>
				<td><label><%=persona.getApellidos()%></label></td>
				<td><label><%=persona.getDireccion()%></label></td>
				<td><label><%=persona.getEdad()%></label></td>
				<td><label><%=persona.getEmail()%></label></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<a href="Index.html">Regreso a Inicio</a>
</body>
</html>