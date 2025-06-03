package com.tz.gestorUsuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tz.modelo.Role;
import com.tz.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class userServlet
 */
@WebServlet("/userServlet")
public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private List<Usuario> usuarios = new ArrayList<>();
	
    public userServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("usuario") == null) {
			response.sendRedirect("login.jsp");
			return;
		}*/
		
		
		String accion = request.getParameter("accion");
		if(accion.equals("listar")) {
			request.setAttribute("usuarios", usuarios);
			request.getRequestDispatcher("listarUsuarios.jsp").forward(request, response);
		}else if(accion.equals("detalle")){
			int indice = Integer.parseInt(request.getParameter("indice"));
			Usuario user = usuarios.get(indice);
			request.setAttribute("usuario", user);
			request.getRequestDispatcher("detalleUsuario.jsp").forward(request, response);
		} else if(accion.equals("add")){
			List<Role> listado = (List<Role>) getServletContext().getAttribute("roles");
			System.out.println(listado);
			
			request.setAttribute("xroles", listado);
			request.getRequestDispatcher("addUser.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		int edad = Integer.parseInt(request.getParameter("edad"));
		String pais = request.getParameter("pais");
		String roleName = request.getParameter("role");
		List<Role> listado = (List<Role>) getServletContext().getAttribute("roles");
		Role role = listado.stream()
				.filter(r -> r.getNombre().equals(roleName))
				.findFirst()
				.orElse(null);
		
		usuarios.add(new Usuario(nombre,edad,pais,role));
		response.sendRedirect("/GestorUsuarios/userServlet?accion=listar");
	}

}
