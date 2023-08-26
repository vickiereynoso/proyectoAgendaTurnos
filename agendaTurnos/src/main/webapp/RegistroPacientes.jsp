<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AGENDA</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
<style><%@ include file="css/estilos.css" %></style>
	<h2>Ingrese datos del paciente:</h2>
	<form method="get" action="RegistroPacientes" >
	<label for="dni">DNI:</label> <input type="number" name="dni" id="dni"><br>
	<label for="nombre">Nombre:</label> <input type="text" name="nombre" id="nombre"><br>
	<label for="apellido">Apellido:</label> <input type="text" name="apellido" id="apellido"><br>
	<label for="email">Email:</label> <input type="email" name="email" id="email"><br>
	<label for="telefono">Teléfono:</label> <input type="text" name="telefono" id="telefono"><br>
	<input type="submit" value="Registrar datos" name="submit" id="submit">
	</form>
</body>
</html>