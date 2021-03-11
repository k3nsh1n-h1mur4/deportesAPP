import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

import javax.swing.*;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class example{
	
	private static String username;
	private static String password;
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		// TODO Auto-generated method stub
		JFrame jf = new JFrame("LogIn");
		JLabel lbusername = new JLabel();
		lbusername.setText("Username: ");
		lbusername.setBounds(20, 50, 150, 20);
		JTextField txUsername = new JTextField();
		txUsername.setBounds(100, 50, 150, 20);
		
		JLabel lbpassword = new JLabel();
		lbpassword.setText("Password: ");
		lbpassword.setBounds(20, 100, 150, 20);
		JPasswordField txPassword = new JPasswordField();
		txPassword.setBounds(100, 100, 150, 20);
		JButton btn = new JButton();
		btn.setText("Entrar");
		btn.setBounds(60, 150, 80, 30);
		
		

		ActionListener al = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("Isaac");
				username = txUsername.getText();
				char[] pwd = txPassword.getPassword();
				
				
				
				Login lg = new Login();
				password = lg.cvPassword(pwd);
				InsertUsers iu = new InsertUsers();
				try {
					
					String p = iu.EncryptedPassword(password);
					System.out.println(p);
				} catch (NoSuchAlgorithmException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					lg.LogIn(username, password);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lg.setUsername(username);
				
				
				//String pwd = lg.cvPassword(password);
				//System.out.println(pwd);
			}
			
		};
		
		btn.addActionListener(al);
		
		
		jf.add(lbusername);
		jf.add(txUsername);
		jf.add(lbpassword);
		jf.add(txPassword);
		jf.add(btn);
		jf.setSize(400, 400);
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RegisterForm rf = new RegisterForm();
		

	}
	
	
	
	
}
