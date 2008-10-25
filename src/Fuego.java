
/**
 * @author guido
 *
 */
public class Fuego extends Terreno {

	/**Constructor de Fuego.-
	 * 
	 */
    public Fuego(int posicionX,int posicionY){
		this.setPosicionX(posicionX);
		this.setPosicionY(posicionY);
		this.setActivo(true);
	}
	
	/**Redefino el método de la interfaz con la lógica propia
	 * de este tipo de terreno.-
	 * @param pooglin
	 */
	public void accionarTerreno(Personaje pooglin){
		
		((Pooglin)pooglin).getMatarse().utilizar(pooglin);
		/* Reemplacé este código por el de arriba ¿queda mejor o no? (así no instancio nada mas).-
		Habilidad matarPooglin=((Pooglin)pooglin).getMatarse();
		matarPooglin.utilizar(pooglin);
		*/
	}
	
}
