import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class Login extends JFrame{
	public String username;
	public String password;
	public JTextField txUsername;
	public JPasswordField txPassword;
	
	public Login() {
		setSize(500, 500);
		setTitle("LogIn");
		setLocationRelativeTo(null);
		this.setMinimumSize(new Dimension(200, 200));
		
		initComponents();
	
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
	}
	
	
	private void initComponents() {
		JPanel jp = new JPanel();
		jp.setLayout(null);
		this.getContentPane().add(jp);
		
		JLabel lbusername = new JLabel();
		lbusername.setText("Username: ");
		lbusername.setBounds(20, 50, 150, 20);
		jp.add(lbusername);
		
		JTextField txUsername = new JTextField();
		txUsername.setBounds(100, 50, 150, 20);
		jp.add(txUsername);
		
		JLabel lbpassword = new JLabel();
		lbpassword.setText("Password: ");
		lbpassword.setBounds(20, 100, 150, 20);
		jp.add(lbpassword);
		
		JPasswordField txPassword = new JPasswordField();
		txPassword.setBounds(100, 100, 150, 20);
		jp.add(txPassword);
		
		JButton btn = new JButton();
		btn.setText("Entrar");
		btn.setBounds(60, 150, 80, 30);
		jp.add(btn);
		
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				username = txUsername.getText();
				char[] pwd = txPassword.getPassword();
				password = cvPassword(pwd);
				
				System.out.println(username);
				System.out.println(password);
				try {
					LogIn(username, password);
					setVisible(false);
					RegisterForm rf = new RegisterForm();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			
		};
		btn.addActionListener(al);
	}
	
	
	

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
				System.out.println("Usuario o Contrase??a en blanco");
				System.exit(1);
			}else {
				PreparedStatement pstm = conn.prepareStatement(SQL);
				pstm.setString(1, username);
				
				
				ResultSet rs = pstm.executeQuery();
				while(rs.next()) {
					user1 = rs.getString("username");
					pwd = rs.getString("password");
					if(username.equals(user1) && password.equals(pwd)) {
						System.out.println("Usuario v??lido");
						
					}else {
						System.out.println("Usuario o contrase??a inv??lidos");
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
