package conectar;

import java.io.IOException;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.util.Properties;

	public class MySQLConnector {

	    Properties prop = new Properties();

	    public MySQLConnector() {
	        try {
	            prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    public Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
	        try {

	            Class.forName(prop.getProperty(MySQLConstants.DRIVER));

	            return  DriverManager.getConnection(getURL());

	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e.getMessage());
	            throw e;
	        }
	    }
	    private String getURL() {
	        return prop.getProperty(MySQLConstants.URL_PREFIX) +
	                prop.getProperty(MySQLConstants.URL_HOST) + ":" +
	                prop.getProperty(MySQLConstants.URL_PORT) + "/" +
	                prop.getProperty(MySQLConstants.URL_SCHEMA) + "?user=" +
	                prop.getProperty(MySQLConstants.USER) + "&password=" +
	                prop.getProperty(MySQLConstants.PASSWD) + "&useSSL=" +
	                prop.getProperty(MySQLConstants.URL_SSL);
	    }

	    public static void main(String[] args) throws SQLException, ClassNotFoundException {
	        MySQLConnector connector = new MySQLConnector();
	        Connection connection = connector.getMySQLConnection();
	        System.out.println(connection.getCatalog());
	       
	    }

		public Properties getProp() {
			return prop;
		}

		public void setProp(Properties prop) {
			this.prop = prop;
		}
	    
	    
	}

