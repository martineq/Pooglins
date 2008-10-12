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
	private Habilidad habilidad;
	
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
	public int getAltura() {
		return this.altura;
	}

	@Override
	public void subirAltura() {
		this.altura++;
		return;
	}

	@Override
	public void bajarAltura() {
		this.altura--;
		return;
	}


	@Override
	public Habilidad getHabilidad() {
		return this.habilidad;
	}


	@Override
	public void setHabilidad(Habilidad habilidad) {
				
	}
	
	@Override
	public void morir() {
		
	}
	
	public void abrirParacaidas() {
	}
	
	public void aterrizar(){
		
	}


	
}
