<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AGENDA</title>
<link rel="stylesheet" href="css/estilos.css">
</head>
<body>
<style><%@ include file="css/estilos.css" %></style>
<%@ include file="index1.jsp" %>
<br>
<br>
	<h2>Ingrese área de Especialidad:</h2>
	<form method="get" action="IngresoEspecializaciones">
	<label for="especialidad">Especialidad:</label> <input type="text" name="especialidad" id="especialidad"><br>
	<input type="submit" value="Registrar datos" name="submit" id="submit">
	</form>
</body>
</html>