package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import modelo.AgujeroNegro;
import modelo.ControladorJuego;
import modelo.Fuego;
import modelo.Hielo;
import modelo.Roca;
import modelo.Terreno;
import modelo.Tierra;
import modelo.Vacio;
import vista.VistaAgujeroNegro;
import vista.VistaFuego;
import vista.VistaHielo;
import vista.VistaRoca;
import vista.VistaTierra;
import vista.VistaVacio;

/**Clase que se usa para crear el terreno deseado.-
 * @author Mart
 *
 */
public class EditorDeMatriz {

	public EditorDeMatriz(){
		
	}
	/**M�todo que carga toda una matriz con el tipo de Terreno a elecci�n
	 * del usuario.-
	 * @param matrizNivel
	 * @param anchoDeMatriz
	 * @param altoDeMatriz
	 * @param controlador
	 * @return Terreno[][]
	 */
	public static Terreno[][] editar(Terreno[][] matrizNivel,int anchoDeMatriz, int altoDeMatriz, ControladorJuego controlador){
		//Instancio cada bloque de la matriz:
		
		System.out.println( "Creaci�n del terreno:\nAncho del terreno: " + ( anchoDeMatriz - 2 ) + "\nAlto del terreno: " + ( altoDeMatriz - 2 ) );
		
		//Lleno todo de vac�os.-
		for(int fila=0;fila<anchoDeMatriz;fila++){
			for(int columna=0;columna<altoDeMatriz;columna++){
				matrizNivel[fila][columna] = new Vacio(fila,columna);
				VistaVacio v = new VistaVacio();
				v.setPosicionable(matrizNivel[fila][columna]);
				controlador.agregarDibujable(v);
			}
		}
		
		System.out.println("Se llen� toda la matriz con Vacio.-");
		
		//Lleno los bordes con Roca.-
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
		
		System.out.println("Se llen� todo el contorno con Roca.-");
		
		//Instancio cada bloque de la matriz pero a elecci�n.-
		System.out.println("Llenado de la matriz por coordenada (Se va llenando horizontalmente): ");
		System.out.println("Ingrese un numero seg�n el terreno:");
		System.out.println("0)Vacio\n1)Roca\n2)Tierra\n3)Hielo\n4)Fuego\n5)AgujeroNegro\n6)L�nea autom�tica\n(Presione enter sin ninguna opcion, para repetir el �timo terreno elegido)\n");
		boolean linea = false;
		int opcion = 0;
		for ( int columna = 1 ; columna < altoDeMatriz - 1 ; columna++  ){
			for ( int fila = 1 ; fila < anchoDeMatriz - 1 ; fila++ ){
				System.out.println("Coordenadas: X = "+ fila + " Y = " + columna );
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
				try {
				      if ( !linea ){
				    	  try {
				    	  opcion = Integer.parseInt(br.readLine());
				    	  } catch (NumberFormatException ex) {
						      System.out.println("Idem");
						    }
				    	  System.out.println("leyo:"+opcion);
				      }
				      else System.out.println("L�nea autom�tica...");
				      if ( opcion == 6 ){
				    	  linea = true;
				    	  System.out.println("L�nea autom�tica de... (ingresar el N� correspondiente al terreno):");
				    	  opcion = Integer.parseInt(br.readLine());
				      }   
				      System.out.println("op:"+opcion);
				      if (opcion == 0 ){
						    System.out.println("Eligi� Vacio");
							matrizNivel[fila][columna] = new Vacio(fila,columna);
							VistaVacio v = new VistaVacio();
							v.setPosicionable(matrizNivel[fila][columna]);
							controlador.agregarDibujable(v);
						}
				      if (opcion == 1 ){
							System.out.println("Eligi� Roca");
							matrizNivel[fila][columna] = new Roca(fila,columna);
							VistaRoca v = new VistaRoca();
							v.setPosicionable(matrizNivel[fila][columna]);
							controlador.agregarDibujable(v);
						}
						if (opcion == 2 ){
							System.out.println("Eligi� Tierra");
							matrizNivel[fila][columna] = new Tierra(fila,columna);
							VistaTierra v = new VistaTierra();
							v.setPosicionable(matrizNivel[fila][columna]);
							controlador.agregarDibujable(v);
						}
						if (opcion == 3 ){
							System.out.println("Eligi� Hielo");
							matrizNivel[fila][columna] = new Hielo(fila,columna);
							VistaHielo v = new VistaHielo();
							v.setPosicionable(matrizNivel[fila][columna]);
							controlador.agregarDibujable(v);
						}
						if (opcion == 4 ){
							System.out.println("Eligi� Fuego");
							matrizNivel[fila][columna] = new Fuego(fila,columna);
							VistaFuego v = new VistaFuego();
							v.setPosicionable(matrizNivel[fila][columna]);
							controlador.agregarDibujable(v);
						}
						if (opcion == 5 ){
							System.out.println("Eligi� AgujeroNegro");
							matrizNivel[fila][columna] = new AgujeroNegro(fila,columna);
							VistaAgujeroNegro v = new VistaAgujeroNegro();
							v.setPosicionable(matrizNivel[fila][columna]);
							controlador.agregarDibujable(v);
						}
						if( fila == (anchoDeMatriz - 2) ) linea = false;
				    }
				    catch (IOException ex) {
				      System.out.println("Error de entrada:");
				      System.out.println(ex);
				    }
			}
		}
		System.out.println("Lista la matriz !!!");
		return matrizNivel;	
	}
}
