package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import MODEL.gestorUsuarios;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class interfazUpgradeR {

	private JFrame frmVolversePremium;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazUpgradeR window = new interfazUpgradeR(user);
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
	public interfazUpgradeR(String user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String user) {
		frmVolversePremium = new JFrame();
		frmVolversePremium.setResizable(false);
		frmVolversePremium.setIconImage(Toolkit.getDefaultToolkit().getImage(interfazUpgradeR.class.getResource("/img/icono.png")));
		frmVolversePremium.setTitle("Volverse Premium");
		frmVolversePremium.setBounds(100, 100, 450, 300);
		frmVolversePremium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmVolversePremium.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton goPrem = new JButton("Si");
		goPrem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmVolversePremium.dispose();
				gestorUsuarios.upgradeUser(user);
				interfazLogin.main(new String[0]);
			}
		});
		panel.add(goPrem);
		
		JButton discardPrem = new JButton("No");
		discardPrem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmVolversePremium.dispose();
				interfazLogin.main(new String[0]);
			}
		});
		panel.add(discardPrem);
	}

}
