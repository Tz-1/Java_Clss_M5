package controlador;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<Usuario> usuarios;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		
		// Obtener la lista de usuarios del contexto
		List<Usuario> usuarios = (List<Usuario>) getServletContext().getAttribute("usuarios");
		
		boolean autenticado = usuarios.stream().anyMatch(user->user.getUsuario().equals(usuario) && user.getClave().equals(clave));
		Usuario user = usuarios.stream().filter(usr-> usr.getUsuario().equals(usuario)).findFirst().orElse(null);
		
		if(autenticado) {
			HttpSession sesion = request.getSession();
			sesion.setAttribute("usuario", user.getNombre());
			
			//Redirige al centro de comandos
			response.sendRedirect(request.getContextPath()+"/dashboard");
		}else {
			request.setAttribute("error", "Credenciales invalidas");
			request.getRequestDispatcher("login.jsp").forward(request, response);

		}
	}

}
