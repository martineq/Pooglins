
/**Clase que representa a los bloques de terreno donde el pooglin se desplaza.-
 * @author lkolaric
 * @version 2(Mart)
 */
public class Roca extends Terreno {

	private static int VELOCIDAD_NULA = 0;
	private static int VELOCIDAD_NORMAL = 6;
	
	public Roca(int posicionX,int posicionY){
		this.setPosicionX(posicionX);
		this.setPosicionY(posicionY);
		this.setActivo(true);
	}
	
	public void accionarTerreno(Personaje personaje) {
		Pooglin pooglin = (Pooglin) personaje;
		Velocidad velocidad = pooglin.getVelocidad();
		if ( pooglin.getPosicionY() == this.getPosicionY()){ //Caso donde estoy sobre la roca.-
			velocidad.setVelocidadY(VELOCIDAD_NULA);
			velocidad.setVelocidadX( ( (velocidad.getVelocidadX()) / Math.abs( velocidad.getVelocidadX()) ) * VELOCIDAD_NORMAL);
		}else {  /* Agrego el caso donde me voy a encontrar con una roca de frente. Mart.- */
		    velocidad.cambiarDireccion();
			velocidad.setVelocidadY(VELOCIDAD_NULA);
		}
		pooglin.setVelocidad(velocidad);
	}

}
