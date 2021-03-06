import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class InsertUsers {
	public String username;
	public String password;
	
	public InsertUsers() {
		
	}
	
	
	public void CrearUsuarios(String username, String password) throws ClassNotFoundException {
		String SQL = "INSERT INTO users(username, password)VALUES(?,?)";
		MysqlConnector my = new MysqlConnector();
		Connection conn = my.DBConnection();
		
		try {
			PreparedStatement pstm = conn.prepareStatement(SQL);
			pstm.setString(1, username);
			pstm.setString(2, password);
			ResultSet rs = pstm.executeQuery();
			if(rs.rowInserted()) {
				System.out.println("Usuario Registrado");
			}else {
				System.out.println("Error");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String EncryptedPassword(String password) throws NoSuchAlgorithmException {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(password.getBytes());
			byte[] pass = messageDigest.digest();
			StringBuilder sb = new StringBuilder();
			for(byte b : pass) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
			
		}catch(IllegalArgumentException al) {
			System.out.printf("Error: %s", al.getMessage());
		}
		
		
		return password;
	}
	
}
