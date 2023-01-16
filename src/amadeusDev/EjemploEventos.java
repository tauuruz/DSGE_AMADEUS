package amadeusDev;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class EjemploEventos {

	public static void main(String[] args) {
		FrameBotones frm=new FrameBotones();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.show();
	}
}

class FrameBotones extends JFrame{
	JButton btnAzul = new JButton("Azul");
	JButton btnAmarillo = new JButton("Amarillo");
	JButton btnRojo = new JButton("Rojo");
		
	FrameBotones(){
		setTitle("Ejemplo de eventos");
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(btnAzul);
		getContentPane().add(btnAmarillo);
		getContentPane().add(btnRojo);
		pack();
		btnAzul.addActionListener(new MiOyente());
		btnAmarillo.addActionListener(new MiOyente());
		btnRojo.addActionListener(new MiOyente());
		}
	
	class MiOyente implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource()==btnAzul)
				getContentPane().setBackground(Color.BLUE);
			else if(event.getSource()==btnAmarillo)
				getContentPane().setBackground(Color.YELLOW);
			else if(event.getSource()==btnRojo)
				getContentPane().setBackground(Color.RED);
		}
	}
}


