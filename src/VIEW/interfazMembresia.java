package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class interfazMembresia {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazMembresia window = new interfazMembresia(user);
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
	public interfazMembresia(String user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String user) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
