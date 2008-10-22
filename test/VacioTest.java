import junit.framework.TestCase;

public class VacioTest extends TestCase {
	private Pooglin unPooglin;
	private Vacio vacio;
	
	protected void setUp(){
		unPooglin = new Pooglin(0,0);
		vacio = new Vacio(0, 0);  // Le puse 0,0 por poner algo. Edgardo fijate que valor habria que ponerle.-
	}
	
	public void testAccionarTerrenoProfundo(){
		vacio.accionarTerreno(unPooglin);
//aca se debe probar la velocidad del poolglin
		
	}

}
