<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalles de usuarios</title>
</head>
<body>
	<h2>Detalle del usuario</h2>
	<br>
	<p><strong>Nombre: </strong><c:out value="${usuario.nombre }" /></p>
	<p><strong>Edad: </strong><c:out value="${usuario.edad }" /></p>
	<p><strong>Pais: </strong><c:out value="${usuario.pais }" /></p>
	<p><strong>Rol: </strong><c:out value="${usuario.role }" /></p>
	<br>
	<p><a href="/GestorUsuarios/userServlet?accion=listar">Regresar</a></p>
	
</body>
</html>