<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="paqueteobjetos.*" %>
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
<style>
.tabla_platos{border-collapse: collapse;}
tr, th, td {border: 1px solid black;}
</style>
</head>
<body>
<%
ArrayList<Plato> lista_platos=(ArrayList<Plato>)request.getAttribute("lista_platos");
String tabla=PintarHTML.crearTabla(lista_platos);
%>
<h1>Borrar plato</h1>
<%=tabla %>
</body>
</html>