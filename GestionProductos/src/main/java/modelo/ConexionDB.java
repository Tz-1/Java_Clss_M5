package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
	// Definimos las constantes
	private static final String URL = "jdbc:postgresql://localhost:5432/db_productos";
    private static final String USER = "postgres";
    private static final String PASSWORD = "tb123";
    private static Connection conn = null;
    
    
	private ConexionDB() {
		try {
			// Forzar la carga del driver
			Class.forName("org.postgresql.Driver");
			
			
			//Creamos la conexion a partir del objeto conexion.
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			//Verificar si se logro la conexion
			if(conn!=null) {
				System.out.println("Conexion Establecida");
			} else {
				System.out.println("No se logro conectar");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnect() {
		if(conn==null) {
			new ConexionDB();
		}
		return conn;
	}
}
