<%
	// Cerrar la sesion
	session.invalidate();
	Cookie[] cookies = request.getCookies(); // Recupero la cookies grabadas
	if(cookies != null){ // Si existen
		for (Cookie cookie : cookies){
			if("usuario".equals(cookie.getName())){
				cookie.setMaxAge(0); //Elimina la cookie
				response.addCookie(cookie);
			}
		}
	}
	response.sendRedirect("login.jsp");
%>