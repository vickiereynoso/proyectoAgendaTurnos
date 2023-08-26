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
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Insert title here</title>
	</head>
	<body>
	
	<div>
        <section>
        	<h2>Especialidad</h2>
            <div>
	           <% try{ 
					Connection conexion = Conexion.conectar();
					Statement stmt = conexion.createStatement();
					String sql ="SELECT * FROM especialidades";
					ResultSet datos = stmt.executeQuery(sql);
				%>							
						<form action="#">
							     <label for="lang">Especialidad</label>
							    <select name="especialidades" id="lang">					
						<% while(datos.next()){ %> 				
									<option value="especialidad"><%=datos.getString("especialidad") %></option>
							<% } %>
						</select>
						<input type="submit" value="Enviar" />
						</form>
						<%	
						} catch (Exception e) {
						e.printStackTrace();
						} 
						%>				
			<div>
        </section>
    </div>
    
    
	</body>
	</html>