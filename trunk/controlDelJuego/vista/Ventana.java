package vista;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import modelo.SuperficieDeDibujo;

/*
 * ESta clase reprenta la superficie de dibujo, tipicamente será el formulario
 * principal de la aplicación y donde se dibujará la vista.
 * Esta clase utiliza la tecnica de doble buffering para evitar los efectos de flicking
 */
public class Ventana extends Frame implements SuperficieDeDibujo{

	private Panel panel;
	private String ubicacionDelPanel;
//	public Panel getPanel() {
//		return panel;
//	}

	public void setPanel(Panel panel, String ubicacion) {
		this.panel = panel;
		this.ubicacionDelPanel = ubicacion;
		add(ubicacionDelPanel,panel);	
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
		g.drawImage(this.imagen, 0, 28, null);
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
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}
	
}
