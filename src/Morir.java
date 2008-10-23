
/**Clase que representa la habilidad del pooglin de morir.-
 * @author guido
 * @since
 */
public class Morir extends Comportamiento {

	private static int VELOCIDAD_NULA = 0;
	
	/**Constructor de Morir.-
	 * 
	 */
	public Morir(){
		
	}
	
	public void utilizar(Personaje pooglin){
		Pooglin poglin = (Pooglin)pooglin;
		poglin.setVivo(false);
		Velocidad velocidad = poglin.getVelocidad();
		velocidad.setVelocidadX(VELOCIDAD_NULA);
		velocidad.setVelocidadY(VELOCIDAD_NULA);
		poglin.setVelocidad(velocidad);
		//REVISAR SI VAMOS A SACARLO DE LA PANTALLA CUANDO LO 
		//MATAMOS 
	    //Guido.-
		//El pooglin se "borrará" de pantalla cuando se encuentre en altura cero 
		//y tenga la condicion de vivo == false (para que no muera en el aire). 
		//Además hay que comprobar que no se encuentre congelado. Mart.-
	}

	public void utilizar(Terreno terreno) {
		// no se usa
	}

	public void utilizar(Terreno terreno, Pooglin pooglin) {
		// no se usa
		
	}
}
