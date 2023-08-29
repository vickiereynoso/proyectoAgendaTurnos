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
<h2 align="left"><font><strong>Profesionales</strong></font></h2>
		
		<table align="left" cellpadding="5" cellspacing="5" border="1">
		<tr>
		
		</tr>
		<tr bgcolor="lightblue">
		<td><b>DNI</b></td>
		<td><b>NOMBRE</b></td>
		<td><b>APELLIDO</b></td>
		<td><b>ESPECIALIDAD</b></td>
		<td><b>EMAIL</b></td>
		<td><b>TELÉFONO</b></td>
		
		</tr>
		<%
		try{ 
			Connection conexion = Conexion.conectar();
			Statement stmt = conexion.createStatement();
			String sql ="SELECT * FROM profesionales";
			ResultSet datos = stmt.executeQuery(sql);
		
		while(datos.next()){
		%>
		<tr bgcolor="lightgrey">
		

		<td><%=datos.getInt("dni") %></td>
		<td><%=datos.getString("nombre") %></td>
		<td><%=datos.getString("apellido") %></td>
		<td><%=datos.getString("especialidad") %></td>
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

		<br>
		<br>
		<br>
		<br>
		<br>		
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
			
		<div>
        <section>
        	<h2>Buscar por especialidad:</h2>
            <div>
			   	<% try{ 
					Connection conexion = Conexion.conectar();
					Statement stmt = conexion.createStatement();
					String sql ="SELECT * FROM especialidades";
					ResultSet datos = stmt.executeQuery(sql);
				%>
				<form method="get" action="BusquedaDeProfesionalPorArea" >
				<label for="especialidad">Especialidad</label>
				<select name="especialidad" id="especialidad">	
			    <% while(datos.next()){ %> 				
							<option value= <%=datos.getString("especialidad") %> ><%=datos.getString("especialidad") %></option>
					<% } %>
				</select>
				<br>
				<input type="submit" value="Buscar" name="submit" id="submit">
				</form>
				<% 	} catch (Exception e) {
				e.printStackTrace();
				} 
				%>			
			<div>
        </section>
    </div>

		<div>
        <section>
        	<h2>Buscar por DNI:</h2>
            <div>
			   	<% try{ 
					Connection conexion = Conexion.conectar();
					Statement stmt = conexion.createStatement();
					String sql ="SELECT * FROM profesionales";
					ResultSet datos = stmt.executeQuery(sql);
				%>
				<form method="get" action="BusquedaPorDNI" >
				<label for="dni">DNI:</label> <input type="number" name="dni" id="dni"><br>
				<input type="submit" value="Buscar" name="submit" id="submit">
				</form>
				<% 	} catch (Exception e) {
				e.printStackTrace();
				} 
				%>			
			<div>
        </section>
    </div>

		
</body>
</html>