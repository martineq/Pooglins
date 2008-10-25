
/**Clase que representa a los bloques de terreno donde el pooglin se desplaza.-
 * @author lkolaric
 *
 */
public class Roca extends Terreno {

	
	public Roca(int posicionX,int posicionY){
		this.setPosicionX(posicionX);
		this.setPosicionY(posicionY);
		this.setActivo(true);
	}
	
	public void accionarTerreno(Personaje personaje) {
		Pooglin pooglin = (Pooglin) personaje;
		Velocidad velocidad = pooglin.getVelocidad();
		if ( pooglin.getPosicionY() == this.getPosicionY()){ //Caso en que estoy frente a la roca
			 velocidad.cambiarDireccion();//aca no me importa la velocidad en Y, supuestamente tiene que ser nula
		}else {  //caso sobre la roca
			velocidad.setVelocidadY(Velocidad.VELOCIDAD_NULA);
		}
		pooglin.setVelocidad(velocidad);
	}

}
