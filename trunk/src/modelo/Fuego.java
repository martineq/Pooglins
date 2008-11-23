package modelo;

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
	
	/**Redefino el metodo de la interfaz con la logica propia
	 * de este tipo de terreno.-
	 * @param pooglin
	 */
	public void accionarTerreno(Personaje pooglin){
		Habilidad matarPooglin=((Pooglin)pooglin).getMatarse();
		matarPooglin.utilizar(pooglin);
	}
	

}
