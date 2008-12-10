import modelo.Pooglin;
import modelo.Tunel;
import modelo.Terreno;
import modelo.Tierra;
import modelo.Velocidad;
import junit.framework.TestCase;


public class TunelTest extends TestCase {
	private Terreno terreno;
	private Tunel tunel ;
	private Pooglin pooglin;
	
	protected void setUp(){
		terreno = new Tierra(0,3);
		tunel = new Tunel();
		pooglin = new Pooglin(0,3);
		pooglin.setHabilidad(tunel);
 		
	}
	public void testUtilizarTeletransportarse(){
		Velocidad velocidad = new Velocidad();
		velocidad.setVelocidadX(6);
		pooglin.setVelocidad(velocidad);
		tunel.utilizar(terreno,pooglin);
		int posicionX = pooglin.getPosicionX();
		int posicionY = pooglin.getPosicionY();
		assertEquals(2,posicionX);
		assertEquals(1,posicionY);
		pooglin = new Pooglin(8,3);
		terreno = new Tierra(8,3);
		velocidad.setVelocidadX(-6);
		pooglin.setVelocidad(velocidad);
		tunel.utilizar(terreno, pooglin);
		posicionX = pooglin.getPosicionX();
		posicionY = pooglin.getPosicionY();
		assertEquals(6,posicionX);
		assertEquals(1,posicionY);
	}


}
