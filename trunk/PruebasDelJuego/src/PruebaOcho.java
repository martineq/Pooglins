package src;

import java.util.HashMap;

import controlador.MouseAdaptador;
import controlador.MouseParaPooglins;
import vista.Ventana;
import vista.VentanaPrincipal;
import vista.VistaAgujeroNegro;
import vista.VistaFuego;
import vista.VistaHielo;
import vista.VistaPooglin;
import vista.VistaPuerta;
import vista.VistaRoca;
import vista.VistaTierra;
import vista.VistaVacio;
import modelo.AgujeroNegro;
import modelo.ControladorJuego;
import modelo.Fuego;
import modelo.Habilidad;
import modelo.Nivel;
import modelo.Pooglin;
import modelo.Puerta;
import modelo.Roca;
import modelo.Taladro;
import modelo.Terreno;
import modelo.Tierra;
import modelo.Vacio;



public class PruebaOcho {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int anchoDeVentana = 985;
		int altoDeVentana = 700;
		int cantidadDePooglin = 1;
		int altoDeMatriz = 14;
		int anchoDeMatriz = 22;
		Pooglin pooglins[] = new Pooglin[cantidadDePooglin];
		Terreno[][] matrizNivel;
		

		MouseParaPooglins oyente = new MouseParaPooglins(pooglins);
	
		
		// Primero instancio parte de mi modelo
		
		for (int i =0; i< cantidadDePooglin; i++){
			pooglins[i] = new Pooglin(1,1);
		}
		
		//Luego instancio los objetos del framework: 
		//      una ventana y el controlador
		Ventana ventana = new VentanaPrincipal(anchoDeVentana,altoDeVentana);
		ControladorJuego controlador = new ControladorJuego();
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);
		ventana.addMouseListener(oyente);
		
		
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
			    	matrizNivel[fila][columna] = new Roca(fila,columna);	
			    	VistaRoca r = new VistaRoca();
			    	r.setPosicionable(matrizNivel[fila][columna]);
			    	controlador.agregarDibujable(r);
			    }
			}
		}
		for(int fila=1;fila<11;fila++){
			if(fila != 5){
		    matrizNivel[fila][3] = new Tierra(fila,3);
			VistaTierra t = new VistaTierra();
	    	t.setPosicionable(matrizNivel[fila][3]);
	    	controlador.agregarDibujable(t);
			}
		}
		
			
		for(int fila=1;fila<11;fila++){
				matrizNivel[fila][2] = new Tierra(fila,2);
				VistaTierra t = new VistaTierra();
		    	t.setPosicionable(matrizNivel[fila][2]);
		    	controlador.agregarDibujable(t);
					matrizNivel[5][2] = new Fuego(5,2);
					VistaFuego n = new VistaFuego();
				    n.setPosicionable(matrizNivel[5][2]);
				    controlador.agregarDibujable(n);
						
				
		    }

		matrizNivel[10][1] = new Tierra(10,1);
		VistaTierra t1 = new VistaTierra();
    	t1.setPosicionable(matrizNivel[10][1]);
    	controlador.agregarDibujable(t1);

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
				
			matrizNivel[fila][5] = new Tierra(fila,5);
			VistaTierra t = new VistaTierra();
	    	t.setPosicionable(matrizNivel[fila][5]);
	    	controlador.agregarDibujable(t);	
			}
			}

		for(int fila=1;fila<21;fila++){
			if(fila != 19){		
			matrizNivel[fila][9] = new Tierra(fila,9);
			VistaTierra t = new VistaTierra();
	    	t.setPosicionable(matrizNivel[fila][9]);
	    	controlador.agregarDibujable(t);	
			}
			}

		for(int fila=1;fila<21;fila++){
			if(fila != 2){		
				
			matrizNivel[fila][5] = new Tierra(fila,5);
			VistaTierra t = new VistaTierra();
	    	t.setPosicionable(matrizNivel[fila][5]);
	    	controlador.agregarDibujable(t);	
			}
			}


	/*	matrizNivel[1][4] = new Tierra(1,4);
		VistaTierra t = new VistaTierra();
    	t.setPosicionable(matrizNivel[1][4]);
    	controlador.agregarDibujable(t);	
    
    
    	
    	matrizNivel[20][4] = new Tierra(20,4);
		VistaTierra td = new VistaTierra();
    	td.setPosicionable(matrizNivel[20][4]);
    	controlador.agregarDibujable(td);	
*/
		
		Puerta puertaComienzo= new Puerta(1,1);
		Puerta puertaSalida = new Puerta(18,12);
		
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
		
//		Habilidad habilidad[] = new Habilidad[5];
//		for(int j = 0 ; j<habilidad.length;j++){
//			habilidad[j] = new Taladro();
//		}
//		
		//nivel.setHabilidadesDisponibles(habilidad);
		
		HashMap<String,String> habilidades = new HashMap<String,String>();
		habilidades.put("Platillo","2");
		habilidades.put("RayoLaser","2");
		habilidades.put("Taladro","2");
		habilidades.put("Tunel","2");
		habilidades.put("Teletransportarse","2");
		habilidades.put("Congelamiento","2");
		
		nivel.setHabilidadesDisponibles(habilidades);
		
		
		
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
