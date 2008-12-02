package controlador;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import pruebaMenu.VentanaInicio;

import vista.Ventana;
import vista.VistaPooglin;


import modelo.Pooglin;
import modelo.Terreno;


public class MouseAdaptador extends MouseAdapter {
//public class MouseAdaptador implements MouseListener {

	private Pooglin[] pooglins;
	
	public MouseAdaptador(){
	}
	
	private int calcularPosiocion(int posicionEnPantalla){
		return (int) Math.floor((posicionEnPantalla/47));
	}

	public void mouseClicked(MouseEvent arg0) {
		System.out.println("Pasaste por mouseClick");
		int clickEnPosicionX = calcularPosiocion(arg0.getX());
		int clickEnPosicionY = calcularPosiocion(arg0.getY());
		
		System.out.println("Pasaste por mouseClick");
		System.out.println("Posicion x: "+ clickEnPosicionX );
		System.out.println("Posicion y: "+ clickEnPosicionY );
		for(int i = 0; i<pooglins.length;i++){
			if((pooglins[i].getPosicionX()==clickEnPosicionX)&&(pooglins[i].getPosicionY()==clickEnPosicionY)){
				pooglins[i].setPosicionX(12);
				pooglins[i].setPosicionY(12);
			}
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
