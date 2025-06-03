<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar usuarios</title>
</head>
<body>
	<h2>Listado de usuarios</h2>
	<br>
	<c:if test = "${empty usuarios}" >
		<p>No hay usuarios registrados.</p>
		</c:if>
	<c:if test = "${not empty usuarios}">
		<table border=1>
			<tr>
				<th>Nombre</th>
				<th>Edad</th>
				<th>Pais</th>
				<th>Detalle</th>
			</tr>
			<c:forEach var="usuario" items="${usuarios}" varStatus="status">
				<tr>
					<td><c:out value="${usuario.nombre}" /></td>
					<td><c:out value="${usuario.edad}" /></td>
					<td><c:out value="${usuario.pais}" /></td>
					<td><a href="/GestorUsuarios/userServlet?accion=detalle&indice=${status.index }">Ver Detalle</a></td>
				</tr>	
			</c:forEach>
		</table>
	</c:if>
	<p><a href="index.jsp">Volver al inicio</a></p>
</body>
</html>