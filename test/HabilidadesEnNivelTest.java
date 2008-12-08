import modelo.Nivel;
import modelo.Personaje;
import modelo.Platillo;
import modelo.Pooglin;
import modelo.Puerta;
import modelo.Roca;
import modelo.Taladro;
import modelo.Terreno;
import modelo.Tierra;
import modelo.Vacio;
import junit.framework.TestCase;

public class HabilidadesEnNivelTest extends TestCase {
	//private int tamanioMatriz=50;
	private Terreno[][] matrizNivel;
	private Nivel nivel;
	Personaje []pooglins;
	int altoDeMatriz = 14;
	int anchoDeMatriz = 22;

	private void bordeMatriz(){
	for(int fila=0;fila<anchoDeMatriz;fila++){
		for(int columna=0;columna<altoDeMatriz;columna++){
		    if((fila==0)||(columna==0)||(columna==altoDeMatriz-1)||(fila==anchoDeMatriz-1)) {	
		    	matrizNivel[fila][columna] = new Roca(fila,columna);	
		    }
		}
	}
	}

	private void llenarMatrizConVacio(){
			
		for(int fila=0;fila<anchoDeMatriz;fila++){
			for(int columna=0;columna<altoDeMatriz;columna++){
				matrizNivel[fila][columna] = new Vacio(fila,columna);
			}
		}
	}
	
	protected void setUp(){
		matrizNivel = new Terreno[anchoDeMatriz][altoDeMatriz]; 
		this.llenarMatrizConVacio();
		this.bordeMatriz();
		nivel = Nivel.getInstance();//new Nivel();
		for(int i=1;i<anchoDeMatriz-2;i++) matrizNivel[i][2] = new Tierra(i,2);
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
		for(int i=2;i<anchoDeMatriz-2;i++) matrizNivel[i][2] = new Vacio(i,2);
		nivel.setMatrizNivel(matrizNivel);
	
		for(int j=0; j<cantidadDeMovimientos;j++){			
		    for(int i =0; i<cantidadDePooglin;i++){
				int posicionX = ((Pooglin)pooglins[i]).getPosicionX();
				int posicionY = ((Pooglin)pooglins[i]).getPosicionY();
				Terreno terrenoActual = nivel.revisarNivel(pooglins[i]);
				//Terreno terrenoActual = nivel.revisarNivel(posicionX,posicionY,pooglins[i]);
				//((Pooglin)pooglins[i]).usarHabilidad();
				pooglins[i].vivir();
				terrenoActual.accionarTerreno(pooglins[i]);
			}
		}
		
		cantidadDeMovimientos = 18;
		((Pooglin)pooglins[0]).setHabilidad(new Platillo());
		for(int j =0; j<cantidadDeMovimientos;j++){			
		    for(int i =0; i<cantidadDePooglin;i++){
				int posicionX = ((Pooglin)pooglins[i]).getPosicionX();
				int posicionY = ((Pooglin)pooglins[i]).getPosicionY();
				if(((Pooglin)pooglins[i]).estaVivo()){
				Terreno terrenoActual = nivel.revisarNivel(pooglins[i]);
				//Terreno terrenoActual = nivel.revisarNivel(posicionX,posicionY,pooglins[i]);
				//((Pooglin)pooglins[i]).usarHabilidad(terrenoActual);
				((Pooglin)pooglins[0]).usarHabilidad();
				pooglins[i].vivir();
				terrenoActual.accionarTerreno(pooglins[i]);
				}
		    }
		}
		assertTrue (((Pooglin)pooglins[0]).estaVivo());
		//assertNull(((Pooglin)pooglins[1]).estaVivo());
		
		int posicionY = ((Pooglin)pooglins[0]).getPosicionY();
		assertEquals(3,posicionY);
		int posicionX = ((Pooglin)pooglins[0]).getPosicionX();
		assertEquals(2,posicionX);
		
	}
/*	public void testCaidaConPlatillo(){
		int cantidadDePooglin = 2;
		int cantidadDeMovimientos = 6;
		
		pooglins = new Pooglin[cantidadDePooglin];
		for(int i =0; i<cantidadDePooglin;i++)pooglins[i]=new Pooglin((nivel.getPuertaComienzo()).getPosicionX(),(nivel.getPuertaComienzo()).getPosicionY());
		nivel.setPooglins(pooglins);
		nivel.setCantidadPooglins(cantidadDePooglin);
		nivel.setPooglinsARescatar(cantidadDePooglin);
		//modifico la matriz asi cae el pooglin.
		for(int i=2;i<anchoDeMatriz-2;i++) matrizNivel[i][2] = new Vacio(i,2);
		nivel.setMatrizNivel(matrizNivel);
	
		for(int j=0; j<cantidadDeMovimientos;j++){			
		    for(int i =0; i<cantidadDePooglin;i++){
				int posicionX = ((Pooglin)pooglins[i]).getPosicionX();
				int posicionY = ((Pooglin)pooglins[i]).getPosicionY();
				Terreno terrenoActual = nivel.revisarNivel(posicionX,posicionY,pooglins[i]);
				//((Pooglin)pooglins[i]).usarHabilidad();
				pooglins[i].vivir();
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
				pooglins[i].vivir();
				terrenoActual.accionarTerreno(pooglins[i]);
			}
		}
		assertTrue (((Pooglin)pooglins[0]).estaVivo());
		//assertNull(((Pooglin)pooglins[1]).estaVivo());
		
		int posicionY = ((Pooglin)pooglins[0]).getPosicionY();
		assertEquals(3,posicionY);
		int posicionX = ((Pooglin)pooglins[0]).getPosicionX();
		assertEquals(2,posicionX);
		
	}*/
	
	public void testCaidaSinPlatillo(){
		int cantidadDePooglin = 2;
		int cantidadDeMovimientos = 42;
		
		pooglins = new Pooglin[cantidadDePooglin];
		for(int i =0; i<cantidadDePooglin;i++)pooglins[i]=new Pooglin((nivel.getPuertaComienzo()).getPosicionX(),(nivel.getPuertaComienzo()).getPosicionY());
		nivel.setPooglins(pooglins);
		nivel.setCantidadPooglins(cantidadDePooglin);
		nivel.setPooglinsARescatar(cantidadDePooglin);
		//modifico la matriz asi cae el pooglin.
		for(int i=1;i<anchoDeMatriz-2;i++) matrizNivel[i][2] = new Vacio(i,2);
		nivel.setMatrizNivel(matrizNivel);
	
		for(int j=0; j<cantidadDeMovimientos;j++){			
		    for(int i =0; i<cantidadDePooglin;i++){
				int posicionX = ((Pooglin)pooglins[i]).getPosicionX();
				int posicionY = ((Pooglin)pooglins[i]).getPosicionY();
				if(((Pooglin)pooglins[i]).estaVivo()){
					//Terreno terrenoActual = nivel.revisarNivel(posicionX,posicionY,pooglins[i]);
					Terreno terrenoActual = nivel.revisarNivel(pooglins[i]);
					
					//((Pooglin)pooglins[i]).usarHabilidad();
					pooglins[i].vivir();
					terrenoActual.accionarTerreno(pooglins[i]);
					}
				}
		}
			
		for(int i=0; i<cantidadDePooglin;i++){
			((Pooglin)pooglins[i]).usarHabilidad();
			assertFalse(((Pooglin)pooglins[i]).estaVivo());
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
				//Terreno terrenoActual = nivel.revisarNivel(posicionX,posicionY,pooglins[i]);
				Terreno terrenoActual = nivel.revisarNivel(pooglins[i]);
				
				//((Pooglin)pooglins[i]).usarHabilidad(terrenoActual);
				pooglins[i].vivir();
				terrenoActual.accionarTerreno(pooglins[i]);
			}
		}
	
		int posicionX = ((Pooglin)pooglins[0]).getPosicionX();
		assertEquals(3,posicionX);
		int posicionY = ((Pooglin)pooglins[0]).getPosicionY();
		assertEquals(1,posicionY);
		
		
		
		for(int j =0; j<cantidadDeMovimientos;j++){			
		    for(int i =0; i<cantidadDePooglin;i++){
				posicionX = ((Pooglin)pooglins[i]).getPosicionX();
				posicionY = ((Pooglin)pooglins[i]).getPosicionY();
				Terreno terrenoActual = nivel.revisarNivel(pooglins[i]);
				
				((Pooglin)pooglins[0]).setHabilidad(new Taladro());
				
				//Terreno terrenoActual = nivel.revisarNivel(posicionX,posicionY,pooglins[i]);
				//((Pooglin)pooglins[i]).usarHabilidad(terrenoActual);
				((Pooglin)pooglins[0]).usarHabilidad(terrenoActual,(Pooglin)pooglins[0]);
				pooglins[i].vivir();
				terrenoActual.accionarTerreno(pooglins[0]);
			}
		}
		
		posicionY = ((Pooglin)pooglins[0]).getPosicionY();
		assertEquals(3,posicionY);
		posicionX = ((Pooglin)pooglins[0]).getPosicionX();
		assertEquals(3,posicionX);
	
	}
	
	public void testCongelarPooglin(){
	}

	public void testMatarPooglin(){
	
	}
	
	
	

}
