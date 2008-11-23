import modelo.Velocidad;
import junit.framework.TestCase;


public class VelocidadTest extends TestCase  {
	private Velocidad velocidad;
	
	public void setUp(){
		velocidad = new Velocidad();
	}

	public void testCambiarDireccion() {
		velocidad.setVelocidadX(6);
		velocidad.setVelocidadY(0);
		velocidad.cambiarDireccion();
		assertEquals(-6,velocidad.getVelocidadX());		
	}

	public void testModuloEnX() {
		velocidad.setVelocidadX(-6);
		velocidad.setVelocidadY(0);
		assertEquals(6,velocidad.modulo());
	}

	public void testModuloEnY() {
		velocidad.setVelocidadX(0);
		velocidad.setVelocidadY(-6);
		assertEquals(6,velocidad.modulo());
	}

}
