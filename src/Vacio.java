/**
 * 
 */

/**
 * @author Mart
 *
 */
public class Vacio implements Terreno {

	public void accionarTerreno(Personaje pooglin) {
	}

	public void accionarTerreno(Personaje pooglin,Nivel campo) {
		if (((Pooglin)pooglin).getAltura() > 0 ){
			if(((Pooglin)pooglin).getAltura() > 5){
				Habilidad habActual=((Pooglin)pooglin).getHabilidad();
				if( habActual instanceof Paracaidas){
					//Esta linea queda si y solo si abrirParacaidas() solamente
					//cambia la direccion y modulo de la velocidad, para usarlo tenes
					//que hacerlo con el UTILIZAR de las Habilidades si o si
					//Guido.-
					//La idea seria que habActual.utilizar(pooglin) me haga activar 
					//el paracaidas, y que el abrirParacaidas() realize lo visual
					//fijate en la clase pooglin para que tengas una idea. Mart.-
					((Pooglin)pooglin).abrirParacaidas(); 
					habActual.utilizar(pooglin);					
					pooglin.mover(); 
				}else{
					Habilidad morir=((Pooglin)pooglin).getMatarse();//Modificacion del morir para usar el nuevo atributo.Guido.-
					morir.utilizar(pooglin);
					pooglin.mover();//Me parece que este mover no tiene mucho sentido.Guido.-
				}
			}else{
				pooglin.mover();
			}			
		}else{
			pooglin.mover();
		}
	}	
}
