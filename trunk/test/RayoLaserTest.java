import modelo.Pooglin;
import modelo.RayoLaser;
import modelo.Terreno;
import modelo.Tierra;
import junit.framework.TestCase;


public class RayoLaserTest extends TestCase{
	private Terreno terreno;
	private RayoLaser rayo;
	private Pooglin pooglin;
	
	@Override
	protected void setUp(){
		terreno = new Tierra(0,0);
		rayo = new RayoLaser();
		pooglin = new Pooglin(0,0);
		pooglin.setHabilidad(rayo);
 		
	}
	
	public void testLanzarRayo(){
		assertEquals(4,((Tierra) terreno).getResistencia());
		assertEquals(true,terreno.isActivo());
		rayo.utilizar(terreno,pooglin);
		assertEquals(3,((Tierra) terreno).getResistencia());
		assertEquals(true,terreno.isActivo());
		rayo.utilizar(terreno,pooglin);
		assertEquals(2,((Tierra) terreno).getResistencia());
		assertEquals(true,terreno.isActivo());
		rayo.utilizar(terreno,pooglin);
		assertEquals(1,((Tierra) terreno).getResistencia());
		assertEquals(true,terreno.isActivo());
		rayo.utilizar(terreno,pooglin);
		assertEquals(0,((Tierra) terreno).getResistencia());
		assertEquals(false,terreno.isActivo());
	}
	
	//por si los necesito--generados automaticamente
	public Terreno getTerreno() {
		return terreno;
	}
	public void setTerreno(Terreno terreno) {
		this.terreno = terreno;
	}
	public RayoLaser getRayo() {
		return rayo;
	}
	public void setRayo(RayoLaser rayo) {
		this.rayo = rayo;
	}
	
	
}
