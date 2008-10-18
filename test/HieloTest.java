import junit.framework.TestCase;

public class HieloTest extends TestCase{
	private Pooglin unPooglin;
	private Hielo hielo;
	
	protected void setUp(){
		unPooglin = new Pooglin(0,0);
		hielo = new Hielo();
	}

	public void testAccionarTerrenoPersonaje() {
		hielo.accionarTerreno(unPooglin);
		Velocidad velocidad = unPooglin.getVelocidad();
		assertEquals(5, velocidad.modulo());
	}

	public void testAccionarTerrenoPersonajeNivel() {
	}

}
