<%@ page import="java.util.Date" %>
<!-- <%@ include file="menu.jsp" %> --> <!-- para cuando quiero por ejemplo que una barra de menú me aparezca en todas las pag html que vaya a hacer. -->
<html>
<body>
<h2>Hello World!</h2>

<!-- Un jsp es un servlet básicamente. Java al compilarlo lo convierte en un servlet. 
Y como es una clase, tiene métodos y atributos. -->

<!-- Incorporación de código Java en un archivo html: básicamente un .jsp -->
<% new java.util.Date(); %> <!-- el usuario NO va a ver esta línea de código. -->

<!-- Scriplet de expresión: es el equivalente al syso de java tradicional. -->

<%= new java.util.Date() %> <!-- esta línea SÍ va a ser publicada y será vista por el usuario. -->

<!-- Scriplet de declaración: voy a poder crear métodos y atributos dentro de mi jsp. -->

<!-- OJO a continuación es sólo a modo de ejemplo ya que no debería haber lógica en un jsp, eso va en otra capa. -->
<%! Date fechaActual = new Date(); 
	
	Date obtenerFecha(){
		return fechaActual;		
	}

%>

La fecha actual es <%= obtenerFecha() %> <!-- Llamo al método obtenerFecha() -->

<!-- Scriplet de directivas: me permite hacer configuraciones. -->
<!-- Directiva page: -->
<%@ page import="java.util.Date" %> <!-- iría arriba de todo, antes del DOCTYPE y de la apertura de la etiqueta <html>. -->

</body>
</html>
