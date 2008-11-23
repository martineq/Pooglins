package controlador;

import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

import src.VentanaInicio;


import modelo.Terreno;


public class MouseAdaptador extends MouseAdapter {
	private VentanaInicio ventana;
	
	public MouseAdaptador(VentanaInicio ventana){
		this.ventana = ventana;
	}
	
	public void mouseClicked(MouseEvent arg0) {
		
		Button bt = (Button)arg0.getSource();
		System.out.println(bt.getLabel());
		//if(bt.getLabel() == "Nivel 1") ventana.CargarNivel1();
		if(bt.getLabel() == "Nivel 1") bt.setLabel("Cambie");
			
	}


}
