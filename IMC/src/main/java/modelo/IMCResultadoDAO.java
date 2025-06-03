package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IMCResultadoDAO {
	public boolean grabarIMC(IMCResultado imc) throws SQLException {
		String sql = "INSERT INTO resultado_imc (user_id, peso, altura, imc) VALUES (?,?,?,?)"; 
		try {
			Connection conn = DBConn.getConexion();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, imc.getUserId());
			pstm.setFloat(2, imc.getPeso());
			pstm.setFloat(3, imc.getAltura());
			pstm.setFloat(4, imc.getImc());
			return pstm.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
}
