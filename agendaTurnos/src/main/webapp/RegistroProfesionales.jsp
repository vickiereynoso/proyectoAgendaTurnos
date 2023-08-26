<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.agendaTurnos.conexion.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AGENDA</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
<style><%@ include file="css/estilos.css" %></style>
	<h2>Ingrese datos del profesional:</h2>
	
   	<% try{ 
		Connection conexion = Conexion.conectar();
		Statement stmt = conexion.createStatement();
		String sql ="SELECT * FROM especialidades";
		ResultSet datos = stmt.executeQuery(sql);
	%>
	<form method="get" action="RegistroProfesionales" >
	<label for="dni">DNI:</label> <input type="number" name="dni" id="dni"><br>
	<label for="nombre">Nombre:</label> <input type="text" name="nombre" id="nombre"><br>
	<label for="apellido">Apellido:</label> <input type="text" name="apellido" id="apellido"><br>
	<label for="especialidad">Especialidad</label>
	<select name="especialidad" id="especialidad">	
    <% while(datos.next()){ %> 				
				<option value= <%=datos.getString("especialidad") %> ><%=datos.getString("especialidad") %></option>
		<% } %>
	</select>
	<br>
	<label for="email">Email:</label> <input type="email" name="email" id="email"><br>
	<label for="telefono">Teléfono:</label> <input type="text" name="telefono" id="telefono"><br>
	<input type="submit" value="Registrar datos" name="submit" id="submit">
	</form>
	<% 	} catch (Exception e) {
	e.printStackTrace();
	} 
	%>
</body>
</html>