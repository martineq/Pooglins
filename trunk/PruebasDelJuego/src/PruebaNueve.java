package src;

import java.util.HashMap;

import controlador.MouseParaPooglins;
import vista.Imagen;
import vista.Ventana;
import vista.VentanaPrincipal;
import vista.VistaFuego;
import vista.VistaHielo;
import vista.VistaPooglin;
import vista.VistaPuerta;
import vista.VistaRoca;

import vista.VistaTierra;
import vista.VistaVacio;
import modelo.ControladorJuego;
import modelo.Nivel;
import modelo.Pooglin;
import modelo.Puerta;
import modelo.Roca;
import modelo.Terreno;
import modelo.Tierra;
import modelo.Vacio;

public class PruebaNueve {
	
	private static void llenarBordeConRoca(Terreno[][] matrizNivel) {
		int altoDeMatriz = 14;
		int anchoDeMatriz = 22;
		
		for(int fila=0;fila<anchoDeMatriz;fila++){
			for(int columna=0;columna<altoDeMatriz;columna++){
			    if((fila==0)||(columna==0)||(columna==altoDeMatriz-1)||(fila==anchoDeMatriz-1)) {	
			    	matrizNivel[fila][columna] = new Roca(fila,columna);	
			    }
			}
		}
	}
	
	private static void llenarMatrizConVacio(Terreno[][] matrizNivel) {
		int altoDeMatriz = 14;
		int anchoDeMatriz = 22;
		for(int fila=0;fila<anchoDeMatriz;fila++){
			for(int columna=0;columna<altoDeMatriz;columna++){
				matrizNivel[fila][columna] = new Vacio(fila,columna);
			}
		}
	}
	
	private static void llenarLineaDeTierraConVacioEn(Terreno[][] matrizNivel,int numeroDeLinea,int PosicionDelVacio) {
			for(int columna=1;columna<21;columna++){
			if(columna != PosicionDelVacio){
		    matrizNivel[columna][numeroDeLinea] = new Tierra(columna,numeroDeLinea);
			}
		}
	}
	
	public static void agregarMatrizNivelConTerreno(Nivel nivel){
	
	int altoDeMatriz = 14;
		int anchoDeMatriz = 22;
		Terreno[][] matrizNivel;
		matrizNivel = new Terreno[anchoDeMatriz][altoDeMatriz];
	    		
		llenarMatrizConVacio(matrizNivel);	
		llenarBordeConRoca(matrizNivel);
		//este metodo llena toda una linea con tierra,
		//el segundo argumento es el numero de la linea a llenar 
		//el tercero es la posicion del Vacio
		//llenarLineaDeTierraConVacioEn(matrizNivel,numeroDeLinea,PosicionDelVacio);
		//llenarLineaDeTierraConVacioEn(matrizNivel);
		//si posicion del vacio=0 no hay aguero en la linea
//		llenarLineaDeTierraConVacioEn(matrizNivel,2,7);
//		llenarLineaDeTierraConVacioEn(matrizNivel,4,9);
//		llenarLineaDeTierraConVacioEn(matrizNivel,6,11);
//		llenarLineaDeTierraConVacioEn(matrizNivel,9,14);
//		llenarLineaDeTierraConVacioEn(matrizNivel,11,18);
		//llenarLineaDeTierraConVacioEn(matrizNivel,2,0);
		llenarLineaDeTierraConVacioEn(matrizNivel,3,0);
		llenarLineaDeTierraConVacioEn(matrizNivel,4,0);
		llenarLineaDeTierraConVacioEn(matrizNivel,5,0);
		llenarLineaDeTierraConVacioEn(matrizNivel,6,0);
		
//		llenarLineaDeTierraConVacioEn(matrizNivel,7,0);
//		llenarLineaDeTierraConVacioEn(matrizNivel,8,0);
//		
		llenarLineaDeTierraConVacioEn(matrizNivel,9,0);
		llenarLineaDeTierraConVacioEn(matrizNivel,11,0);
		
//		matrizNivel[1][3] = new Tierra(1,3);
//		//matrizNivel[2][3] = new Tierra(2,3);
//		matrizNivel[3][3] = new Tierra(3,3);
//		
//		matrizNivel[4][2] = new Tierra(4,2);
//		matrizNivel[5][2] = new Tierra(5,2);
//		matrizNivel[6][2] = new Tierra(6,2);
////		
//		matrizNivel[7][2] = new Tierra(7,2);
//		matrizNivel[8][2] = new Tierra(8,2);
//		matrizNivel[9][2] = new Tierra(9,2);
//		matrizNivel[10][3] = new Tierra(10,3);
////		
        nivel.setMatrizNivel(matrizNivel);
	}

	public static void agregarDibujosDelTerreno(Nivel nivel, ControladorJuego controlador){
		int altoDeMatriz = 14;
		int anchoDeMatriz = 22;
	
//		Class c = null;
//		try {
//			c = Class.forName("vista.VistaVacio");
//				
//			System.out.println("Se agrego la clase.");
//			} 
//		catch (ClassNotFoundException e) {
//			System.err.println("No se puede encontrar Fuego");
//			//throw e;
//			}
//		
//		try {
//			c.newInstance();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
//		Method metodo = null;
//		
//		try {
//			metodo = c.getMethod("vista.VistaVacio.setPosicionable");
//			metodo = c.getMethods();
//			for(int i=0; i<metodo.length;i++){
//				System.out.println(metodo[i]);
//			}
//			
//			
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} 
//		
		//Nivel nivel = Nivel.getInstance();
		Terreno [][]matrizNivel = nivel.getMatrizNivel();
		//Imagen [][]vistatablero = new Imagen[anchoDeMatriz][altoDeMatriz];
		//String nombre;
		Imagen vista=null;
		
		for(int fila=0;fila<anchoDeMatriz;fila++){
			for(int columna=0;columna<altoDeMatriz;columna++){
				String nombre = matrizNivel[fila][columna].getClass().getName();
				
				System.out.println(nombre+" x:"+columna+" y:"+fila);
				if(nombre.equals("modelo.Tierra")) vista = new VistaTierra();
				if(nombre.equals("modelo.Vacio")) vista = new VistaVacio();
				if(nombre.equals("modelo.Fuego")) vista = new VistaFuego();
				if(nombre.equals("modelo.Hielo")) vista = new VistaHielo();
				if(nombre.equals("modelo.Roca")) vista = new VistaRoca();
			
				vista.setPosicionable(matrizNivel[fila][columna]);
				////vistatablero[fila][columna] = vista;
				controlador.agregarDibujable(vista);
				//matrizNivel[fila][columna] = new Vacio(fila,columna);
				//VistaVacio v = new VistaVacio();
				//c.setPosicionable(matrizNivel[fila][columna]);
				//	controlador.agregarDibujable(v);
			}
		}
		//controlador.setTablero(vistatablero);
		
		
	}
	
	@SuppressWarnings("unchecked")
	public static void agregarHabilidades(Nivel nivel){
		HashMap habilidades=new HashMap();
		habilidades.put("Platillo",2);
		habilidades.put("RayoLaser",5);
		habilidades.put("Taladro",20);
		habilidades.put("Tunel",2);
		habilidades.put("Teletransportarse",2);
		habilidades.put("Congelamiento",2);
		habilidades.put("Morir",2);
		
		nivel.setHabilidadesDisponibles(habilidades);
	}
	
	public static void agregarPooglin(Nivel nivel, ControladorJuego controlador, int cantidadDePooglin){
		Pooglin pooglins[] = new Pooglin[cantidadDePooglin];
		int posicionComienzoX = nivel.getPuertaComienzo().getPosicionX();
		int posicionComienzoY = nivel.getPuertaComienzo().getPosicionY();
		
		for (int i =0; i< cantidadDePooglin; i++){
			pooglins[i] = new Pooglin(posicionComienzoX,posicionComienzoY);
			VistaPooglin vistaPooglin = new VistaPooglin(pooglins[i]);
			//vistaPooglin.setPosicionable(pooglins[i]);
			controlador.agregarDibujable(vistaPooglin);
		}
		
		nivel.setCantidadPooglins(cantidadDePooglin);
		nivel.setPooglins(pooglins);
}
	
	public static void agregarPuertaSalida(Nivel nivel,
			ControladorJuego controlador, int posicionX, int posicionY) {
		 
		Puerta puertaSalida = new Puerta(posicionX,posicionY);
		VistaPuerta vPuerta = new VistaPuerta();
		vPuerta.setPosicionable(puertaSalida);
	    controlador.agregarDibujable(vPuerta);
		nivel.setPuertaSalida(puertaSalida);
			
	}

	public static void agregarPuertaComienzo(Nivel nivel,
			ControladorJuego controlador,  int posicionX, int posicionY) {
		 
		Puerta puertaComienzo= new Puerta(posicionX,posicionY);
    	VistaPuerta vPuerta = new VistaPuerta();
		vPuerta.setPosicionable(puertaComienzo);
    	controlador.agregarDibujable(vPuerta);
        nivel.setPuertaComienzo(puertaComienzo);
	}

	public static void cargarNivel(Nivel nivel, ControladorJuego controlador,
			int cantidadDePooglin) {
		
		agregarMatrizNivelConTerreno(nivel);
		agregarDibujosDelTerreno(nivel,controlador);
		agregarHabilidades(nivel);
		agregarPuertaComienzo(nivel,controlador,1,1);
		agregarPuertaSalida(nivel,controlador,18,12);
		agregarPooglin(nivel, controlador, cantidadDePooglin);
		
	}
	//public void comenzarJuego(){
	public static  void main(String[] args) {
		int anchoDeVentana = 970;
		int altoDeVentana = 700;
		int cantidadDePooglin = 2;
		
		
		//instancio los objetos del framework: 
		//una ventana y el controlador
		ControladorJuego controlador = new ControladorJuego();
		Nivel nivel = Nivel.getInstance();
		cargarNivel(nivel, controlador, cantidadDePooglin);
		
		MouseParaPooglins oyente = new MouseParaPooglins((Pooglin[])nivel.getPooglins());
	
		
		Ventana ventana = new VentanaPrincipal(anchoDeVentana,altoDeVentana);
		controlador.setSuperficieDeDibujo(ventana);
		//termino la creacion de la ventana
		
		ventana.addMouseListener(oyente);
		nivel.setPooglinsARescatar(cantidadDePooglin);
		controlador.agregarObjetoVivo(nivel);
		controlador.setIntervaloSimulacion(350);
		nivel.setDuracionDelJuego(300);
		
		ventana.setVisible(true);
	//	nivel.comenzarTiempo();
		controlador.comenzar();
	}
}
