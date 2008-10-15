/**Esta clase empaqueta todos los atributos necesarios para describir la velocidad de un 
 * pooglin y, de esta manera, hacer mas simple la clase pooglin.
 * @author lkolaric
 *Lo que estamos proponiendo es que cada clase que modifique la velocidad del pooglin, lo
 *haga por ella misma, es decir, como si el hielo tuviera un coeficiente de rozamiento
 *y ELLO le modificara la velocidad. De esta manera, conceptualmente hablando estaria bien y 
 *el codigo seria simple.
 */
public class Velocidad {

	/**
	 * La velocidad estara marcado por su signo determinando de esta manera la direccion
	 * del movimiento del pooglin, junto con el valor de la velocidad que al no tener 
	 * aceleracion, estara dado por cuatro valores literales:
	 * Velocidad Nula = 0
	 * Velocidad Paracaidas = 1
	 * Velocidad Normal = 2
	 * Velocidad Maxima = 3
	 * */
	private int velocidadX;
	private int velocidadY;
	
	
	public Velocidad(){
		this.setVelocidadX(0);
		this.setVelocidadY(0);
	}
	
	public void cambiarDireccion(){
		this.setVelocidadX((-1)*this.getVelocidadX());
	}
	
	//Habria que ver si hay que cambiar la direccion en Y en algun momento del prg
	
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
	
	
}