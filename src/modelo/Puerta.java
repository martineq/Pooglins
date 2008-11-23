package modelo;

/**
 * @author guido
 *
 *
 */
public class Puerta implements Posicionable{
	private int posicionX;
	private int posicionY;
	private int base = 44;
	
	/**Constructor clase puerta, solo a través de este
	 * se puede setear las coordenadas de las puertas
	 * dado que las mismas son fijas y constantes
	 *  para cada nivel.-
	 * @param posX
	 * @param posY
	 */
	public Puerta(int posX,int posY){
		this.posicionX=posX*base;
		this.posicionY=posY*base;
	}
	
	public int getPosicionX(){
		return this.posicionX;
	}
	
	public int getPosicionY(){
		return this.posicionY;
	}
}
