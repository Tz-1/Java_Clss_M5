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
		<title>Imc</title>
	</head>
	<body>
	<%@ include file="menu.jsp" %>
	<section>
		<div class="container mt-3">
			<div class="card">
				<div class="card-body">
					<form action="/IMC/imc" method="post" autocomplete="off">
						<input type="hidden" name="userId" value=<%= sesion.getAttribute("userId")%> />
						<div class="form-group">
							<label for="peso" class="form-label">Peso:</label>
							<input class="form-control" type="number" step="any" name="peso" required/>
						</div>
						<div class="form-group">
							<label for="altura" class="form-label">Altura:</label>
							<input class="form-control" type="number" step="any" name="altura" required/>
						</div>
						<button class="btn btn-primary mt-3" type="submit">Enviar
						</button>
					</form>
					<c:if test="${not empty mensaje }">
				    <div class="mt-5">
				        <p class="${cssClass}" style="font-size: 1.2rem;">${mensaje }</p>
				    </div>
					</c:if>
				</div>
			</div>
		</div>
	</section>
	<%@ include file="pie.jsp" %>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	</body>
</html>