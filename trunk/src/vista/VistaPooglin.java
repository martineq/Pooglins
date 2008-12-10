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
	private int contadorDeLaser;
	private int velocidad;	

	
	public VistaPooglin(Pooglin pooglin) {
		this.pooglin = pooglin;
		velocidad = pooglin.getVelocidad().getVelocidadX();	
		this.setNombreArchivoImagen(imagenActual);
		this.setPosicionable(pooglin);
		contadorDeLaser = 0;
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
	
	private void dispararLaser(){
		if (contadorDeLaser == 0)
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Laser//Laser 1.jpg");
		if (contadorDeLaser == 1)
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Laser//Laser 2.jpg");
		if (contadorDeLaser == 2)
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Laser//Laser 3.jpg");
		if (contadorDeLaser == 3){
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Laser//Laser 4.jpg");
			contadorDeLaser =0;
		}
		contadorDeLaser ++;
	}
	
	private void taladrar() {
		if (contadorDeLaser == 0)
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Taladro//Taladro 1.jpg");
		if (contadorDeLaser == 1)
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Taladro//Taladro 2.jpg");
		if (contadorDeLaser == 2)
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Taladro//Taladro 3.jpg");
		if (contadorDeLaser == 3){
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Taladro//Taladro 4.jpg");
			contadorDeLaser =0;
		}
		contadorDeLaser ++;
	}
	
	private void matarPooglin() {
		if (contadorDeLaser == 0)
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Morir//Morir 1.jpg");
		if (contadorDeLaser == 1)
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Morir//Morir 2.jpg");
		if (contadorDeLaser == 2)
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Morir//Morir 3.jpg");
		if (contadorDeLaser == 3)
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Morir//Morir 4.jpg");
		if (contadorDeLaser == 4)
			this.setNombreArchivoImagen("..//lospooglins//imagenes//Morir//Morir 5.jpg");
		if (contadorDeLaser == 5){
			pooglin.setHabilidad(pooglin.getMatarse());
			pooglin.borrarse();
		}
		contadorDeLaser ++;
	}
		

	
	@Override
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		super.dibujar(superficeDeDibujo);
		int velocidadEnX = pooglin.getVelocidad().getVelocidadX();	
		int velocidadEnY =pooglin.getVelocidad().getVelocidadY();
		
		//Falta si tiene velocidad en Y e ademas no tiene
		//platillo tiene que caer quieto
		
		if((pooglin.getHabilidad() instanceof Morir)){
			matarPooglin();
			return;
		}
	
		if((pooglin.getHabilidad() instanceof Taladro)){
			taladrar();
			return;
		}
		
		if((pooglin.getHabilidad() instanceof RayoLaser)){
			dispararLaser();
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
	

		
//		if((pooglin.getHabilidad() instanceof Morir)){
//			System.out.println("entro con: " + pooglin.getHabilidad());
//			matarPooglin();
//			return;
//		}
//		
//		if((pooglin.getHabilidad() instanceof Taladro)){
//			taladrar();
//		    return;
//		}
//		
//		if((pooglin.getHabilidad() instanceof RayoLaser)){
//			dispararLaser();
//		}
//		else{
//			if((velocidadEnY > 0)&&(pooglin.getHabilidad() instanceof Platillo)){
//				this.setNombreArchivoImagen("..//lospooglins//imagenes//Platillo.jpg");
//				}
//				
//		if((velocidadEnY > 0)){
//			this.setNombreArchivoImagen("..//lospooglins//imagenes//caminando//Derecha 1.jpg");
//		}
//	
//		
//		
//		else{
//			if (velocidadEnX > 0) {
//				moverADerecha();
//			}
//			else {
//				moverAIzquiera();
//			}
//		}
	}
}


	


}