package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import MODEL.gestorUsuarios;
import MODEL.usuario;
public class interfazDowngrade {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,usuario usuario) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazDowngrade window = new interfazDowngrade(usuario);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfazDowngrade(usuario usuario) {
		initialize(usuario);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(usuario usuario) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(interfazUpgrade.class.getResource("/img/icono.png")));
		frame.setTitle("Cancelar membresía");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton downG = new JButton("Si");
		downG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorUsuarios.downgradeUser(usuario.getUsuario());
				usuario.setPrem(false);
				frame.dispose();
				interfazLibreria.main(new String[0],usuario);
			}
		});
		panel.add(downG);
		
		JButton cancelB = new JButton("No");
		cancelB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				interfazLibreria.main(new String[0],usuario);
			}
		});
		panel.add(cancelB);
	}

}
