
/**Interfase que representa a un Terreno del juego.-
 * @author Mart
 *
 */
public interface Terreno {

	/**M�todo que activa al terreno a interactuar con el personaje.-
	 * @param pooglin
	 */
	public void accionarTerreno(Personaje pooglin);
	
	/**M�todo que activa al terreno a interactuar con el personaje.-
	 * @param pooglin
	 * @param campo
	 */
	public void accionarTerreno(Personaje pooglin,Nivel campo);
	
}
