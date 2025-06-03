package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;

/**
 * Servlet implementation class RegistroSvl
 */
@WebServlet("/registro")
public class RegistroSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	List<Usuario> usuarios = new ArrayList<>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("registro.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		List<Usuario> usuarios = (List<Usuario>) getServletContext().getAttribute("usuarios");
		boolean existe = usuarios.stream().anyMatch(user->user.getUsuario().equals(usuario));
		if(existe) {
			request.setAttribute("error", "Usuario ya existe");
			request.getRequestDispatcher("registro.jsp").forward(request, response);
		}else {
			usuarios.add(new Usuario(nombre, usuario, clave));
			getServletContext().setAttribute("usuarios", usuarios);
			response.sendRedirect("/RepasoServlet/");
		}
		
		
	}

}
