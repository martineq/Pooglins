package modelo;

import java.util.Iterator;

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
	private boolean revisado;
	
	
	public void setRevisado(boolean revisado) {
		this.revisado = revisado;
	}

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
		//todos los pooglins arrancan con velocidad normal por defecto.Guido.-
		this.velocidad.setVelocidadX(Velocidad.VELOCIDAD_NORMAL);//todos los pooglins arrancan con velocidad normal por defecto.Guido.-
		//Agrego al constructor la linea para crear atributo Matarse.Guido.-
		this.matarse = new Morir(); 
		this.setCantTurnosQueNoSeMovio(0);
		this.revisado = false;
	}

	/**
	 * Constructor para el uso de persistencia.-
	 * @param elementoPadre
	 */
	public Pooglin(Element elementoPadre){
		Iterator<?> iter = elementoPadre.elementIterator();
		while( iter.hasNext() ){
			Element elementoHijo = (Element)iter.next();
			String texto = elementoHijo.getName();
			//Cargo posicionX.-
			if ( texto.equals( "posicionX" ) ) this.setPosicionX( Integer.parseInt( (elementoHijo.attributeValue("valor"))) );
			
			//Cargo posicionY.-
			if ( texto.equals( "posicionY" ) ) this.setPosicionY( Integer.parseInt( (elementoHijo.attributeValue("valor"))) );
			
			//Cargo velocidad.-
			if ( texto.equals( "velocidad" ) ) this.setVelocidad(new Velocidad(elementoHijo));
			
			//Cargo habilidad.-
			if ( texto.equals( "habilidad" ) ){
				String habilidad = elementoHijo.attributeValue("tipo");
				if (habilidad.equals("Congelamiento")) this.setHabilidad(new Congelamiento());
				if (habilidad.equals("Morir")) this.setHabilidad(new Morir());
				if (habilidad.equals("Platillo")) this.setHabilidad(new Platillo());
				if (habilidad.equals("RayoLaser")) this.setHabilidad(new RayoLaser());
				if (habilidad.equals("Taladro")) this.setHabilidad(new Taladro());
				if (habilidad.equals("Teletransportarse")) this.setHabilidad(new Teletransportarse());
				if (habilidad.equals("null")) this.setHabilidad(null);
			 }
			
			//Cargo vivo.-
			if ( texto.equals( "vivo" ) ){
				 String condicion = elementoHijo.attributeValue("condicion");
				 if (condicion.equals("vivo")) this.setVivo(true);
				 if (condicion.equals("muerto")) this.setVivo(false);
			 }
			
			//Cargo matarse.-
			if ( texto.equals( "matarse" ) ) this.matarse = new Morir();
			
			//Cargo cantTurnosQueNoSeMovio.-
			if ( texto.equals( "cantTurnosQueNoSeMovio" ) ) this.setCantTurnosQueNoSeMovio( Integer.parseInt( elementoHijo.attributeValue("valor") ) );
			
			//Cargo altura.-
			if ( texto.equals( "altura" ) ) this.setAltura( Integer.parseInt( elementoHijo.attributeValue("valor") ) );
			
			//Cargo revisado.-
			if ( texto.equals( "revisado" ) ){
				 String condicion = elementoHijo.attributeValue("condicion");
				 if (condicion.equals("true")) this.setRevisado(true);
				 if (condicion.equals("false")) this.setRevisado(false);
			 }
			
		}
		
	}
	
	
	//Secciï¿½n de Geter's y Seter's

	public int getPosicionX(){
		return this.posicionX;
	}

	/**
	 * @param x
	 */
	public void setPosicionX(int x){
		this.posicionX = x;
	}
	
	/**
	 * @param y
	 */
	public void setPosicionY(int y){
		this.posicionY = y;
	}
	
	public int getPosicionY(){
		return this.posicionY;
	}
	
	public void  sacarHabilidad() {
		this.habilidad= null;
	}
	public Habilidad getHabilidad() {
		return this.habilidad;
	}

	/**
	 * @param habilidad
	 */
	public void setHabilidad(Habilidad habilidad) {
		this.habilidad = habilidad;
	}

	/**
	 * @param vivo
	 */
	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}	
	
	/**
	 * @return boolean
	 */
	public boolean estaVivo(){
		return this.vivo;		
	}

	/**
	 * @param rapidezMovimiento
	 */
	public void setVelocidad(Velocidad rapidezMovimiento){
		this.velocidad=rapidezMovimiento;
	}
	/**
	 * @return Velocidad
	 */
	public Velocidad getVelocidad(){
		return this.velocidad;
	}
	
	/**
	 * @return Habilidad
	 */
	public Habilidad getMatarse(){
		return matarse;
	}
	//Fin de Secciï¿½n de Geter's y Seter's
	
	public void vivir() { 
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
	
	public void borrarse(){
		this.setPosicionX(-1);
		this.setPosicionY(-1);
	}
	
	public void usarHabilidad(){
		this.getHabilidad().utilizar(this);	
	}

	/**
	 * @param terreno
	 */
	public void usarHabilidad(Terreno terreno) {
		this.getHabilidad().utilizar(terreno);
	}
	
	public void usarHabilidad(Terreno terreno, Pooglin pooglin) {
		this.getHabilidad().utilizar(terreno,pooglin);
	}
	
	/**
	 * @return int
	 */
	public int getAltura() {
		return altura;
	}

	/**
	 * @param altura
	 */
	public void setAltura(int altura) {
		this.altura = altura;
	}

	/**
	 * @param cant
	 */
	public void setCantTurnosQueNoSeMovio (int cant){
		this.cantTurnosQueNoSeMovio = cant;
	}
	

	/**Método que guarda todos los atributos de la clase Pooglin
	 * para luego ser exportados a XML.-
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
		elementoHijo.addAttribute("valor", Integer.toString(this.posicionX) );
		
		//Guardo la posicionY.-
		elementoHijo = elementoPadre.addElement("posicionY");
		elementoHijo.addAttribute("valor", Integer.toString(this.posicionY) );
		
		//Guardo la velocidad.-
		elementoHijo = elementoPadre.addElement("velocidad");
		this.velocidad.guardar(elementoHijo);
		
		//Guardo la habilidad;
		elementoHijo = elementoPadre.addElement("habilidad");
		Object elemento = this.habilidad;
		if ( elemento instanceof Congelamiento ) elementoHijo.addAttribute( "tipo" , "Congelamiento" );
		if ( elemento instanceof Morir ) elementoHijo.addAttribute( "tipo" , "Morir" );
		if ( elemento instanceof Platillo ) elementoHijo.addAttribute( "tipo" , "Platillo" );
		if ( elemento instanceof RayoLaser ) elementoHijo.addAttribute( "tipo" , "RayoLaser" );
		if ( elemento instanceof Taladro ) elementoHijo.addAttribute( "tipo" , "Taladro" );
		if ( elemento instanceof Teletransportarse ) elementoHijo.addAttribute( "tipo" , "Teletransportarse" );
		if ( elemento == null ) elementoHijo.addAttribute( "tipo" , "null" );
		
		//Guardo la condición de si está vivo.-
		elementoHijo = elementoPadre.addElement("vivo");
		String condicionVivo = "muerto";
		if (this.vivo) condicionVivo = "vivo";
		elementoHijo.addAttribute("condicion",condicionVivo);
		
		//Guardo la habilidad de matarse.-
		elementoHijo = elementoPadre.addElement("matarse");
		
		//Guardo la cantTurnosQueNoSeMovio.-
		elementoHijo = elementoPadre.addElement("cantTurnosQueNoSeMovio");
		elementoHijo.addAttribute("valor", Integer.toString(this.cantTurnosQueNoSeMovio) );
		
		//Guardo la altura.-
		elementoHijo = elementoPadre.addElement("altura");
		elementoHijo.addAttribute("valor", Integer.toString(this.altura) );
		
		//Guardo la condición de si está revisado.-
		elementoHijo = elementoPadre.addElement("revisado");
		String condicionRevisado = "false";
		if (this.revisado) condicionRevisado = "true";
		elementoHijo.addAttribute("condicion",condicionRevisado);
		
	}

	public boolean estaRevisado() {
		// TODO Auto-generated method stub
		return revisado;
	}

}
