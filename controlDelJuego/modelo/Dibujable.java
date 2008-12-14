package modelo;

/*
 * Esta abstraccion representa a todos los objetos Vista de la aplicacion
 * Cada objeto vista está relacionado con un objeto del modelo que implementa
 * la interface Posicionable
 */

public interface Dibujable {	
	public void dibujar(SuperficieDeDibujo superfice);
	public Posicionable getPosicionable();
	public void setPosicionable(Posicionable posicionable);
	
}
