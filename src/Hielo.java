
/**
 * @author guido
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
	
	/*private static int VELOCIDAD_HIELO = 5;
	private static int VELOCIDAD_NULA = 0;*/
	
	/**Este m�todo le "aumenta" la velocidad al pooglin una vez que este
	 * pisa Hielo.-
	 * @param pooglin
	 */
	private void acelerarPooglin(Personaje pooglin){
		Pooglin auxiliarPooglin = (Pooglin) pooglin;
		Velocidad auxiliarVelocidad = auxiliarPooglin.getVelocidad();
		int velocidadX = auxiliarVelocidad.getVelocidadX();
		auxiliarVelocidad.setVelocidadX((velocidadX / Math.abs(velocidadX)) * Velocidad.VELOCIDAD_MAXIMA);
		auxiliarPooglin.setVelocidad(auxiliarVelocidad);
	}
	
	/**Redefino el m�todo de la interfaz con la l�gica propia de 
	 * este tipo de terreno.
	 * Adem�s de permitir que el pooglin este parado sobre hielo,
	 * puede haber hielo lateralmente y simplemente le cambia la
	 * Direcci�n a la velocidad del pooglin.
	 * @param pooglin
	 */
	public void accionarTerreno(Personaje pooglin){ //>>> Fijarse si est� bien la condici�n del if o si es al rev�s. Mart.-
		Pooglin pooglinAuxiliar = (Pooglin)pooglin;
		if ( pooglinAuxiliar.getPosicionY() == this.getPosicionY()){//Caso en que el pooglin tiene hielo adelante.
			Velocidad velocidad = pooglinAuxiliar.getVelocidad();   //>>> Si est�n en la misma "Y" �no es el caso del hielo abajo del pooglin?
			velocidad.cambiarDireccion();
			velocidad.setVelocidadY(Velocidad.VELOCIDAD_NULA);
			pooglinAuxiliar.setVelocidad(velocidad);
		}else{//Es el caso que el pooglin pisa el hielo.
			Velocidad velocidad = ((Pooglin)pooglin).getVelocidad();
			velocidad.setVelocidadY(Velocidad.VELOCIDAD_NULA);
			pooglinAuxiliar.setVelocidad(velocidad);
			acelerarPooglin(pooglin);
		}
	}
}


