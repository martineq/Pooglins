import junit.framework.TestCase;

public class FuegoTest extends TestCase {
	private Pooglin unPooglin;
	private Fuego fuego;
		
	protected void setUp(){
		unPooglin = new Pooglin(0,0);
		fuego = new Fuego();
	}
	
	public void testAccionarFuego(){
		fuego.accionarTerreno(unPooglin);
		assertFalse(unPooglin.estaVivo());
	}
	
}
