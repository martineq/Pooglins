
import junit.framework.TestCase;

/**
 * 
 */

/**
 * @author guido
 *
 */
public class PuertaTest extends TestCase{
	private Puerta puertaComienzo;
	private Puerta puertaFinal;
	
	protected void setUp(){
		puertaComienzo = new Puerta(3,9);
		puertaFinal = new Puerta(0,10);
	}
	
	public void testPuerta() {
		assertNotNull(puertaComienzo);
		assertNotNull(puertaFinal);
		
	}
	
	public void testGettersPuerta(){
		int posicionXpuertaComienzo=puertaComienzo.getPosicionX();
		int posicionYpuertaComienzo=puertaComienzo.getPosicionY();
		assertEquals(3,posicionXpuertaComienzo);
		assertEquals(9,posicionYpuertaComienzo);
		int posicionXpuertaFinal=puertaFinal.getPosicionX();
		int posicionYpuertaFinal=puertaFinal.getPosicionY();
		assertEquals(0,posicionXpuertaFinal);
		assertEquals(10,posicionYpuertaFinal);
	}

}
