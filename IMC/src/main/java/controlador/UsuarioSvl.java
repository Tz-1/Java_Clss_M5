package controlador;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Usuario;
import modelo.UsuarioDAO;

/**
 * Servlet implementation class UsuarioSvl
 */
@WebServlet("/usuario")
public class UsuarioSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO userDAO = new UsuarioDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		if("registrar".equals(accion)) {
			String nombre = request.getParameter("nombre");
			String correo = request.getParameter("correo");
			String clave = request.getParameter("clave");
			try {
				if(userDAO.registrarUsuario(new Usuario(nombre,correo, clave))) {
					request.setAttribute("mensaje", "Usuario Registrado");
				}else {
					request.setAttribute("mensaje", "Error al registrar");
				}
				request.getRequestDispatcher("pantalla.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("login".equals(accion)) {
			String correo = request.getParameter("usuario");
			String clave = request.getParameter("clave");
			
			try {
				Usuario usr = userDAO.esUsuarioValido(correo, clave);
				if(usr != null) {
					HttpSession sesion = request.getSession();
					sesion.setAttribute("userId", usr.getId());
					sesion.setAttribute("usuario", usr.getNombre());
					response.sendRedirect("index.jsp");
				}else {
					request.setAttribute("error","Usuario o clave invalida");
					request.getRequestDispatcher("login.jsp");
				}
			} catch (Exception e) {
				request.setAttribute("error","Usuario o clave invalida"+e.getMessage());
				request.getRequestDispatcher("login.jsp");
			}
		}
	}

}
