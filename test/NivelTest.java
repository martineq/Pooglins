import modelo.Fuego;
import modelo.Nivel;
import modelo.Personaje;
import modelo.Pooglin;
import modelo.Puerta;
import modelo.Roca;
import modelo.Terreno;
import modelo.Vacio;
import junit.framework.TestCase;

public class NivelTest extends TestCase{

	private int tamanioMatriz=50;
	private Terreno[][] matrizNivel;
	private Nivel nivel;
	Personaje []pooglins;
	
	private void bordeMatriz(){
		for(int i=0;i<tamanioMatriz-1;i++){
			matrizNivel[0][i] = new Roca(0,i);
			matrizNivel[i][0] = new Roca(i,0);
			matrizNivel[tamanioMatriz-1][i] = new Roca(tamanioMatriz,i);
			matrizNivel[i][tamanioMatriz-1] = new Roca(i,tamanioMatriz);
		}
	}
	
	private void llenarMatrizConVacio(){
	for(int fila=0;fila<tamanioMatriz-1;fila++){
		for(int columna=0;columna<tamanioMatriz-1;columna++){
		matrizNivel[fila][columna] = new Vacio(fila,columna);
			}
		}
	}
	
	@Override
	protected void setUp(){
		matrizNivel = new Terreno[tamanioMatriz][tamanioMatriz]; 
		this.llenarMatrizConVacio();
		this.bordeMatriz();
		nivel = Nivel.getInstance();//new Nivel();
		nivel.setMatrizNivel(matrizNivel);
	}
	
	public void testRevisarNivel() {
		nivel.setPuertaComienzo(new Puerta(0,1));
		nivel.setPuertaSalida(new Puerta(48,1));
		pooglins = new Pooglin[1];
		for(int i =0; i<1;i++)pooglins[i]=new Pooglin((nivel.getPuertaComienzo()).getPosicionX(),(nivel.getPuertaComienzo()).getPosicionY());
		nivel.setPooglins(pooglins);
		nivel.setCantidadPooglins(1);
		nivel.setPooglinsARescatar(1);
	
		//Terreno terreno = nivel.revisarNivel(2, 2, pooglins[0]);
		matrizNivel[0][2] = new Vacio(0,2);
		Terreno terreno = nivel.revisarNivel(pooglins[0]);
		
		if(terreno instanceof Vacio) assertTrue(true);
		else fail("EL terreno no es el que esta en la matriz");
		
		matrizNivel[3][3] = new Fuego(3,3);
		((Pooglin)pooglins[0]).setPosicionX(3);
		((Pooglin)pooglins[0]).setPosicionY(2);
		terreno = nivel.revisarNivel(pooglins[0]);
		//terreno = nivel.revisarNivel(2, 2, pooglins[0]);
		if(terreno instanceof Fuego) assertTrue(true);
		else fail("EL terreno no es el que esta en la matriz");
		
		
	}
		
}
