<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Productos</title>
</head>
<body>
	<h2>Listado de productos</h2>
	<br>
	<button><a href="/GestionProductos/productos?accion=add">Agregar Productos</a></button>
	<br>
	<br>
	<c:if test="${empty productos}">
		<p>No hay productos registrados</p>
	</c:if>
	<c:if test="${not empty productos}">
		<table border=1>
			<thead>
			<tr>
				<th>Id</th>
				<th>Producto</th>
				<th>Precio</th>
				<th>Acciones</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach var="prod" items="${productos}" varStatus="status">
					<tr>
						<td>${prod.idProducto}</td>
						<td>${prod.nombre}</td>
						<td>${prod.precio}</td>
						<td>
							<div style="margin:5px 10px; display:flex; flex-direction:row; gap:5px;">
								<div>
									<a href="/GestionProductos/productos?accion=editar&id=${prod.idProducto}">Editar</a>
								</div>
								
								<div>
									<a href="/GestionProductos/productos?accion=eliminar&id=${prod.idProducto}">Eliminar</a>
								</div>		
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<br>
	<button><a href="/GestionProductos">Regresar</a></button>
</body>
</html>