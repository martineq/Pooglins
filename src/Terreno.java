
/**Interfase que representa a un Terreno del juego.-
 * @author Mart
 *
 */
public interface Terreno {

	/**Método que activa al terreno a interactuar con el personaje.-
	 * @param pooglin
	 */
	public void accionarTerreno(Personaje pooglin);
	
	/**Método que activa al terreno a interactuar con el personaje.-
	 * @param pooglin
	 * @param campo
	 */
	public void accionarTerreno(Personaje pooglin,Nivel campo);
	
}
