import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;



public class RegisterForm extends JFrame{
	private String username;
	private String password;
	public JTextField txUser;
	public JTextField txPassword;
	

	public RegisterForm() {
		setSize(500, 500);
		setTitle("Registro Usuarios");
		setLocationRelativeTo(null);
		this.setMinimumSize(new Dimension(200, 200));
		
		initComponents();
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	private void initComponents() {
		JPanel jp = new JPanel();
		jp.setLayout(null);
		this.getContentPane().add(jp);
		jp.setBackground(Color.ORANGE);
		
		JLabel lbuser = new JLabel();
		lbuser.setText("Usuario: ");
		lbuser.setBounds(20, 50, 150, 20);
		jp.add(lbuser);
		
		JTextField txuser = new JTextField();
		//txuser.setText("Usuario: ");
		txuser.setBounds(100, 50, 150, 20);
		jp.add(txuser);
		
		JLabel lbpassword = new JLabel();
		lbpassword.setText("Password: ");
		lbpassword.setBounds(20, 100, 150, 20);
		jp.add(lbpassword);
		
		JPasswordField txPassword = new JPasswordField();
		//txpassword.setText("Password: ");
		txPassword.setBounds(100, 100, 150, 20);
		jp.add(txPassword);
		
		JButton btnRegister = new JButton();
		btnRegister.setText("Registrar Usuario");
		btnRegister.setBounds(60, 150, 200, 30);
		jp.add(btnRegister);
		
		ActionListener al = new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				username = txuser.getText();
				char[] pwd = txPassword.getPassword();
				password = cvPassword(pwd);
				System.out.println(username);
				System.out.println(password);
				try {
					Register(username, password);
				} catch (Exception e2) {
					// TODO: handle exception
				}	
			}
			
		};
		btnRegister.addActionListener(al);
	}
	
	
	
	
	private void Register(String username, String password) throws ClassNotFoundException {
		/*username = txUser.getText();
		password = txPassword.getText();*/
		
		//String SQL = "INSERT INTO users(username, password)VALUES(?, ?)";
		/*System.out.println(username);
		System.out.println(password);*/
		//System.out.printf("hash: %s", password.hashCode());
		
		MysqlConnector my = new MysqlConnector();
		Connection conn = my.DBConnection();
		
		try {
			if(username.isEmpty() && password.isEmpty()) {
				System.out.println("Usuario o Contrase??a en blanco");
				System.exit(1);
			} else {
				PreparedStatement pstm = conn.prepareStatement("INSERT INTO users(username, password)VALUES(?, ?)");
				pstm.setString(1, username);
				pstm.setString(2, password);
				int rs = pstm.executeUpdate();
				System.out.println(rs);
				if(rs == 1) {
					System.out.println("Registro realizado exitosamente");
				} else if(rs == 2){
					System.out.println("Registro no se realizo");
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public String cvPassword(char[] password) {
		String pwd = new String(password);
		//System.out.println(pwd);
		return pwd;
	}

	
	/*public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}*/
	
	
	
	

	
	
}
