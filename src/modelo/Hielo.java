package modelo;

/**
 * @author guido
 *
 *
 */
public class Hielo extends Terreno {

	/**Constructor de Hielo.-
	 * 
	 */
	public Hielo(int posicionX,int posicionY){
		this.setPosicionX(posicionX);
		this.setPosicionY(posicionY);
		this.setActivo(true);
	}
	
	/**Este metodo le "aumenta" la velocidad al pooglin una vez que este
	 * pisa Hielo.-
	 * @param unPooglin
	 */
	private void acelerarPooglin(Personaje unPooglin){
		Pooglin pooglin = (Pooglin) unPooglin;
		Velocidad velocidad = pooglin.getVelocidad();
		pooglin.setAltura(0);
		int velocidadX = velocidad.getVelocidadX();
		velocidad.setVelocidadX((velocidadX / Math.abs(velocidadX)) * Velocidad.VELOCIDAD_MAXIMA);
		pooglin.setVelocidad(velocidad);
	}
	
	/**Redefino el metodo de la interfaz con la lógica propia de 
	 * este tipo de terreno.
	 * Ademas de permitir que el pooglin este parado sobre hielo,
	 * puede haber hielo lateralmente y simplemente le cambia la
	 * direccion a la velocidad del pooglin.
	 * @param pooglin
	 */
	@Override
	public void accionarTerreno(Personaje pooglin){
		Pooglin pooglinAuxiliar=(Pooglin)pooglin;
		//Caso en que el pooglin tiene hielo adelante.
		if ( pooglinAuxiliar.getPosicionY() == this.getPosicionY()){
			Velocidad velocidad = pooglinAuxiliar.getVelocidad();
			velocidad.cambiarDireccion();
			velocidad.setVelocidadY(0);
			pooglinAuxiliar.setVelocidad(velocidad);
			pooglinAuxiliar.setCantTurnosQueNoSeMovio(0);	
		}
		else{//Es el caso que el pooglin pisa el hielo.
			Velocidad velocidad= ((Pooglin) pooglin).getVelocidad();
			velocidad.setVelocidadY(0);
			pooglinAuxiliar.setVelocidad(velocidad);
			acelerarPooglin(pooglin);
		}
	}
}


