package vista;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.util.HashMap;
import java.util.Iterator;

import modelo.Congelamiento;
import modelo.Morir;
import modelo.Nivel;
import modelo.Platillo;
import modelo.RayoLaser;
import modelo.Taladro;
import modelo.Teletransportarse;
import modelo.Tunel;

import controlador.MouseAdaptador;
import controlador.MouseParaBotones;

public class VentanaPrincipal extends Ventana {
	public VentanaPrincipal(int ancho, int alto) {
		super(ancho,alto);
		this.setTitle("Los Pooglins");
	}
	private static final long serialVersionUID = 1L;
}
