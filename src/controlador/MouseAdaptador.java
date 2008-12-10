package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import modelo.Pooglin;

public class MouseAdaptador extends MouseAdapter {

	private Pooglin[] pooglins;
	
	public MouseAdaptador(){
	}
	
	private int calcularPosiocion(int posicionEnPantalla){
		return (int) Math.floor((posicionEnPantalla/47));
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int clickEnPosicionX = calcularPosiocion(arg0.getX());
		int clickEnPosicionY = calcularPosiocion(arg0.getY());
	
		for(int i = 0; i<pooglins.length;i++){
			if((pooglins[i].getPosicionX()==clickEnPosicionX)&&(pooglins[i].getPosicionY()==clickEnPosicionY)){
				pooglins[i].setPosicionX(12);
				pooglins[i].setPosicionY(12);
			}
		}
	}

}
