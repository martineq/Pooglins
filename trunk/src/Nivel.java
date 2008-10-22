
/**Clase que representa el campo de juego donde se encuentran los personajes
 * y los distintos tipos de terrenos. Implementa la interfaz Escenario.- 
 * 
 *
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
	
	//Ver si el escenario se va a pasar en una lista o como se van
	//a pasar las cosas para saber como cargamos la matriz etc
	//Guido.-
	/**Constructor de Nivel.-
	 * 
	 */
	public Nivel(int cantidadPersonajes,int cantidadPersonajesArescatar){
		//Creo que hay que inicializar la matriz con un "contorno" de "rocas" (rocas en los 4 bordes de la pantalla)
		//para que el pooglin no se pueda escapar de la pantalla caminando y para 
		//poder calcular la altura en que se encuetra el pooglin.-
		
		//Cargo la matriz
		
		//Creo las puertas de comienzo y fin
		
		//this.puertaComienzo=new Puerta(X,Y);
		//this.puertaSalida=new Puerta(X,Y);
		//Suponemos que pondremos las puertas de entrada y salida siempre en los
		//mismo lugares????????
		//Ver...Tiene que lanzar una Excepcion si cantArescatar>cantPersonajes.
		//Guido.-
		this.cantidadPooglins=cantidadPersonajes;
		this.pooglinsARescatar=cantidadPersonajesArescatar;
		
		this.pooglins=new Personaje[cantidadPersonajes];
		
		//Obtengo la posicion de la puerta inicial y cargo el 
		//vector de pooglins con los pooglins en esa posicion
		//inicial
		//Guido.-
		int posicionInicialX=this.puertaComienzo.getPosicionX();
		int posicionInicialY=this.puertaComienzo.getPosicionY();
		for(int i=0;i<this.pooglins.length;i++){
			this.pooglins[i]=new Pooglin(posicionInicialX,posicionInicialY);
		}
	}
	
	
	public void manejar() {
	//En revision...
	//FALTA VER TEMA HABILIDADES DISPONIBLES
	//Y COMO LAS VA A ACTIVAR EL USUARIO.-
	//Guido.-
		
		
		//Ciclo que controla que queden pooglins vivos o que no se haya 
		//terminado el nivel xq todos los pooglins fueron rescatados
		//o el tiempo se termino.
		//Guido.-
		while((this.cantidadPooglins!=0)||(this.pooglinsARescatar!=0)){//ver tema tiempo.Guido.-
		
			for(int i=0;i<this.pooglins.length;i++){
				Pooglin pooglin=(Pooglin)this.pooglins[i];
				int posicionX=pooglin.getPosicionX();
				int posicionY=pooglin.getPosicionY();	
				
				if (alcanzoSalida(posicionX,posicionY)){//"Mato" y borro al pooglin que salio.-
					Habilidad matarse=pooglin.getMatarse();
					matarse.utilizar(pooglin);
					pooglin.borrarse();
				}
					
				if (!pooglinMuerto(pooglin)){//si el pooglin actual No esta muerto
				Terreno terrenoActual = revisarNivel(posicionX,posicionY,pooglin);
				pooglin.mover();
				terrenoActual.accionarTerreno(pooglin);//ver si voy a devolver un Terreno Guido.-
				actualizarMatriz(terrenoActual);
				}	
				
				
				//Controlar si el usuario quiere activar
				//alguna habilidad para este pooglin
				//Guido.-
			}
			
		}
	}

	/**Método que devuelve el terreno dado por la posición X e Y.-
	 * @author guido
	 * @param posicionX
	 * @param posicionY
	 * @return
	 */
	public Terreno revisarNivel(int posicionX, int posicionY,Personaje pooglin){
		//EN REVISION ...
		//Guido.-
		
		Velocidad velocidad=((Pooglin)pooglin).getVelocidad();
		
		//obtengo el terreno de la posicion justo adelante del pooglin
		Terreno terrenoActual=this.matrizNivel[posicionX][posicionY+1];
		
		if(velocidad.getVelocidadY()!=0){//si tiene velocidad en Y devuelvo lo que tiene hacia abajo
			return terrenoActual=this.matrizNivel[posicionX+1][posicionY];
		}else{
			if (terrenoActual instanceof Vacio){//Si es vacio devuelvo lo que hay justo adelante y abajo es decir, donde va a pisar el pooglin
				return terrenoActual=this.matrizNivel[posicionX+1][posicionY+1];
			}else{
				return terrenoActual;//sino devuelvo lo que tiene justo adelante
			}
		}
		
	}
		


	/**Metodo privado que chequea si el pooglin actual alcanzo
	 * la salida y disminuye la cantidad de pooglins a rescatar
	 * asi como tambien la cantidad de pooglins en el nivel.-
	 * @param posicionX
	 * @param posicionY
	 */
	private boolean alcanzoSalida(int posicionX,int posicionY){
		int coordenadaXpuertaSalida=this.puertaSalida.getPosicionX();
		int coordenadaYpuertaSalida=this.puertaSalida.getPosicionY();
		if((coordenadaXpuertaSalida==posicionX)&&(coordenadaYpuertaSalida==posicionY)){
			this.pooglinsARescatar--;
			//tiene que matar al pooglin?
			return true;
		}
		return false;
	}
	
	/**Metodo privado que controla que el personaje actual
	 * este vivo, si no lo esta, disminuye la cantidad
	 * de pooglins vivos en el nivel;ademas devuelve
	 * si el pooglin actual esta o no vivo.-
	 * @param pooglin
	 */
	private boolean pooglinMuerto(Personaje pooglin){
		boolean estaVivo=((Pooglin)pooglin).estaVivo();
		if (!estaVivo) this.cantidadPooglins--;
		return estaVivo;
	}
	
	/**Metodo privado que en caso de ser necesario
	 * actualiza el terreno de la posicion actual 
	 * por un terreno de tipo Vacio.-
	 * @param terrenoActual
	 */
	private void actualizarMatriz(Terreno terrenoActual){
		if (!terrenoActual.isActivo()){
			this.matrizNivel[terrenoActual.getPosicionX()][terrenoActual.getPosicionY()] = new Vacio(terrenoActual.getPosicionX(),terrenoActual.getPosicionY());
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
