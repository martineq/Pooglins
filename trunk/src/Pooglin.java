/**
 * 
 */

/**
 * @author mart
 *
 */
public class Pooglin implements Personaje {

	private int posicionX;
	private int posicionY;
	private int altura;
	private Velocidad velocidad;
	private Habilidad habilidad;
	private boolean habilidadActivada; //me dice si active o no la habilidad
	private boolean vivo;
	private Habilidad matarse;//Composicion con clase Matar. Guido.-

	public Pooglin(int posicionX,int posicionY){
		this.setVivo(true);
		this.setPosicionX(posicionX);
		this.setPosicionY(posicionY);
		this.setAltura(0);
		this.setHabilidad(null);
		this.velocidad = new Velocidad();
		this.setHabilidadActivada(false);
		this.matarse= new Matar();//Agrego al constructor la linea para crear atributo Matarse.Guido.-
	}
	
	/* (non-Javadoc)
	 * @see Personaje#mover()
	 */
	
	public void mover() {
		
		/*Ver si esto en realmente necesario o se puede hacer de otra manera
		 * 
		 * if ( !(this.estaVivo()) && ( (this.velocidad.getDireccion() != (Velocidad.Direccion.ABAJO)  ) ) ){
			// como la condicion de vivo es falsa y no estoy cayendo, en este monento muere
			this.velocidad.setModulo(0);
		}*/
		
		if ( this.velocidad.getVelocidadX()>0 ){
			this.setPosicionX(this.getPosicionX()+1);
		}else if (this.velocidad.getVelocidadX()<0){
			this.setPosicionX(this.getPosicionX()-1);
		}
		
		if ( this.velocidad.getVelocidadY()>0 ){
			this.setPosicionY(this.getPosicionY()+1);
		}else if ( this.velocidad.getVelocidadY()<0 ){
			this.setPosicionY(this.getPosicionY()-1);
		}
	}
	
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

	public int getAltura() {  // Me dice a que "altura del piso se encuentra"
		return this.altura;
	}

	public void subirAltura() {
		setAltura(this.altura++);
		return;
	}

	public void bajarAltura() {
		setAltura(this.altura--);
		return;
	}

	public void setAltura(int altura) {
		this.altura = altura;
		return;
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
	
	public boolean isHabilidadActivada() {
		return habilidadActivada;
	}

	public void setHabilidadActivada(boolean habilidadActivada) {
		this.habilidadActivada = habilidadActivada;
	}

	public void setVelocidad(Velocidad rapidezMovimiento){
		this.velocidad=rapidezMovimiento;
	}
	public Velocidad getVelocidad(){
		return this.velocidad;
	}
	//Agrego el getter del atributo matarse
	//Guido.-Ver si no es necesario un Setter(creo q no)
	public Habilidad getMatarse(){
		return matarse;
	}
}
