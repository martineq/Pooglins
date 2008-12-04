package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import vista.Imagen;
import vista.VistaFuego;
import vista.VistaHielo;
import vista.VistaRoca;
import vista.VistaTierra;
import vista.VistaVacio;

/**
 * @author 
 * Esta clase es la encargada de manejar todo el gameloop. Básicamente tiene una lista
 * de ObjetosVivos y una Dibujables que son recorridas en cada gameloop.
 */
public class ControladorJuego {
	private long intervaloSimulacion;
	private boolean estaEnEjecucion;
	private List objetosVivos;
	private List dibujables;
	private SuperficieDeDibujo superficieDeDibujo;	
//	private Imagen[][] Tablero;
//	
//	
//	public Imagen[][] getTablero() {
//		return Tablero;
//	}
//
//	public void setTablero(Imagen[][] vistatablero) {
//		Tablero = vistatablero;
//	}

	
	
	/*private void dibujarTablero(){
		int altoDeMatriz = 14;
		int anchoDeMatriz = 22;
		for(int fila=0;fila<anchoDeMatriz;fila++){
			for(int columna=0;columna<altoDeMatriz;columna++){
				Tablero[fila][columna].dibujar(this.superficieDeDibujo);
			}		
		}
		//this.superficieDeDibujo.actualizar();
	}*/
	
	public ControladorJuego(){
		this.objetosVivos = new ArrayList();
		this.dibujables = new ArrayList();
	}
	
	public void comenzar(){
		estaEnEjecucion = true;
		
		try{
		while(estaEnEjecucion){
			
			simular();
			//dibujarTablero();
				
			dibujar();
			
			Thread.sleep(intervaloSimulacion);
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
//	private void controlarMatriz() {
//		int altoDeMatriz = 14;
//		int anchoDeMatriz = 22;
//		
//		Nivel nivel = Nivel.getInstance();
//		Terreno[][] matrizNivel = nivel.getMatrizNivel();
//		//if (!terrenoActual.isActivo()){
//	
//		for(int fila=0;fila<anchoDeMatriz;fila++){
//			for(int columna=0;columna<altoDeMatriz;columna++){
//				if (!matrizNivel[fila][columna].isActivo()){
//					Imagen vista = new VistaVacio();
//					vista.setPosicionable(matrizNivel[fila][columna]);
//					this.agregarDibujable(vista);
//				}	
//			}
//		}
//	
//	
//	}

	public void detener(){
		this.estaEnEjecucion = false;
	}
	
	public void agregarObjetoVivo(ObjetoVivo objetoVivo){
		objetosVivos.add(objetoVivo);
	}
	
	public void removerSimulador(ObjetoVivo objetoVivo){
		objetosVivos.remove(objetoVivo);
	}

	public void agregarDibujable(Dibujable unDibujable){
		dibujables.add(unDibujable);
	}
	
	public void removerDibujable(Dibujable unDibujable){
		dibujables.remove(unDibujable);
	}
	
	public long getIntervaloSimulacion() {
		return intervaloSimulacion;
	}

	public void setIntervaloSimulacion(long intervaloSimulacion) {
		this.intervaloSimulacion = intervaloSimulacion;
	}


	private void dibujar() {
		Iterator iterador = dibujables.iterator();
		while(iterador.hasNext()){
			Dibujable dib = (Dibujable)iterador.next();
			dib.dibujar(this.superficieDeDibujo);
		}		
		this.superficieDeDibujo.actualizar();
	}
	
	private void simular() throws InterruptedException {
		this.superficieDeDibujo.limpiar();
		Iterator iterador = objetosVivos.iterator();
		while(iterador.hasNext()){
			((ObjetoVivo)iterador.next()).vivir();
			
		}
	}

	public SuperficieDeDibujo getSuperficieDeDibujo() {
		return superficieDeDibujo;
	}

	public void setSuperficieDeDibujo(SuperficieDeDibujo superficieDeDibujo) {
		this.superficieDeDibujo = superficieDeDibujo;
	}
	

}
