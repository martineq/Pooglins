package controlador;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.JOptionPane;

import src.VentanaInicio;
import vista.Ventana;
import vista.VistaPooglin;


import modelo.Congelamiento;
import modelo.Habilidad;
import modelo.Nivel;
import modelo.Platillo;
import modelo.Pooglin;
import modelo.RayoLaser;
import modelo.Taladro;
import modelo.Teletransportarse;
import modelo.Terreno;
import modelo.Tunel;


public class MouseParaBotones extends MouseAdapter {
//public class MouseAdaptador implements MouseListener {

	//private Pooglin[] pooglins;
	
	public MouseParaBotones(){
	//	this.pooglins = pooglin;
	}
	
	private int calcularPosiocion(int posicionEnPantalla){
		return (int) Math.floor((posicionEnPantalla/42));
	}

	@SuppressWarnings("unchecked")
	public void mouseClicked(MouseEvent arg0) {
		Button bt = (Button)arg0.getSource();
		String nombre = bt.getLabel();
		Nivel nivel = Nivel.getInstance();
		
		HashMap habilidades;
		
		Habilidad habilidad=null;
		
		habilidades = nivel.getHabilidadesDisponibles();
		
		//Convierto de String a Int para evitar la excepcion en tiempo de ejecucion
		//Guido.-
		try{
			int cantidadHabilidades=Integer.parseInt((String) habilidades.get(nombre));
		
		if (cantidadHabilidades>0){
		//if((Integer)habilidades.get(nombre)>0){
			System.out.println(nombre);
			if(nombre.equals("Taladro")) habilidad = new Taladro();
			if(nombre.equals("Congelamiento")) habilidad = new Congelamiento();
			if(nombre.equals("Platillo")) habilidad = new Platillo();
			if(nombre.equals("Teletransportarse")) habilidad = new Teletransportarse();
			if(nombre.equals("Tunel")) habilidad = new Tunel();
			if(nombre.equals("RayoLaser")) habilidad = new RayoLaser();
			
		}
		System.out.println(habilidad);
		
		nivel.setHabilidad(habilidad);
		}
		catch(NumberFormatException e){
			//se dispara solo si lo que se quiere convertir
			//de string a int no es un numero
			//en este caso, NUNCA se va a disparar
			//Guido.-
		}
	}

/*	public void mouseMoved(MouseEvent arg0){
		System.out.println("Pasaste por mouseMove");
		
	}

	@Override

	@Override
	public void mouseEntered(MouseEvent arg0) {
		System.out.println("Pasaste por mouseentered");
			
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
*/
}
