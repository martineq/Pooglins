
/**Clase que representa a los bloques de terreno donde hay un agujero negro.-
 * @author lkolaric
 * @since 15/10/08
 */
public class AgujeroNegro extends Terreno {

	/**Constructor de AgujeroNegro.-
	 * 
	 */
    public AgujeroNegro(int posicionX,int posicionY){
		this.setPosicionX(posicionX);
		this.setPosicionY(posicionY);
		this.setActivo(true);
	}

	public void accionarTerreno(Personaje pooglin) {
		
	}

	public void accionarTerreno(Personaje pooglin,Nivel campo) {
	
	}

}