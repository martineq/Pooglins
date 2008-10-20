/**
 * 
 */

/**
 * @author lkolaric
 *
 */
public class Roca implements Terreno {

	private int posicionX;
	private int posicionY;
	
	
	/* (non-Javadoc)
	 * @see Terreno#accionarTerreno(Personaje)
	 */
	public void accionarTerreno(Personaje personaje) {
		Pooglin pooglin = (Pooglin) personaje;
		if ( pooglin.getPosicionY() == this.getPosicionY()){
			Velocidad velocidad = pooglin.getVelocidad();
			velocidad.cambiarDireccion();
			pooglin.setVelocidad(velocidad);
		}else {}
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

}
