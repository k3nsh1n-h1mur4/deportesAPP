import java.sql.*;
import java.sql.SQLException;


public class MysqlConnector {
	
	Connection connection = null;
	private static final String HOST = "localhost:3306";
	private static final String DB = "dbAdmision";
	private static final String USER = "k3nsh1n";
	private static final String PWD = "k0rn82...";
	private static final String URL = String.format("jdbc:mysql://%s/%s?user=%s&password=%s", HOST, DB, USER, PWD);
	
	public static Connection DBConnection() throws ClassNotFoundException{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(URL);
			if(connection.isValid(5000)) {
				System.out.println("Conexión Exitosa");
			}
			
			System.out.println(connection.getClass());
			return connection;
		}catch(SQLException ex) {
			System.out.printf("Error: %s", ex.getMessage());
			System.out.printf("Error: %s", ex.getErrorCode());
		}
		return null;
		
	}
	
}
