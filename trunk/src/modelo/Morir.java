package modelo;

/**Clase que representa la habilidad del pooglin de morir.-
 * @author guido
 * @since
 * 
 */
public class Morir extends Comportamiento {

	
	/**Constructor de Morir.-
	 * 
	 */
	public Morir(){
		
	}
	
	public void utilizar(Personaje pooglin){
		Pooglin poglin = (Pooglin)pooglin;
		poglin.setVivo(false);
		Velocidad velocidad = poglin.getVelocidad();
		velocidad.setVelocidadX(Velocidad.VELOCIDAD_NULA);
		velocidad.setVelocidadY(Velocidad.VELOCIDAD_NULA);
		poglin.setVelocidad(velocidad);
		//REVISAR SI VAMOS A SACARLO DE LA PANTALLA CUANDO LO 
		//MATAMOS 
	    //Guido.-
		//El pooglin se "borrará" de pantalla cuando se encuentre en altura cero 
		//y tenga la condición de vivo == false (para que no muera en el aire). 
		//Además hay que comprobar que no se encuentre congelado. Mart.-
	}

	public void utilizar(Terreno terreno) {
		// no se usa
	}

	public void utilizar(Terreno terreno, Pooglin pooglin) {
		// no se usa
		
	}
}
