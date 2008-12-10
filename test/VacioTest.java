import modelo.Pooglin;
import modelo.Vacio;
import junit.framework.TestCase;

public class VacioTest extends TestCase {
	private Pooglin unPooglin;
	private Vacio vacio;
	
	@Override
	protected void setUp(){
		unPooglin = new Pooglin(0,0);
		vacio = new Vacio(0, 0);  // Le puse 0,0 por poner algo. Edgardo fijate que valor habria que ponerle.-
	}
	
	public void testAccionarTerrenoProfundo(){
		vacio.accionarTerreno(unPooglin);
		//revisar la clase vacio porque no se modifica en ningun
		//lugar el atributo altura.
		//assertEquals(unPooglin.getVelocidad().modulo(),5);
//aca se debe probar la velocidad del poolglin
		
	}

}
