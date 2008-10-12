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
			if (pooglin.altura() > 0 ){
				if(pooglin > 5){
					if( pooglin.getHabilidad() instanceof Paracaidas){
					
					}else{
						
					}
				}
			
			
			}else{
				
			
			}
			
			
		}
		 
	}


}
