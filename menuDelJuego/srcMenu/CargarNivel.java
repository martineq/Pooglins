package srcMenu;

import vista.UnionMVC;
import modelo.ControladorJuego;

class CargarNivel extends Thread {
   String nombreDelXML;
   
	public String getNombreDelXML() {
		return nombreDelXML;
	}

	public void setNombreDelXML(String nombreDelXML) {
		this.nombreDelXML = nombreDelXML;
	}

	@Override
	public void run() {
		ControladorJuego controlador = UnionMVC.cargarJuego(nombreDelXML,975,730,350);
		controlador.comenzar();
	}
}