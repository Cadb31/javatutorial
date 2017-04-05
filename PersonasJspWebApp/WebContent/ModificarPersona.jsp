<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.agsnasoft.java.model.Persona"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar Persona</title>
</head>
<body>
	<form action="controllerServlet" method="post">
	<input type="hidden" name="navigation" value="modificar">
		<table>
			<thead>
				<tr>
					<th colspan="2">Personas Modificar</th>
				</tr>
				<tr>
					<th colspan="2"></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="2">Modificar Persona:</td>
				</tr>
				<% Persona persona = (Persona) request.getAttribute("persona"); %>
				<tr>
					<td><label>Nombre:</label></td>
					<td><input id="nombre" name="nombre" type="text" value="<%=persona.getNombre()%>"/></td>
				</tr>
				<tr>
					<td><label>Apellidos:</label></td>
					<td><input id="apellidos" name="apellidos" type="text" value="<%=persona.getApellidos()%>"/></td>
				</tr>
				<tr>
					<td><label>Dirección:</label></td>
					<td><input id="direccion" name="direccion" type="text" value="<%=persona.getDireccion()%>"/></td>
				</tr>
				<tr>
					<td><label>Edad:</label></td>
					<td><input id="edad" name="edad" type="text" value="<%=persona.getEdad()%>"/></td>
				</tr>
				<tr>
					<td><label>Email:</label></td>
					<td><input id="email" name="email" type="text" value="<%=persona.getEmail()%>"/></td>
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