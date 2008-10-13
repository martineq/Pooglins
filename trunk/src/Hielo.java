/**
 * 
 */

/**
 * @author guido
 *
 */
public class Hielo implements Terreno{

	/**Redefino el metodo de la interfaz con la lógica propia de 
	 * este tipo de terreno.
	 * @param pooglin
	 */
	public void accionarTerreno(Personaje pooglin){
		Velocidad velocidad=((Pooglin)pooglin).getVelocidad();
		int moduloVelocidad=velocidad.getModulo();
		int duplicaVelocidad=moduloVelocidad * 2;
		velocidad.setModulo(duplicaVelocidad);
		((Pooglin)pooglin).setVelocidad(velocidad);
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
