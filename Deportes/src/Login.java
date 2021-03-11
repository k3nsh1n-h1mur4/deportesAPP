import java.sql.*;


public class Login{
	public String username;
	public String password;
	
	public Login() {}

	public void LogIn(String username, String password) throws ClassNotFoundException{
		String user1 = null;
		String pwd = null;
		
		String SQL = "SELECT * FROM users WHERE username = ?";
		System.out.println(username);
		System.out.printf("hash: %s", password.hashCode());
		
		MysqlConnector my = new MysqlConnector();
		Connection conn = my.DBConnection();
		//System.out.println(conn.getClass());
		try {
			if(username.isEmpty() && password.isEmpty()) {
				System.out.println("Usuario o Contraseña en blanco");
				System.exit(1);
			}else {
				PreparedStatement pstm = conn.prepareStatement(SQL);
				pstm.setString(1, username);
				
				
				ResultSet rs = pstm.executeQuery();
				while(rs.next()) {
					user1 = rs.getString("username");
					pwd = rs.getString("password");
					if(username.equals(user1) && password.equals(pwd)) {
						System.out.println("Usuario válido");
					}else {
						System.out.println("Usuario o contraseña inválidos");
						System.exit(1);
					}
				}
				//System.out.println(pstm);
				//System.out.println(user1);
				//System.out.println(pwd);
			}
			
		}catch(SQLException e) {
			System.out.printf("Error: %s", e.getMessage());
		}
		
		
		
	}
	
	public String cvPassword(char[] password) {
		String pwd = new String(password);
		//System.out.println(pwd);
		return pwd;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}

	public Integer EncryptPassword(String password) {
		int encrypted_password;
		this.password = password;
		encrypted_password = password.hashCode();
		return encrypted_password;
	}
	
	
	
}
