import modelo.Pooglin;
import modelo.Teletransportarse;
import modelo.Terreno;
import modelo.Tierra;
import modelo.Velocidad;
import junit.framework.TestCase;

public class TeletransportarseTest extends TestCase {

	private Terreno terreno;
	private Teletransportarse teleport;
	private Pooglin pooglin;
	
	protected void setUp(){
		terreno = new Tierra(0,0);
		teleport = new Teletransportarse();
		pooglin = new Pooglin(0,0);
		pooglin.setHabilidad(teleport);
 		
	}
	public void testUtilizarTeletransportarse(){
		Velocidad velocidad = new Velocidad();
		velocidad.setVelocidadX(6);
		pooglin.setVelocidad(velocidad);
		teleport.utilizar(terreno,pooglin);
		int posicionX = pooglin.getPosicionX();
		int posicionY = pooglin.getPosicionY();
		assertEquals(5,posicionX);
		assertEquals(0,posicionY);
		pooglin = new Pooglin(8,1);
		terreno = new Tierra(8,1);
		velocidad.setVelocidadX(-6);
		pooglin.setVelocidad(velocidad);
		teleport.utilizar(terreno, pooglin);
		posicionX = pooglin.getPosicionX();
		posicionY = pooglin.getPosicionY();
		assertEquals(3,posicionX);
		assertEquals(1,posicionY);
	}
}
