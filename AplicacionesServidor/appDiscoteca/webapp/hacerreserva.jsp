<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="paqueteobjetos.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
String usuario=(String)request.getAttribute("usuario");
int entradasPorNombre=(int)request.getAttribute("entradasPorNombre");
int entradasDisponibles=(int)request.getAttribute("entradasDisponibles");

String color;
int porcentajeV = 50 * 75 / 100;
int porcentajeR = 50 * 25 / 100;
if (entradasDisponibles > porcentajeV)
{
    color="green";
}
else if (entradasDisponibles < porcentajeR)
{
	color="red";
}
else
{
	color="orange";
}
%>
<style>
  span {color:<%=color %>;}
</style>
<body>
<h1>Reserva de entradas</h1>
Bienvenido <%=usuario %>
<br><br>
<form action="Servlet" method="post">
<input type="hidden" name="usuario" value="<%=usuario%>">
<%
//Código para pintar desplegables
out.print("Entradas disponibles: ");
out.print(PintarHTML.opcionEntradas(entradasPorNombre, entradasDisponibles));
%>
<button type="submit" name="accion" value="crearReserva">Reservar</button>
</form>
<br><br>
<p>Aforo actual <span><%=entradasDisponibles %></span></p>
</body>
</html>