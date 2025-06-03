package com.tz.gestorUsuario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.tz.DAO.RoleDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class RoleServlet
 */
@WebServlet("/RoleServlet")
public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoleDAO roleDAO= new RoleDAO();
       
	public RoleServlet() {
		super();
	}
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("usuario") == null) {
			response.sendRedirect("login.jsp");
			return;
		}*/
		
		String accion = request.getParameter("accion");
		if("listar".equals(accion)) {
			try {
				List<String> roles = roleDAO.getRoles();
				request.setAttribute("roles", roles);
				request.getRequestDispatcher("listarRole.jsp").forward(request, response);
				} catch (Exception e) {
					throw new ServletException("Error al obetner roles",e);
				}
		}else if("add".equals(accion)) {
			request.getRequestDispatcher("addRole.jsp").forward(request, response);
		}
	}
		
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		
		try {
			roleDAO.addRole(nombre);
		} catch (SQLException e) {
			throw new ServletException("Error al agregar rol ", e);
		}
	
		response.sendRedirect("/GestorUsuarios/RoleServlet?accion=listar");
	}
	


}
