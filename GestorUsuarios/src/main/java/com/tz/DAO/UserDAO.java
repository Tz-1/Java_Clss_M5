package com.tz.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tz.conf.DatabaseConnection;
import com.tz.modelo.Usuario;

public class UserDAO {
	public List<Usuario> getUsers(){
		List<Usuario> usuarios = new ArrayList<>();
		String consulta = "SELECT * FROM usuarios WHERE id_user != false;";
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnection.getConnection();
			if(conn == null) {
        		throw new SQLException("Problema con la conexión a la base de datos");
        	}
			stmt = conn.prepareStatement(consulta);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				usuarios.add(new Usuario(rs.getInt("id_user"), rs.getString("nombre"), rs.getString("correo"), rs.getString("clave")
						, rs.getInt("id_rol"), rs.getBoolean("estado")));
			}
			System.out.println("Lista de Usuarios con exito");
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public Usuario getUser(int idUser) {
		Usuario user = null;
		String sql = "SELECT * FROM usuarios WHERE id_user"+idUser;
		Connection conn = null;
		try {
			conn = DatabaseConnection.getConnection();
			if(conn == null) {
        		throw new SQLException("Problema con la conexión a la base de datos");
        	}
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				user = new Usuario(rs.getInt("id_user"), rs.getString("nombre"), rs.getString("correo"), rs.getString("clave")
						,rs.getInt("id_rol"), rs.getBoolean("estado"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public void addUser(Usuario user) throws SQLException{
		String query = "INSERT INTO usuarios (nombre, correo, clave, id_rol, estado) VALUES (?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
        	conn = DatabaseConnection.getConnection();
        	if(conn == null) {
        		throw new SQLException("No se puedo establecer la conexión con la base de datos");
        	}
            stmt = conn.prepareStatement(query);
            stmt.setString(1, user.getNombre());
            stmt.setString(2, user.getCorreo());
            stmt.setString(3, user.getClave());
            stmt.setInt(4, user.getIdRol());
            if(!stmt.execute()) {
            	System.out.println("Usuario creado con extio");
            } else {
            	System.out.println("Fallo la creacion del usuario");
            }
            stmt.close();
        } catch (SQLException e) {
			e.printStackTrace();
        }finally {
        	System.out.println("Agrego Rol con exito");
        }
	}
	
	public void updateUser(Usuario user) {
		String query = "UPDATE usuarios SET nombre=?, correo=?, clave=?, id_role=?, estado=?";
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
        	conn = DatabaseConnection.getConnection();
        	if(conn == null) {
        		throw new SQLException("No se puedo establecer la conexión con la base de datos");
        	}
            stmt = conn.prepareStatement(query);
            stmt.setString(1, user.getNombre());
            stmt.setString(2, user.getCorreo());
            stmt.setString(3, user.getClave());
            stmt.setInt(4, user.getIdRol());
            stmt.setBoolean(5, user.isEstado());
            if(stmt.executeUpdate() > 0) {
            	System.out.println("Usuario actualizado con extio");
            } else {
            	System.out.println("Fallo la actualizacion del usuario");
            }
            stmt.close();
        } catch (SQLException e) {
			e.printStackTrace();
		}finally {
        	System.out.println("Agrego Rol con exito");
        }
	}
	
	public void eliminarUser(int idUser) {
		String query = "DELETE FROM usuarios WHERE id_user = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnection.getConnection();
			if(conn == null) {
				throw new SQLException("No se puedo establecer la conexión con la base de datos");
			}
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, idUser);
			int fila = stmt.executeUpdate();
			if(fila > 0) {
				System.out.println("Se elimino el usuario con exito.");
			}else {
				System.out.println("Problemas al eliminar el usuario");
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
