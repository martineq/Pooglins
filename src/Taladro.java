


/**Taladro: es una herramienta que permite destruir un terreno que sea Tierra.
 * @author lkolaric
 *
 */
public class Taladro extends Herramienta {

	public void utilizar(Terreno terreno) {
		if (terreno instanceof Tierra){
			terreno.setActivo(false);
		}
	}
}
