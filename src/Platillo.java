
/**Clase que representa la habilidad del pooglin de usar un platillo volador.-
 * @author Mart
 * @since 12/10/08
 */
public class Platillo extends Herramienta{
	
	private static int VELOCIDAD_PLATILLO = 7;
	
	/**Constructor de Platillo.-
	 * @author mart
	 * @since 18/10/08 
	 */
	public Platillo(){
		
	}
	
	/**Uso de la habilidad Platillo Volador, asegura la vida del pooglin
	 * y baja su velocidad
	 * @author mart
	 * @since 18/10/08 
	 */
	public void utilizar(Personaje personaje) {
		((Pooglin)personaje).setVivo(true);
		Velocidad velocidadActual = ((Pooglin)personaje).getVelocidad();
		velocidadActual.setVelocidadY(-1 * VELOCIDAD_PLATILLO); 
		((Pooglin)personaje).setVelocidad(velocidadActual);
	}
		
}
