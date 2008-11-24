package controlador;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import src.VentanaInicio;
import vista.Ventana;
import vista.VistaPooglin;


import modelo.Terreno;


//public class MouseAdaptador extends MouseAdapter {
public class MouseAdaptador implements MouseListener {

//private  ventana;
	
	public MouseAdaptador(){
		//this.ventana = vistaPooglin;
	}
	

	public void mouseMoved(MouseEvent arg0){
		System.out.println("Pasaste por mouseMove");
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("Pasaste por mouseClick");
		
	}

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

}
