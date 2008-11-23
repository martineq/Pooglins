package vista;

import java.awt.Graphics;

import modelo.SuperficieDeDibujo;

public class Circulo  extends Figura {

	private int radio;
	
	public Circulo(int radio){
		this.radio = radio;
	}
	
	public void dibujar(SuperficieDeDibujo superfice) {
		Graphics grafico = ((Ventana)superfice).getGrafico();
		grafico.setColor(getColor());
		grafico.fillOval(getPosicionable().getPosicionX() , getPosicionable().getPosicionY(), this.radio, this.radio);
	}

}
