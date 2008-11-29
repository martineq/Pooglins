package modelo;


import java.util.Collection;
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

	/* (non-Javadoc)
	 * @see Terreno#accionarTerreno(Personaje)
	 * Método que acciona el terreno.Obtiene la instancia de nivel,
	 * los pooglins cercanos, recorre la coleccion con un iterador
	 * y succiona los pooglins cercanos dentro del agujero negro
	 * matandolos.
	 * CONSIDERACION IMPORTANTE:
	 * el agujero negro antes de succionar debe ser activado
	 * por un pooglin, es decir, cuando un pooglin pisa el
	 * agujero negro es succionado asi como tambien los 
	 * pooglins que esten a 1 bloque de distancia del agujero
	 * en todas las direcciones alrededor de su "boca".
	 * Sin embargo, mientras ningun pooglin lo active, el
	 * agujero negro no succionará a ningun pooglin de sus 
	 * alrededores.
	 */
	@SuppressWarnings("unchecked")
	public void accionarTerreno(Personaje pooglin) {
	
		this.nivel= Nivel.getInstance();//Instancio una referencia al nivel ya que es unica
		 								//por ser un Singleton.
		Collection personajesCercanos = nivel.obtenerPooglinsCercanos(this.getPosicionX(),this.getPosicionY());
		Iterator it = personajesCercanos.iterator();
		while (it.hasNext()){
			Pooglin pooglinCercano = (Pooglin) it.next();
			pooglinCercano.setPosicionX(this.getPosicionX());//coloco al pooglin en el agujero negro
			pooglinCercano.setPosicionY(this.getPosicionY());
			Habilidad habilidad = pooglinCercano.getMatarse();
			habilidad.utilizar(pooglinCercano);//mato o succiono al pooglin.
		}
	}
	
    /* ¿Se va a usar?
	public void accionarTerreno(Personaje pooglin,Nivel campo) {
	
	}*/

}