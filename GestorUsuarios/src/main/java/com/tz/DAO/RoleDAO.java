package com.tz.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tz.conf.DatabaseConnection;
import com.tz.modelo.Role;

//Need to update

public class RoleDAO {
	
	public List<String> getRoles() throws SQLException {
		List<String> roles = new ArrayList<>();
		String query = "SELECT nombre FROM roles WHERE estado != false";
		Connection conn = null;
        PreparedStatement stmt = null;
		try {
			conn = DatabaseConnection.getConnection();
			if(conn == null) {
        		throw new SQLException("No se puedo establecer la conexión con la base de datos");
        	}
			stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				roles.add(rs.getString("nombre"));
			}
			System.out.println("Listo Roles con exito");
			rs.close();
			stmt.close();
		}finally {
        	System.out.println("Listo Roles");
        }
		return roles;
	}
	
	public Role getRole(int id) {
		Role rol = null;
		String query = "SELECT id_rol, nombre, estado FROM roles WHERE id_rol = "+id;
		Connection conn = null;
		try {
			conn = DatabaseConnection.getConnection();
			if(conn == null) {
				throw new SQLException("No se puede establecer la conexion a la DB");
			}
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				rol = new Role(rs.getInt("id_rol"), rs.getString("nombre"), rs.getBoolean("estado"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rol;
	}
	
	public void addRole(String roleName) throws SQLException {
        String query = "INSERT INTO roles (nombre) VALUES (?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
        	conn = DatabaseConnection.getConnection();
        	if(conn == null) {
        		throw new SQLException("No se puedo establecer la conexión con la base de datos");
        	}
            stmt = conn.prepareStatement(query);
            stmt.setString(1, roleName);
            stmt.executeUpdate();
        }finally {
        	System.out.println("Agrego Rol con exito");
        }
    }

    public void deleteRole(int roleId) throws SQLException {
        String query = "DELETE FROM roles WHERE id_rol = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, roleId);
            stmt.executeUpdate();
        }
    }
}
