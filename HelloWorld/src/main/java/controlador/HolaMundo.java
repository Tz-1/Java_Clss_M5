package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HolaMundo
 */
@WebServlet("/HolaMundo")
public class HolaMundo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolaMundo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		String nombre = request.getParameter("nombre");
		String rut = request.getParameter("rut");
		String edad = request.getParameter("edad");
		int edadToInt = Integer.parseInt(edad);
		
		PrintWriter salida = response.getWriter();
		salida.println("<html><body>");
		salida.println("<h1>Calculadora</h1>");
		salida.println("<br>");
		salida.println("<form action='/HelloWorld/HolaMundo' method='post'>");
		salida.println("Numero 1: <input type='text' name='num1'/> </br>");
		salida.println("Numero 2: <input type='text' name='num2'/> </br>");
		salida.println("<input type ='submit' value='Sumar'/>");
		salida.println("</form>");
		salida.println("<h1>Hola "+nombre+"</h1>");
		salida.println("<p>Su rut es "+rut+"</p>");
		salida.println("<p>Su edad es: "+edadToInt+" </p>");
		if(edadToInt >= 18) {
			salida.println("<p> Mayor de edad </p>");
		} else {
			salida.println("<p> Menor de edad </p>");
		}
		salida.println("</html></body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter salida = response.getWriter();
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		
		int nom1 = Integer.parseInt(num1);
		int nom2= Integer.parseInt(num2);

		int resultado = nom1 + nom2;
		
		salida.println("<html><body>");
		salida.println("<h1>Resultado</h1>");
		salida.println("<br>");
		salida.println("<p>El resultado de la suma es: "+resultado+"</p>");
		salida.println("</html></body>");
	}

}
