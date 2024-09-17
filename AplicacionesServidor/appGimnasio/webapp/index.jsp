<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Servlet" method="post">
<input type="hidden" name="accion" value="login">
Usuario: <input type="text" name="usuario">
Password: <input type="text" name="password">
<input type="submit" value="Enviar">
</form><br><br>
<a href="Servlet?accion=iraregistro">Registrase</a>
</body>
</html>