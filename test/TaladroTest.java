import modelo.Pooglin;
import modelo.Roca;
import modelo.Taladro;
import modelo.Terreno;
import modelo.Tierra;
import junit.framework.TestCase;


public class TaladroTest extends TestCase{
	private Terreno terreno;
	private Pooglin pooglin;
	private Terreno terreno2;
	private Taladro taladro;
	
	protected void setUp(){
		this.terreno = new Tierra(0,0);
		this.pooglin = new Pooglin(0,0);
		this.terreno2 = new Roca(0,0);
		taladro = new Taladro();
	}
	
	public void testUtilizarTaladro(){
		taladro.utilizar(terreno, pooglin);
		assertEquals(1,taladro.getCantidadExcavaciones());
		assertEquals(false,terreno.isActivo());
		
		assertEquals(6,pooglin.getVelocidad().getVelocidadY());
		taladro.utilizar(terreno, pooglin);
		assertEquals(false,terreno.isActivo());
		
		assertEquals(2,taladro.getCantidadExcavaciones());
		assertEquals(6,pooglin.getVelocidad().getVelocidadY());
		taladro.utilizar(terreno, pooglin);
		assertEquals(false,terreno.isActivo());
	
		assertEquals(3,taladro.getCantidadExcavaciones());
		assertEquals(6,pooglin.getVelocidad().getVelocidadY());
		taladro.utilizar(terreno, pooglin);
		assertEquals(false,terreno.isActivo());
	
		assertEquals(4,taladro.getCantidadExcavaciones());
		assertEquals(6,pooglin.getVelocidad().getVelocidadY());
		taladro.utilizar(terreno, pooglin);
		assertEquals(false,terreno.isActivo());

		assertEquals(5,taladro.getCantidadExcavaciones());
		assertEquals(6,pooglin.getVelocidad().getVelocidadY());
		taladro.utilizar(terreno, pooglin);
		assertEquals(false,terreno.isActivo());

		assertEquals(5,taladro.getCantidadExcavaciones());//ya no se puede excavar mas
		assertEquals(6,pooglin.getVelocidad().getVelocidadY());
		taladro = new Taladro();
		taladro.utilizar(terreno2, pooglin);
		assertEquals(true,terreno2.isActivo());
		assertEquals(0,taladro.getCantidadExcavaciones());
	}
	
}
