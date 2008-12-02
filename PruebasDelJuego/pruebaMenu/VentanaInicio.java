package pruebaMenu;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.SuperficieDeDibujo;
import vista.Ventana;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;


import controlador.MouseAdaptador;


public class VentanaInicio extends JFrame{
	JPanel panel = new JPanel();
	JButton btJugar = new JButton("Jugar");
	JButton btNivel = new JButton("Elejir nivel");
	JButton btSalir = new JButton("Salir");

	
	public VentanaInicio() {
		this.setSize(200, 200);
		this.setResizable(false);
		MouseParaMenu oyenteMenu = new MouseParaMenu(this);	
		
		btJugar.addMouseListener(oyenteMenu);
		btNivel.addMouseListener(oyenteMenu);
		btSalir.addMouseListener(oyenteMenu);
		
		panel.add(btJugar);
		panel.add(btNivel);
		panel.add(btSalir);
		
		panel.setLayout(new GridLayout(3,1));
		this.getContentPane().add(panel);
		
		this.setBackground(Color.black);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}

	public void paint(Graphics g) {
		super.paint(g);
	
	}
	
	
	
}


