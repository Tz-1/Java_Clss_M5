<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
String usuario = null;
Cookie[] cookies = request.getCookies();
if(cookies != null){
	for(Cookie cookie : cookies){
		if("usuario".equals(cookie.getName())){
			usuario = cookie.getValue();
			break;
		}
	}
}

 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestor Usuarios</title>
</head>
<body>
	<h1>Bienvenido, <c:out value="${usuario }" default="Invitado"></c:out></h1>
	<c:if test="${sessionScope.usuario == null}">
    	<p><a href="logout.jsp">Cerrar Sesion</a></p>
	</c:if>
	<br>
	<ul>
		<li><a href="/GestorUsuarios/RoleServlet?accion=add">Agregar Roles</a></li>
		<li><a href="/GestorUsuarios/userServlet?accion=listar">Listar Usuarios</a></li>
		<li><a href="/GestorUsuarios/userServlet?accion=add">Agregar Usuarios</a></li>
	</ul>
</body>
</html>