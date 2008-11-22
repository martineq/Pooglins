

/**Clase que representa a el personaje Pooglin.-
 * @author Mart
 * @since 11/10/08
 * 
 */
public class Pooglin implements Personaje{

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
	
	public void mover() { // >>> Acï¿½ faltan ver los casos donde se me "acaba" la pantalla.- 
		this.cantTurnosQueNoSeMovio++;
		if(this.cantTurnosQueNoSeMovio!=this.velocidad.modulo()){
			return;
		}
		
		if ( this.velocidad.getVelocidadY()>0 ){
			this.setPosicionY(this.getPosicionY()+1);
			//this.setAltura(this.getAltura() + 1);   //Borrar... 
		}else if ( this.velocidad.getVelocidadY()<0 ){
				this.setPosicionY(this.getPosicionY()-1);
				//this.setAltura(this.getAltura() + 1);   //Borrar... 
			  }else if ( this.velocidad.getVelocidadX()>0 ){
					  this.setPosicionX(this.getPosicionX()+1);
				    }else if (this.velocidad.getVelocidadX()<0){
							this.setPosicionX(this.getPosicionX()-1);
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
}
