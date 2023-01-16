package amadeusDev;

import java.awt.EventQueue;
import javax.swing.JFrame;

import gestionSoporte.*;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import MODEL.gestorLibreria;
import MODEL.videojuego;
import MODEL.desarrollador;
import MODEL.gestorTienda;
import VIEW.interfazAcerca;
import VIEW.interfazLogin;
import VIEW.interfazReporte;
import VIEW.interfazResenas;

import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class interfazDev {
	
	static String sel = null;
	static videojuego game = null;

	private JFrame interfazDev;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, desarrollador desarrollador) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazDev window = new interfazDev(desarrollador);
					window.interfazDev.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfazDev(desarrollador desarrollador) {
		initialize(desarrollador);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize(desarrollador desarrollador) {
		
		interfazDev = new JFrame();
		interfazDev.setIconImage(Toolkit.getDefaultToolkit().getImage(interfazDev.class.getResource("/img/icono.png")));
		interfazDev.setTitle("Amadeus - "+desarrollador.getNombre());
		interfazDev.setBounds(100, 100, 1000, 717);
		interfazDev.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		interfazDev.getContentPane().setLayout(null);
		
		JButton exit = new JButton("Salir");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		exit.setBounds(885, 627, 89, 23);
		interfazDev.getContentPane().add(exit);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 964, 609);
		interfazDev.getContentPane().add(panel);
		panel.setLayout(null);
		
		@SuppressWarnings("rawtypes")
		JList list = new JList();
		DefaultListModel<String> model;
		model = new DefaultListModel<>();
		for (String nomJ : gestorLibreria.mostrarJuegosDev(desarrollador.getDev())) {
			model.addElement(nomJ);
        }
		list.setModel(model);
		list.setBackground(Color.LIGHT_GRAY);
		list.setBounds(10, 52, 185, 546);
		panel.add(list);
		
		JLabel lblNewLabel = new JLabel("Juegos del desarrollador");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 185, 30);
		panel.add(lblNewLabel);
		
		JButton cuenta = new JButton("Mi cuenta");
		cuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazCuentaDev.main(new String[0],desarrollador);
			}
		});
		cuenta.setBounds(875, 0, 89, 23);
		panel.add(cuenta);
		
		JLabel userName = new JLabel("Bienvenido/a: " + desarrollador.getNombre());
		userName.setHorizontalAlignment(SwingConstants.RIGHT);
		userName.setBounds(659, 4, 206, 14);
		panel.add(userName);
		
		JLabel title = new JLabel("");
		title.setFont(new Font("Tahoma", Font.BOLD, 20));
		title.setBounds(205, 53, 759, 30);
		panel.add(title);
		
		JTextArea descBox = new JTextArea();
		descBox.setBackground(Color.LIGHT_GRAY);
		descBox.setBounds(205, 385, 749, 213);
		descBox.setLineWrap(true);
		descBox.setWrapStyleWord(true);
		panel.add(descBox);
		descBox.setVisible(false);
		
		JLabel cat = new JLabel("Categoría: ");
		cat.setHorizontalAlignment(SwingConstants.CENTER);
		cat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cat.setBounds(304, 354, 78, 20);
		panel.add(cat);
		cat.setVisible(false);
		
		JLabel genre = new JLabel("Genero: ");
		genre.setHorizontalAlignment(SwingConstants.CENTER);
		genre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		genre.setBounds(642, 354, 62, 20);
		panel.add(genre);
		genre.setVisible(false);
		
		JLabel catLabel = new JLabel("");
		catLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		catLabel.setBounds(392, 354, 240, 20);
		panel.add(catLabel);
		
		JLabel genLabel = new JLabel("");
		genLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		genLabel.setBounds(714, 354, 240, 20);
		panel.add(genLabel);
		
		JLabel img1 = new JLabel("");
		img1.setBounds(205, 117, 232, 191);
		panel.add(img1);
		
		JLabel img2 = new JLabel("");
		img2.setBounds(462, 117, 232, 191);
		panel.add(img2);
		
		JLabel img3 = new JLabel("");
		img3.setBounds(722, 117, 232, 191);
		panel.add(img3);
		
		JButton logoff = new JButton("Cerrar sesión");
		logoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazDev.dispose();
				interfazLoginDev.main(new String[0]);
			}
		});
		logoff.setFont(new Font("Tahoma", Font.PLAIN, 11));
		logoff.setBounds(769, 627, 106, 23);
		interfazDev.getContentPane().add(logoff);
		
		JMenuBar menuBar = new JMenuBar();
		interfazDev.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Ayuda");
		mnNewMenu.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mnNewMenu);
		
		JMenuItem reporteMenu = new JMenuItem("Generar reporte");
		reporteMenu.setHorizontalAlignment(SwingConstants.LEFT);
		reporteMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazReporte.main(new String[0],desarrollador.getDev());
			}
		});
		mnNewMenu.add(reporteMenu);
		
		JMenuItem acercaMenu = new JMenuItem("Acreca de Amadeus");
		acercaMenu.setHorizontalAlignment(SwingConstants.LEFT);
		acercaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazAcerca.main(new String[0]);
			}
		});
		mnNewMenu.add(acercaMenu);
		
		JButton resenasBt = new JButton("Mostrar reseñas");
		resenasBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sel==null) {
					JOptionPane.showMessageDialog(null, "Primero seleccione un juego.");
				}
				else {
					interfazResenas.main(new String[0],game);
				}
			}
		});
		resenasBt.setFont(new Font("Tahoma", Font.PLAIN, 11));
		resenasBt.setBounds(20, 627, 186, 23);
		interfazDev.getContentPane().add(resenasBt);
		resenasBt.setVisible(false);
		
		list.addListSelectionListener(new ListSelectionListener() {

	        @Override
	        public void valueChanged(ListSelectionEvent arg0) {
	            if (!arg0.getValueIsAdjusting()) {
	            	String selected =list.getSelectedValue().toString();
	            	sel=selected;
	            	videojuego juego=gestorTienda.visualizarTienda(selected);
	            	game=juego;
	            	
	            	ImageIcon imageIcon1 = new ImageIcon(interfazLogin.class.getResource("/img/"+juego.getID()+"_1.jpg"));
	        		Image image = imageIcon1.getImage();
	        		Image newimg = image.getScaledInstance(198, 172,  java.awt.Image.SCALE_SMOOTH);
	        		imageIcon1 = new ImageIcon(newimg);
	        		img1.setIcon(imageIcon1);
	        		
	        		ImageIcon imageIcon2 = new ImageIcon(interfazLogin.class.getResource("/img/"+juego.getID()+"_2.jpg"));
	        		Image image2 = imageIcon2.getImage();
	        		Image newimg2 = image2.getScaledInstance(198, 172,  java.awt.Image.SCALE_SMOOTH);
	        		imageIcon2 = new ImageIcon(newimg2);
	        		img2.setIcon(imageIcon2);
	        		
	        		ImageIcon imageIcon3 = new ImageIcon(interfazLogin.class.getResource("/img/"+juego.getID()+"_3.jpg"));
	        		Image image3 = imageIcon3.getImage();
	        		Image newimg3 = image3.getScaledInstance(198, 172,  java.awt.Image.SCALE_SMOOTH);
	        		imageIcon3 = new ImageIcon(newimg3);
	        		img3.setIcon(imageIcon3);
	        		
	            	descBox.setText(juego.getDescripcion());
	            	title.setText(juego.getNombre());
	            	catLabel.setText(juego.getCategoria());
	            	genLabel.setText(juego.getGenero());
	            	cat.setVisible(true);
	            	genre.setVisible(true);
	            	descBox.setVisible(true);
	            	resenasBt.setVisible(true);
	            }
	        }
	    });
	}
}
