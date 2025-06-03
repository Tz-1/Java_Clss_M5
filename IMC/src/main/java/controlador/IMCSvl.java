package controlador;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.IMCResultado;
import modelo.IMCResultadoDAO;

/**
 * Servlet implementation class IMCSvl
 */
@WebServlet("/imc")
public class IMCSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IMCResultadoDAO imcDAO = new IMCResultadoDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IMCSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("imc.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		float peso = Float.parseFloat(request.getParameter("peso"));
		float altura = Float.parseFloat(request.getParameter("altura"));
		
		IMCResultado imc = new IMCResultado(userId, peso, altura);
		try {
			if(imcDAO.grabarIMC(imc)) {
	            String categoria = imc.CategoriaIMC();
	            String cssClass = imc.getCategoriaClass();
				request.setAttribute("mensaje", "IMC Registrado. Su valor de IMC es: " + imc.getImc() + "\nCategoria: "+ categoria);
				request.setAttribute("cssClass", cssClass); 
			}else {
				request.setAttribute("mensaje", "Error al registrar el IMC");
			}
			request.getRequestDispatcher("imc.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
