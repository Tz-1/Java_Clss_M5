package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
	public boolean registrarUsuario(Usuario user) throws SQLException{
		String sql = "INSERT INTO usuarios (nombre,clave, correo) VALUES (?,?,?)";
		try {
			Connection conn = DBConn.getConexion();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getNombre());
			pstm.setString(2, user.getClave());
			pstm.setString(3, user.getCorreo());
			if(pstm.executeUpdate() > 0) {
				System.out.println("Usuario Añadido");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Usuario esUsuarioValido(String usuario, String clave) throws SQLException{
		String sql = "SELECT * FROM usuarios WHERE correo = ? AND clave = ?";
		try {
			Connection conn = DBConn.getConexion();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, usuario);
			pstm.setString(2, clave);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				Usuario user = new Usuario(rs.getString("nombre"), rs.getString("correo"), rs.getString("clave"));
				user.setId(rs.getInt("id"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
