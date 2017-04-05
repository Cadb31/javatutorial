<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertar Persona</title>
</head>
<body>
	<form action="controllerServlet" method="post">
	<input type="hidden" name="navigation" value="insertar">
		<table>
			<thead>
				<tr>
					<th colspan="2">Personas Insertar</th>
				</tr>
				<tr>
					<th colspan="2"></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="2">Nueva Persona:</td>
				</tr>
				<tr>
					<td><label>Nombre:</label></td>
					<td><input id="nombre" name="nombre" type="text" /></td>
				</tr>
				<tr>
					<td><label>Apellidos:</label></td>
					<td><input id="apellidos" name="apellidos" type="text" /></td>
				</tr>
				<tr>
					<td><label>Dirección:</label></td>
					<td><input id="direccion" name="direccion" type="text" /></td>
				</tr>
				<tr>
					<td><label>Edad:</label></td>
					<td><input id="edad" name="edad" type="text" /></td>
				</tr>
				<tr>
					<td><label>Email:</label></td>
					<td><input id="email" name="email" type="text" /></td>
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