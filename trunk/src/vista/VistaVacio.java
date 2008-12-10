package vista;

import modelo.Nivel;
import modelo.SuperficieDeDibujo;
import modelo.Terreno;

@SuppressWarnings("serial")
public class VistaVacio extends Imagen{
	private String archivoImagen = "..//lospooglins//imagenes//vacio.jpg";
	private int pasosParaCongelar;
	
	public VistaVacio() {
		this.setNombreArchivoImagen(archivoImagen);
		pasosParaCongelar = 0;
		
	}
	
	@Override
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		super.dibujar(superficeDeDibujo);
		Nivel nivel = Nivel.getInstance();
		Terreno terreno = nivel.getTerreno(this.getPosicionable().getPosicionX(), this.getPosicionable().getPosicionY());
		String nombreDelTerreno = terreno.getClass().getName();
		
		
		if((nombreDelTerreno.equals("modelo.Hielo"))&&(pasosParaCongelar<5)) //this.setNombreArchivoImagen("..//lospooglins//imagenes//hielo.jpg"); 
		congelar();		
		
		
		
	}
	
	private void congelar() {
			
		if(pasosParaCongelar == 0){
		this.setNombreArchivoImagen("..//lospooglins//imagenes//congelado//Congelar 1.jpg"); 
		}
		if(pasosParaCongelar == 1){
		this.setNombreArchivoImagen("..//lospooglins//imagenes//congelado//Congelar 2.jpg"); 
		}
		if(pasosParaCongelar == 2){
		this.setNombreArchivoImagen("..//lospooglins//imagenes//congelado//Congelar 3.jpg"); 
		}
		if(pasosParaCongelar == 3){
		this.setNombreArchivoImagen("..//lospooglins//imagenes//congelado//Congelar 4.jpg"); 	
		}
		if(pasosParaCongelar == 4){
		this.setNombreArchivoImagen("..//lospooglins//imagenes//hielo.jpg"); 
		}
		pasosParaCongelar ++;
	}
	
}
	
