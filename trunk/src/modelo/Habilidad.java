package modelo;


/**Interfase que representa cualquier tipo de habilidad.-
 * @author Mart
 * @since 11/10/08
 * 
 */
public interface Habilidad {
	
	/**Usa la habilidad del personaje.-
	 * @param personaje
	 */
	public void utilizar(ObjetoVivo personaje);

	/**
	 * @param terreno
	 */
	public void utilizar(Terreno terreno);

	/**
	 * @param terreno
	 * @param pooglin
	 */
	public void utilizar(Terreno terreno, Pooglin pooglin);
	
	
}
