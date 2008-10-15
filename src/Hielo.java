/**
 * 
 */

/**
 * @author guido
 *
 */
public class Hielo implements Terreno{

	private static int velocidadHielo = 3;
	
	/**Este metodo le "aumenta" la velocidad al pooglin una vez que este
	 * pisa Hielo. 
	 * @param pooglin
	 */
	private void acelerarPooglin(Personaje pooglin){
		Pooglin auxiliarPooglin = (Pooglin) pooglin;
		Velocidad auxiliarVelocidad = auxiliarPooglin.getVelocidad();
		int velocidadX = auxiliarVelocidad.getVelocidadX();
		auxiliarVelocidad.setVelocidadX((velocidadX / Math.abs(velocidadX)) * velocidadHielo);
		auxiliarPooglin.setVelocidad(auxiliarVelocidad);
	}
	
	/**Redefino el metodo de la interfaz con la l�gica propia de 
	 * este tipo de terreno.
	 * @param pooglin
	 */
	public void accionarTerreno(Personaje pooglin){
		acelerarPooglin(pooglin);
	}
	/** Este metodo no lo implemento por no ser necesario para
	 * el desarrollo de esta clase, solamente lo redefino porque esta
	 * en la interfaz y quiero evitar que esta sea una clase abstracta.
	 * @param pooglin
	 * @param campo
	 */
	public void accionarTerreno(Personaje pooglin, Nivel campo){
	}
}
