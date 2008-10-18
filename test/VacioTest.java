import junit.framework.TestCase;

public class VacioTest extends TestCase {
	private Pooglin unPooglin;
	private Vacio vacio;
	
	protected void setUp(){
		unPooglin = new Pooglin(0,0);
		vacio = new Vacio();
	}
	
	public void testAccionarTerrenoProfundo(){
		vacio.accionarTerreno(unPooglin);
		assertFalse(unPooglin.estaVivo());
	}

}
