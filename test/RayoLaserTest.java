import junit.framework.TestCase;


public class RayoLaserTest extends TestCase{
	private Terreno terreno;
	private RayoLaser rayo;
	
	protected void setUp(){
		terreno = new Tierra(0,0);
		rayo = new RayoLaser();
	}
	
	public void testLanzarRayo(){
		assertEquals(4,((Tierra) terreno).getResistencia());
		assertEquals(true,terreno.isActivo());
		rayo.utilizar(terreno);
		assertEquals(3,((Tierra) terreno).getResistencia());
		rayo = new RayoLaser();
		assertEquals(true,terreno.isActivo());
		rayo.utilizar(terreno);
		assertEquals(2,((Tierra) terreno).getResistencia());
		rayo = new RayoLaser();
		assertEquals(true,terreno.isActivo());
		rayo.utilizar(terreno);
		assertEquals(1,((Tierra) terreno).getResistencia());
		rayo = new RayoLaser();
		assertEquals(true,terreno.isActivo());
		rayo.utilizar(terreno);
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
