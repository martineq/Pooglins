
import junit.framework.TestCase;

/**
 * 
 */

/**
 * @author guido
 *
 */
public class MorirTest extends TestCase{

	private Pooglin unPooglin;
	private Morir morir;
	
	protected void setUp(){
		unPooglin = new Pooglin(0,0);
		morir = new Morir();
	}

	public void testUtilizarMorir() {
		Velocidad velocidad = unPooglin.getVelocidad();
		velocidad.setVelocidadX(6);
		velocidad.setVelocidadY(0);
		unPooglin.setVelocidad(velocidad);
		morir.utilizar(unPooglin);
		boolean vive=unPooglin.estaVivo();
		assertFalse(vive);
		velocidad=unPooglin.getVelocidad();
		assertEquals(0,velocidad.getVelocidadX());
		assertEquals(0,velocidad.getVelocidadY());
	}


}
