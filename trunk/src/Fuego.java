

/**Clase que representa a los bloques de terreno donde hay Fuego.-
 * @author guido
 * @since
 */
public class Fuego implements Terreno {
	
	/**Constructor de Fuego.-
	 * 
	 */
	public Fuego(){
		
	}
	
	/**Redefino el metodo de la interfaz con la logica propia
	 * de este tipo de terreno.-
	 * @param pooglin
	 */
	public void accionarTerreno(Personaje pooglin){
		Habilidad matarPooglin=((Pooglin)pooglin).getMatarse();
		matarPooglin.utilizar(pooglin);
	}
	
	/**Este metodo no lo implemento por no ser necesario para
	 * el desarrollo de esta clase, pero lo redefino para que 
	 * no sea abstracta dado que el mismo esta en la interfaz
	 * @param pooglin
	 * @param campo
	 */
	public void accionarTerreno(Personaje pooglin,Nivel campo){
	}
}
