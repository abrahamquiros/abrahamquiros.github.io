<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="paqueteobjetos.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ArrayList<Plato> lista_primeros=(ArrayList<Plato>)request.getAttribute("lista_primeros");
ArrayList<Plato> lista_segundos=(ArrayList<Plato>)request.getAttribute("lista_segundos");
ArrayList<Plato> lista_postres=(ArrayList<Plato>)request.getAttribute("lista_postres");
%>
<h1>Hacer pedido:</h1>
<form action="Servlet" method="post">
<%
//Código para pintar desplegables
out.print("Mesa: ");
out.print(PintarHTML.opcionMesa());
out.print("  Primeros: ");
out.print(PintarHTML.crearOpcion(1, lista_primeros));
out.print("  Segundos: ");
out.print(PintarHTML.crearOpcion(2, lista_segundos));
out.print("  Postres: ");
out.print(PintarHTML.crearOpcion(3, lista_postres));
%>
<br><br>
<label for="observaciones">Observaciones:</label><br>
<textarea name="observaciones" rows="4" cols="50">
</textarea>
<br><br>
<button type="submit" name="accion" value="crearPedido">ENVIAR</button>
<br><br>
<h1>Login cocineros:</h1>
<a href="Servlet?accion=irLogin">Iniciar sesion</a>
</form>
</body>
</html>