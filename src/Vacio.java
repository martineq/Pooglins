
/**Clase que representa a los bloques de terreno donde el pooglin se desplaza.-
 * @author Mart
 * @since 11/10/08
 */
public class Vacio implements Terreno {

	/**El atributo altura va a ser usado solo por la clase Vacio,
	 * para poder comprobar si el personaje se encuentra en caida libre.-
	 */
	private int altura;
	private static int VELOCIDAD_NORMAL = 6;

	/**Constructor de Vacio.-
     * 
     */
    public Vacio(){
		
	}
		
	/**Seter que me indica la "altura del piso" en que se encuentra el personaje.-
	 * @since 18/10/08
	 * @param pooglin
	 * @param campo
	 */
	private void setAltura(Personaje pooglin,Nivel campo) {
		int contador = 1;
		altura = 0;
		while ( (campo.revisarNivel( ((Pooglin)pooglin).getPosicionX() , ((Pooglin)pooglin).getPosicionY() - contador  ,pooglin) instanceof Vacio ){
			altura++;
			contador++;
		}
	}

	private int getAltura() {
		return altura;
	}
		
	/**Método privado que cambia la velocidad en 'Y' del pooglin.- 
	 * @since 18/10/08
	 * @param pooglin
	 */
	private void caer(Pooglin pooglin){
		Velocidad velocidadActual = pooglin.getVelocidad();
		// me parece que conviene pooner un metodo para asignar c/velocidad,
		// o sino poner constantes. Como para que la clase vacio no sepa que 'velocidad'
		// le estoy dando, y que solo sea interno a la clase velocidad
		// p.e.: velocidadPlatillo(); que devuelva el valor de la vel. del platillo. Martín.-
		velocidadActual.setVelocidadY( (-1) * VELOCIDAD_NORMAL ); 
		pooglin.setVelocidad(velocidadActual);
	}	
	
	public void accionarTerreno(Personaje pooglin) {
		
	}

	public void accionarTerreno(Personaje pooglin,Nivel campo) {
		this.setAltura(pooglin,campo);
		if ( this.getAltura() > 0 ){ //Es el caso donde el pooglin está en el aire (está cayendo).-
			if( this.getAltura() > 5){ //Si estoy con altura>5 el poooglin muere, a menos que la habilidad que tenga sea un platillo.-
				Habilidad morir = ((Pooglin)pooglin).getMatarse();
				morir.utilizar(pooglin);
				Habilidad habilidadActual = ((Pooglin)pooglin).getHabilidad();
				habilidadActual.utilizar(pooglin); //Si habilidadActual es un Platillo => el pooglin va a vivir.-
				pooglin.mover();
			}else{
				this.caer((Pooglin)pooglin);
				pooglin.mover();				   
			}									   		   
		}else{ //Es el caso donde el pooglin está en el piso.-
			if ( ((Pooglin)pooglin).estaVivo() ){
				if ( (((Pooglin)pooglin).getVelocidad()).getVelocidadY() != 0 ) //Si venia cayendo, freno la caida.-
					(((Pooglin)pooglin).getVelocidad()).setVelocidadY(0); 
				//Me parece que el proximo "pooglin.mover();" no va porque antes tengo 
				//que saber que velocidad va a tener el personaje al hacer el 
				//"accionarTerreno" de los otros terrenos como hielo, roca, tierra
				//porque sino se va a mover con la velocidad del último terreno pisado.-
				//En resumen: si el pooglin no está cayendo, el vacio no es el que le da la velocidad,
				//se la va a dar el terreno que se encuentre "pisando".-
				
				//pooglin.mover();
			}else{
				((Pooglin)pooglin).borrarse(); //Si está "muerto" y "en el piso" desaparece de pantalla.-
			}								   //Además faltaría chequear que no se encuentre congelado (en ese caso no se borra de pantalla).-
		}
	}	
	
}