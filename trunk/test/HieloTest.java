import junit.framework.TestCase;

public class HieloTest extends TestCase{
	private Pooglin unPooglin;
	private Hielo hielo;
	
	protected void setUp(){
		unPooglin = new Pooglin(0,0);
		hielo = new Hielo(0,0); //Cambié el constructor
	}

	public void testAccionarTerrenoPersonaje() {
		Velocidad velocidad = unPooglin.getVelocidad();
		velocidad.setVelocidadX(6);
		velocidad.setVelocidadY(0);
		unPooglin.setVelocidad(velocidad);
		hielo.accionarTerreno(unPooglin);
		velocidad = unPooglin.getVelocidad();
		assertEquals(5, velocidad.modulo());
	}

	public void testAccionarTerrenoPersonajeNivel() {
	}

}
