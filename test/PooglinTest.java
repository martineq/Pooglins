import junit.framework.TestCase;


public class PooglinTest extends TestCase {
	private Pooglin unPooglin;
	
	protected void setUp(){
		unPooglin = new Pooglin(0,0);
	}

	public void testPooglin() {
		assertNotNull(unPooglin);
	}

	public void testMover() {
		assertEquals(unPooglin.getPosicionX(),0);
		unPooglin.mover();
		assertEquals(unPooglin.getPosicionX(),1);
		assertEquals(unPooglin.getPosicionY(),0);
		unPooglin.mover();
		assertEquals(unPooglin.getPosicionX(),2);	
	}

	public void testVerPosicionX() {
		assertEquals(unPooglin.getPosicionX(),0);
	}

	public void testVerPosicionY() {
		assertEquals(unPooglin.getPosicionY(),0);
	}

	public void testGetAltura() {
		assertEquals(unPooglin.getAltura(),0);
			
	}

	public void testSubirAltura() {
		int altura = unPooglin.getAltura();
		unPooglin.subirAltura();
		assertEquals(unPooglin.getAltura(),altura+1);
	}

	public void testBajarAltura() {
		int altura = unPooglin.getAltura();
		unPooglin.bajarAltura();
		assertEquals(unPooglin.getAltura(),altura-1);
	}

	public void testGetHabilidad() {
	}

	public void testSetHabilidad() {
		
	}

	public void testMorir() {
				
	}

	public void testAbrirParacaidas() {
		
	}

	public void testAterrizar() {
	}

}
