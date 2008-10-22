
/**
 * 
 */

/**
 * @author lkolaric
 *
 */
public class Hielo extends Terreno {

	/**Constructor de Hielo.-
	 * 
	 */
	public Hielo(){
		
	}
	
	private static int VELOCIDAD_HIELO = 5;
	
	/**Este metodo le "aumenta" la velocidad al pooglin una vez que este
	 * pisa Hielo.-
	 * @param pooglin
	 */
	private void acelerarPooglin(Personaje pooglin){
		Pooglin auxiliarPooglin = (Pooglin) pooglin;
		Velocidad auxiliarVelocidad = auxiliarPooglin.getVelocidad();
		int velocidadX = auxiliarVelocidad.getVelocidadX();
		auxiliarVelocidad.setVelocidadX((velocidadX / Math.abs(velocidadX)) * VELOCIDAD_HIELO);
		auxiliarPooglin.setVelocidad(auxiliarVelocidad);
	}
	
	/**Redefino el metodo de la interfaz con la lógica propia de 
	 * este tipo de terreno.
	 * @param pooglin
	 */
	public void accionarTerreno(Personaje pooglin){
		Velocidad velocidad= ((Pooglin) pooglin).getVelocidad();
		velocidad.setVelocidadY(0);
		((Pooglin) pooglin).setVelocidad(velocidad);
		acelerarPooglin(pooglin);
	}

}
