import java.sql.Connection;

public class InsertUsers {
	public String username;
	
	public InsertUsers() {
		
	}
	
	
	public void CrearUsuarios(String username, String password) throws ClassNotFoundException {
		MysqlConnector my = new MysqlConnector();
		Connection conn = my.DBConnection();
		
		Login lg = new Login();
		lg.EncryptPassword(password);
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}
	
}
