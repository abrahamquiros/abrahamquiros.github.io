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
ArrayList<Pedido> lista_pedidos=(ArrayList<Pedido>) request.getAttribute("lista_pedidos");
String tabla=PintarHTML.crearTablaPedidos(lista_pedidos);
%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.tabla_pedido{border-collapse: collapse;}
tr, th, td {border: 1px solid black;}
</style>
</head>
<body>
<h1>Pedidos pendientes</h1>
<%=tabla %>
<br><br>
<a href="Servlet?accion=irInsertarPlatos">Insertar platos</a>
<br><br>
<a href="Servlet?accion=irBorrarPlatos">Borrar platos</a>
<br><br>
<form action="Servlet" method="POST">
<button type="submit" name="accion" value="exportar">Exportar a CSV</button>
</form>
</body>
</html>