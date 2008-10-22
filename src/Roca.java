
/**
 * 
 */

/**
 * @author lkolaric
 *
 */
public class Roca extends Terreno {

	/* (non-Javadoc)
	 * @see Terreno#accionarTerreno(temporal.Personaje)
	 */
	public void accionarTerreno(Personaje personaje) {
		Pooglin pooglin = (Pooglin) personaje;
		if ( pooglin.getPosicionY() == this.getPosicionY()){
			Velocidad velocidad = pooglin.getVelocidad();
			velocidad.cambiarDireccion();
			velocidad.setVelocidadY(0);
			pooglin.setVelocidad(velocidad);
		}else {}
	}

}
