import junit.framework.TestCase;


public class FuegoTest extends TestCase {
	//private Nivel nivelPruebaFuego;
	private Pooglin unPooglin;
	
	protected void setUp(){
	//aca hay que inicializar el nivelPruebaFuego  
	//con fuego para probarlo
	unPooglin = new Pooglin(0,0);
	
	}
	
	public void testAccionarTerreno(){
		unPooglin.mover();
		assertTrue(unPooglin.estaVivo());
	}

}
