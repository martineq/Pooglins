package pruebaMenu;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Panel;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JPanel;

import modelo.ControladorJuego;
import modelo.Nivel;
import modelo.Pooglin;
import modelo.Puerta;
import modelo.Roca;
import modelo.Terreno;
import modelo.Tierra;
import modelo.Vacio;
import vista.Imagen;
import vista.Ventana;
import vista.VentanaPrincipal;
import vista.VistaFuego;
import vista.VistaHielo;
import vista.VistaPooglin;
import vista.VistaPuerta;
import vista.VistaRoca;
import vista.VistaTierra;
import vista.VistaVacio;
import controlador.MouseParaPooglins;


public class MenuPrincipal{
	
	public static void main(String[] args){
		VentanaInicio menuPrincipal = new VentanaInicio();
		menuPrincipal.setVisible(true);
	}

}
