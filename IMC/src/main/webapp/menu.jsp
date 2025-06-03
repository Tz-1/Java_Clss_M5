<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page import = "jakarta.servlet.http.HttpSession" %>
<header>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
	  <a class="navbar-brand" href="#">Navbar</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item active">
	        <a class="nav-link" href="index.jsp">Inicio</a>
	      </li>
	      <c:if test="${empty sessionScope.usuario }">
	      <li class="nav-item">
	        <a class="nav-link" href="login.jsp">Login</a>
	      </li>
	      </c:if>
	      <c:if test="${not empty sessionScope.usuario }">
	      <li class="nav-item">
	        <a class="nav-link" href="#">Usuario</a>
	      </li>
	      </c:if>
	      <c:if test="${not empty sessionScope.usuario }">
	      <li class="nav-item">
	        <a class="nav-link" href="/IMC/imc">IMC</a>
	      </li>
	      </c:if>
	      <c:if test="${not empty sessionScope.usuario }">
	      <li class="nav-item">
	        <a class="nav-link" href="/IMC/logout">Logout</a>
	      </li>
	      </c:if>
	    </ul>
	  </div>
	  </div>
	</nav>
</header>