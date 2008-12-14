package vista;

import modelo.Morir;
import modelo.Platillo;
import modelo.Pooglin;
import modelo.RayoLaser;
import modelo.SuperficieDeDibujo;
import modelo.Taladro;

@SuppressWarnings("serial")
public class VistaPooglin extends Imagen {
	private String haciaDerecha = "..//lospooglins//imagenes//caminando//Derecha 1.jpg";
	private String haciaDerecha2 = "..//lospooglins//imagenes//caminando//Derecha 2.jpg";
	private String haciaIzquierda = "..//lospooglins//imagenes//caminando//Izquierda 1.jpg";
	private String haciaIzquierda2 = "..//lospooglins//imagenes//caminando//Izquierda 2.jpg";
	private String imagenActual;
	private Pooglin pooglin;
	private int pasosDeAnimacion;
	private int velocidad;	

	
	public VistaPooglin(Pooglin pooglin) {
		this.pooglin = pooglin;
		velocidad = pooglin.getVelocidad().getVelocidadX();	
		this.setNombreArchivoImagen(imagenActual);
		this.setPosicionable(pooglin);
		pasosDeAnimacion = 0;
		if (velocidad > 0) {
			imagenActual = haciaDerecha;
			moverADerecha();
		}
		else {
			imagenActual = haciaIzquierda;
			moverAIzquiera();
		}
	 }


	private void moverADerecha(){
		if((imagenActual.equals(haciaDerecha))||(imagenActual.equals(haciaIzquierda))||(imagenActual.equals(haciaIzquierda2)))imagenActual = haciaDerecha2;
			else imagenActual = haciaDerecha;
		this.setNombreArchivoImagen(imagenActual);
	}

	private void moverAIzquiera(){
		if((imagenActual.equals(haciaIzquierda))||(imagenActual.equals(haciaDerecha))||(imagenActual.equals(haciaDerecha2)))	imagenActual = haciaIzquierda2;
			else	imagenActual = haciaIzquierda;
		this.setNombreArchivoImagen(imagenActual);
	}
	
	private void dispararLaserDerecha(){
		if (pasosDeAnimacion == 0)
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Laser//LaserDerecha 1.jpg");
		if (pasosDeAnimacion == 1)
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Laser//LaserDerecha 2.jpg");
		if (pasosDeAnimacion == 2)
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Laser//LaserDerecha 3.jpg");
		if (pasosDeAnimacion == 3){
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Laser//LaserDerecha 4.jpg");
			pasosDeAnimacion =0;
		}
		pasosDeAnimacion ++;
	}
	
	private void dispararLaserIzquierda(){
		if (pasosDeAnimacion == 0)
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Laser//LaserIzquierda 1.jpg");
		if (pasosDeAnimacion == 1)
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Laser//LaserIzquierda 2.jpg");
		if (pasosDeAnimacion == 2)
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Laser//LaserIzquierda 3.jpg");
		if (pasosDeAnimacion == 3){
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Laser//LaserIzquierda 4.jpg");
			pasosDeAnimacion =0;
		}
		pasosDeAnimacion ++;
	}
	private void taladrar() {
		if (pasosDeAnimacion == 0)
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Taladro//Taladro 1.jpg");
		if (pasosDeAnimacion == 1)
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Taladro//Taladro 2.jpg");
		if (pasosDeAnimacion == 2)
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Taladro//Taladro 3.jpg");
		if (pasosDeAnimacion == 3){
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Taladro//Taladro 4.jpg");
			pasosDeAnimacion =0;
		}
		pasosDeAnimacion ++;
	}
	
	private void matarPooglin() {
		if (pasosDeAnimacion == 0)
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Morir//Morir 1.jpg");
		if (pasosDeAnimacion == 1)
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Morir//Morir 2.jpg");
		if (pasosDeAnimacion == 2)
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Morir//Morir 3.jpg");
		if (pasosDeAnimacion == 3)
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Morir//Morir 4.jpg");
		if (pasosDeAnimacion == 4)
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Morir//Morir 5.jpg");
		if (pasosDeAnimacion == 5){
			pooglin.setHabilidad(pooglin.getMatarse());
			pooglin.borrarse();
		}
		pasosDeAnimacion ++;
	}
		
	@Override
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		super.dibujar(superficeDeDibujo);
		int velocidadEnX = pooglin.getVelocidad().getVelocidadX();	
		int velocidadEnY =pooglin.getVelocidad().getVelocidadY();
		
		if((pooglin.getHabilidad() instanceof Morir)){
			matarPooglin();
			return;
		}
	
		if((pooglin.getHabilidad() instanceof Taladro)){
			taladrar();
			return;
		}
		
		if((pooglin.getHabilidad() instanceof RayoLaser)){
			velocidad = pooglin.getVelocidad().getVelocidadX();	
			if (velocidad > 0) dispararLaserDerecha();
				else dispararLaserIzquierda();
			return;
		}
		
		if((velocidadEnY > 0)&&(pooglin.getHabilidad() instanceof Platillo)){
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Platillo.jpg");
			}
		else if((velocidadEnY > 0)){
			this.setNombreArchivoImagen("..//lospooglins//imagenes//caminando//Derecha 1.jpg");
		}

	else{
		if (velocidadEnX > 0) {
			moverADerecha();
		}
		else {
			moverAIzquiera();
		}

	}
}


	


}