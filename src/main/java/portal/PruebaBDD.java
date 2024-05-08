package portal;
import java.sql.Connection;
import java.sql.SQLException;

import conectar.MySQLConnector;

public class PruebaBDD {
	
	
	
	public static void main(String[] args) {
		try {
			Connection conexion = new MySQLConnector().getMySQLConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
