import junit.framework.TestCase;


public class VacioTest extends TestCase {
	//private Nivel nivelPruebaVacio;
	private Pooglin unPooglin;
	
	protected void setUp(){
	unPooglin = new Pooglin(0,0);
	}
	
	public void testAccionarTerrenoProfundo(){
		//aca hay que inicializar el nivelPruebaVacio  
		//vacio con mas de 5 bloques de profundidad.
		unPooglin.mover();
		assertFalse(unPooglin.estaVivo());
	}

	public void testAccionarTerrenoNoProfundo(){
		//aca hay que inicializar el nivelPruebaVacio  
		//vacio con menos de 5 bloques de profundidad.
		unPooglin.mover();
		assertTrue(unPooglin.estaVivo());
	}

}
