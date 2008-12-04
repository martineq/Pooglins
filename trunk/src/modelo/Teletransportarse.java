package modelo;

/**
 * @author guido
 *
 *
 */
public class Teletransportarse extends Comportamiento{
	
//	public void utilizar(Terreno terreno, Pooglin pooglin){
//		
//	}
//	
//	public void utilizar(Personaje pooglin){
//		
//	}
	
	
	public void utilizar(Terreno terreno, Pooglin pooglin) {
		int posicionX = pooglin.getPosicionX();
		
		if (pooglin.getVelocidad().getVelocidadX() > 0){
			posicionX = posicionX + 5;
			
		}else{
			posicionX = posicionX - 5;
			
		}
		if (posicionX > 0  && posicionX < 22){
			
			pooglin.setPosicionX(posicionX);
		
		}
		pooglin.sacarHabilidad();
	}

	public String toString(){
		return "Teletransportarse";
	}
}
