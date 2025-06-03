<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
</head>
<body>
<h1>Registro</h1>
<div>
<form action="/RepasoServlet/login" method="post">
<label for="nombre">Nombre:</label>
<input type="text" id="nombre" name="nombre" required />
<br>
<label for="usuario">Usuario:</label>
<input type="text" id="usuario" name="usuario" required />
<br>
<label for="clave">Clave:</label>
<input type="password" id="clave" name="clave" required />
<br>
<button type="submit">Entrar</button>
</form>
<c:if test="${not empty error }">
		<p style="color:red;"> ${error }</p>
</c:if>
</div>
</body>
</html>