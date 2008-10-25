

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
	
	private static int VELOCIDAD_NULA = 0;
	private static int VELOCIDAD_NORMAL = 6;

	private int resistencia = 4;
	
	public Tierra(int posicionX,int posicionY){
		this.setPosicionX(posicionX);
		this.setPosicionY(posicionY);
		this.setActivo(true);
	}
	
	private void accionarLateral(Pooglin pooglin) {
		Habilidad habilidad = pooglin.getHabilidad();
		if (habilidad instanceof RayoLaser){
			pooglin.usarHabilidad(this);
		}else {
			Velocidad velocidad = pooglin.getVelocidad();
			velocidad.cambiarDireccion();
			pooglin.setVelocidad(velocidad);
		}
		
	}
	
	private void accionarAbajo(Pooglin pooglin) {
		Velocidad auxVelocidad = pooglin.getVelocidad();
		auxVelocidad.setVelocidadX( ( (auxVelocidad.getVelocidadX()) / Math.abs( auxVelocidad.getVelocidadX()) ) * VELOCIDAD_NORMAL);
		pooglin.setVelocidad(auxVelocidad); //Agregado para que la tierra setee una velocidad cuando se está caminando sobre ella. Mart.-
		Habilidad habilidad = pooglin.getHabilidad();
		if (habilidad instanceof Taladro){
			pooglin.usarHabilidad(this);
		}else {
			
		}
	}
	
	public void accionarTerreno(Personaje pooglin) { //>>> Fijarse si está bien la condición del if o si es al revés. Mart.-
		if (((Pooglin) pooglin).getPosicionY() == this.getPosicionY()){
			this.accionarLateral((Pooglin)pooglin);
		}else{
			Velocidad velocidad = ((Pooglin) pooglin).getVelocidad();
			velocidad.setVelocidadY(VELOCIDAD_NULA);
			((Pooglin) pooglin).setVelocidad(velocidad);
			this.accionarAbajo((Pooglin)pooglin);
		}
	}
	
	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}
	
}
