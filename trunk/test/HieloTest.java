
import modelo.Hielo;
import modelo.Pooglin;
import modelo.Velocidad;
import junit.framework.TestCase;

public class HieloTest extends TestCase{
	private Pooglin unPooglin;
	private Hielo hielo;
	
	@Override
	protected void setUp(){
		unPooglin = new Pooglin(2,1);
		hielo = new Hielo(2,2); //Cambié el constructor
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
