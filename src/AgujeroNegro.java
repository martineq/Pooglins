import java.util.ArrayList;
import java.util.Iterator;



/**Clase que representa a los bloques de terreno donde hay un agujero negro.-
 * @author guido
 * @since 15/10/08
 * 
 */
public class AgujeroNegro extends Terreno {
	//REFERENCIA PARA USAR NIVEL COMO SINGLETON.-
	//FALTA APLICAR ESE PATRON.-
	//EN DESARROLLO.-
	//Guido.-
	private Nivel nivel;
	
	/**Constructor de AgujeroNegro.-
	 * 
	 */
    public AgujeroNegro(int posicionX,int posicionY){
		this.setPosicionX(posicionX);
		this.setPosicionY(posicionY);
		this.setActivo(true);
	}

	public void accionarTerreno(Personaje pooglin) {
		//Comento...Cuando Nivel sea Singleton obtengo una instancia.-
		//Guido.-...Desarrollandolo...esperando el ejemplo de Pablo 
		//Suarez.-
		this.nivel = new Nivel();//Instancio una referencia al nivel ya que es unica
		 //por ser un Singleton.
		ArrayList personajesCercanos = nivel.obtenerPooglinsCercanos(this.getPosicionX(),this.getPosicionY());
		Iterator it = personajesCercanos.iterator();
		while (it.hasNext()){
			Pooglin pooglinCercano = (Pooglin) it.next();
			pooglinCercano.setPosicionX(this.getPosicionX());//coloco al pooglin en el agujero negro
			pooglinCercano.setPosicionY(this.getPosicionY());
			Habilidad morir = pooglinCercano.getMatarse();
			morir.utilizar(pooglin);//mato o succiono al pooglin.

}
	}
	
    /* ¿Se va a usar?
	public void accionarTerreno(Personaje pooglin,Nivel campo) {
	
	}*/

}