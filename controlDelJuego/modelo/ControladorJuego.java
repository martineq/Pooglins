package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Nicolas
 * Esta clase es la encargada de manejar todo el gameloop. Básicamente tiene una lista
 * de ObjetosVivos y una Dibujables que son recorridas en cada gameloop.
 */
public class ControladorJuego {
	
	public ControladorJuego(){
		this.objetosVivos = new ArrayList();
		this.dibujables = new ArrayList();
	}
	
	public void comenzar(){
		estaEnEjecucion = true;
		try{
		while(estaEnEjecucion){
			simular();
			dibujar();
			Thread.sleep(intervaloSimulacion);
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
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
			System.out.println(dib.getPosicionable().getPosicionX());
			System.out.println( dib.getPosicionable().getPosicionY());
		}		
		this.superficieDeDibujo.actualizar();
	}
	
	private void simular() {
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
	
	private long intervaloSimulacion;
	private boolean estaEnEjecucion;
	private List objetosVivos;
	private List dibujables;
	private SuperficieDeDibujo superficieDeDibujo;	
}
