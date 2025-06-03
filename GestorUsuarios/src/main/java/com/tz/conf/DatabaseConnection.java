package com.tz.conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static final String URL = "jdbc:postgresql:/localhost:5432/test";
    private static final String USER = "postgres";
    private static final String PASSWORD = "tb123";
    private static Connection cnx = null;
    
    private DatabaseConnection() {
    	try {
    		
    		// Cargamos el driver
    		Class.forName("org.postgresql.Driver");
    		
    		//Creamos la conexion
			//cnx = DriverManager.getConnection(URL, USER, PASSWORD);
    		cnx = DriverManager.getConnection("jdbc:postgresql:test?user=postgres&password=tb123");
    		
			//Verificamos
			if(cnx!=null) {
				System.out.println("Conexion establecida");
			}else {
				System.out.println("Fallo la conexion");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
        
    }
    public static Connection getConnection() {
    	if(cnx == null) {
    		new DatabaseConnection();
    	}
    	return cnx;
    }
}
