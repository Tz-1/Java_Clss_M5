package com.tz.gestorUsuario;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet("/AuthServlet")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario"); //Recupéro los datos que envia el formulario
		String clave = request.getParameter("clave");
		
		//Valido que los datos sean correctos
		if("admin".equals(usuario) && "1234".equals(clave)) {
			//Crear la sesion y establece el nombre de usuario
			HttpSession session = request.getSession();	
			session.setAttribute("usuario", usuario);
			
			//Creo una cookie para recordar al usuario
			Cookie userCookie = new Cookie("usuario", usuario);
			userCookie.setMaxAge(60*60); // 1 hora
			response.addCookie(userCookie);
			
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("login.jsp?error=invalid");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
