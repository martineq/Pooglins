package modelo;


import java.util.ArrayList;
import java.util.Collection;

import org.dom4j.Element;

/**Clase que representa el campo de juego donde se encuentran los personajes
 * y los distintos tipos de terrenos. Implementa la interfaz Escenario.- 
 * 
 *
 */
/**
 * @author guido
 *
 *
 */

public class Nivel implements Escenario, ObjetoVivo {
	private Terreno[][] matrizNivel;
	private Personaje[] pooglins;
	private int pooglinsARescatar;
	private int cantidadPooglins;
	private Puerta puertaComienzo;
	private Puerta puertaSalida;
	private Habilidad[] habilidadesDisponibles;
	
	private static Nivel nivel=null;//Singleton

	
	/**Metodo getInstance que permite la utilizaci�n del
	 * patr�n Singleton para la clase Nivel, desde cualquier
	 * lugar de la aplicaci�n puedo obtener una instancia
	 * de esta clase que luego de que se la haya invocado una 
	 * vez, siempre va a ser la misma.
	 * @return
	 */
	public static Nivel getInstance(){
		if(nivel==null)nivel=new Nivel();
		return nivel;
		
	}
	
	/**Constructor Privado, para obtener una instancia debe
	 * hacerse mediante el uso de getInstance()dado que Nivel
	 * es un Singleton.
	 * 
	 */
	private Nivel(){
		//De momento lo defino asi.-	
	}
	
	//Ver si el escenario se va a pasar en una lista o como se van
	//a pasar las cosas para saber como cargamos la matriz etc
	//Guido.-
	/**Lo dejo comentado y uso el constructor por defecto para
	 * las pruebas; el nivel lo voy a setear con los 
	 * getter's y los setter's
	 * Constructor de Nivel.-
	 * @throws InterruptedException 
	 * 
	 */
	/*public Nivel(int cantidadPersonajes,int cantidadPersonajesArescatar){
		//Creo que hay que inicializar la matriz con un "contorno" de "rocas" (rocas en los 4 bordes de la pantalla)
		//para que el pooglin no se pueda escapar de la pantalla caminando y para 
		//poder calcular la altura en que se encuetra el pooglin.-
		
		//Cargo la matriz
		
		//Creo las puertas de comienzo y fin
		
		//this.puertaComienzo=new Puerta(X,Y);
		//this.puertaSalida=new Puerta(X1,Y1);
	
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
	*/

	public void vivir() {
	//En revision...
	//FALTA VER TEMA HABILIDADES DISPONIBLES
	//Y COMO LAS VA A ACTIVAR EL USUARIO.-
	//Guido.-
	//Ciclo que controla que queden pooglins vivos o que no se haya 
	//terminado el nivel xq todos los pooglins fueron rescatados
	//o el tiempo se termino.
	//Guido.-
	//	while((this.cantidadPooglins > 0)||((this.pooglinsARescatar > 0)&&(this.pooglinsARescatar < this.cantidadPooglins))){//ver tema tiempo.Guido.-
		
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
					//System.out.println("Nombre de la clase: "+terrenoActual.getClass().getName());
					//pooglin.setAltura(alturaPooglin(pooglin));
					pooglin.vivir();
					terrenoActual.accionarTerreno(pooglin);//ver si voy a devolver un Terreno Guido.-
					actualizarMatriz(terrenoActual);
				}	
					
				//Controlar si el usuario quiere activar
				//alguna habilidad para este pooglin
				//Guido.-
				activarHabilidad(pooglin);
//			}
			
		}
	}

	private boolean estaEnLaEntrada(int posicionX, int posicionY) {
		int coordenadaXpuertaEntrada=this.puertaComienzo.getPosicionX();
		int coordenadaYpuertaEntrada=this.puertaComienzo.getPosicionY();
		if((coordenadaXpuertaEntrada==posicionX)&&(coordenadaYpuertaEntrada==posicionY))
			return true;
		else return false;
	}

	/**M�todo que devuelve el terreno dado por la posici�n X e Y.
	 * @param posicionX
	 * @param posicionY
	 * @return Terreno
	 */
	public Terreno revisarNivel(int posicionX, int posicionY,Personaje pooglin){
		Velocidad velocidad=((Pooglin)pooglin).getVelocidad();
		int direccion;
		
		Terreno terrenoActual;// = this.matrizNivel[posicionX][posicionY+1];
		if(velocidad.getVelocidadX() > 0) direccion = 1;
			else direccion = -1;
		
		if (this.matrizNivel[posicionX][posicionY+1] instanceof Vacio){
			terrenoActual = this.matrizNivel[posicionX][posicionY+1];		
		}
		else{
			if(this.matrizNivel[posicionX+direccion][posicionY] instanceof Vacio){
				terrenoActual =this.matrizNivel[posicionX][posicionY+1];
			}
			else {
				terrenoActual = matrizNivel[posicionX+direccion][posicionY];
			}
		}
		
		
		return terrenoActual;
}
		
	
	
	/**M�todo encargado de obtener los pooglins cercanos a una
	 * determinada posicion del nivel. Devuelve un ArrayList
	 * que contiene los pooglins que cumplen con esta condici�n.
	 * 
	 * @param posicionX
	 * @param posicionY
	 * @return ArrayList
	 */
	@SuppressWarnings("unchecked")
	public Collection obtenerPooglinsCercanos(int posicionX,int posicionY){
		//Esta horrible!!!! es nada mas que para ver la idea...
		//Lo estoy refactorizando.-
		//Guido.-
		
		Collection pooglinsCercanos= new ArrayList();
		for(int i=0;i<this.pooglins.length;i++){
			Pooglin pooglin= (Pooglin)this.pooglins[i];
			int posicionXpooglin=pooglin.getPosicionX();
			int posicionYpooglin=pooglin.getPosicionY();
			
			if((posicionX==posicionXpooglin)&&(posicionY==posicionYpooglin-1)) pooglinsCercanos.add(pooglin);
			if((posicionX==posicionXpooglin+1)&&(posicionY==posicionYpooglin-1)) pooglinsCercanos.add(pooglin);
			if((posicionX==posicionXpooglin-1)&&(posicionY==posicionYpooglin-1)) pooglinsCercanos.add(pooglin);
			//if((posicionY==posicionYpooglin+1)||(posicionY==posicionYpooglin-1)) pooglinsCercanos.add(pooglin);
		}
	
		
		
		return pooglinsCercanos;
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
		if (!estaVivo){
			this.cantidadPooglins--;
			return true;
		}
		return false;
	}
	
	/**Metodo privado que en caso de ser necesario
	 * actualiza el terreno de la posicion actual 
	 * por un terreno de tipo Hielo, si el terreno
	 * era un Vacio(implica que hay un pooglin congelado)
	 * o en Vacio si el terreno actual es de otro tipo.-
	 * @param terrenoActual
	 */
	private void actualizarMatriz(Terreno terrenoActual){
		if (!terrenoActual.isActivo()){
			if (terrenoActual instanceof Vacio){
				this.matrizNivel[terrenoActual.getPosicionX()][terrenoActual.getPosicionY()] = new Hielo(terrenoActual.getPosicionX(),terrenoActual.getPosicionY());
			}else{//Sino el unico otro terreno que puede llegar inactivo es la Tierra y debe transformarse en Vacio.
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
		//una habilidad de ese tio disponible.-
		//Guido.-
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
	

	/**Me indica la "altura del piso" en que se encuentra el personaje.-
     * @since 18/10/08
     * @param pooglin
     * @param campo
     */
 /*   private int alturaPooglin(Personaje pooglin) {
            int contador = 1;
            int altura = 0;
            int posicionX = ((Pooglin)pooglin).getPosicionX()/base;
            int posicionY = ((Pooglin)pooglin).getPosicionY()/base;
            
            
            while ( (revisarNivel( posicionX , posicionY + contador  ,pooglin)) instanceof Vacio ){
                    altura++;
                    contador++;
            }
            return altura; 
    	return 1;//SACARLA
    }*/

    
    /**M�todo que inicia el proceso de el guardado de todos los objetos instanciados
     * para luego exportarlos a un archivo en disco, en formato XML,.
     * @author Mart.-
     */
    public boolean salvarJuego(){
    	System.out.println("Inicio de la Persistencia.-");
		Persistencia save = new Persistencia(); //Creo un objeto de clase Persistencia.-
		this.guardar(save.crearRaiz());  //Guardo todos los atributos.-
		save.guardarDocumento();  //Guardo todos los objetos en un XML
		System.out.println("Persistencia finalizada.-");
    	return true;
    }
    
    
	/**M�todo que guarda dentro del elemento asignado por par�metro todos los objetos
	 * de esta clase que se instanciaron en el curso del programa como nuevos elementos
	 * hijos del asignado, solo guarda los atributos de esta "capa de datos", 
	 * si existiera una "capa" mas profunda, delega la tarea a la clase que se encuentre
	 * contenida en esa pr�xima "capa".- 
	 * @param elementoPadre
	 */
	public void guardar(Element elementoPadre){
		/** Tengo que guardar todo esto:
		 *  private Terreno[][] matrizNivel;
			private Personaje[] pooglins;
			private int pooglinsARescatar;
			private int cantidadPooglins;
			private Puerta puertaComienzo;
			private Puerta puertaSalida;
			private Habilidad[] habilidadesDisponibles;
		 * 
		 * */
		//Guardo pooglinsARescatar.-
		Element elementoHijo = elementoPadre.addElement("pooglinsARescatar");
		elementoHijo.addAttribute("valor",( (Integer)pooglinsARescatar).toString() );
		
		//Guardo cantidadPooglins.-
		elementoHijo = elementoPadre.addElement("cantidadPooglins");
		elementoHijo.addAttribute("valor",( (Integer)cantidadPooglins).toString() );
		
		//Guardo la matriz.-
		elementoHijo = elementoPadre.addElement("matrizNivel");
		for (int i = 0 ; i < matrizNivel.length ; i++ ){
			for (int j = 0 ; j < matrizNivel[i].length ; j++ ){
				
				Element elementoHijo2 = elementoHijo.addElement("Terreno");
				elementoHijo2.addAttribute( "x" , ((Integer)i).toString() );
				elementoHijo2.addAttribute( "y" , ((Integer)j).toString() );
				
				Object elemento = matrizNivel[i][j];
				if ( elemento instanceof AgujeroNegro ) {
					elementoHijo2.addAttribute( "tipo" , "AgujeroNegro" );
				}
				if ( elemento instanceof Fuego ) {
					elementoHijo2.addAttribute( "tipo" , "Fuego" );
				}
				if ( elemento instanceof Hielo ) {
					elementoHijo2.addAttribute( "tipo" , "Hielo" );
				}
				if ( elemento instanceof Roca ) {
					elementoHijo2.addAttribute( "tipo" , "Roca" );
				}
				if ( elemento instanceof Tierra ) {
					elementoHijo2.addAttribute( "tipo" , "Tierra" );
				}
				if ( elemento instanceof Vacio ) {
					elementoHijo2.addAttribute( "tipo" , "Vacio" );
				}
			}
		}
		
		//Guardo el vector de pooglins.-
		elementoHijo = elementoPadre.addElement("pooglins");
		for (int i = 0 ; i < pooglins.length ; i++ ){
			Element elementoHijo2 = elementoHijo.addElement("pooglinNumero"+i);
			((Pooglin)pooglins[i]).guardar(elementoHijo2);
		}
				
		//Guardo la puertaComienzo.- 
		elementoHijo = elementoPadre.addElement("puertaComienzo");
		puertaComienzo.guardar(elementoHijo);
		
		//Guardo la puertaSalida.-
		elementoHijo = elementoPadre.addElement("puertaSalida");
		puertaSalida.guardar(elementoHijo);
		
		//Guardo las habilidadesDisponibles.-
		elementoHijo = elementoPadre.addElement("habilidadesDisponibles");
		for (int i = 0 ; i < habilidadesDisponibles.length ; i++ ){
			Element elementoHijo2 = elementoHijo.addElement("habilidadNumero"+i);
	
			Object elemento = habilidadesDisponibles[i];
				if ( elemento instanceof Congelamiento ) {
					elementoHijo2.addAttribute( "tipo" , "Congelamiento" );
				}
				if ( elemento instanceof Morir ) {
					elementoHijo2.addAttribute( "tipo" , "Morir" );
				}
				if ( elemento instanceof Platillo ) {
					elementoHijo2.addAttribute( "tipo" , "Platillo" );
				}
				if ( elemento instanceof RayoLaser ) {
					elementoHijo2.addAttribute( "tipo" , "RayoLaser" );
				}
				if ( elemento instanceof Taladro ) {
					elementoHijo2.addAttribute( "tipo" , "Taladro" );
				}
				if ( elemento instanceof Teletransportarse ) {
					elementoHijo2.addAttribute( "tipo" , "Teletransportarse" );
				}
		}
		
		
	}
	
	
}