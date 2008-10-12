/**
 * 
 */

/**
 * @author mart
 *
 */
public interface Personaje {

	public void mover();
	
	public int getPosicionX();
	
	public void setposicionX(int x);
	
	public int getPosicionY();
	
	public void setposicionY(int y);
	
	public int getAltura(); // Me dice a que "altura del piso se encuentra"
	
	public void subirAltura();
	
	public void bajarAltura();
	
	public void setHabilidad(Habilidad habilidad );
	
	public Habilidad getHabilidad();
	
	public void morir();
	
	
}
