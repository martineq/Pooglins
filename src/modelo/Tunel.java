package modelo;

/**Tunel: Es una herramienta que permite crear un "T�nel Electromagn�tico",
 * similar a una escalera.�ste transporta un pooglin dos posiciones verticales y dos 
 * horizontales, haci�ndolo desaparecer de su posici�n actual y teletrasportandolo
 * a la posici�n nueva.-
 *  
 * @author lkolaric
 * 
 */
public class Tunel extends Herramienta {

	/**Constructor de Tunel.-
	 * 
	 */
	public Tunel(){
		
	}
	
	public void utilizar(Terreno terreno, Pooglin pooglin) {
		int posicionX = pooglin.getPosicionX();
		int posicionY = pooglin.getPosicionY();
		
		if (pooglin.getVelocidad().getVelocidadX() > 0){
			posicionX = posicionX + 2;
			posicionY = posicionY - 2;
		}else{
			posicionX = posicionX - 2;
			posicionY = posicionY - 2;
		}
		if (posicionX > 0 && posicionY > 0 && posicionX < 22){
			
			pooglin.setPosicionX(posicionX);
			pooglin.setPosicionY(posicionY);
		}
		pooglin.sacarHabilidad();
	}
	
	@Override
	public String toString(){
		return "Tunel";
	}
}
