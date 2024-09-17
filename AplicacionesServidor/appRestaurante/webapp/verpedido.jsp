<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="paqueteobjetos.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Ticket t = (Ticket) request.getAttribute("ticket");
%>
<h1>Datos del pedido</h1>
<p><strong>Primer Plato:</strong> <%=t.getPlatos()[0] %> <strong>Precio:</strong><%=t.getPrecios()[0] %></p>
<p><strong>Segundo Plato:</strong> <%=t.getPlatos()[1] %> <strong>Precio:</strong><%=t.getPrecios()[1] %></p>
<p><strong>Postre:</strong> <%=t.getPlatos()[2] %> <strong>Precio:</strong><%=t.getPrecios()[2] %></p>
<p><strong>Precio total:</strong> <%= t.getPrecio_total() %></p>
</body>
</html>