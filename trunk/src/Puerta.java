

/**
 * @author guido
 *
 */
public class Puerta {
	private int posicionX;
	private int posicionY;
	
	
	/**Constructor clase puerta, solo atraves de este
	 * se puede setear las coordenadas de las puertas
	 * dado que las mismas son fijas y constantes
	 *  para cada nivel.-
	 * @param posX
	 * @param posY
	 */
	public Puerta(int posX,int posY){
		this.posicionX=posX;
		this.posicionY=posY;
	}
	
	public int getPosicionX(){
		return this.posicionX;
	}
	
	public int getPosicionY(){
		return this.posicionY;
	}
}
