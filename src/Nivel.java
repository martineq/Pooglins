
/**Clase que representa el campo de juego donde se encuentran los personajes
 * y los distintos tipos de terrenos. Implementa la interfaz Escenario.- 
 * @author guido
 * @since 11/10/08
 */
/**
 * @author guido
 *
 */
public class Nivel implements Escenario {
	private Terreno[][] matrizNivel;
	private Personaje[] pooglins;
	private int pooglinsARescatar;
	private int cantidadPooglins;
	private Puerta puertaComienzo;
	private Puerta puertaSalida;
	
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
	//En construccion ...
	//Guido.-
		
		
		//Ciclo que controle que queden pooglins vivos o que no se haya 
		//terminado el nivel xq todos los pooglins fueron rescatados
		//o el tiempo se termino.
		//Guido.-
		
		
		for(int i=0;i<this.pooglins.length;i++){
			Pooglin pooglin=(Pooglin)this.pooglins[i];
			int posicionX=pooglin.getPosicionX();
			int posicionY=pooglin.getPosicionY();
			pooglin.mover();//ver si va primero el mover o primero el revisar nivel Guido.-
			Terreno terrenoActual=revisarNivel(posicionX,posicionY);
			terrenoActual.accionarTerreno(pooglin);//ver si voy a devolver un Terreno Guido.-
			
			//Revisandolo, depende de si el mover va antes o despues 
			//de utilizar el terreno...=mente tengo q obtener las 
			//nuevas posiciones, x eso no lo dejo comentado...
			//Guido.-
			posicionX=pooglin.getPosicionX();
			posicionY=pooglin.getPosicionY();
			alcanzoSalida(posicionX,posicionY);
		}
	}

	/**Método que devuelve el terreno dado por la posición X e Y.-
	 * @author guido
	 * @param posicionX
	 * @param posicionY
	 * @return
	 */
	public Terreno revisarNivel(int posicionX, int posicionY){
		//EN REVISION y CONSTRUCCION...
		//Guido.-
		
		//obtengo el terreno de la posicion justo adelante del pooglin
		Terreno terrenoActual=this.matrizNivel[posicionX][posicionY+1];
		//No me gusta esta linea, ver si no hay una forma mejor de hacerlo
		//xq estoy usando instanceof:S....
		//Probar con Excepciones....
		//Guido.-
		if (terrenoActual instanceof Vacio){//Si es vacio devuelvo lo que hay justo adelante y abajo es decir, donde va a pisar el pooglin
			terrenoActual=this.matrizNivel[posicionX+1][posicionY+1];
		}
		return terrenoActual;
		
	}

	/**Metodo privado que chequea si el pooglin actual alcanzo
	 * la salida y disminuye la cantidad de pooglins a rescatar
	 * asi como tambien la cantidad de pooglins en el nivel.-
	 * @param posicionX
	 * @param posicionY
	 */
	private void alcanzoSalida(int posicionX,int posicionY){
		int coordenadaXpuertaSalida=this.puertaSalida.getPosicionX();
		int coordenadaYpuertaSalida=this.puertaSalida.getPosicionY();
		if((coordenadaXpuertaSalida==posicionX)&&(coordenadaYpuertaSalida==posicionY)){
			this.pooglinsARescatar--;
			this.cantidadPooglins--;
		}
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
