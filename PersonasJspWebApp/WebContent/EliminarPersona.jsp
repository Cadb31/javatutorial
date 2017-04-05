<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.agsnasoft.java.model.Persona"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Eliminar Persona</title>
</head>
<body>
	<form action="controllerServlet" method="post">
	<input type="hidden" name="navigation" value="eliminar">
		<table>
			<thead>
				<tr>
					<th colspan="2">Personas Eliminar</th>
				</tr>
				<tr>
					<th colspan="2"></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="2">Eliminar Persona:</td>
				</tr>
				<% Persona persona = (Persona) request.getAttribute("persona"); %>
				<tr>
					<td><label>Nombre:</label></td>
					<td><label><%=persona.getNombre()%></label></td>
				</tr>
				<tr>
					<td><label>Apellidos:</label></td>
					<td><label><%=persona.getApellidos()%></label></td>
				</tr>
				<tr>
					<td><label>Dirección:</label></td>
					<td><label><%=persona.getDireccion()%></label></td>
				</tr>
				<tr>
					<td><label>Edad:</label></td>
					<td><label><%=persona.getEdad()%></label></td>
				</tr>
				<tr>
					<td><label>Email:</label></td>
					<td><label><%=persona.getEmail()%></label></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td><input type="submit" value="Cancelar" /></td>
					<td><input type="submit" value="Aceptar" /></td>
				</tr>
			</tfoot>
		</table>
	</form>
	<a href="Index.html">Regreso a Inicio</a>
</body>
</html>