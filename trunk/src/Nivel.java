
/**Clase que representa el campo de juego donde se encuentran los personajes
 * y los distintos tipos de terrenos. Implementa la interfaz Escenario.- 
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
	private Habilidad[] habilidadesDisponibles;

	private static int VELOCIDAD_NULA = 0;
	private static int VELOCIDAD_NORMAL = 6;
	
	//Ver si el escenario se va a pasar en una lista o como se van
	//a pasar las cosas para saber como cargamos la matriz etc
	//Guido.-
	/**Lo dejo comentado y uso el constructor por defecto para
	 * las pruebas; el nivel lo voy a setear con los 
	 * getter's y los setter's
	 * Constructor de Nivel.-
	 * 
	 */
	/*public Nivel(int cantidadPersonajes,int cantidadPersonajesArescatar){
		//Creo que hay que inicializar la matriz con un "contorno" de "rocas" (rocas en los 4 bordes de la pantalla)
		//para que el pooglin no se pueda escapar de la pantalla caminando y para 
		//poder calcular la altura en que se encuentra el pooglin.-
		
		//Cargo la matriz
		
		//Creo las puertas de comienzo y fin
		
		//this.puertaComienzo=new Puerta(X,Y);
		//this.puertaSalida=new Puerta(X1,Y1);
	
		//Ver...Tiene que lanzar una Excepción si cantArescatar>cantPersonajes.
		//Guido.-
		this.cantidadPooglins=cantidadPersonajes;
		this.pooglinsARescatar=cantidadPersonajesArescatar;
		
		this.pooglins=new Personaje[cantidadPersonajes];
		
		//Obtengo la posición de la puerta inicial y cargo el 
		//vector de pooglins con los pooglins en esa posición
		//inicial
		//Guido.-
		int posicionInicialX=this.puertaComienzo.getPosicionX();
		int posicionInicialY=this.puertaComienzo.getPosicionY();
		for(int i=0;i<this.pooglins.length;i++){
			this.pooglins[i]=new Pooglin(posicionInicialX,posicionInicialY);
		}
	}
	*/

	public void manejar() {
	//En revision...
	//FALTA VER TEMA HABILIDADES DISPONIBLES
	//Y COMO LAS VA A ACTIVAR EL USUARIO.-
	//Guido.-
		
		
		//Ciclo que controla que queden pooglins vivos o que no se haya 
		//terminado el nivel xq todos los pooglins fueron rescatados
		//o el tiempo se termino.
		//Guido.-
		while ((this.cantidadPooglins > 0)||((this.pooglinsARescatar > 0) && (this.pooglinsARescatar < this.cantidadPooglins))){ //ver tema tiempo.Guido.-
		
			for( int i = 0 ; i < this.pooglins.length ; i++ ){
				Pooglin pooglin = (Pooglin)this.pooglins[i];
				int posicionX = pooglin.getPosicionX();
				int posicionY = pooglin.getPosicionY();	
				
				if (alcanzoSalida(posicionX,posicionY)){//"Mato" y borro al pooglin que salió.-
					/*Habilidad matarse = pooglin.getMatarse();
					matarse.utilizar(pooglin); cambio estas líneas por la de abajo*/
					pooglin.getMatarse().utilizar(pooglin);
					pooglin.borrarse();
				}
					
				if (!pooglinMuerto(pooglin)){ //Si el pooglin actual no esta muerto.-
					Terreno terrenoActual = revisarNivel(posicionX,posicionY,pooglin);
					pooglin.mover();
					terrenoActual.accionarTerreno(pooglin);//ver si voy a devolver un Terreno Guido.-
					actualizarMatriz(terrenoActual);
				}	
				
				//Controlar si el usuario quiere activar
				//alguna habilidad para este pooglin
				//Guido.-
				activarHabilidad(pooglin);
			}
			
		}
	}

	/**Método que devuelve el terreno dado por la posición X e Y.
	 * @param posicionX
	 * @param posicionY
	 * @return Terreno
	 */
	public Terreno revisarNivel(int posicionX, int posicionY,Personaje pooglin){
		//EN REVISION ...
		//Guido.-
		
		Velocidad velocidad = ((Pooglin)pooglin).getVelocidad();
		
		//obtengo el terreno de la posición justo adelante del pooglin
		Terreno terrenoActual=this.matrizNivel[posicionX+1][posicionY];
		
		if(velocidad.getVelocidadY()!= VELOCIDAD_NULA){//si tiene velocidad en Y devuelvo lo que tiene hacia abajo
			return ( terrenoActual=this.matrizNivel[posicionX][posicionY+1] );
		}else{
			if (terrenoActual instanceof Vacio){//Si es vacio devuelvo lo que hay justo adelante y abajo es decir, donde va a pisar el pooglin
				terrenoActual=this.matrizNivel[posicionX+1][posicionY+1];
				if (terrenoActual instanceof Vacio){ //Si se va a caer seteo la velocidad en "Y".-
					velocidad.setVelocidadY(VELOCIDAD_NORMAL);
					((Pooglin)pooglin).setVelocidad(velocidad);
				}
				return terrenoActual;
			}else{
				return terrenoActual;//sino devuelvo lo que tiene justo adelante
			}
		}
		
	}
		


	/**Método privado que chequea si el pooglin actual alcanzo
	 * la salida y disminuye la cantidad de pooglins a rescatar
	 * Así como también la cantidad de pooglins en el nivel.-
	 * @param posicionX
	 * @param posicionY
	 */
	private boolean alcanzoSalida(int posicionX,int posicionY){
		int coordenadaXpuertaSalida=this.puertaSalida.getPosicionX();
		int coordenadaYpuertaSalida=this.puertaSalida.getPosicionY();
		if((coordenadaXpuertaSalida==posicionX)&&(coordenadaYpuertaSalida==posicionY)){
			this.pooglinsARescatar--;
			return true;
		}
		return false;
	}
	
	/**Método privado que controla que el personaje actual
	 * este vivo, si no lo esta, disminuye la cantidad
	 * de pooglins vivos en el nivel; además devuelve
	 * si el pooglin actual esta o no vivo.-
	 * @param pooglin
	 */
	private boolean pooglinMuerto(Personaje pooglin){
		if ( !( ((Pooglin)pooglin).estaVivo() ) ){
			this.cantidadPooglins--;
			return true;
		}
		return false;
	}
	
	/**Método privado que en caso de ser necesario
	 * actualiza el terreno de la posición actual 
	 * por un terreno de tipo Hielo, si el terreno
	 * era un Vacio(implica que hay un pooglin congelado)
	 * o en Vacio si el terreno actual es de otro tipo.-
	 * @param terrenoActual
	 */
	private void actualizarMatriz(Terreno terrenoActual){
		if (!terrenoActual.isActivo()){
			if (terrenoActual instanceof Vacio){
				this.matrizNivel[terrenoActual.getPosicionX()][terrenoActual.getPosicionY()] = new Hielo(terrenoActual.getPosicionX(),terrenoActual.getPosicionY());
			}else{//Sino el único otro terreno que puede llegar inactivo es la Tierra y debe transformarse en Vacio.
				this.matrizNivel[terrenoActual.getPosicionX()][terrenoActual.getPosicionY()] = new Vacio(terrenoActual.getPosicionX(),terrenoActual.getPosicionY());
			}
		}
	}
	/**Metodo privado que va a servir para que el 
	 * usuario pueda activarle al personaje una
	 * de las habilidades disponibles para el nivel.
	 * @param pooglin
	 */
	private void activarHabilidad(Personaje pooglin){
		//Funcion que va a servir para que el usuario
		//pueda activar una de las habilidades
		//pertenecientes y disponibles en el nivel actual
		//a cada personaje en particular.
		//Debe controlar que la habilidad pertenezca a 
		//las habilitadas para el nivel y que quede
		//una habilidad de ese tipo disponible.-
		//Guido.-
	}
	//Geter's y Seter's Realizados automáticamete.-
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

	public Puerta getPuertaComienzo() {
		return puertaComienzo;
	}

	public void setPuertaComienzo(Puerta puertaComienzo) {
		this.puertaComienzo = puertaComienzo;
	}

	public Puerta getPuertaSalida() {
		return puertaSalida;
	}

	public void setPuertaSalida(Puerta puertaSalida) {
		this.puertaSalida = puertaSalida;
	}
	public Habilidad[] getHabilidadesDisponibles() {
		return habilidadesDisponibles;
	}

	public void setHabilidadesDisponibles(Habilidad[] habilidadesDisponibles) {
		this.habilidadesDisponibles = habilidadesDisponibles;
	}
	
}
