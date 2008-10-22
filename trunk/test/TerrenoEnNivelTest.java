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
		
	}
/* 
    Terreno terrenoActual = revisarNivel(posicionX,posicionY,pooglin);
 	pooglin.mover();
	terrenoActual.accionarTerreno(pooglin);
*/
	public void testNivelConTierra(){
		for(int i=1;i<tamanioMatriz-1;i++) matrizNivel[i][2] = new Tierra(i,2);
		nivel.setPuertaComienzo(new Puerta(0,1));
		nivel.setPuertaSalida(new Puerta(48,1));
		pooglins = new Pooglin[15];
		for(int i =0; i<15;i++)pooglins[i]=new Pooglin((nivel.getPuertaComienzo()).getPosicionX(),(nivel.getPuertaComienzo()).getPosicionY());
		nivel.setPooglins(pooglins);
		nivel.setCantidadPooglins(15);
		nivel.setPooglinsARescatar(15);
		nivel.setMatrizNivel(matrizNivel);
		nivel.manejar();
		assertEquals(0,nivel.getPooglinsARescatar());
	}
	
	public void testNivelConHielo(){
		for(int i=1;i<tamanioMatriz-1;i++) matrizNivel[i][4] = new Hielo(i,4);
		nivel.setMatrizNivel(matrizNivel);
		nivel.setPuertaComienzo(new Puerta(5,3));
		nivel.setPuertaSalida(new Puerta(25,3));
		pooglins = new Pooglin[25];
		for(int i =0; i<25;i++)pooglins[i]=new Pooglin((nivel.getPuertaComienzo()).getPosicionX(),(nivel.getPuertaComienzo()).getPosicionY());
		nivel.setPooglins(pooglins);
		nivel.setCantidadPooglins(25);
		nivel.setPooglinsARescatar(15);
		nivel.manejar();
		assertEquals(-10,nivel.getPooglinsARescatar());//Porque llegan todos los pooglins, es decir rescate 25
		assertEquals(0,nivel.getCantidadPooglins());
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
		for(int i=1;i<tamanioMatriz-1;i++) matrizNivel[i][40] = new Hielo(i,40);
		nivel.setMatrizNivel(matrizNivel);
		nivel.setPuertaComienzo(new Puerta(1,39));
		nivel.setPuertaSalida(new Puerta(15,39));
		matrizNivel[10][40] = new Fuego(10,40);
		nivel.setMatrizNivel(matrizNivel);
		pooglins = new Pooglin[25];
		for(int i =0; i<25;i++)pooglins[i]=new Pooglin((nivel.getPuertaComienzo()).getPosicionX(),(nivel.getPuertaComienzo()).getPosicionY());
		nivel.setPooglins(pooglins);
		nivel.setCantidadPooglins(25);
		nivel.setPooglinsARescatar(15);
		nivel.manejar();
		assertEquals(0,nivel.getCantidadPooglins());
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
