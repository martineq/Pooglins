
/**Clase que representa a los bloques de terreno donde el pooglin se desplaza.-
 * @author mart
 * @since 11/10/08
 */
public class Vacio implements Terreno {

	/**El atributo altura va a ser usado solo por la clase Vacio,
	 * para poder comprobar si el personaje se encuentra en caida libre.-
	 */
	private int altura;

	/**Constructor de Vacio.-
     * 
     */
    public Vacio(){
		
	}
		
	/**Seter que me indica la "altura del piso" en que se encuentra el personaje.-
	 * @author Mart
	 * @since 18/10/08
	 * @param pooglin
	 * @param campo
	 */
	private void setAltura(Personaje pooglin,Nivel campo) {
		int contador = 1;
		altura = 0;
		while ( (campo.revisarNivel( ((Pooglin)pooglin).getPosicionX() , ((Pooglin)pooglin).getPosicionY() - contador ) ) instanceof Vacio ){
			altura++;
			contador++;
		}
	}

	private int getAltura() {
		return altura;
	}

		
	/**Método privado que cambia la velocidad en 'Y' del pooglin.- 
	 * @author Mart
	 * @since 18/10/08
	 * @param pooglin
	 * @return void
	 * @throws sin throws
	 */
	private void caer(Pooglin pooglin){
		Velocidad velocidadActual = pooglin.getVelocidad();
		// me parece que conviene pooner un metodo para asignar c/velocidad,
		// o sino poner constantes. Como para que la clase vacio no sepa que 'velocidad'
		// le estoy dando, y que solo sea interno a la clase velocidad
		// p.e.: velocidadPlatillo(); que devuelva el valor de la vel. del platillo. Martín.-
		velocidadActual.setVelocidadY(-6); 
		pooglin.setVelocidad(velocidadActual);
	}	
	
	public void accionarTerreno(Personaje pooglin) {
		
	}

	public void accionarTerreno(Personaje pooglin,Nivel campo) {
		this.setAltura(pooglin, campo);
		if ( this.getAltura() > 0 ){ //Es el caso donde el pooglin está en el aire (está cayendo).-
			if( this.getAltura() > 5){ //Si estoy con altura>5 el poooglin muere, a menos que la habilidad que tenga sea un platillo.-
				Habilidad morir=((Pooglin)pooglin).getMatarse();
				morir.utilizar(pooglin);
				Habilidad habilidadActual=((Pooglin)pooglin).getHabilidad();
				habilidadActual.utilizar(pooglin); //Si habilidadActual es un Platillo => el pooglin va a vivir.-
				pooglin.mover();
			}else{
				this.caer((Pooglin)pooglin);
				pooglin.mover();				   
			}									   		   
		}else{ //Es el caso donde el pooglin está en el piso.-
			if ( ((Pooglin)pooglin).estaVivo() ){
				pooglin.mover(); //No cambio la velocidad, esta tocando 'el piso' (o sea no está cayendo).-
			}else{
				((Pooglin)pooglin).borrarse(); //Aca desaparece de pantalla.-
			}
		}
	}	


}