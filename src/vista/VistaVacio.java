package vista;

import modelo.Nivel;
import modelo.Posicionable;
import modelo.SuperficieDeDibujo;
import modelo.Terreno;

public class VistaVacio extends Imagen{
	private String archivoImagen = "..//lospooglins//imagenes//vacio.jpg";
	public VistaVacio() {
		this.setNombreArchivoImagen(archivoImagen);
	}
	//despues borro este metodo. edgardo.
	public void setPosicionable(Posicionable posicionable) {
		//	System.out.println("PosicionX:" + posicionable.getPosicionX()+" PosicionY: " + posicionable.getPosicionY());	
			super.setPosicionable(posicionable);
		}
	
	
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		super.dibujar(superficeDeDibujo);
		Nivel nivel = Nivel.getInstance();
		Terreno terreno = nivel.getTerreno(this.getPosicionable().getPosicionX(), this.getPosicionable().getPosicionY());
		String nombreDelTerreno = terreno.getClass().getName();
		//System.out.println(terreno.getClass().getName());
		
		if(nombreDelTerreno.equals("modelo.Hielo")) this.setNombreArchivoImagen("..//lospooglins//imagenes//hielo.jpg"); 
		
		//("modelo.Vacio")
		
//		Graphics grafico = ((Ventana)superficeDeDibujo).getGrafico();
//		grafico.drawImage(this.imagen, this.posicionable.getPosicionX()*PosicionEnPantalla, this.posicionable.getPosicionY()*PosicionEnPantalla, null);
	}
}
