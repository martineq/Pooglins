
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
	
	/**Redefino el m�todo de la interfaz con la l�gica propia
	 * de este tipo de terreno.-
	 * @param pooglin
	 */
	public void accionarTerreno(Personaje pooglin){
		
		((Pooglin)pooglin).getMatarse().utilizar(pooglin);
		/* Reemplac� este c�digo por el de arriba �queda mejor o no? (as� no instancio nada mas).-
		Habilidad matarPooglin=((Pooglin)pooglin).getMatarse();
		matarPooglin.utilizar(pooglin);
		*/
	}
	
}
