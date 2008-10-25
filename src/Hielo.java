
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
	
	/**Este método le "aumenta" la velocidad al pooglin una vez que este
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
	
	/**Redefino el método de la interfaz con la lógica propia de 
	 * este tipo de terreno.
	 * Además de permitir que el pooglin este parado sobre hielo,
	 * puede haber hielo lateralmente y simplemente le cambia la
	 * Dirección a la velocidad del pooglin.
	 * @param pooglin
	 */
	public void accionarTerreno(Personaje pooglin){ //>>> Fijarse si está bien la condición del if o si es al revés. Mart.-
		Pooglin pooglinAuxiliar = (Pooglin)pooglin;
		if ( pooglinAuxiliar.getPosicionY() == this.getPosicionY()){//Caso en que el pooglin tiene hielo adelante.
			Velocidad velocidad = pooglinAuxiliar.getVelocidad();   //>>> Si están en la misma "Y" ¿no es el caso del hielo abajo del pooglin?
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


