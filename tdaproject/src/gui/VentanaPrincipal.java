package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;


public class VentanaPrincipal extends JFrame {

	private JPanel principal;
	private JTextField user;
	private JPasswordField password;
	JButton btnIn;
	VentanaPlanificador vent = new VentanaPlanificador();
	
	public VentanaPrincipal() {
		setType(Type.UTILITY);
		setTitle("INICIO DE SESION");
		setForeground(Color.WHITE);
		setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 305);
		principal = new JPanel();
		principal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(principal);
		principal.setLayout(null);
		
		user = new JTextField();
		user.setToolTipText("\r\n");
		user.setBounds(86, 85, 270, 20);
		principal.add(user);
		user.setColumns(1);
		
		password = new JPasswordField();
		password.setEchoChar('*');
		password.setBounds(86, 134, 270, 20);
		principal.add(password);
		
		JLabel userlabel = new JLabel("Usuario:");
		userlabel.setBounds(86, 63, 270, 14);
		principal.add(userlabel);
		
		JLabel passlabel = new JLabel("Contrase\u00F1a:");
		passlabel.setBounds(86, 116, 270, 14);
		principal.add(passlabel);
		
		btnIn = new JButton("Ingresar");
		btnIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acceso();
			}
		});
		btnIn.setBounds(86, 183, 270, 23);
		principal.add(btnIn);
	}
	public void acceso() {
		
		if(user.getText().toLowerCase().equals("admin") && password.getText().toLowerCase().equals("admin") ) {
			vent.setVisible(true);
			user.setText("");
			password.setText("");
			setVisible(false);
			
		}
		else {
			user.setText("");
			password.setText("");
		}
	}
}
