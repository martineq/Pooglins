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
import modelo.Personaje;
import modelo.Platillo;
import modelo.Pooglin;
import modelo.Puerta;
import modelo.Roca;
import modelo.Terreno;
import modelo.TiempoEnSegundos;
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
		int cantidadDePooglin = 4;
		Pooglin pooglins[] = new Pooglin[cantidadDePooglin];
		int pooglinsARescatar = 3;
		int contador = 0;
		HashMap habilidadesDisponibles = new HashMap();
		Habilidad habilidad = null;
		int duracionDelJuego = 600;

		
        //Instancio el controlador.-
        ControladorJuego controlador = new ControladorJuego();
        
		//Instancio Nivel.-
		Nivel nivel = Nivel.getInstance();
    	
		//Instancio Pooglins.-
		for (int i =0; i < cantidadDePooglin; i++){
			pooglins[i] = new Pooglin(1,1);
			pooglins[i].setHabilidad(null);
		}
		
		//Instancio Puertas.-
		Puerta puertaComienzo= new Puerta(1,1);
		Puerta puertaSalida = new Puerta(18,12);
		
		//Instancio habilidadesDisponibles.-
		habilidadesDisponibles.put("Platillo",9);
		habilidadesDisponibles.put("RayoLaser",9);
		habilidadesDisponibles.put("Taladro",9);
		habilidadesDisponibles.put("Tunel",9);
		habilidadesDisponibles.put("Teletransportarse",9);
		habilidadesDisponibles.put("Congelamiento",9);
		habilidadesDisponibles.put("Morir",9);
		
		//Instancio la matriz.-
		matrizNivel = new Terreno[anchoDeMatriz][altoDeMatriz];
		
		//Cargo la matriz.-
		matrizNivel = EditorDeMatriz.editar(matrizNivel, anchoDeMatriz, altoDeMatriz, controlador);

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
		//nivel.iniciarTiempoEnSegundos();
		
		
		//Guardo toda la configuración en un XML.-
		//nivel.guardarXML("Nivel0.xml"); //<<<<<<<<< Acá va el nombre del Escenario.-
			
		//Preparo los controladores de la vista para las puertas.-
		VistaPuerta vPuerta = new VistaPuerta();
		vPuerta.setPosicionable(puertaComienzo);
    	controlador.agregarDibujable(vPuerta);
    	vPuerta = new VistaPuerta();
		vPuerta.setPosicionable(puertaSalida);
    	controlador.agregarDibujable(vPuerta);
		
		//Instancio una imagen para que actúe como vista para el pooglin.-
		for (int i =0; i< cantidadDePooglin; i++){
			VistaPooglin vistaPooglin = new VistaPooglin(pooglins[i]);
			//vistaPooglin.setPosicionable(pooglins[i]);
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
		//nivel.comenzarTiempo();
		controlador.comenzar();
		
	}
}
