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
	
	@Override
	public void utilizar(Personaje pooglin){
		Pooglin poglin = (Pooglin)pooglin;
		poglin.setVivo(false);
		Velocidad velocidad = poglin.getVelocidad();
		velocidad.setVelocidadX(Velocidad.VELOCIDAD_NULA);
		velocidad.setVelocidadY(Velocidad.VELOCIDAD_NULA);
		poglin.setVelocidad(velocidad);
		}

	@Override
	public void utilizar(Terreno terreno) {
		// no se usa
	}

	public void utilizar(Terreno terreno, Pooglin pooglin) {
		// no se usa
		
	}
	
	@Override
	public String toString(){
		return "Matar";
	}
}
