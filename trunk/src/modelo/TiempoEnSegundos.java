package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class TiempoEnSegundos {
	private Timer timer;
	private int tiempoEnSegundos;
	private static TiempoEnSegundos tiempo;
	
	private TiempoEnSegundos(){
	}
	
	public static TiempoEnSegundos getInstance(){
		if ( tiempo == null ) tiempo = new TiempoEnSegundos();
		return tiempo;
	}
	
	public void terminarTiempo(){
		timer.stop();
		tiempoEnSegundos = 0;
	}

	public void comenzarTiempo(){
		if(tiempoEnSegundos > 0) return;
		timer = new Timer (1000, new ActionListener ()
		{
			public void actionPerformed(ActionEvent e){
				tiempoEnSegundos++;
			}
		});
		timer.start();
    }
	
	public int getTiempoEnSegundos() {
		return tiempoEnSegundos;
	}
}