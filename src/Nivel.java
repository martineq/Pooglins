
/**Clase que representa el campo de juego donde se encuentran los personajes
 * y los distintos tipos de terrenos. Implementa la interfaz Escenario.- 
 * @author mart
 * @since 11/10/08
 */
public class Nivel implements Escenario {
	private Terreno[][] matrizNivel;
	private Personaje[] pooglins;
	private int pooglinsARescatar;
	private int cantidadPooglins;
	
	/**Constructor de Nivel.-
	 * 
	 */
	public Nivel(){
		
	}
	
	public void manejar() {
		
	}

	/**Método que devuelve el terreno dado por la posición X e Y.-
	 * @param posicionX
	 * @param posicionY
	 * @return
	 */
	public Terreno revisarNivel(int posicionX, int posicionY){
		return null;	
	}
}
