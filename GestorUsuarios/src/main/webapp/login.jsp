<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="jakarta.tags.core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio de sesion</title>
</head>
<body>
<h2>Inicio de Sesion</h2>
<form action="/GestorUsuarios/AuthServlet" method="post">
	<label>Usuario:</label>
	<input type ="text" name ="usuario" required />
	<label>Clave:</label>
	<input type="text" name="clave" required />
	<br>
	<button type="submit">Iniciar</button>
</form>
<c:if test="${param.error == 'invalid'}">
	<p style="color:red">Usuario o contraseña incorrecta!</p>
</c:if>
</body>
</html>