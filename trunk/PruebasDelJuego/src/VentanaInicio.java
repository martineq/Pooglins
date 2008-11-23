package src;
import java.awt.*;

import javax.swing.BoxLayout;


import controlador.MouseAdaptador;

import vista.Ventana;

public class VentanaInicio extends Ventana{
	
	public VentanaInicio(int ancho, int alto) {
		super(ancho, alto);

		Panel panel = new Panel();
		
		MouseAdaptador oyente = new MouseAdaptador(this);
		
		Button btNivelUno = new Button("Nivel 1");
		btNivelUno.setSize(10, 10);
		panel.add(btNivelUno);
		btNivelUno.addMouseListener(oyente);
		
		Button btNivelDos = new Button("Nivel 2");
		btNivelDos.setSize(10, 10);
		panel.add(btNivelDos);
		btNivelDos.addMouseListener(oyente);
		
		Button btSalir = new Button("Salir");
		btSalir.setSize(10, 10);
		panel.add(btSalir);
		btSalir.addMouseListener(oyente);
		
		
		this.setPanel(panel, "Center");
	
	}


}


