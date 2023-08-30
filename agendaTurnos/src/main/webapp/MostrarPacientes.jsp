<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
<%@ include file="index1.jsp" %>

<br>
<br>
			<div>
				<h2>Lista Pacientes:</h2>
				<table cellpadding="5" cellspacing="5" border="1">
				<tr>
				</tr>
				<tr bgcolor="lightblue">
				<td><b>DNI</b></td>
				<td><b>NOMBRE</b></td>
				<td><b>APELLIDO</b></td>
				<td><b>EMAIL</b></td>
				<td><b>TELÉFONO</b></td>
				
				</tr>
				<%
				try{ 
					Connection conexion = Conexion.conectar();
					Statement stmt = conexion.createStatement();
					String sql ="SELECT * FROM pacientes";
					ResultSet datos = stmt.executeQuery(sql);				
				while(datos.next()){
				%>
				<tr bgcolor="lightgrey">
				<td><%=datos.getInt("dni") %></td>
				<td><%=datos.getString("nombre") %></td>
				<td><%=datos.getString("apellido") %></td>
				<td><%=datos.getString("email") %></td>
				<td><%=datos.getString("telefono") %></td>		
				</tr>	
				<% 
					}				
				} catch (Exception e) {
				e.printStackTrace();
				}
				%>			
				</table>
		</div>

		


		<div>
        <section>
        	<h2>Buscar por DNI:</h2>
            <div>
				<form method="get" action="BusquedaPacientePorDNI" >
				<label for="dni">DNI:</label> <input type="number" name="dni" id="dni"><br>
				<input type="submit" value="Buscar" name="submit" id="submit">
				</form>		
			<div>
        </section>
    </div>

		
</body>
</html>