package vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

import javax.swing.JButton;

import controlador.MouseParaBotones;

import modelo.Habilidad;
import modelo.Nivel;
import modelo.SuperficieDeDibujo;

/*
 * ESta clase reprenta la superficie de dibujo, tipicamente será el formulario
 * principal de la aplicación y donde se dibujará la vista.
 * Esta clase utiliza la tecnica de doble buffering para evitar los efectos de flicking
 */
public class Ventana extends Frame implements SuperficieDeDibujo{
	
	private Panel panelSuperior;// = new Panel();
	private Panel panelInferior;// = new Panel();
	private Label lbCantCongelar;
	private Label lbCantPlatillo;
	private Label lbCantLaser;
	private Label lbCantTaladro;
	private Label lbCantTrasportarse; 
	private Label lbCantTunel;
	private Label lbCantSuicidarse;
	private Label lbTiempo;
	private Label lbCantDePooglinARescatar;
	private Label lbCantDePooglinVivos;
	private Label lbHabilidadDisponible;
	
//	public Panel getPanel() {
//		return panel;
//	}
	
	public void actualizarDatosEtiquetas(){
		Integer cantidadDeHabilidadesDisponibles;
		Nivel nivel = Nivel.getInstance();
		HashMap habilidades = nivel.getHabilidadesDisponibles();
	
		cantidadDeHabilidadesDisponibles = (Integer)habilidades.get("Congelamiento");
		lbCantCongelar.setText(cantidadDeHabilidadesDisponibles.toString());
		
		cantidadDeHabilidadesDisponibles = (Integer)habilidades.get("Platillo");
		lbCantPlatillo.setText(cantidadDeHabilidadesDisponibles.toString());
		
		cantidadDeHabilidadesDisponibles = (Integer)habilidades.get("RayoLaser");
		lbCantLaser.setText(cantidadDeHabilidadesDisponibles.toString());
		
		cantidadDeHabilidadesDisponibles = (Integer)habilidades.get("Taladro");
		lbCantTaladro.setText(cantidadDeHabilidadesDisponibles.toString());
		
		cantidadDeHabilidadesDisponibles = (Integer)habilidades.get("Teletransportarse");
		lbCantTrasportarse .setText(cantidadDeHabilidadesDisponibles.toString());
		
		cantidadDeHabilidadesDisponibles = (Integer)habilidades.get("Tunel");
		lbCantTunel.setText(cantidadDeHabilidadesDisponibles.toString());
		
		cantidadDeHabilidadesDisponibles = (Integer)habilidades.get("Morir");
		lbCantSuicidarse.setText(cantidadDeHabilidadesDisponibles.toString());
		
		//son las del panel superior
		Integer tiempo = nivel.getTiempoQueFaltaEnSegundos();	
		lbTiempo.setText("Tiempo: "+tiempo.toString()+ " Seg ");
		
		Integer cantidadDePooglinRescatar = nivel.getPooglinsARescatar();
		lbCantDePooglinARescatar.setText("Pooglin A Rescatar: "+cantidadDePooglinRescatar.toString());
		
		Integer CantDePooglinVivos = Nivel.getInstance().getCantidadPooglins();
		lbCantDePooglinVivos.setText("Pooglins Vivos: "+CantDePooglinVivos.toString());
	
	//	String habilidadDisponible = habilidadDisponible = Nivel.getInstance().getHabilidad().toString();
		
		Habilidad habilidadDisponible = Nivel.getInstance().getHabilidad();
		lbHabilidadDisponible.setSize(215,25);
		if(habilidadDisponible == null){
			lbHabilidadDisponible.setText("Habilidad Disponible: Ninguna");
			lbHabilidadDisponible.setForeground(Color.white);
			lbHabilidadDisponible.setBackground(Color.darkGray);
		}
		else{
			lbHabilidadDisponible.setText("Habilidad Disponible: " +habilidadDisponible);
			lbHabilidadDisponible.setForeground(Color.black);
			lbHabilidadDisponible.setBackground(Color.green);	
		}
		
		
	}
	
	public void agregarEtiquetas(){
		lbCantCongelar.setAlignment(Label.CENTER);
		lbCantCongelar.setBackground(Color.black);
		lbCantCongelar.setForeground(Color.green);
		
		lbCantPlatillo.setAlignment(Label.CENTER);
		lbCantPlatillo.setBackground(Color.black);
		lbCantPlatillo.setForeground(Color.green);

		lbCantLaser.setAlignment(Label.CENTER);
		lbCantLaser.setBackground(Color.black);
		lbCantLaser.setForeground(Color.green);
		
		lbCantTaladro.setAlignment(Label.CENTER);
		lbCantTaladro.setBackground(Color.black);
		lbCantTaladro.setForeground(Color.green);
		
		lbCantTrasportarse.setAlignment(Label.CENTER);
		lbCantTrasportarse.setBackground(Color.black);
		lbCantTrasportarse.setForeground(Color.green);
		
		lbCantTunel.setAlignment(Label.CENTER);
		lbCantTunel.setBackground(Color.black);
		lbCantTunel.setForeground(Color.green);
	
		lbCantSuicidarse.setAlignment(Label.CENTER);
		lbCantSuicidarse.setBackground(Color.black);
		lbCantSuicidarse.setForeground(Color.green);
		
		
		panelInferior.add(lbCantCongelar);
		panelInferior.add(lbCantPlatillo);
		panelInferior.add(lbCantLaser);
		panelInferior.add(lbCantTaladro);
		panelInferior.add(lbCantTrasportarse);
		panelInferior.add(lbCantTunel);
		panelInferior.add(lbCantSuicidarse);
	}
	
	public void agregarBotones(){
		MouseParaBotones oyente = new MouseParaBotones();
		
		JButton btCongelar = new JButton("Congelamiento");
		panelInferior.add(btCongelar);
		btCongelar.addMouseListener(oyente);
		
		JButton btPlatillo = new JButton("Platillo");
		panelInferior.add(btPlatillo);
		btPlatillo.addMouseListener(oyente);
		
		JButton btRayoLaser = new JButton("RayoLaser");
		panelInferior.add(btRayoLaser);
		btRayoLaser.addMouseListener(oyente);	
		
		JButton btTaladro = new JButton("Taladro");
		panelInferior.add(btTaladro);
		btTaladro.addMouseListener(oyente);
			
		JButton btTransportarse = new JButton("Teletransportarse");
		panelInferior.add(btTransportarse);
		btTransportarse.addMouseListener(oyente);
	
		JButton btTunel = new JButton("Tunel");
		panelInferior.add(btTunel);
		btTunel.addMouseListener(oyente);	
		
		JButton btSuicidarse = new JButton("Suicidarse");
		panelInferior.add(btSuicidarse);
		btSuicidarse.addMouseListener(oyente);
			
		
		//this.setPanel(panelBotones, "South");
		//this.setTitle("Los Pooglins");
	}


	/**
	 * Esta yerba es generada automática y aún no se su utilidad
	 */
	private static final long serialVersionUID = 1L;
	
	// es llamado internamente por el metodo repaint() de la clase Frame
	public void update(Graphics g) {
		paint(g);
	}

	/* 
	 *Esta es la imagen en que se realiza todo el dibujo utilizando la tecnica
	 *de doble buffering.
	 */
    private Image imagen;
    
	public void paint(Graphics g) {
		actualizarDatosEtiquetas();
		g.drawImage(this.imagen, 0, 60, null);
	}

	public void limpiar() {
		if(this.imagen == null)
			this.imagen = this.createImage(getSize().width, getSize().height);
		Graphics superficieParaDibujar =  this.imagen.getGraphics();
		superficieParaDibujar.setColor(Color.black);// 
		superficieParaDibujar.fillRect(0, 0, this.getSize().width, this.getSize().height);		
	}

	public Graphics getGrafico(){
		return this.imagen.getGraphics();
	}
	
	public void actualizar(){
		actualizarDatosEtiquetas();
		this.repaint();
	}
	
	public Ventana(int ancho,int alto) {
		setSize(ancho, alto);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
		int x = (screenSize.width - frameSize.width) / 2;
		int y = (screenSize.height - frameSize.height) / 2;
		setLocation(x, y);
		this.setResizable(false);
		panelInferior = new Panel();
		panelSuperior = new Panel();
		
		lbCantCongelar = new Label();
		lbCantPlatillo = new Label();
		lbCantLaser = new Label();
		lbCantTaladro = new Label();
		lbCantTrasportarse = new Label();
		lbCantTunel = new Label();
		lbCantSuicidarse = new Label();
		lbTiempo= new Label();
		lbCantDePooglinARescatar = new Label();
		lbCantDePooglinVivos =new Label();
		lbHabilidadDisponible = new Label();
		
		agregarEtiquetas();
		agregarBotones();
		
		panelInferior.setBackground(Color.black);
		panelInferior.setLayout(new GridLayout(2,2));
		add(panelInferior,BorderLayout.SOUTH);
		
		cargarPanelSuperior();
		
		
		panelSuperior.setBackground(Color.darkGray);
		//panelSuperior.setLayout(new GridLayout(2,2));
		//panelSuperior.setLayout(new BorderLayout());
		
		add(panelSuperior, BorderLayout.NORTH);
		
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}

	private void cargarPanelSuperior() {
		//Label lbl = new Label("TEXTO DEL JUEGO, NIVEL, TIEMPO, CANT DE POOGLIN, ETC....");
		
		Integer tiempo = Nivel.getInstance().getTiempoQueFaltaEnSegundos();	
		lbTiempo.setText("Tiempo: "+tiempo.toString()+ " Seg ");
		lbTiempo.setForeground(Color.white);
		panelSuperior.add(lbTiempo);
		
		Integer cantidadDePooglinRescatar = Nivel.getInstance().getPooglinsARescatar();
		lbCantDePooglinARescatar.setForeground(Color.white);
		lbCantDePooglinARescatar.setText("Pooglin A Rescatar: "+cantidadDePooglinRescatar.toString());
		panelSuperior.add(lbCantDePooglinARescatar);
		
		Integer CantDePooglinVivos = Nivel.getInstance().getCantidadPooglins();
		lbCantDePooglinVivos.setForeground(Color.white);
		lbCantDePooglinVivos.setText("Pooglins Vivos: "+CantDePooglinVivos.toString());
		panelSuperior.add(lbCantDePooglinVivos);
		
		//String habilidadDisponible = Nivel.getInstance().getHabilidad().toString();
		
		Habilidad habilidadDisponible = Nivel.getInstance().getHabilidad();
		
		
		lbHabilidadDisponible.setForeground(Color.white);
		lbHabilidadDisponible.setText("Habilidad Disponible: "+habilidadDisponible);
		panelSuperior.add(lbHabilidadDisponible);
		
		
	}
	
}
