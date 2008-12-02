package controlador;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import pruebaMenu.VentanaInicio;

import vista.Ventana;
import vista.VistaPooglin;


import modelo.Nivel;
import modelo.Pooglin;
import modelo.Terreno;


public class MouseParaPooglins extends MouseAdapter {
//public class MouseAdaptador implements MouseListener {

	private Pooglin[] pooglins;
	
	public MouseParaPooglins(Pooglin[] pooglin){
		this.pooglins = pooglin;
	}
	
	private int calcularPosiocion(int posicionEnPantalla){
		return (int) Math.floor((posicionEnPantalla/42));
	}

	public void mouseClicked(MouseEvent arg0) {
		int clickEnPosicionX = calcularPosiocion(arg0.getX());
		int clickEnPosicionY = calcularPosiocion(arg0.getY()-60);
		Nivel nivel = Nivel.getInstance();
		
		for(int i = 0; i<pooglins.length;i++){
			if((pooglins[i].getPosicionX()==clickEnPosicionX)&&(pooglins[i].getPosicionY()==clickEnPosicionY)){	
				//pooglins[i].usarHabilidad();
				System.out.println("Click en pooglin");
				pooglins[i].setHabilidad(nivel.getHabilidad());
				nivel.sacarHabilidad();
				//pooglins[i].usarHabilidad(nivel.getTerreno(pooglins[i].getPosicionX(), pooglins[i].getPosicionY()));
				//pooglins[i].sacarHabilidad();
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
