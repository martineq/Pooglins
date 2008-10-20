/**
 * 
 */

/**Clase Tierra: esta clase es un terreno mas que utilizaremos para el juego, el 
 * cual podra ser destruido por un taladro o actuar como obstaculo, y ser destruido
 * por una cantidad determinada de tiros de RayoLaser
 * 
 * @author lkolaric
 *
 */
public class Tierra implements Terreno {

	
	/**
	 * PosicionX, PosicionY son atributos enteros necesarios en la clase
	 * para poder comparar la posicion del terreno con la del Pooglin.
	 */
	
	private int posicionX;
	private int posicionY;
	private int resistencia;
	
	public Tierra(int posicionX,int posicionY){
		this.setPosicionX(posicionX);
		this.setPosicionY(posicionY);
	}
	
	private void accionarLateral(Pooglin pooglin) {
		Habilidad habilidad = pooglin.getHabilidad();
		if (habilidad instanceof RayoLaser){
			this.setResistencia(this.getResistencia() + 1);
			pooglin.usarHabilidad(this);
		}else {
			Velocidad velocidad = pooglin.getVelocidad();
			velocidad.cambiarDireccion();
			pooglin.setVelocidad(velocidad);
		}
		
	}
	
	private void accionarAbajo(Pooglin pooglin) {
		Habilidad habilidad = pooglin.getHabilidad();
		if (habilidad instanceof Taladro){
			pooglin.usarHabilidad(this);
		}else {}
	}
	
	/* (non-Javadoc)
	 * @see Terreno#accionarTerreno(Personaje)
	 */
	public void accionarTerreno(Personaje pooglin) {
		if (((Pooglin) pooglin).getPosicionY() == this.getPosicionY()){
			this.accionarLateral((Pooglin)pooglin);
		}else{
			this.accionarAbajo((Pooglin)pooglin);
		}
	}
	
	public int getPosicionX() {
		return posicionX;
	}
	
	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}
	
	public int getPosicionY() {
		return posicionY;
	}
	
	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}

	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}
	
	
}