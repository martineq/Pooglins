

/**Interfase que representa cualquier tipo de habilidad.-
 * @author Mart
 * @since 11/10/08
 */
public interface Habilidad {
	
	/**Usa la habilidad del personaje.-
	 * @param personaje
	 */
	public void utilizar(Personaje personaje);

	public void utilizar(Terreno terreno);

	public void utilizar(Terreno terreno, Pooglin pooglin);
	
	
}
