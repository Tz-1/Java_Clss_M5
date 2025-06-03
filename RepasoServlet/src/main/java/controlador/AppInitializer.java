package controlador;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import modelo.Usuario;

/**
 * Application Lifecycle Listener implementation class AppInitializer
 *
 */
@WebListener
public class AppInitializer implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public AppInitializer() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Tz","admin","123"));
        // Guardar la lista en el contexto de la aplicacion
        sce.getServletContext().setAttribute("usuarios", usuarios);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}
