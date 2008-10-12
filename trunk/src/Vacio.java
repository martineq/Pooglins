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
				if( pooglin.getHabilidad() instanceof Paracaidas){
					((Pooglin)pooglin).abrirParacaidas();  // ¿Se usa así?
					pooglin.mover(); //
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
