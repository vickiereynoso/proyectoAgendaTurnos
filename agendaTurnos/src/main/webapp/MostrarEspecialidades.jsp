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
<%@ include file="index1.jsp" %>

<br>
<br>
	<div>
        <section>
            <div>
				<form method="get" action="ListarEspecialidades" >
				<input type="submit" value="Listar Especialidades" name="submit" id="submit">
				</form>		
			<div>
        </section>
    </div>

</body>
</html>