package src;

import controlador.MouseAdaptador;
import vista.Ventana;
import vista.VentanaPrincipal;
import vista.VistaPooglin;
import vista.VistaPuerta;
import vista.VistaRoca;
import vista.VistaTierra;
import vista.VistaVacio;
import modelo.ControladorJuego;
import modelo.Habilidad;
import modelo.Nivel;
import modelo.Platillo;
import modelo.Pooglin;
import modelo.Puerta;
import modelo.Roca;
import modelo.Terreno;
import modelo.Tierra;
import modelo.Vacio;



public class CreadorDeEscenarios {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int anchoDeVentana = 985;
		int altoDeVentana = 700;
		int cantidadDePooglin = 5;
		int pooglinsARescatar = 5;
		int contador = 0;
		int altoDeMatriz = 14;
		int anchoDeMatriz = 22;
		Pooglin pooglins[] = new Pooglin[cantidadDePooglin];
		Terreno[][] matrizNivel;
		Habilidad[] habilidadesDisponibles;
		MouseAdaptador oyente = new MouseAdaptador();
	
		//Instancio Nivel.-
		Nivel nivel = Nivel.getInstance();
		
		//Instancio Pooglins.-
		for (int i =0; i< cantidadDePooglin; i++){
			pooglins[i] = new Pooglin(1,1);
			pooglins[i].setHabilidad(new Platillo());
		}
		
		//Instancio Puertas.-
		Puerta puertaComienzo= new Puerta(1,1);
		Puerta puertaSalida = new Puerta(18,12);
		
		//Instancio Habilidades.-
		habilidadesDisponibles = new Habilidad[5];//Nuevo.-
		for( int i = 0 ; i < 5 ; i++ )habilidadesDisponibles[i] = new Platillo(); //Nuevo.-
		
		//Luego instancio los objetos del framework: 
		//      una ventana y el controlador
		Ventana ventana = new VentanaPrincipal(anchoDeVentana,altoDeVentana);
		ControladorJuego controlador = new ControladorJuego();
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);
		
		//Instancio la matriz.-
		matrizNivel = new Terreno[anchoDeMatriz][altoDeMatriz];
		
		//Instancio cada bloque de la matriz.-
		for(int fila=0;fila<anchoDeMatriz;fila++){
			for(int columna=0;columna<altoDeMatriz;columna++){
				matrizNivel[fila][columna] = new Vacio(fila,columna);
				VistaVacio v = new VistaVacio();
				v.setPosicionable(matrizNivel[fila][columna]);
				controlador.agregarDibujable(v);
			}
		}
		for(int fila=0;fila<anchoDeMatriz;fila++){
			for(int columna=0;columna<altoDeMatriz;columna++){
			    if((fila==0)||(columna==0)||(columna==altoDeMatriz-1)||(fila==anchoDeMatriz-1)) {	
			    	matrizNivel[fila][columna] = new Roca(fila,columna);	
			    	VistaRoca r = new VistaRoca();
			    	r.setPosicionable(matrizNivel[fila][columna]);
			    	controlador.agregarDibujable(r);
			    }
			}
		}
		for(int fila=1;fila<11;fila++){
			if(fila != 5){
			    matrizNivel[fila][2] = new Tierra(fila,2);
				VistaTierra t = new VistaTierra();
		    	t.setPosicionable(matrizNivel[fila][2]);
		    	controlador.agregarDibujable(t);
			}
		}
		for(int fila=1;fila<21;fila++){
			if(fila != 19){		
				matrizNivel[fila][8] = new Tierra(fila,8);
				VistaTierra t = new VistaTierra();
		    	t.setPosicionable(matrizNivel[fila][8]);
		    	controlador.agregarDibujable(t);	
			}
		}
		for(int fila=1;fila<21;fila++){
			if(fila != 2){		
				matrizNivel[fila][5] = new Roca(fila,5);
				VistaRoca t = new VistaRoca();
				t.setPosicionable(matrizNivel[fila][5]);
				controlador.agregarDibujable(t);	
			}
		}

		//Seteo las variables en nivel.-
		nivel.setCantidadPooglins(cantidadDePooglin);
		nivel.setPooglins(pooglins);
    	nivel.setPuertaComienzo(puertaComienzo);
		nivel.setPuertaSalida(puertaSalida);
		nivel.setMatrizNivel(matrizNivel);
		nivel.setPooglinsARescatar(pooglinsARescatar);
		nivel.setContador(contador);
		nivel.setHabilidadesDisponibles(habilidadesDisponibles);
		
		nivel.guardarXML("PruebaSiete.xml"); //<<<<<<<<< Acá va el nombre del Escenario.-

		//Preparo los controladores de la vista.-
		VistaPuerta vPuerta = new VistaPuerta();
		vPuerta.setPosicionable(puertaComienzo);
    	controlador.agregarDibujable(vPuerta);
    	vPuerta = new VistaPuerta();
		vPuerta.setPosicionable(puertaSalida);
    	controlador.agregarDibujable(vPuerta);
		
		//Instancio una imagen para que actúe como vista para el pooglin.-
		for (int i =0; i< cantidadDePooglin; i++){
			VistaPooglin vistaPooglin = new VistaPooglin();
			vistaPooglin.setPosicionable(pooglins[i]);
			controlador.agregarDibujable(vistaPooglin);
			vistaPooglin.addMouseListener(oyente);
		}
		controlador.agregarObjetoVivo(nivel);
		controlador.setIntervaloSimulacion(50);
		controlador.comenzar();
		
	}
}
