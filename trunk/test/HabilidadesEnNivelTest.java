/*import junit.framework.TestCase;
/* 
    Terreno terrenoActual = revisarNivel(posicionX,posicionY,pooglin);
 	pooglin.mover();
	terrenoActual.accionarTerreno(pooglin);

	public void testNivelConTierra(){
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
*/
import junit.framework.TestCase;


public class HabilidadesEnNivelTest extends TestCase {
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
		for(int posicionY=1;posicionY<tamanioMatriz-2;posicionY++){
			for(int posicionX=1;posicionX<tamanioMatriz-2;posicionX++){
			matrizNivel[posicionY][posicionX] = new Vacio(posicionX,posicionY);
			}
		}
	}
	
	protected void setUp(){
		matrizNivel = new Terreno[tamanioMatriz][tamanioMatriz]; 
		this.llenarMatrizConVacio();
		this.bordeMatriz();
		nivel = new Nivel();
		for(int i=1;i<tamanioMatriz-2;i++) matrizNivel[i][2] = new Tierra(i,2);
		nivel.setPuertaComienzo(new Puerta(1,1));
		nivel.setPuertaSalida(new Puerta(48,1));
	}
	
	public void testCaidaConPlatillo(){
		
		
	}
	
	public void testCaidaSinPlatillo(){
	}

	public void testTaladro(){
		int cantidadDePooglin = 1;
		int cantidadDeMovimientos = 12;
		
		pooglins = new Pooglin[cantidadDePooglin];
		for(int i =0; i<cantidadDePooglin;i++)pooglins[i]=new Pooglin((nivel.getPuertaComienzo()).getPosicionX(),(nivel.getPuertaComienzo()).getPosicionY());
		nivel.setPooglins(pooglins);
		nivel.setCantidadPooglins(cantidadDePooglin);
		nivel.setPooglinsARescatar(cantidadDePooglin);
		nivel.setMatrizNivel(matrizNivel);
	
		for(int j =0; j<cantidadDeMovimientos;j++){			
		    for(int i =0; i<cantidadDePooglin;i++){
				int posicionX = ((Pooglin)pooglins[i]).getPosicionX();
				int posicionY = ((Pooglin)pooglins[i]).getPosicionY();
				Terreno terrenoActual = nivel.revisarNivel(posicionX,posicionY,pooglins[i]);
				//((Pooglin)pooglins[i]).usarHabilidad(terrenoActual);
				pooglins[i].mover();
				terrenoActual.accionarTerreno(pooglins[i]);
			}
		}
	
		//int posicionX = ((Pooglin)pooglins[0]).getPosicionX();
		//assertEquals(3,posicionX);
		
		((Pooglin)pooglins[0]).setHabilidad(new Taladro());
		for(int j =0; j<cantidadDeMovimientos;j++){			
		    for(int i =0; i<cantidadDePooglin;i++){
				int posicionX = ((Pooglin)pooglins[i]).getPosicionX();
				int posicionY = ((Pooglin)pooglins[i]).getPosicionY();
				Terreno terrenoActual = nivel.revisarNivel(posicionX,posicionY,pooglins[i]);
				//((Pooglin)pooglins[i]).usarHabilidad(terrenoActual);
				((Pooglin)pooglins[0]).usarHabilidad(terrenoActual);
				pooglins[i].mover();
				terrenoActual.accionarTerreno(pooglins[i]);
			}
		}
		
		int posicionY = ((Pooglin)pooglins[0]).getPosicionY();
		assertEquals(3,posicionY);
		
		int posicionX = ((Pooglin)pooglins[0]).getPosicionX();
		assertEquals(3,posicionX);
	
	}
	
	public void testCongelarPooglin(){
			}

	public void testMatarPooglin(){
	
	}
	
	
	

}
