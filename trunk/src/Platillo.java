
/**Clase que representa la habilidad del pooglin de usar un platillo volador.-
 * @author mart
 * @since 12/10/08
 */
public class Platillo extends Herramienta{
	
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
		velocidadActual.setVelocidadY(-7); 
		((Pooglin)personaje).setVelocidad(velocidadActual);
	}
		
}
