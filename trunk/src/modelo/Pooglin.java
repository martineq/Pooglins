package modelo;

import org.dom4j.Element;


/**Clase que representa a el personaje Pooglin.-
 * @author Mart
 * @since 11/10/08
 * 
 */
public class Pooglin implements Personaje , Posicionable, ObjetoVivo{
	private int posicionX;
	private int posicionY;
	private Velocidad velocidad;
	private Habilidad habilidad;
	private boolean vivo;
	private Habilidad matarse; //Composicion con clase Morir. Guido.-
	private int cantTurnosQueNoSeMovio;
	private int altura;
	/**Constructor de la clase Pooglin. Los valores que no se
	 * pasan por parï¿½metro tienen un valor por defecto.-
	 * @param posicionX
	 * @param posicionY
	 */
	public Pooglin(int posicionX,int posicionY){
		this.setVivo(true);
		this.setPosicionX(posicionX);
		this.setPosicionY(posicionY);
		this.setHabilidad(null);
		this.velocidad = new Velocidad();
		this.velocidad.setVelocidadX(Velocidad.VELOCIDAD_NORMAL);//todos los pooglins arrancan con velocidad normal por defecto.Guido.-
		//¿No arrancarían con velocidad en "Y" igualada a cero?
		this.matarse = new Morir(); //Agrego al constructor la linea para crear atributo Matarse.Guido.-
		this.cantTurnosQueNoSeMovio = 0;
	}

	public Pooglin(Element elementoPadre){
		/**this.setVivo(true);
		this.setPosicionX(posicionX);
		this.setPosicionY(posicionY);
		this.setHabilidad(null);
		this.velocidad = new Velocidad();
		this.velocidad.setVelocidadX(Velocidad.VELOCIDAD_NORMAL);//todos los pooglins arrancan con velocidad normal por defecto.Guido.-
		//¿No arrancarían con velocidad en "Y" igualada a cero?
		this.matarse = new Morir(); //Agrego al constructor la linea para crear atributo Matarse.Guido.-
		this.cantTurnosQueNoSeMovio = 0;*/
		
//		System.out.println("El x es: "+ elementoHijo.attributeValue("posicionX")); //Luego sacar.-
		
	}
	
	
	//Secciï¿½n de Geter's y Seter's
	public int getPosicionX(){
		return this.posicionX;
	}

	public void setPosicionX(int x){
		this.posicionX = x;
	}
	
	public void setPosicionY(int y){
		this.posicionY = y;
	}
	
	public int getPosicionY(){
		return this.posicionY;
	}
	
	public Habilidad getHabilidad() {
		return this.habilidad;
	}

	public void setHabilidad(Habilidad habilidad) {
		this.habilidad = habilidad;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}	
	
	public boolean estaVivo(){
		return this.vivo;		
	}

	public void setVelocidad(Velocidad rapidezMovimiento){
		this.velocidad=rapidezMovimiento;
	}
	public Velocidad getVelocidad(){
		return this.velocidad;
	}
	
	public Habilidad getMatarse(){
		return matarse;
	}
	//Fin de Secciï¿½n de Geter's y Seter's
	
	public void vivir() { // >>> Acï¿½ faltan ver los casos donde se me "acaba" la pantalla.- 
		int posicionX = this.getPosicionX();
		int posicionY = this.getPosicionY();
		
		this.cantTurnosQueNoSeMovio++;
		if(this.cantTurnosQueNoSeMovio!=this.velocidad.modulo()){
			return;
		}
		
		if ( this.velocidad.getVelocidadY()>0 ){
			this.setPosicionY(posicionY+1);
		}else if ( this.velocidad.getVelocidadY()<0 ){
				this.setPosicionY(posicionY-1);
			  }else if ( this.velocidad.getVelocidadX()>0 ){
					  this.setPosicionX(posicionX +1);
				    }else if (this.velocidad.getVelocidadX()<0){
							this.setPosicionX(posicionX-1);
				    	  }
		
		this.cantTurnosQueNoSeMovio=0;
	}
	
	/**Mï¿½todo donde el pooglin desaparece de "pantalla".-
	 * @since 18/10/08
	 */
	public void borrarse(){
		this.setPosicionX(-1);
		this.setPosicionY(-1);
	}
	
	//agrego para poder utilizar congelar y el matar.
	public void usarHabilidad(){
		this.getHabilidad().utilizar(this);	
	}

	public void usarHabilidad(Terreno terreno) {
		this.getHabilidad().utilizar(terreno);
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}


	/**Método que guarda todos los atributos de la clase Pooglin
	 * para luego ser exportados a XML.-
	 * @author Mart
	 * @param elementoPadre
	 */
	public void guardar(Element elementoPadre){
		/** Tengo que guardar todo esto:
		 *  private int posicionX;
			private int posicionY;
			private Velocidad velocidad;
			private Habilidad habilidad;
			private boolean vivo;
			private Habilidad matarse; //Composición con clase Morir. Guido.-
			private int cantTurnosQueNoSeMovio;
			private int altura;
		 */
		//Guardo la posicionX.-
		Element elementoHijo = elementoPadre.addElement("posicionX");
		elementoHijo.addAttribute("valor",( (Integer)this.posicionX).toString() );
		
		//Guardo la posicionY.-
		elementoHijo = elementoPadre.addElement("posicionY");
		elementoHijo.addAttribute("valor",( (Integer)this.posicionY).toString() );
		
		//Guardo la velocidad.-
		elementoHijo = elementoPadre.addElement("velocidad");
		this.velocidad.guardar(elementoHijo);
		
		//Guardo la habilidad;
		elementoHijo = elementoPadre.addElement("habilidad");
		Object elemento = this.habilidad;
		if ( elemento instanceof Congelamiento ) {
			elementoHijo.addAttribute( "tipo" , "Congelamiento" );
		}
		if ( elemento instanceof Morir ) {
			elementoHijo.addAttribute( "tipo" , "Morir" );
		}
		if ( elemento instanceof Platillo ) {
			elementoHijo.addAttribute( "tipo" , "Platillo" );
		}
		if ( elemento instanceof RayoLaser ) {
			elementoHijo.addAttribute( "tipo" , "RayoLaser" );
		}
		if ( elemento instanceof Taladro ) {
			elementoHijo.addAttribute( "tipo" , "Taladro" );
		}
		if ( elemento instanceof Teletransportarse ) {
			elementoHijo.addAttribute( "tipo" , "Teletransportarse" );
		}
		
		//Guardo la condición de si está vivo.-
		elementoHijo = elementoPadre.addElement("vivo");
		String condicionVivo = "muerto";
		if (this.vivo) condicionVivo = "vivo";
		elementoHijo.addAttribute("condicion",condicionVivo);
		
		//Guardo la habilidad de matarse.-
		elementoHijo = elementoPadre.addElement("matarse");
		
		//Guardo la cantTurnosQueNoSeMovio.-
		elementoHijo = elementoPadre.addElement("cantTurnosQueNoSeMovio");
		elementoHijo.addAttribute("valor",( (Integer)this.cantTurnosQueNoSeMovio).toString() );
		
		//Guardo la altura.-
		elementoHijo = elementoPadre.addElement("altura");
		elementoHijo.addAttribute("valor",( (Integer)this.altura).toString() );
	}

}
