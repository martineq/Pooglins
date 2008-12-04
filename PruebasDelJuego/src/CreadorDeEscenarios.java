package src;
import java.util.HashMap;
import controlador.MouseParaPooglins;
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
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//Variables de configuración.-
		int altoDeMatriz = 14;
		int anchoDeMatriz = 22;
        int anchoDeVentana = 970;
		int altoDeVentana = 700;
		//Variables para cargar en Nivel.-
		Terreno[][] matrizNivel;
		int cantidadDePooglin = 2;
		Pooglin pooglins[] = new Pooglin[cantidadDePooglin];
		int pooglinsARescatar = 2;
		int contador = 0;
		HashMap habilidadesDisponibles = new HashMap();
		Habilidad habilidad = null;
		int duracionDelJuego = 300;
 
        
        //Instancio el controlador.-
        ControladorJuego controlador = new ControladorJuego();
        
		//Instancio Nivel.-
		Nivel nivel = Nivel.getInstance();
    	
		//Instancio Pooglins.-
		for (int i =0; i < cantidadDePooglin; i++){
			pooglins[i] = new Pooglin(1,1);
			pooglins[i].setHabilidad(new Platillo());
		}
		
		//Instancio Puertas.-
		Puerta puertaComienzo= new Puerta(1,1);
		Puerta puertaSalida = new Puerta(18,12);
		
		//Instancio habilidadesDisponibles.-
		habilidadesDisponibles.put("Platillo",2);
		habilidadesDisponibles.put("RayoLaser",5);
		habilidadesDisponibles.put("Taladro",20);
		habilidadesDisponibles.put("Tunel",2);
		habilidadesDisponibles.put("Teletransportarse",2);
		habilidadesDisponibles.put("Congelamiento",2);
		habilidadesDisponibles.put("Morir",2);
		
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
		nivel.setHabilidad(habilidad);
		nivel.setDuracionDelJuego(duracionDelJuego);
		nivel.iniciarTiempoEnSegundos();
		
		//Guardo toda la configuración en un XML.-
		//nivel.guardarXML("Pooglins.xml"); //<<<<<<<<< Acá va el nombre del Escenario.-
		
		
		//Preparo los controladores de la vista para las puertas.-
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
		}
		
		
		//Instancio oyente.-
    	MouseParaPooglins oyente = new MouseParaPooglins((Pooglin[])nivel.getPooglins());
    	
		//Luego instancio los objetos del framework: una ventana y el controlador.-
		Ventana ventana = new VentanaPrincipal(anchoDeVentana,altoDeVentana);
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);
		
		ventana.addMouseListener(oyente);
		controlador.agregarObjetoVivo(nivel);
		controlador.setIntervaloSimulacion(350);
		nivel.comenzarTiempo();
		controlador.comenzar();
		
	}
}
