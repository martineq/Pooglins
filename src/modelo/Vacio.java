package modelo;

/**Clase que representa a los bloques de terreno donde el pooglin se desplaza.-
 * @author Mart
 * @since 11/10/08
 */
public class Vacio extends Terreno {

	private static int ALTURA_MAX = 5;
	//private int posicionX;
	//private int posicionY;
	
	/**Constructor de Vacio.-
     * 
     */
    public Vacio(int posicionX,int posicionY){
		this.setPosicionX(posicionX);
		this.setPosicionY(posicionY);
		this.setActivo(true);
	}
	    
//	public void setPosicionX(int posicionX) {
//		this.posicionX = posicionX;
//	}
//
//	public int getPosicionX() {
//		return posicionX;
//	}
//
//	public void setPosicionY(int posicionY) {
//		this.posicionY = posicionY;
//	}
//
//	public int getPosicionY() {
//		return posicionY;
//	}

	public void accionarTerreno(Personaje pooglin) {
		if ( ((Pooglin)pooglin).getAltura() > 0 ){ //Es el caso donde el pooglin está en el aire (está cayendo).-
			if( ((Pooglin)pooglin).getAltura() > ALTURA_MAX ){ //Si estoy con altura > ALTURA_MAX el pooglin muere, a menos que la habilidad que tenga sea un platillo.-
				Habilidad morir = ((Pooglin)pooglin).getMatarse();
				morir.utilizar(pooglin);
				Habilidad habilidadActual = ((Pooglin)pooglin).getHabilidad();
				habilidadActual.utilizar(pooglin); //Si habilidadActual es un Platillo => el pooglin va a vivir.-
			}else{
				this.caer((Pooglin)pooglin);
			}									   		   
		}else{ //Es el caso donde el pooglin está en el piso.-
			if ( ((Pooglin)pooglin).estaVivo() ){
				if ( (((Pooglin)pooglin).getVelocidad()).getVelocidadY() != Velocidad.VELOCIDAD_NULA ){ //Si venia cayendo, freno la caída.-
					(((Pooglin)pooglin).getVelocidad()).setVelocidadY(Velocidad.VELOCIDAD_NULA); 
			   	}else{//es el caso en el que el pooglin esta vivo y en el suelo, 
			   		Habilidad habilidadActual=((Pooglin)pooglin).getHabilidad();
			   		if(habilidadActual instanceof Congelamiento){
			   			habilidadActual.utilizar(pooglin);//"mata" al pooglin
			   			((Pooglin)pooglin).usarHabilidad(this);//transforma el terreno en Hielo
			   		}
			   	}
				//Me parece que el próximo "pooglin.mover();" no va porque antes tengo 
				//que saber que velocidad va a tener el personaje al hacer el 
				//"accionarTerreno" de los otros terrenos como hielo, roca, tierra
				//porque sino se va a mover con la velocidad del último terreno pisado.-
				//En resumen: si el pooglin no está cayendo, el vacio no es el que le da la velocidad,
				//se la va a dar el terreno que se encuentre "pisando".-
				//pooglin.mover();
			}else{
				((Pooglin)pooglin).borrarse(); //Si está "muerto" y "en el piso" desaparece de pantalla.-
			}								    
		}
	}
	
	/**Método privado que cambia la velocidad en 'Y' del pooglin.- 
	 * @since 18/10/08
	 * @param pooglin
	 */
	private void caer(Pooglin pooglin){
		Velocidad velocidadActual = pooglin.getVelocidad();
		velocidadActual.setVelocidadY( Velocidad.VELOCIDAD_NORMAL ); 
		pooglin.setVelocidad(velocidadActual);
	}	
}