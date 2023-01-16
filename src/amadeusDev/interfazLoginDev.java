package amadeusDev;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import MODEL.gestorUsuarios;
import MODEL.desarrollador;
import VIEW.interfazLogin;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class interfazLoginDev {

	private JFrame frmAmadeusDev;
	private JTextField usernameTxt;
	private JPasswordField passwordTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazLoginDev window = new interfazLoginDev();
					window.frmAmadeusDev.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfazLoginDev() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAmadeusDev = new JFrame();
		frmAmadeusDev.setTitle("Amadeus Dev");
		frmAmadeusDev.setIconImage(Toolkit.getDefaultToolkit().getImage(interfazLoginDev.class.getResource("/img/icono.png")));
		frmAmadeusDev.setResizable(false);
		frmAmadeusDev.setBounds(100, 100, 450, 300);
		frmAmadeusDev.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAmadeusDev.getContentPane().setLayout(null);
		
		JLabel username = new JLabel("Nombre de ususario:");
		username.setFont(new Font("Tahoma", Font.PLAIN, 11));
		username.setBounds(65, 85, 99, 14);
		frmAmadeusDev.getContentPane().add(username);
		
		usernameTxt = new JTextField();
		usernameTxt.setColumns(10);
		usernameTxt.setBounds(174, 82, 173, 20);
		frmAmadeusDev.getContentPane().add(usernameTxt);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setBounds(174, 123, 173, 20);
		frmAmadeusDev.getContentPane().add(passwordTxt);
		
		JLabel password = new JLabel("Contrase\u00F1a:");
		password.setFont(new Font("Tahoma", Font.PLAIN, 11));
		password.setBounds(104, 126, 60, 14);
		frmAmadeusDev.getContentPane().add(password);
		
		ImageIcon imageIcon = new ImageIcon(interfazLogin.class.getResource("/img/icono.png"));
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		
		JLabel logo = new JLabel("");
		logo.setIcon(imageIcon);
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setBounds(191, 11, 60, 60);
		frmAmadeusDev.getContentPane().add(logo);
		
		JButton login = new JButton("Iniciar Sesión");
		login.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String Username=usernameTxt.getText();
				String Password=passwordTxt.getText();
				if(gestorUsuarios.logInDev(Username,Password)==1) {
		        	frmAmadeusDev.dispose();
		        	desarrollador desarrollador=gestorDev.visualizarCuenta(Username);
					interfazDev.main(new String[0],desarrollador);
		        }
				else {
					JOptionPane.showMessageDialog(null, "Usuario/Contraseña - Incorrectos");
				}
			}
		});
		login.setFont(new Font("Tahoma", Font.PLAIN, 11));
		login.setBounds(248, 154, 99, 23);
		frmAmadeusDev.getContentPane().add(login);
		login.getRootPane().setDefaultButton(login);
		
		JButton exit = new JButton("Salir");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		exit.setBounds(335, 227, 89, 23);
		frmAmadeusDev.getContentPane().add(exit);
	}
}
