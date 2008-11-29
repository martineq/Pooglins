package modelo;

/**Clase Tierra: esta clase es un terreno mas que utilizaremos para el juego, el 
 * cual podrá ser destruido por un taladro o actuar como obstáculo, y ser destruido
 * por una cantidad determinada de tiros de RayoLaser
 * 
 * @author lkolaric
 *
 */
public class Tierra extends Terreno {

	/**
	 * PosicionX, PosicionY son atributos enteros necesarios en la clase
	 * para poder comparar la posición del terreno con la del Pooglin.
	 */
	
	private int resistencia = 4;
	
	/**Constructor de Tierra.-
	 * @param posicionX
	 * @param posicionY
	 */
	public Tierra(int posicionX,int posicionY){
		this.setPosicionX(posicionX);
		this.setPosicionY(posicionY);
		this.setActivo(true);
	}
	
	/**
	 * @param pooglin
	 */
	private void accionarLateral(Pooglin pooglin) {
		Habilidad habilidad = pooglin.getHabilidad();
		Velocidad velocidad = pooglin.getVelocidad();
		pooglin.setAltura(0);
		if (habilidad instanceof RayoLaser){
			pooglin.usarHabilidad(this);
			if (this.isActivo()){
				velocidad.cambiarDireccion();
			}
		}else {
			velocidad.cambiarDireccion();
		}
		pooglin.setVelocidad(velocidad);
		
	}
	
	/**
	 * @param pooglin
	 */
	private void accionarAbajo(Pooglin pooglin) {
		Velocidad auxVelocidad = pooglin.getVelocidad();
		auxVelocidad.setVelocidadX( ( (auxVelocidad.getVelocidadX()) / Math.abs( auxVelocidad.getVelocidadX()) ) * Velocidad.VELOCIDAD_NORMAL);
		pooglin.setVelocidad(auxVelocidad); //esto hay que verlo...
		Habilidad habilidad = pooglin.getHabilidad();
		if (habilidad instanceof Taladro){
			pooglin.usarHabilidad(this,pooglin);
		}else {
			
		}
	}
	
	public void accionarTerreno(Personaje pooglin) { 
		Pooglin auxPooglin = (Pooglin) pooglin;
		
		if (auxPooglin.getPosicionY() == this.getPosicionY()){
			this.accionarLateral((Pooglin)pooglin);
		}else{
			Velocidad velocidad = auxPooglin.getVelocidad();
			velocidad.setVelocidadY(Velocidad.VELOCIDAD_NULA);
			auxPooglin.setVelocidad(velocidad);
			this.accionarAbajo(auxPooglin);
		}
	}
	
	/**
	 * @return
	 */
	public int getResistencia() {
		return this.resistencia;
	}

	/**
	 * @param resistencia
	 */
	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}
	
}
