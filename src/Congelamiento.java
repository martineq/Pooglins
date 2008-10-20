

/**Representa la habilidad que tiene un pooglin de congelarse.-
 * @author Mart
 * @since 18/10/08
 */
public class Congelamiento implements Habilidad {

	public void utilizar(Personaje personaje) {
		Habilidad morir = ((Pooglin)personaje).getMatarse();
		morir.utilizar(personaje);
	}

	public void utilizar(Terreno terreno) {
				
	}

}
