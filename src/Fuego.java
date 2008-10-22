
/**
 * 
 */

/**
 * @author lkolaric
 *
 */
public class Fuego extends Terreno {

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
	

}
