package vista;

import java.awt.Color;
import java.awt.Graphics;
import modelo.SuperficieDeDibujo;

/* 
 * Esta clase dibuja un Cuadrado (de color gris por el momento)utilizando la API Java2D 
 */
public class Cuadrado extends Figura {

	private int alto;
	private int ancho;

	public Cuadrado(int ancho, int alto, Color color){
		this.alto = alto;
		this.ancho = ancho;
		setColor(color);
	}
	
	public void dibujar(SuperficieDeDibujo superfice) {
//		Graphics grafico = ((Ventana)superfice).getGrafico();
//		grafico.setColor(this.getColor());
//		grafico.fillRect(this.getPosicionable().getPosicionX(), this.getPosicionable().getPosicionY(), this.ancho, this.alto);
	}
}
