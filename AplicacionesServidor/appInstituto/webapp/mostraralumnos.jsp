<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="paqueteobjetos.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%
ArrayList<Alumno> lista_alumnos=(ArrayList<Alumno>)request.getAttribute("lista_alumnos");
String tabla=PintarHtml.crearTabla(lista_alumnos);
String titulo=request.getParameter("titulo");
if (titulo==null)
{
	titulo="";
}
%>
<style>
.tabla_alumnos{border-collapse: collapse;}
tr, th, td {border: 1px solid black;}
</style>
</head>
<body>
ALUMNOS REGISTRADOS <%=titulo %>
<%=tabla %>
</body>
</html>