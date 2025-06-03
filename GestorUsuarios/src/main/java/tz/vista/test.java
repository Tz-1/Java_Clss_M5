package tz.vista;

import java.sql.SQLException;
import java.util.List;

import com.tz.DAO.RoleDAO;

public class test {

	public static void main(String[] args) {
	    RoleDAO dao = new RoleDAO();
	    try {
	        List<String> roles = dao.getRoles();
	        System.out.println("Roles obtenidos: " + roles);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


}
