package vista;

import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;

import controlador.MouseAdaptador;



public class VentanaPrincipal extends Ventana {
	public VentanaPrincipal(int ancho, int alto) {
		super(ancho,alto);
		MouseAdaptador oyente = new MouseAdaptador();
		
		Panel panelBotones = new Panel();
		
		Button btCongelar = new Button("Congelar");
		btCongelar.setSize(10, 10);
		panelBotones.add(btCongelar);
		btCongelar.addMouseListener(oyente);
		
		
		Button btPlatillo = new Button("Platillo");
		btPlatillo.setSize(10, 10);
		panelBotones.add(btPlatillo);
		btPlatillo.addMouseListener(oyente);
		
		Button btRayoLaser = new Button("Rayo Laser");
		btRayoLaser.setSize(10, 10);
		panelBotones.add(btRayoLaser);
		
		Button btTaladro = new Button("Taladro");
		btTaladro.setSize(10, 10);
		panelBotones.add(btTaladro);
		
		
		Button btTransportarse = new Button("Transportarse");
		btTransportarse.setSize(10, 10);
		panelBotones.add(btTransportarse);
		
		
		this.setPanel(panelBotones, "South");
		this.setTitle("Los Pooglins");
	
		
	
	
	
	}
	private static final long serialVersionUID = 1L;
}
