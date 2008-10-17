
/**
 * 
 */

/**
 * @author guido
 *
 */
public class Matar implements Habilidad {

	//Ver si no tiene que hacer algo ademas de setear en
	//Falso el atributo está vivo
	//Guido.-
	public void utilizar(Personaje pooglin){
		Pooglin poglin=(Pooglin)pooglin;
		poglin.setVivo(false);
		Velocidad velocidad = poglin.getVelocidad();
		velocidad.setVelocidadX(0);
		velocidad.setVelocidadY(0);
		poglin.setVelocidad(velocidad);
		//REVISAR SI VAMOS A SACARLO DE LA PANTALLA CUANDO LO 
		//MATAMOS 
		//Guido.-
		//((Pooglin)pooglin).setPosicionX(-5);
		//((Pooglin)pooglin).setPosicionY(-5);
	}
}
