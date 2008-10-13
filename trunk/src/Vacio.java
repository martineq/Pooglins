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
	
	@Override
	public void accionarTerreno(Personaje pooglin,Nivel campo) {
		if (pooglin.getAltura() > 0 ){
			if(pooglin.getAltura() > 5){
				Habilidad habActual=pooglin.getHabilidad();
				if( habActual instanceof Paracaidas){
					//((Pooglin)pooglin).abrirParacaidas();  // ¿Se usa así?
					
					//se usa asi martin, por el Polimorfismo,lo otro 
					//lo deje comentado x las dudas 
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
