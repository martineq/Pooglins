
import modelo.Fuego;
import modelo.Pooglin;
import junit.framework.TestCase;

public class FuegoTest extends TestCase {
	private Pooglin unPooglin;
	private Fuego fuego;
		
	@Override
	protected void setUp(){
		unPooglin = new Pooglin(0,0);
		fuego = new Fuego(0,0); //Cambié el constructor
	}
	
	public void testAccionarFuego(){
		fuego.accionarTerreno(unPooglin);
		assertFalse(unPooglin.estaVivo());
	}
	
}
