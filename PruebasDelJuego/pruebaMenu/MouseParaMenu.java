package pruebaMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import pruebaMenu.VentanaInicio;
import modelo.TiempoEnSegundos;



public class MouseParaMenu extends MouseAdapter {
	JFrame ventana;
	
	public MouseParaMenu(JFrame ventana){
		this.ventana = ventana;
	}
		public void mouseClicked(MouseEvent arg0) {
		CargarNivel ejecutarNivel = new CargarNivel();
		JButton nombre = (JButton)arg0.getSource();
		
		if(nombre.getText()== "Jugar") 	{
			//ventana2.dispose();			
			System.out.println("Falta Cargar el Nivel: "+ ((VentanaInicio)ventana).getNumeroDeNivel());
			System.out.println("implementar logica en Mouse para menu");			
			ejecutarNivel.setNombreDelXML("Pooglins.xml");
			TiempoEnSegundos.getInstance().comenzarTiempo();
			ejecutarNivel.start();
		}
		
		if(nombre.getText()== "Cargar Nivel") 	{
			abrir();
		}
		
		if(nombre.getText()== "Salir") 	{
			System.out.println("Guardar antes de salir");
			ventana.dispose();
			System.exit(0);
		}
	
	
	}
	
	public void abrir () {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		CargarNivel ejecutarNivel = new CargarNivel();
		
		int result= fileChooser.showOpenDialog(ventana);
		if (result== JFileChooser.CANCEL_OPTION) return;
		File name= fileChooser.getSelectedFile();
		if(name.exists()) {
			if (name.isFile()) {
				//Falta controlar que sea un XML.
				//Edgardo.
				ejecutarNivel.setNombreDelXML(name.toString());
				TiempoEnSegundos.getInstance().comenzarTiempo();
				ejecutarNivel.start();
				//JOptionPane.showMessageDialog(null,"Error en el archivo", "Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			else {
				JOptionPane.showMessageDialog(null," No existe "," Error ",JOptionPane.ERROR_MESSAGE);
			}
		}
	}


