package modelo;

import java.util.Iterator;

import org.dom4j.Element;

/**
 * @author guido
 *
 *
 */
public class Puerta implements Posicionable{
	private int posicionX;
	private int posicionY;
	
	/**Constructor clase puerta, solo a través de este
	 * se puede setear las coordenadas de las puertas
	 * dado que las mismas son fijas y constantes
	 *  para cada nivel.-
	 * @param posX
	 * @param posY
	 */
	public Puerta(int posX,int posY){
		this.posicionX = posX;
		this.posicionY = posY;
	}
	
	/**
	 * Constructor para el uso de persistencia.-
	 * @param elementoPadre
	 */
	public Puerta(Element elementoPadre){
		Iterator<?> iter = elementoPadre.elementIterator();
		while( iter.hasNext() ){
			Element elementoHijo = (Element)iter.next();
			String texto = elementoHijo.getName();
			//Cargo posicionX.-
			if ( texto.equals( "posicionX" ) ){
				this.posicionX = Integer.parseInt( (elementoHijo.attributeValue("valor")));
			 }
			//Cargo posicionY.-
			if ( texto.equals( "posicionY" ) ){
				this.posicionY = Integer.parseInt( (elementoHijo.attributeValue("valor")));
			 }
		}
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
		elementoHijo.addAttribute("valor", Integer.toString(this.posicionX) );
		
		//Guardo la posicionY.-
		elementoHijo = elementoPadre.addElement("posicionY");
		elementoHijo.addAttribute("valor", Integer.toString(this.posicionY) );
		
	}
	
}
