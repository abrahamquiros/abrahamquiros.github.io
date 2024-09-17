<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
ArrayList<Titulacion> lista_titulaciones=(ArrayList<Titulacion>)request.getAttribute("lista_titulaciones");
ArrayList<Curso> lista_cursos=(ArrayList<Curso>)request.getAttribute("lista_cursos");
%>
<h1>Registrar alumnos:</h1>
<form action="Servlet" method="post">
<label for="nombre">Nombre:</label>
<input type="text" name="nombre">

<%
//Código para pintar desplegables
out.print("Titulación: ");
out.print(PintarHtml.opcionTitulo(lista_titulaciones));
out.print(" Curso: ");
out.print(PintarHtml.opcionCurso(lista_cursos));
%>
<button type="submit" name="accion" value="crearalumno">Registrar</button>
</form>
<br>
<a href="Servlet?accion=veralumnos">Ver alumnos</a>
<br>
<br>
<h3>Filtrar por titulación:</h3	>
<form action="Servlet" method="post">
<select name="titulo">
<option value="daw">DAW</option>
<option value="dam">DAM</option>
<option value="asir">ASIR</option>
</select><br>
<button type="submit" name="accion" value="filtrarAlumnos">Mostrar por titulo</button>
</form>
</body>
</html>