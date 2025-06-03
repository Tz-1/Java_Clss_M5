package controlador;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Producto;
import modelo.ProductoDAOImpl;

/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet("/productos")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductoDAOImpl implDAO = new ProductoDAOImpl();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		try {
			if("add".equals(accion)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("addProducto.jsp");
				dispatcher.forward(request, response);
				
			}else if(accion == null){
				List<Producto> productos = implDAO.getAllProducts();
				request.setAttribute("productos", productos);	
				RequestDispatcher dispatcher = request.getRequestDispatcher("productos.jsp");
				dispatcher.forward(request, response);
	
			}else if ("editar".equals(accion)) {
				int id = Integer.parseInt(request.getParameter("id"));
				Producto p = implDAO.getProduct(id);
				request.setAttribute("p", p);
				RequestDispatcher dispatcher = request.getRequestDispatcher("editProductos.jsp");
				dispatcher.forward(request, response);
				
			}else if("eliminar".equals(accion)) {
				int id = Integer.parseInt(request.getParameter("id"));
				request.setAttribute("id", id);
				implDAO.eliminarProduct(id);
				response.sendRedirect("/GestionProductos/productos");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		try {
			if("add".equals(accion)) {
				String nombre = request.getParameter("nombre");
				double precio = Double.parseDouble(request.getParameter("precio"));
				implDAO.addProduct(new Producto(0, nombre, precio));
				response.sendRedirect("/GestionProductos/productos");
			}else if ("editar".equals(accion)){
				int id = Integer.parseInt(request.getParameter("id"));
				String nombre = request.getParameter("nombre");
				double precio = Double.parseDouble(request.getParameter("precio"));
				implDAO.updateProduct(new Producto(id, nombre, precio));
				response.sendRedirect("/GestionProductos/productos");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
