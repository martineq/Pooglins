/**
 * 
 */

/**
 * @author Mart
 *
 */
public class Vacio implements Terreno {

	@Override
	public void accionarTerreno(Personaje pooglin) {
	}
	
	//Casteo el Personaje a Pooglin para acceder a los get's y set's
	//si a alguien no le parece lo modifica, martin, fijate el comentario
	//en Personaje.java.-
	//Guido.-
	@Override
	public void accionarTerreno(Personaje pooglin,Nivel campo) {
		if (((Pooglin)pooglin).getAltura() > 0 ){
			if(((Pooglin)pooglin).getAltura() > 5){
				Habilidad habActual=((Pooglin)pooglin).getHabilidad();
				if( habActual instanceof Paracaidas){
					//Esta linea queda si y solo si abrirParacaidas() solamente
					//cambia la direccion y modulo de la velocidad, para usarlo tenes
					//que hacerlo con el UTILIZAR de las Habilidades si o si
					//Guido.-
					((Pooglin)pooglin).abrirParacaidas();  // ¿Se usa así?
					
					//Se usa asi martin, por el Polimorfismo,lo otro 
					//lo deje pero con un comentario importante 
					//=mente no me cierra el instanceOf habria q verlo bien
					//Guido.-
					habActual.utilizar(pooglin);					
					pooglin.mover(); 
				}else{
					pooglin.morir();
					pooglin.mover();
				}
			}else{
				pooglin.mover();
			}			
		}else{
			pooglin.mover();
		}
	}	
}
