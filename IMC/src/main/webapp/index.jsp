<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page import = "jakarta.servlet.http.HttpSession" %>
<%
	HttpSession sesion = request.getSession(false);
 %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<style>
			<%@ include file="assets/css/estilo.css"%>
		</style>
		<title>Home</title>
	</head>
	<body>
	<%@ include file="menu.jsp" %>
	<main class="container mt-3">
		<h1>Bienvenidos</h1>
		<h3><%if(sesion.getAttribute("usuario")!=null) { out.print(sesion.getAttribute("usuario")); }%></h3>
	</main>
	<%@ include file="pie.jsp" %>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	</body>
</html>