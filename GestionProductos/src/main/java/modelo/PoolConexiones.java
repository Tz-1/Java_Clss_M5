package modelo;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class PoolConexiones {
	private static final BasicDataSource dataSource = new BasicDataSource();
	
	static {
		dataSource.setUrl("jdbc:postgresql://localhost:5432/db_productos");
		dataSource.setUsername("postgres");
		dataSource.setPassword("tb123");
		dataSource.setDriverClassName("org.postgresql.Driver");
		
		
		// Configurar el pool de conexiones
		dataSource.setInitialSize(5); //Define cuantas conexiones se crean cuando inicializa el pool
		dataSource.setMaxTotal(20); //Define el maximo de conexiones en nuestra aplicacion
		dataSource.setMaxIdle(10); // Define el maximo de conexiones en espera
		dataSource.setMinIdle(5); // Define el minimo de conexiones en espera
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
}
