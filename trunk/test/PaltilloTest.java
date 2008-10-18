import junit.framework.TestCase;

public class PaltilloTest extends TestCase{
	private Pooglin unPooglin;
	private Platillo platillo;
		
	protected void setUp(){
		unPooglin = new Pooglin(0,0);
		platillo = new Platillo();
	}

	public void testUtilizarConParacaidas() {
    	platillo.utilizar(unPooglin);
		Velocidad velocidad = unPooglin.getVelocidad();
		assertEquals(7, velocidad.modulo());
	}

}
