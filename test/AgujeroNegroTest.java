
import junit.framework.TestCase;

/**
 * 
 */

/**
 * @author guido
 *
 */
public class AgujeroNegroTest extends TestCase{

	private Nivel nivel=null;
	private AgujeroNegro agujeroNegro;
	private Terreno[][] matrizNivel;
	private Personaje[] pooglins;
	private int tamanioMatriz;
	private int cantidadPooglins;
	
	private void llenarMatrizConVacio(){
		for(int posicionY=1;posicionY<tamanioMatriz-2;posicionY++){
			for(int posicionX=1;posicionX<tamanioMatriz-2;posicionX++){
			matrizNivel[posicionX][posicionY] = new Vacio(posicionX,posicionY);
			}
		}
	}
	
	public void setUp(){
		nivel=Nivel.getInstance();
		tamanioMatriz=20;
		cantidadPooglins=5;
		pooglins=new Personaje[cantidadPooglins];
		pooglins[0]=new Pooglin(5,5);
		pooglins[1]=new Pooglin(7,5);
		pooglins[2]=new Pooglin(5,6);
		pooglins[3]=new Pooglin(6,6);
		pooglins[4]=new Pooglin(7,6);
		nivel.setCantidadPooglins(cantidadPooglins);
		nivel.setPooglins(pooglins);
		matrizNivel=new Terreno[tamanioMatriz][tamanioMatriz];
		llenarMatrizConVacio();
		agujeroNegro=new AgujeroNegro(6,5);
		matrizNivel[6][5]=agujeroNegro;
		nivel.setMatrizNivel(matrizNivel);
		
		
	}
	public void testAccionarTerreno(){
		Pooglin pooglin=new Pooglin(5,5);
		agujeroNegro.accionarTerreno(pooglin);
		Personaje[] pooglins=nivel.getPooglins();
		for (int i=0;i<pooglins.length;i++){
			int posicionX=((Pooglin)pooglins[i]).getPosicionX();
			int posicionY=((Pooglin)pooglins[i]).getPosicionY();
			assertEquals(6,posicionX);
			assertEquals(5,posicionY);
			assertTrue(((Pooglin)pooglins[i]).estaVivo());
		}
	}
}