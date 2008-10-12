/**
 * 
 */

/**
 * @author mart
 *
 */
public class Pooglin implements Personaje {

	private int posicionX;
	private int posicionY;
	private int altura;
	
	public Pooglin(int posicionX,int posicionY){
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.altura=0;
	}
	
	
	/* (non-Javadoc)
	 * @see Personaje#mover()
	 */
	@Override
	public void mover() {
		
	}

	@Override
	public int verPosicionX(){
		return this.posicionX;
	}
	
	@Override
	public int verPosicionY(){
		return this.posicionY;
	}

	@Override
	public int altura() {
		return altura;
	}

	@Override
	public void subirAltura() {
		altura++;
		return;
	}

	@Override
	public void bajarAltura() {
		altura--;
		return;
	}
	
	
}
