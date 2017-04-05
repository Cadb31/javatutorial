<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consultar Persona</title>
</head>
<body>
<form action="controllerServlet" method="post">
	<input type="hidden" name="navigation" value="consultar">
		<table>
			<thead>
				<tr>
					<th colspan="3">Consultar Personas</th>
				</tr>
				<tr>
					<th colspan="3">* Para consultar todas</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><label>Id Persona:</label></td>
					<td><input id="id" name="id" type="text" /></td>					
					<td><input type="submit" value="Consultar" /></td>
				</tr>					
			</tbody>
		</table>
	</form>
	<a href="Index.html">Regreso a Inicio</a>
</body>
</html>