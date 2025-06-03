<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP/JSTL</title>
</head>
<body>
<!-- Declaracion -->
<%!
String saludo = "!Bienvenido a JSP Y JSTL";

public int calcularCuadrado(int num){
	return num*num;
}
%>

<!-- Expresion -->
<h1><%= saludo %></h1>
<p>Fecha actual: <%= new java.util.Date() %></p>

<!-- Scriptlet -->
<%
int numero = 6;
int cuadrado = calcularCuadrado(numero);
%>

<p>El cuadrado de <%= numero %> es: <%=cuadrado %></p>

<%
if(numero % 2 == 0){
	%>	
	<p>El <%= numero %> es par.</p>
	<%
}else{	
	%>
	<p>El <%= numero %> es impar.</p>
<%
}
%>


<form action="saludo.jsp" method="post">
<label>Nombre :</label>
<input type="text" name = "nombre"/>
<button type="submit">Enviar</button>
</form>

</body>
</html>