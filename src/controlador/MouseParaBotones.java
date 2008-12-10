package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.JButton;
import modelo.Congelamiento;
import modelo.Habilidad;
import modelo.Morir;
import modelo.Nivel;
import modelo.Platillo;
import modelo.RayoLaser;
import modelo.Taladro;
import modelo.Teletransportarse;
import modelo.Tunel;

public class MouseParaBotones extends MouseAdapter {

	public MouseParaBotones(){
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void mouseClicked(MouseEvent arg0) {
		JButton bt = (JButton)arg0.getSource();
		String nombre = bt.getText();
		
		Nivel nivel = Nivel.getInstance();
		HashMap habilidades;
		Habilidad habilidad=null;
		
		habilidades = nivel.getHabilidadesDisponibles();
		int cantidadDeHabilidadesDisponibles = (Integer)habilidades.get(nombre);
		System.out.println(nombre +" "+cantidadDeHabilidadesDisponibles);
		
		if(cantidadDeHabilidadesDisponibles>0){
			habilidades.put(nombre, (cantidadDeHabilidadesDisponibles-1));
			if(nombre.equals("Taladro")) habilidad = new Taladro();
			if(nombre.equals("Congelamiento")) habilidad = new Congelamiento();
			if(nombre.equals("Platillo")) habilidad = new Platillo();
			if(nombre.equals("Teletransportarse")) habilidad = new Teletransportarse();
			if(nombre.equals("Tunel")) habilidad = new Tunel();
			if(nombre.equals("RayoLaser")) habilidad = new RayoLaser();
			if(nombre.equals("Morir")) habilidad = new Morir();	
		}
		else System.out.println("no hay mas habilidades");
		
		
		System.out.println(habilidad);	
		nivel.setHabilidad(habilidad);
		
	}

}
