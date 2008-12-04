package modelo;



/**Clase que representa la habilidad del pooglin de usar un platillo volador.-
 * @author Mart
 * @since 12/10/08
 * 
 */
public class Platillo extends Herramienta{
	
	
	/**Constructor de Platillo.-
	 * @since 18/10/08 
	 */
	public Platillo(){
		
	}
	
	public void utilizar(Terreno terreno, Pooglin pooglin){}

	/**Uso de la habilidad Platillo Volador, asegura la vida del pooglin
	 * y baja su velocidad
	 * @since 18/10/08 
	 */
	public void utilizar(Personaje personaje) {
		System.out.println("platillo");
		((Pooglin)personaje).setVivo(true);
		Velocidad velocidadActual = ((Pooglin)personaje).getVelocidad();
		velocidadActual.setVelocidadY( 1 * Velocidad.VELOCIDAD_PLATILLO ); 
		((Pooglin)personaje).setVelocidad(velocidadActual);
	}
	
	public String toString(){
		return "Platillo";
	}
}
