<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar roles</title>
</head>
<body>
	<h2>Agregar un nuevo Rol</h2>
	<form action="/GestorUsuarios/RoleServlet" method="post">
	<label>Nombre del Rol:</label>
	<input type="text" name="nombre" required/><br>
	<button type="submit">Agregar Rol</button>
	</form>
</body>
</html>