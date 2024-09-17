<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
	<%@page import="paqueteobjetos.*"%>
	<%@page import="paquetedatos.*"%>
<!DOCTYPE html>
<html>
<head>
<%
String master=(String)request.getAttribute("master"); 
if (master==null || !master.equals("OK"))
{
	// Acesso denegado
	ArrayList<Plato> lista_primeros=AccesoDatos.getPrimeros();
	request.setAttribute("lista_primeros", lista_primeros);
	ArrayList<Plato> lista_segundos=AccesoDatos.getSegundos();
	request.setAttribute("lista_segundos", lista_segundos);
	ArrayList<Plato> lista_postres=AccesoDatos.getPostres();
	request.setAttribute("lista_postres", lista_postres);
	request.getRequestDispatcher("insertarpedido.jsp").forward(request, response);
}
%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Insertar plato</h1>
<form action="Servlet" method="post">
<label for="nombre">Nombre:</label>
<input type="text" name="nombre">
<label for="precio">Precio:</label>
<input type="text" name="precio">
<select name="tipo">
<option value="1">Primero</option>
<option value="2">Segundo</option>
<option value="3">Postre</option>
</select>
<button type="submit" name="accion" value="crearPlato">Insertar plato</button>
</form>
</body>
</html>