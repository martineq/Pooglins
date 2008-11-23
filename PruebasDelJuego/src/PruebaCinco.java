package src;

import vista.Ventana;
import vista.VentanaPrincipal;
import vista.VistaPooglin;
import vista.VistaPuerta;
import vista.VistaRoca;
import vista.VistaTierra;
import vista.VistaVacio;
import modelo.ControladorJuego;
import modelo.Nivel;
import modelo.Pooglin;
import modelo.Puerta;
import modelo.Terreno;
import modelo.Tierra;
import modelo.Vacio;



public class PruebaCinco {
	public static void main(String[] args) {
		int anchoDeVentana = 985;
		int altoDeVentana = 700;
		int cantidadDePooglin = 1;
		int altoDeMatriz = 14;
		int anchoDeMatriz = 22;
		Pooglin pooglins[] = new Pooglin[cantidadDePooglin];
		Terreno[][] matrizNivel;

		
		// Primero instancio parte de mi modelo
		
		for (int i =0; i< cantidadDePooglin; i++){
			pooglins[i] = new Pooglin(2,1);
		}
		
		//Luego instancio los objetos del framework: 
		//      una ventana y el controlador
		Ventana ventana = new VentanaPrincipal(anchoDeVentana,altoDeVentana);
		ControladorJuego controlador = new ControladorJuego();
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);
		
		// Pido una instancia de nivel para setear la matriz.
		Nivel nivel = Nivel.getInstance();
		nivel.setCantidadPooglins(cantidadDePooglin);
		nivel.setPooglins(pooglins);
		//*********************************************************
		//*---------- Comienzo a rellenar la matriz --------------*
		//*********************************************************
		matrizNivel = new Terreno[anchoDeMatriz][altoDeMatriz];

		// Primero la relleno toda con vacio..
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
				else{
				    matrizNivel[fila][1] = new Tierra(fila,1);
					VistaRoca p = new VistaRoca();
			    	p.setPosicionable(matrizNivel[fila][1]);
			    	controlador.agregarDibujable(p);
				}
		    }
		

		
		
		Puerta puertaComienzo= new Puerta(1,1);
		Puerta puertaSalida = new Puerta(10,1);
		
		VistaPuerta vPuerta = new VistaPuerta();
		vPuerta.setPosicionable(puertaComienzo);
    	controlador.agregarDibujable(vPuerta);
		
    	vPuerta = new VistaPuerta();
		vPuerta.setPosicionable(puertaSalida);
    	controlador.agregarDibujable(vPuerta);
		
    	nivel.setPuertaComienzo(puertaComienzo);
		nivel.setPuertaSalida(puertaSalida);
//		for(int fila=0;fila<anchoDeMatriz;fila++){
//			for(int columna=0;columna<altoDeMatriz;columna++){
//			estos For recorren toda la matriz
//			}
//		}

		nivel.setMatrizNivel(matrizNivel);
		
		//--Prueba--

		//--Prueba--
		
		
		//*********************************************************
		//*---------- Termine de rellenar la matriz --------------*
		//*********************************************************
		
		// instancio una vista para mi tablero. 	
		//VistaTablero vistaTablero = new VistaTablero();
		//vistaTablero.setPosicionable(nivel);
			
		//Instancio una imagen para que actue como vista para el pooglin
		
		for (int i =0; i< cantidadDePooglin; i++){
			VistaPooglin vistaPooglin = new VistaPooglin();
			vistaPooglin.setPosicionable(pooglins[i]);
			//controlador.agregarObjetoVivo(pooglins[i]);
			controlador.agregarDibujable(vistaPooglin);
		}
	
		controlador.agregarObjetoVivo(nivel);
		controlador.setIntervaloSimulacion(100);
		controlador.comenzar();

	}

}
