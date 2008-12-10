package modelo;
/**Terreno: clase abstracta que representa el concepto de terreno en el juego
 * @author lkolaric
 *
 */
public abstract class Terreno implements Posicionable {
	/**PosicionX y PosicionY serán atributos de esta clase abstracta debido a que la 
	 * clase Nivel, las habilidad y hasta ellas mismas necesitan saber en que posicion
	 * de la matriz principal se encuentran.
	 */
	private int posicionX;
	private int posicionY;
	private boolean activo;
	
	public abstract void accionarTerreno(ObjetoVivo pooglin);
	
	public int getPosicionX() {
		return posicionX;
	}
	/**
	 * @param posicionX
	 */
	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}
	public int getPosicionY() {
		return posicionY;
	}
	/**
	 * @param posicionY
	 */
	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}
	/**
	 * @return boolean
	 */
	public boolean isActivo() {
		return activo;
	}
	/**
	 * @param activo
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
}
