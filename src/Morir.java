/**Clase que representa la habilidad del pooglin de morir.-
 * @author guido
 * @since
 */
public class Morir implements Habilidad {

	/**Constructor de Morir.-
	 * 
	 */
	public Morir(){
		
	}
	
	public void utilizar(Personaje pooglin){
		Pooglin poglin = (Pooglin)pooglin;
		poglin.setVivo(false);
		Velocidad velocidad = poglin.getVelocidad();
		velocidad.setVelocidadX(0);
		velocidad.setVelocidadY(0);
		poglin.setVelocidad(velocidad);
		//REVISAR SI VAMOS A SACARLO DE LA PANTALLA CUANDO LO 
		//MATAMOS 
	    //Guido.-
		//El pooglin se "borrará" de pantalla cuando se encuentre en altura cero 
		//y tenga la condicion de vivo == false (para que no muera en el aire). Mart.-
	}
}
