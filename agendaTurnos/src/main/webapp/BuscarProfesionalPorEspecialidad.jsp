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
<%@ include file="index1.jsp" %>

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


</body>
</html>