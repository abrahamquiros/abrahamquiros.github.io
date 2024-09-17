<%@page import="paqueteobjetos.PintarHTML"%>
<%@page import="java.util.ArrayList"%>
<%@page import="paqueteobjetos.Entrenamiento"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%
String usuario=(String)request.getAttribute("usuario");
ArrayList<Entrenamiento> lista_entrenos=(ArrayList<Entrenamiento>)request.getAttribute("lista_entrenos");
String tabla=PintarHTML.crearTabla(lista_entrenos);

%>
</head>
<body>
<%=tabla %>
<br>
<form action="Servlet" method="post">
<input type="hidden" name="usuario" value="<%=usuario %>">
<button type="submit" name="accion" value="exportar">Exportar a csv</button>

<form action="Servlet" method="post">
<input type="hidden" name="usuario" value="<%=usuario %>">
<button type="submit" name="accion" value="crearhtml">Crear HTML</button>
</form>
</body>
</html>