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

<div class="navbar">
  <a href="index1.jsp">Inicio</a>
  
  <div class="dropdown">
    <button class="dropbtn">Profesionales
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="RegistroProfesionales.jsp">Carga Profesionales</a>
      <a href="MostrarProfesionales.jsp">Listado Profesionales</a>
      <a href="BuscarProfesionalPorDNI.jsp">Buscar Profesional</a>
      <a href="BuscarProfesionalPorEspecialidad.jsp">Buscar Por Especialidad</a>
    </div>
  </div>
  
  <div class="dropdown">
    <button class="dropbtn">Pacientes
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="RegistroPacientes.jsp">Carga Pacientes</a>
      <a href="MostrarPacientes.jsp">Listado Pacientes</a>
      <a href="BuscarPacientePorDNI.jsp">Buscar Paciente</a>
    </div>
  </div>
  
  <div class="dropdown">
    <button class="dropbtn">Áreas de Salud
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="CargaListaEspecializaciones.jsp">Carga Especializaciones</a>
      <a href="MostrarEspecialidades.jsp">Listado Especializaciones</a>
    </div>
  </div>  
  
  <div class="dropdown">
    <button class="dropbtn">TURNOS
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="CargaListaTurnos.jsp">Carga Turnos</a>
      <a href="MostrarTurnos.jsp">Listado Turnos</a>
      <a href="BuscarTurno.jsp">Buscar Turno</a>
    </div>
  </div> 
  
  
  
</div>

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