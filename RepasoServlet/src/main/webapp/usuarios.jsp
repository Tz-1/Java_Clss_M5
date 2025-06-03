<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuarios</title>
</head>
<body>
	<h2>Usuarios</h2>
	<table>
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Usuario</th>
			</tr>
		</thead>
		<tbody>
		<c:if test="${empty users }">
			<p>no hay usuarios registradod</p>
		</c:if>
		<c:if test="${not empty users }">
			<c:forEach>
				<tr>
					<td>${user.nombre }</td>
					<td>${user.usuario }</td>
				</tr>
			</c:forEach>
		</c:if>
		</tbody>
	</table>
</body>
</html>