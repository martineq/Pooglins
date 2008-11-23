package modelo;

import org.dom4j.Element;

/**
 * @author guido
 *
 *
 */
public class Puerta implements Posicionable{
	private int posicionX;
	private int posicionY;
	private int base = 44;
	
	/**Constructor clase puerta, solo a trav�s de este
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
	

	public void guardar(Element elementoPadre){
		/** Tengo que guardar todo esto:
		 *  private int posicionX;
			private int posicionY;
		 */
		//Guardo la posicionX.-
		Element elementoHijo = elementoPadre.addElement("posicionX");
		elementoHijo.addAttribute("valor",( (Integer)this.posicionX).toString() );
		
		//Guardo la posicionY.-
		elementoHijo = elementoPadre.addElement("posicionY");
		elementoHijo.addAttribute("valor",( (Integer)this.posicionY).toString() );
		
	}
	
}
