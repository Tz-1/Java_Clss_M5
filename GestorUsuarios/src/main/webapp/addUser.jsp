<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Gestor Usuarios</title>
	</head>
	<body>
		<h2>Agrega Usuarios</h2>
		<br>
		<form action="/GestorUsuarios/userServlet" method="post">
			<label>Nombre: </label>
			<input type="text" name="nombre" required /><br>
			<label>Edad: </label>
			<input type="number" name="edad" required /><br>
			<label>Pais: </label>
			<input type="text" name="pais" required /><br>
			<label>Rol:</label>
			<c:if test="${empty xroles}">
				<input type="text" name="role" value="Usuario" /><br>
			</c:if>
			<c:if test="${not empty xroles}">
				<select name="role">
					<c:forEach var="rol" items="${xroles}">
						<option value="${rol.nombre}"><c:out value="${rol.nombre}" /></option>
					</c:forEach>
				</select>
			</c:if>
			
			<br>
			<button type="submit">Agregar Usuario</button>
		</form>
	</body>
</html>