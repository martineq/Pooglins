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
		if  ( campo.revisarNivel(pooglin.verPosicionX(), pooglin.verPosicionY()-1) instanceof Vacio ){
			if (pooglin.getAltura() > 0 ){
				if(pooglin.getAltura() > 5){
					if( pooglin.getHabilidad() instanceof Paracaidas){
						((Pooglin)pooglin).abrirParacaidas();  // ¿Se usa así?
						pooglin.mover(); //
					}else{
						pooglin.mover();
					}
				}else{
					pooglin.mover();
				}
			}else{
				if( pooglin.getHabilidad() instanceof Paracaidas){
					((Pooglin)pooglin).aterrizar(); 
				}else{
					pooglin.morir();
				}
			}
		}
	}


}
