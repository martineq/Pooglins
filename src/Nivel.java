
/**Clase que representa el campo de juego donde se encuentran los personajes
 * y los distintos tipos de terrenos. Implementa la interfaz Escenario.- 
 * @author Mart
 * @since 11/10/08
 */
public class Nivel implements Escenario {
	private Terreno[][] matrizNivel;
	private Personaje[] pooglins;
	private int pooglinsARescatar;
	private int cantidadPooglins;
	
	/**Constructor de Nivel.-
	 * 
	 */
	public Nivel(){
		//Creo que hay que inicializar la matriz con un "contorno" de "rocas" (rocas en los 4 bordes de la pantalla)
		//para que el pooglin no se pueda escapar de la pantalla caminando y para 
		//poder calcular la altura en que se encuetra el pooglin.-
		
		//Cargo la matriz,etc.-
	}
	
	public void manejar() {
		
	}

	/**Método que devuelve el terreno dado por la posición X e Y.-
	 * @param posicionX
	 * @param posicionY
	 * @return
	 */
	public Terreno revisarNivel(int posicionX, int posicionY){
		return null;	
	}

	//Geter's y Seter's Realizados automaticamete.-
	public void setMatrizNivel(Terreno[][] matrizNivel) {
		this.matrizNivel = matrizNivel;
	}

	public Terreno[][] getMatrizNivel() {
		return matrizNivel;
	}

	public void setPooglins(Personaje[] pooglins) {
		this.pooglins = pooglins;
	}

	public Personaje[] getPooglins() {
		return pooglins;
	}

	public void setPooglinsARescatar(int pooglinsARescatar) {
		this.pooglinsARescatar = pooglinsARescatar;
	}

	public int getPooglinsARescatar() {
		return pooglinsARescatar;
	}

	public void setCantidadPooglins(int cantidadPooglins) {
		this.cantidadPooglins = cantidadPooglins;
	}

	public int getCantidadPooglins() {
		return cantidadPooglins;
	}
}
