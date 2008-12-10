package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import modelo.Nivel;
import modelo.Pooglin;

public class MouseParaPooglins extends MouseAdapter {
	private Pooglin[] pooglins;
	
	public MouseParaPooglins(Pooglin[] pooglin){
		this.pooglins = pooglin;
	}
	
	private int calcularPosiocion(int posicionEnPantalla){
		return (int) Math.floor((posicionEnPantalla/44));
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int clickEnPosicionX = calcularPosiocion(arg0.getX());
		int clickEnPosicionY = calcularPosiocion(arg0.getY()-62);
		Nivel nivel = Nivel.getInstance();	
		for(int i = 0; i<pooglins.length;i++){
			if((pooglins[i].getPosicionX()==clickEnPosicionX)&&(pooglins[i].getPosicionY()==clickEnPosicionY)){	
				System.out.println("Click en pooglin");
				pooglins[i].setHabilidad(nivel.getHabilidad());
				nivel.sacarHabilidad();
			}
		}
	}
}
