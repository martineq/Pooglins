package pruebaMenu;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import pruebaMenu.VentanaInicio;
import src.PruebaNueve;

import vista.Ventana;
import vista.VistaPooglin;


import modelo.Pooglin;
import modelo.Terreno;


public class MouseParaMenu extends MouseAdapter {
	JFrame ventana;
	public MouseParaMenu(JFrame ventana){
		this.ventana = ventana;
	}
	
	public void mouseClicked(MouseEvent arg0) {
		JButton nombre = (JButton)arg0.getSource();
		
		if(nombre.getText()== "Jugar") 	{
			System.out.println("Cargar nivel");
			//PruebaJuego.comenzarJuego();
		}
		
		if(nombre.getText()== "Elejir nivel") 	{
			System.out.println("Falta Logica Elejir Nivel");
		}
		
		if(nombre.getText()== "Salir") 	{
			System.out.println("Guardar antes de salir");
			ventana.dispose();
			System.exit(0);
		}
	
	
	}
/*
	public void mouseMoved(MouseEvent arg0){
		System.out.println("Pasaste por mouseMove");
		
	}

	public void mouseEntered(MouseEvent arg0) {
		System.out.println("posX:"+arg0.getX()+"  posY"+arg0.getY());
			
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
