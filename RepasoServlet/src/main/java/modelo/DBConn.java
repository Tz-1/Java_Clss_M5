package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private static final String URL = "jdbc:postgresql://localhost:5432/db_productos";
	private static final String USER = "postgres";
	private static final String PASSWORD = "tb123";
	private static Connection cnx = null;
	
	private DBConn() {
		try {
			Class.forName("org.postgresql.Driver");
			
			cnx = DriverManager.getConnection(URL,USER,PASSWORD);
			
			if(cnx != null) {
				System.out.println("Conexion establecida");
			} else {
				System.out.println("No se logro conectar");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection conectar() {
		if(cnx==null) {
			new DBConn();
		}
		return cnx;
	}
	
}
