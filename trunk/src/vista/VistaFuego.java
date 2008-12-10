package vista;
import modelo.SuperficieDeDibujo;

@SuppressWarnings("serial")
public class VistaFuego extends Imagen{
	private String archivoImagen = "..//lospooglins//imagenes//Fuego//Fuego 1.jpg";
	public VistaFuego() {
		this.setNombreArchivoImagen(archivoImagen);
	}
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		int numeroAleatorio= ((int)(Math.random() * 100)%4);
		if (numeroAleatorio == 0) archivoImagen = "..//lospooglins//imagenes//Fuego//Fuego 1.jpg";
		if (numeroAleatorio == 1) archivoImagen = "..//lospooglins//imagenes//Fuego//Fuego 2.jpg";
		if (numeroAleatorio == 2) archivoImagen = "..//lospooglins//imagenes//Fuego//Fuego 3.jpg";
		if (numeroAleatorio == 3) archivoImagen = "..//lospooglins//imagenes//fuego//Fuego 4.jpg";
		this.setNombreArchivoImagen(archivoImagen);
		super.dibujar(superficeDeDibujo);
	}

}
