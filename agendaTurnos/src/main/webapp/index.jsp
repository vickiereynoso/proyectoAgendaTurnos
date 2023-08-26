<%@ page import="java.util.Date" %>
<!-- <%@ include file="menu.jsp" %> --> <!-- para cuando quiero por ejemplo que una barra de men� me aparezca en todas las pag html que vaya a hacer. -->
<html>
<body>
<h2>Hello World!</h2>

<!-- Un jsp es un servlet b�sicamente. Java al compilarlo lo convierte en un servlet. 
Y como es una clase, tiene m�todos y atributos. -->

<!-- Incorporaci�n de c�digo Java en un archivo html: b�sicamente un .jsp -->
<% new java.util.Date(); %> <!-- el usuario NO va a ver esta l�nea de c�digo. -->

<!-- Scriplet de expresi�n: es el equivalente al syso de java tradicional. -->

<%= new java.util.Date() %> <!-- esta l�nea S� va a ser publicada y ser� vista por el usuario. -->

<!-- Scriplet de declaraci�n: voy a poder crear m�todos y atributos dentro de mi jsp. -->

<!-- OJO a continuaci�n es s�lo a modo de ejemplo ya que no deber�a haber l�gica en un jsp, eso va en otra capa. -->
<%! Date fechaActual = new Date(); 
	
	Date obtenerFecha(){
		return fechaActual;		
	}

%>

La fecha actual es <%= obtenerFecha() %> <!-- Llamo al m�todo obtenerFecha() -->

<!-- Scriplet de directivas: me permite hacer configuraciones. -->
<!-- Directiva page: -->
<%@ page import="java.util.Date" %> <!-- ir�a arriba de todo, antes del DOCTYPE y de la apertura de la etiqueta <html>. -->

</body>
</html>
