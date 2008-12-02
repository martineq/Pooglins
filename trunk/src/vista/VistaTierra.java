package vista;

import java.awt.Graphics;

import modelo.Nivel;
import modelo.SuperficieDeDibujo;
import modelo.Terreno;

public class VistaTierra extends Imagen{
	private String archivoImagen = "..//lospooglins//imagenes//tierra.jpg";
	public VistaTierra() {
		this.setNombreArchivoImagen(archivoImagen);
	}
	
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		super.dibujar(superficeDeDibujo);
		Nivel nivel = Nivel.getInstance();
		Terreno terreno = nivel.getTerreno(this.getPosicionable().getPosicionX(), this.getPosicionable().getPosicionY());
		String nombreDelTerreno = terreno.getClass().getName();
		
		if(nombreDelTerreno.equals("modelo.Vacio")) this.setNombreArchivoImagen("..//lospooglins//imagenes//vacio.jpg"); 
		
		//("modelo.Vacio")
		
//		Graphics grafico = ((Ventana)superficeDeDibujo).getGrafico();
//		grafico.drawImage(this.imagen, this.posicionable.getPosicionX()*PosicionEnPantalla, this.posicionable.getPosicionY()*PosicionEnPantalla, null);
	}
	    
	
}
