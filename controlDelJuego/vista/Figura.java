package vista;

import java.awt.Color;
import java.awt.Component;

import modelo.Dibujable;
import modelo.Posicionable;
import modelo.SuperficieDeDibujo;

public abstract class Figura extends Component implements Dibujable {

	private Color color;
	private Posicionable posicionable;
	
	public abstract void dibujar(SuperficieDeDibujo superfice) ;

	public void setColor(Color unColor){
		this.color =unColor; 
	}
	
	public Color getColor(){
		return this.color;
	}
	
	public Posicionable getPosicionable() {
		return this.posicionable;
	}

	public void setPosicionable(Posicionable posicionable) {
		this.posicionable = posicionable;		
	}

}
