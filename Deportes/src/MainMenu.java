import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MainMenu extends JFrame{
	public JButton al;
	public JFrame jf;
	
	public MainMenu() {
		JFrame jf = new JFrame();
		jf.setBounds(100, 200, 500, 500);
		
		JPanel jp = new JPanel();
		jp.setBackground(Color.CYAN);
		jf.getContentPane().add(jp);
		JButton btnLogin = new JButton();
		btnLogin.setBounds(60, 150, 30, 15);
		btnLogin.setText("LogIn");
		
		JButton btnRegister = new JButton();
		btnRegister.setBounds(60, 250, 30, 15);
		btnRegister.setText("Registro");
		
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == btnLogin) {
					System.out.println("Boton de LogIn");
					Login lg = new Login();
					jf.setVisible(false);	
				} else if(e.getSource() == btnRegister) {
					RegisterForm rf = new RegisterForm();
					
				}
			}
			
		};
		
		
		jp.add(btnLogin);
		jp.add(btnRegister);
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setVisible(true);
		btnLogin.addActionListener(al);
		
	}
	
	
	
	
	
}
