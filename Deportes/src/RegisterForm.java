import java.awt.*;
import javax.swing.*;


public class RegisterForm {

	public RegisterForm() {
		JFrame jf = new JFrame();
		JLabel lbuser = new JLabel();
		lbuser.setText("Usuario: ");
		lbuser.setBounds(20, 50, 150, 20);
		JTextField txuser = new JTextField();
		txuser.setText("Usuario: ");
		txuser.setBounds(100, 50, 150, 20);
		
		JLabel lbpassword = new JLabel();
		lbpassword.setText("Usuario: ");
		lbpassword.setBounds(20, 100, 150, 20);
		JTextField txpassword = new JTextField();
		txpassword.setText("Usuario: ");
		txpassword.setBounds(20, 100, 150, 20);
		
		
		
		jf.add(lbuser);
		jf.add(txuser);
		jf.add(lbpassword);
		jf.add(txpassword);
		jf.setLayout(null);
		jf.setSize(400, 400);
		jf.setVisible(true);
	}
	
	
	
}