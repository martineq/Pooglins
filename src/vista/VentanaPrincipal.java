package vista;

import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;

import controlador.MouseAdaptador;
import controlador.MouseParaBotones;



public class VentanaPrincipal extends Ventana {
	public VentanaPrincipal(int ancho, int alto) {
		super(ancho,alto);
		MouseParaBotones oyente = new MouseParaBotones();
		
		Panel panelBotones = new Panel();
		
		Button btCongelar = new Button("Congelamiento");
		btCongelar.setSize(10, 10);
		panelBotones.add(btCongelar);
		btCongelar.addMouseListener(oyente);
		
		Button btPlatillo = new Button("Platillo");
		btPlatillo.setSize(10, 10);
		panelBotones.add(btPlatillo);
		btPlatillo.addMouseListener(oyente);
		
		Button btRayoLaser = new Button("RayoLaser");
		btRayoLaser.setSize(10, 10);
		panelBotones.add(btRayoLaser);
		btRayoLaser.addMouseListener(oyente);
		
		Button btTaladro = new Button("Taladro");
		btTaladro.setSize(10, 10);
		panelBotones.add(btTaladro);
		btTaladro.addMouseListener(oyente);
		
		Button btTransportarse = new Button("Teletransportarse");
		btTransportarse.setSize(10, 10);
		panelBotones.add(btTransportarse);
		btTransportarse.addMouseListener(oyente);
		
		Button btTunel = new Button("Tunel");
		btTunel.setSize(10, 10);
		panelBotones.add(btTunel);
		btTunel.addMouseListener(oyente);
		
		
		
		this.setPanel(panelBotones, "South");
		this.setTitle("Los Pooglins");
	
		
	
	
	
	}
	private static final long serialVersionUID = 1L;
}
