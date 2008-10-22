
/**
 * 
 */

/**Terreno: clase abstracta que representa el concepto de terreno en el juego
 * @author lkolaric
 *
 */
public abstract class Terreno {
	/**PosicionX y PosicionY seran atributos de esta clase abstracta debido a que la 
	 * clase Nivel, las habilidad y hasta ellas mismas necesitan saber en que posicion
	 * de la matriz principal se encuentran.
	 */
	private int posicionX;
	private int posicionY;
	private boolean activo;
	
	
	public abstract void accionarTerreno(Personaje pooglin);
	
	//Getters and Setters generados automaticamente.
	public int getPosicionX() {
		return posicionX;
	}
	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}
	public int getPosicionY() {
		return posicionY;
	}
	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
}
