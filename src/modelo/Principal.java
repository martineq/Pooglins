
package modelo;

import vista.*;
import controlador.MouseAdaptador;

/**Clase que contiene al juego
 * @author Mart.-
 *
 */
public class Principal {

	/**Este es el "main" del juego.-
	 * @param args
	 */
	public static void main(String[] args) {
		ControladorJuego controlador = Principal.cargarJuego("PruebaSiete.xml",985,700,70);
		controlador.comenzar();
	}

	
	/**Método donde instancio todo lo relativo a la vista.
	 * recibe por parámetro el nombre del archivo XML, 
	 * las dimensiones de la ventana, y el intervalo de tiempo.-
	 * @author Mart.-
	 * @param nombre
	 * @param ancho
	 * @param alto
	 * @param tiempo
	 * @return ControladorJuego
	 */
	public static ControladorJuego cargarJuego(String nombre, int ancho, int alto, int tiempo){
		//Instancio el oyente.-
		MouseAdaptador oyente = new MouseAdaptador();
		
		//Instancio los objetos del framework: Una ventana y el controlador.-
		Ventana ventana = new VentanaPrincipal(ancho,alto);
		ControladorJuego controlador = new ControladorJuego();
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);
		
		//Instancio "EL" Nivel.-
		Nivel nivel = Nivel.getInstance();
		
		//Instancio todos los objetos cargando desde el archivo XML.-
		nivel.cargarXML(nombre);  //<<<<<<<<< Acá va el nombre de lo que quiero cargar.-
		
		//Cargo toda la vista:
		//Cargo la vista para todo el terreno de juego.-
		for ( int x = 0 ; x < nivel.getTamanioTerrenoX() ; x++ ){
			for ( int y = 0 ; y < nivel.getTamanioTerrenoY() ; y++ ){
				Terreno terreno = nivel.getTerreno(x, y);
				Imagen vista = null;
				if ( terreno instanceof AgujeroNegro){
					vista = new VistaAgujeroNegro();
				}
				if ( terreno instanceof Fuego){
					vista = new VistaFuego();
				}
				if ( terreno instanceof Hielo){
					vista = new VistaHielo();
				}
				if ( terreno instanceof Roca){
					vista = new VistaRoca();
				}
				if ( terreno instanceof Tierra){
					vista = new VistaTierra();
				}
				if ( terreno instanceof Vacio){
					vista = new VistaVacio();
				}
				vista.setPosicionable(terreno);
				controlador.agregarDibujable(vista);
			}
		}
		
		//Cargo la vista para los Pooglins.-  
		for ( int i = 0 ; i < nivel.getTamanioPooglins() ; i++ ){
			VistaPooglin vistaPooglin = new VistaPooglin();
			vistaPooglin.setPosicionable(nivel.getPooglin(i));
			controlador.agregarDibujable(vistaPooglin);
			vistaPooglin.addMouseListener(oyente);
		}

		//Cargo la vista para las puertas de comienzo y fin.-
		VistaPuerta vistaPuerta = new VistaPuerta();
		vistaPuerta.setPosicionable(nivel.getPuertaComienzo());
    	controlador.agregarDibujable(vistaPuerta);
    	vistaPuerta = new VistaPuerta();
    	vistaPuerta.setPosicionable(nivel.getPuertaSalida());
    	controlador.agregarDibujable(vistaPuerta);
	
		//Seteo a el controlador.-
		controlador.agregarObjetoVivo(nivel);
		controlador.setIntervaloSimulacion(tiempo);
		
		return controlador;
	}
	
	
}
