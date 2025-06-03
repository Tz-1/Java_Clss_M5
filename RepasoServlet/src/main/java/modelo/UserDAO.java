package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

	private Usuario user = new Usuario();
	
	public List<Usuario> getUsuarios(){
		String sql = "SELECT * FROM usuarios";
		List<Usuario> users = new ArrayList<>();
		try {
			Connection con = DBConn.conectar();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				user.setNombre(rs.getString("nombre"));
				user.setClave(rs.getString("clave"));
				user.setUsuario(rs.getString("usuario"));
				users.add(user);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
}
