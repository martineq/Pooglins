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
		int cantidadDePooglin = 2;
		int cantidadDeMovimientos = 6;
		
		pooglins = new Pooglin[cantidadDePooglin];
		for(int i =0; i<cantidadDePooglin;i++)pooglins[i]=new Pooglin((nivel.getPuertaComienzo()).getPosicionX(),(nivel.getPuertaComienzo()).getPosicionY());
		nivel.setPooglins(pooglins);
		nivel.setCantidadPooglins(cantidadDePooglin);
		nivel.setPooglinsARescatar(cantidadDePooglin);
		//modifico la matriz asi cae el pooglin.
		for(int i=2;i<tamanioMatriz-2;i++) matrizNivel[i][2] = new Vacio(i,2);
		nivel.setMatrizNivel(matrizNivel);
	
		for(int j=0; j<cantidadDeMovimientos;j++){			
		    for(int i =0; i<cantidadDePooglin;i++){
				int posicionX = ((Pooglin)pooglins[i]).getPosicionX();
				int posicionY = ((Pooglin)pooglins[i]).getPosicionY();
				Terreno terrenoActual = nivel.revisarNivel(posicionX,posicionY,pooglins[i]);
				//((Pooglin)pooglins[i]).usarHabilidad();
				pooglins[i].mover();
				terrenoActual.accionarTerreno(pooglins[i]);
			}
		}
		cantidadDeMovimientos = 42;
		((Pooglin)pooglins[0]).setHabilidad(new Platillo());
		for(int j =0; j<cantidadDeMovimientos;j++){			
		    for(int i =0; i<cantidadDePooglin;i++){
				int posicionX = ((Pooglin)pooglins[i]).getPosicionX();
				int posicionY = ((Pooglin)pooglins[i]).getPosicionY();
				Terreno terrenoActual = nivel.revisarNivel(posicionX,posicionY,pooglins[i]);
				//((Pooglin)pooglins[i]).usarHabilidad(terrenoActual);
				((Pooglin)pooglins[0]).usarHabilidad();
				pooglins[i].mover();
				terrenoActual.accionarTerreno(pooglins[i]);
			}
		}
		assertTrue (((Pooglin)pooglins[0]).estaVivo());
		//assertNull(((Pooglin)pooglins[1]).estaVivo());
		
		int posicionY = ((Pooglin)pooglins[0]).getPosicionY();
		assertEquals(3,posicionY);
		int posicionX = ((Pooglin)pooglins[0]).getPosicionX();
		assertEquals(2,posicionX);
		
	}
	
	public void testCaidaSinPlatillo(){
		int cantidadDePooglin = 2;
		int cantidadDeMovimientos = 42;
		
		pooglins = new Pooglin[cantidadDePooglin];
		for(int i =0; i<cantidadDePooglin;i++)pooglins[i]=new Pooglin((nivel.getPuertaComienzo()).getPosicionX(),(nivel.getPuertaComienzo()).getPosicionY());
		nivel.setPooglins(pooglins);
		nivel.setCantidadPooglins(cantidadDePooglin);
		nivel.setPooglinsARescatar(cantidadDePooglin);
		//modifico la matriz asi cae el pooglin.
		for(int i=1;i<tamanioMatriz-2;i++) matrizNivel[i][2] = new Vacio(i,2);
		nivel.setMatrizNivel(matrizNivel);
	
		for(int j=0; j<cantidadDeMovimientos;j++){			
		    for(int i =0; i<cantidadDePooglin;i++){
				int posicionX = ((Pooglin)pooglins[i]).getPosicionX();
				int posicionY = ((Pooglin)pooglins[i]).getPosicionY();
				Terreno terrenoActual = nivel.revisarNivel(posicionX,posicionY,pooglins[i]);
				//((Pooglin)pooglins[i]).usarHabilidad();
				pooglins[i].mover();
				terrenoActual.accionarTerreno(pooglins[i]);
			}
		}
			
		for(int i=0; i<cantidadDePooglin;i++){
		assertNull(((Pooglin)pooglins[i]).estaVivo());
		}
		
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
