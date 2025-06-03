package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import interfaces.IProductoDAO;

public class ProductoDAOImpl implements IProductoDAO {
	

	@Override
	public void addProduct(Producto p) {
		String sql = "INSERT INTO productos (nombre, precio) VALUES (?, ?)";
		try {
			//Connection cnx = ConexionDB.getConnect();
			Connection cnx = PoolConexiones.getDataSource().getConnection();
			PreparedStatement stmt = cnx.prepareStatement(sql);
			stmt.setString(1, p.getNombre());
			stmt.setDouble(2, p.getPrecio());
			int fila = stmt.executeUpdate();
			if (fila > 0) {
				System.out.println("Producto agregado");
			} else {
				System.out.println("Algo ocurrio agregando el producto");
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Producto> getAllProducts() throws SQLException {
		List<Producto> productos = new ArrayList<>();
		String sql = "SELECT * FROM productos";
		//Connection cnx = ConexionDB.getConnect();
		try {
			Connection cnx = PoolConexiones.getDataSource().getConnection();
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				productos.add(new Producto(rs.getInt("id"), rs.getString("nombre"), 
						rs.getDouble("precio")));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productos;
	}

	@Override
	public Producto getProduct(int id) throws SQLException {
		String sql = "SELECT * FROM productos WHERE id = "+id;
		Producto p = new Producto();
		//Connection cnx = ConexionDB.getConnect();
		try {
			Connection cnx = PoolConexiones.getDataSource().getConnection();
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				p.setIdProducto(rs.getInt("id"));
				p.setNombre(rs.getString("nombre")); 
				p.setPrecio(rs.getDouble("precio"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void updateProduct(Producto p) {
		String query = "UPDATE productos SET nombre = ?, precio = ? WHERE id =?";
		try {
			Connection conn = PoolConexiones.getDataSource().getConnection();
			//conn = ConexionDB.getConnect();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, p.getNombre());
			stmt.setDouble(2, p.getPrecio());
			stmt.setInt(3, p.getIdProducto());
			int fila = stmt.executeUpdate();
			if(fila > 0) {
				System.out.println("Producto actualizado");
			}else {
				System.out.println("Problema al actualizar el producto");
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void eliminarProduct(int id) {
		String query = "DELETE FROM productos WHERE id = ?";
		try {
			Connection conn = PoolConexiones.getDataSource().getConnection();
			//conn = ConexionDB.getConnect();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			int fila = stmt.executeUpdate();
			if(fila > 0) {
				System.out.println("Producto eliminado");
			}else {
				System.out.println("Problema al eliminar el producto");
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
