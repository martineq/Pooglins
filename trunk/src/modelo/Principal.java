package modelo;
import controlador.UnionMVC;

/**Clase que contiene al juego
 * @author Mart.-
 *
 */
public class Principal {
	/**Este es el "main" del juego.-
	 * @param args
	 */
	public static void main(String[] args) {
		ControladorJuego controlador = UnionMVC.cargarJuego("Nivel0.xml",985,700,350);
		controlador.comenzar();
	}
}
