package vista;

import java.awt.Color;
import java.awt.Graphics;

import modelo.SuperficieDeDibujo;

public class VistaPooglin extends Imagen {
	private String archivoImagen = "..//lospooglins//imagenes//pooglin2.jpg";
	
	public VistaPooglin() {
		this.setNombreArchivoImagen(archivoImagen);
	}

	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
	super.dibujar(superficeDeDibujo);
		if(archivoImagen.equals("..//lospooglins//imagenes//pooglin2.jpg"))
				archivoImagen = "..//lospooglins//imagenes//Pooglincerrado.jpg";
		
		else archivoImagen = "..//lospooglins//imagenes//pooglin2.jpg";
		
		this.setNombreArchivoImagen(archivoImagen);
	
	}
	
}
