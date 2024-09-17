<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="paqueteobjetos.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.tabla_reservas{border-collapse: collapse;}
tr, th, td {border: 1px solid black;}
</style>
</head>
<body>
<%
ArrayList<Reserva> lista_reservas=(ArrayList<Reserva>)request.getAttribute("lista_reservas");
String tabla=PintarHTML.crearTabla(lista_reservas);
%>
<h1>Reservas realizadas</h1>
<%=tabla %>
<br><br>
<form action="Servlet" method="post">
<button type="submit" name="accion" value="importar">Importar usuarios CSV</button>
</form>
</body>
</html>