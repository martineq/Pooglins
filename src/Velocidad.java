

/**Esta clase empaqueta todos los atributos necesarios para describir la velocidad de un 
 * pooglin y, de esta manera, hacer mas simple la clase pooglin.
 * Lo que estamos proponiendo es que cada clase que modifique la velocidad del pooglin, lo
 * haga por ella misma, es decir, como si el hielo tuviera un coeficiente de rozamiento
 * y ELLO le modificara la velocidad. De esta manera, conceptualmente hablando estaría bien y 
 * el código seria simple.
 * @author lkolaric
 * @since
 */
public class Velocidad {

	/**La velocidad estará marcada por su signo, determinando de esta manera la direccion
	 * del movimiento del pooglin, junto con el valor de la velocidad que al no tener 
	 * Aceleración, estará dado por cuatro valores literales:
	 * VELOCIDAD_NULA = 0
	 * VELOCIDAD_PLATILLO = 7
	 * VELOCIDAD_NORMAL = 6
	 * VELOCIDAD_MAXIMA = 5
	 * */
	
	public final static int VELOCIDAD_PLATILLO = 7;
	public final static int VELOCIDAD_MAXIMA = 5;
	public final static int VELOCIDAD_NORMAL = 6;
	public final static int VELOCIDAD_NULA = 0;
	private int velocidadX;
	private int velocidadY;
	
	/**Constructor de Velocidad. Inicializa en cero.-
	 * 
	 */
	public Velocidad(){
		this.setVelocidadX(VELOCIDAD_NULA);
		this.setVelocidadY(VELOCIDAD_NULA);
	}
	
	/**Invierte la dirección de la componente de la velocidad en X.-
	 * 
	 */
	public void cambiarDireccion(){
		this.setVelocidadX( (-1) * this.getVelocidadX() );
	}
	
	//Habría que ver si hay que cambiar la dirección en Y en algún momento del programa.-
	
	public int getVelocidadX() {
		return velocidadX;
	}
	public void setVelocidadX(int velocidadX) {
		this.velocidadX = velocidadX;
	}
	public int getVelocidadY() {
		return velocidadY;
	}
	public void setVelocidadY(int velocidadY) {
		this.velocidadY = velocidadY;
	}

	/**Me devuelve el valor del módulo de la velocidad
	 * en la dirección que el personaje se está moviendo.-
	 * @return int
	 */
	public int modulo(){
		if(this.velocidadY != VELOCIDAD_NULA )
		  return Math.abs(this.getVelocidadY());
		else if (this.velocidadX != VELOCIDAD_NULA)
				return Math.abs(this.getVelocidadX());
		return VELOCIDAD_NULA;
	}
	
}