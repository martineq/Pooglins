package modelo;

/**Clase que representa a los bloques de terreno donde el pooglin se desplaza.-
 * @author Mart
 * @since 11/10/08
 */
public class Vacio extends Terreno {

	private static int ALTURA_MAX = 5 * Velocidad.VELOCIDAD_NORMAL;  //¿Por que aparece la velocidad en la altura?
	
	/**Constructor de Vacio.-
     * 
     */
    public Vacio(int posicionX,int posicionY){
		this.setPosicionX(posicionX);
		this.setPosicionY(posicionY);
		this.setActivo(true);
	}

	@Override
	public void accionarTerreno(ObjetoVivo unPooglin) {	
		Pooglin pooglin = (Pooglin)unPooglin;				
		Habilidad habilidadActual = (pooglin).getHabilidad();
		if( pooglin.getAltura() > ALTURA_MAX ){ //Si estoy con altura > ALTURA_MAX el pooglin muere, a menos que la habilidad que tenga sea un platillo.-
			pooglin.setHabilidad(pooglin.getMatarse());
		}
		else if (habilidadActual instanceof Platillo) {
			habilidadActual.utilizar(pooglin);
			pooglin.setAltura(0);
		}
		     else this.caer(pooglin);
	}
	
	/**Método privado que cambia la velocidad en 'Y' del pooglin.- 
	 * @since 18/10/08
	 * @param pooglin
	 */
	private void caer(Pooglin pooglin){
		Velocidad velocidadActual = pooglin.getVelocidad();
		velocidadActual.setVelocidadY( Velocidad.VELOCIDAD_NORMAL ); 
		pooglin.setVelocidad( velocidadActual );
		pooglin.setAltura( pooglin.getAltura() + 1 );
	}	
}