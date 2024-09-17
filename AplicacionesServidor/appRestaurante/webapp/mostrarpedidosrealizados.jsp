<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
	<%@page import="paqueteobjetos.*"%>
<!DOCTYPE html>
<html>
<head>
<%
ArrayList<Pedido> lista_pedidos=(ArrayList<Pedido>) request.getAttribute("lista_pedidos");
String tabla=PintarHTML.crearTablaPedidosRealizados(lista_pedidos);
%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.tabla_pedido{border-collapse: collapse;}
tr, th, td {border: 1px solid black;}
</style>
</head>
<body>
<h1>Pedidos realizados</h1>
<%=tabla %>
<br><br>
<form action="Servlet" method="POST">
<button type="submit" name="accion" value="exportar">Exportar a CSV</button>
</form>
</body>
</html>