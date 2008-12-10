package pruebaMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import pruebaMenu.VentanaInicio;
import modelo.Nivel;
import modelo.TiempoEnSegundos;

public class MouseParaMenu extends MouseAdapter {
	JFrame ventana;
	
	public MouseParaMenu(JFrame ventana){
		this.ventana = ventana;
	}
		@Override
		public void mouseClicked(MouseEvent arg0) {
		CargarNivel ejecutarNivel = new CargarNivel();
		JButton nombre = (JButton)arg0.getSource();
		String ubicacionNivelXml = "Nivel0.xml";
		
		if(nombre.getText()== "Jugar") 	{
			System.out.println("Falta Cargar el Nivel: "+ ((VentanaInicio)ventana).getNumeroDeNivel());
			System.out.println("implementar logica en Mouse para menu");			
			
			switch (((VentanaInicio)ventana).getNumeroDeNivel()){
			case 1:
				ubicacionNivelXml = "Nivel1.xml";
				break;
			case 2:
				ubicacionNivelXml = "Nivel2.xml";
				break;
			case 3:
				ubicacionNivelXml = "Nivel3.xml";
				break;
			case 4:
				ubicacionNivelXml = "Nivel4.xml";
				break;
			case 5:
				ubicacionNivelXml = "Nivel5.xml";
				break;
			}
			
			
			ejecutarNivel.setNombreDelXML(ubicacionNivelXml);
			TiempoEnSegundos.getInstance().comenzarTiempo();
			ejecutarNivel.start();
		
		
		
		}
		
		if(nombre.getText()== "Cargar Nivel") 	{
			abrir();
		}
		
		if(nombre.getText()== "Salir") 	{
			System.out.println("Guardar antes de salir");
			if(Nivel.getInstance().isCargado()) Nivel.getInstance().guardarXML("Guardado.xml");
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
				ejecutarNivel.setNombreDelXML(name.toString());
				TiempoEnSegundos.getInstance().comenzarTiempo();
				ejecutarNivel.start();
				}
			}
			else {
				JOptionPane.showMessageDialog(null," No existe "," Error ",JOptionPane.ERROR_MESSAGE);
			}
		}
	}


