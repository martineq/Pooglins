/**
 * 
 */

/**
 * @author mart
 *
 */
public interface Personaje {

	public void mover();
	
	public int verPosicionX();
	
	public int verPosicionY();
	
	public int altura(); // Me dice a que "altura del piso se encuentra"
	
	public void subirAltura();
	
	public void bajarAltura();
}
