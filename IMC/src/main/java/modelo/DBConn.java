package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	
	private static final String URL = "jdbc:postgresql://localhost:5432/imc_db";
	private static final String USER = "postgres";
	private static final String PASSWORD = "tb123";
	private static Connection cnx = null;
	
	public static Connection getConexion() throws SQLException, ClassNotFoundException {
		if(cnx==null || cnx.isClosed()) {
			Class.forName("org.postgresql.Driver");
			cnx = DriverManager.getConnection(URL,USER,PASSWORD);
			System.out.println("Conexion establecida");
		}
		return cnx;
	}
}
