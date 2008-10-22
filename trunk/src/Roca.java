
/**
 * 
 */

/**
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
		if ( pooglin.getPosicionY() == this.getPosicionY()){
			Velocidad velocidad = pooglin.getVelocidad();
			velocidad.cambiarDireccion();
			velocidad.setVelocidadY(0);
			pooglin.setVelocidad(velocidad);
		}else {}
	}

}
