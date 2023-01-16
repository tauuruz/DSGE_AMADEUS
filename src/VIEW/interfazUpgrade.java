package VIEW;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import MODEL.gestorUsuarios;
import MODEL.usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class interfazUpgrade {

	private JFrame frmVolversePremium;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, usuario usuario) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazUpgrade window = new interfazUpgrade(usuario);
					window.frmVolversePremium.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfazUpgrade(usuario usuario) {
		initialize(usuario);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(usuario usuario) {
		frmVolversePremium = new JFrame();
		frmVolversePremium.setResizable(false);
		frmVolversePremium.setIconImage(Toolkit.getDefaultToolkit().getImage(interfazUpgrade.class.getResource("/img/icono.png")));
		frmVolversePremium.setTitle("Volverse Premium");
		frmVolversePremium.setBounds(100, 100, 450, 300);
		frmVolversePremium.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmVolversePremium.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton goPrem = new JButton("Si");
		goPrem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorUsuarios.upgradeUser(usuario.getUsuario());
				usuario.setPrem(true);
				frmVolversePremium.dispose();
				interfazLibreria.main(new String[0],usuario);
			}
		});
		panel.add(goPrem);
		
		JButton discardPrem = new JButton("No");
		discardPrem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmVolversePremium.dispose();
				interfazLibreria.main(new String[0],usuario);
			}
		});
		panel.add(discardPrem);
	}

}
