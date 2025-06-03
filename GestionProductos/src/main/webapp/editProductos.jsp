<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Productos</title>
</head>
<body>
	<h2>Editar Productos</h2>
	<br>
	<form action="/GestionProductos/productos?accion=editar" method="post">
		<input type="hidden" name="id" value="${p.idProducto}" />
		<label>Nombre: </label>
		<input type="text" name="nombre" value="${p.nombre}" required/>
		<br>
		<label>Precio: </label>
		<input type="number" name="precio" value="${p.precio}" required/>
		<br>
		<button type="submit">Editar</button>
	</form>
</body>
</html>