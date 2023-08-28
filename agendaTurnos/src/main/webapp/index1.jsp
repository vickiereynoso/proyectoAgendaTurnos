<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css">
<title>AGENDA</title>
</head>
<body>
<style><%@ include file="css/estilos.css" %></style>


<nav id="menu">
<ul>
 <li><a href="index1.jsp">HOME</a></li>
 <li><a href="#">Pacientes</a>
	 <ul>
	 <li><a href="RegistroPacientes.jsp">Registro Pacientes</a></li>
	 <li><a href="MostrarPacientes.jsp">Listado Pacientes</a></li>	 	 
	 </ul>
 </li>
 <li><a href="#">Profesionales</a>
 	 <ul>
	 <li><a href="RegistroProfesionales.jsp">Registro Profesionales</a></li>
	 <li><a href="MostrarProfesionales.jsp">Listado Profesionales</a></li>	 
	 </ul>
 </li>
 <li><a href="#">Áreas de Salud</a>
  	 <ul>
	 <li><a href="CargaListaEspecializaciones.jsp">Carga Especializaciones</a></li>
	 <li><a href="MostrarEspecializaciones.jsp">Listado Especializaciones</a></li>	 
	 </ul>
 </li>

</ul>
</nav>

</body>
</html>



<!-- 

-Cargar profesionales.
-Cargar especialidades.
-Cargar pacientes.
-Crear agenda para 1 profesional por primera vez (dias, desplegar lista de profesionales. Ej la dra alesandrini atiende solo 5 horas).
EN LA AGENDA ESTA TODA LA LOGICA DE TURNOS, SI ESTAN OCUPADOS O NO, ETC. OJO.
-Alta de turno: 




 -->