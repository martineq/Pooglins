import junit.framework.TestCase;

public class TerrenoEnNivelTest extends TestCase {
	//supongo matriz cuadrada 50
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
	
	protected void setUp(){
		matrizNivel = new Terreno[tamanioMatriz][tamanioMatriz]; 
		this.llenarMatrizConVacio();
		this.bordeMatriz();
		nivel = new Nivel();
		for(int i=1;i<tamanioMatriz-1;i++) matrizNivel[2][i] = new Tierra(2,i);
		nivel.setPuertaComienzo(new Puerta(0,1));
		nivel.setPuertaSalida(new Puerta(1,48));
	}
/* 
    Terreno terrenoActual = revisarNivel(posicionX,posicionY,pooglin);
 	pooglin.mover();
	terrenoActual.accionarTerreno(pooglin);
*/
	public void testNivelConTierra(){
		pooglins = new Pooglin[15];
		nivel.setCantidadPooglins(15);
		nivel.setPooglinsARescatar(15);
		nivel.setMatrizNivel(matrizNivel);
		nivel.manejar();
		assertEquals(0,nivel.getPooglinsARescatar());
	}
	
	public void testNivelConHielo(){
		for(int i=1;i<10;i++) matrizNivel[2][i] = new Hielo(2,i);
		nivel.setMatrizNivel(matrizNivel);
		nivel.manejar();
		//aca tengo que ver la velocidad de los pooglin en determinado 
		//momento
		//edgardo.
	}
	
	public void testNivelConVacio(){
		nivel.setMatrizNivel(matrizNivel);
		// nunca llegan a la puerta de salida.
		nivel.setPuertaSalida(new Puerta(3,48));
		nivel.manejar();
		//aca tengo que ver que este vivo el pooglin dando vueltas. 
		//edgardo.
	
	}
	
	public void testNivelConFuego(){
		matrizNivel[2][30] = new Fuego(2,30);
		nivel.setMatrizNivel(matrizNivel);
		nivel.manejar();
		//aca tengo que ver que el fuego mate al pooglin. 
		//edgardo.
	}
	
	public void testNivelConRoca(){
		matrizNivel[2][30] = new Roca(1,20);
		nivel.setMatrizNivel(matrizNivel);
		nivel.manejar();
		//aca tengo que ver que el pooglin de la vuelta cuando
		//choca con la roca. 
		//edgardo.
	}
	
	public void testManejar() {
	}

	public void testRevisarNivel() {
	}

}
