package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.Timer;

import org.dom4j.Element;


/**Clase que representa el campo de juego donde se encuentran los personajes
 * y los distintos tipos de terrenos. Implementa la interfaz Escenario.- 
 * @author guido
 */
public class Nivel implements Escenario, ObjetoVivo {
	private Terreno[][] matrizNivel;
	private int duracionDelJuego;
	
	
	public int getDuracionDelJuego() {
		return duracionDelJuego;
	}

	public void setDuracionDelJuego(int duracionDelJuego) {
		this.duracionDelJuego = duracionDelJuego;
	}

	public Terreno[][] getMatrizNivel() {
		return matrizNivel;
	}


	
	// agrego variables para el tiempo.
	private int tiempoEnSegundos;
	
	
	public int getTiempoEnSegundos() {
		return duracionDelJuego-tiempoEnSegundos;
	}

	private Timer timer;
	
	private Personaje[] pooglins;
	private int pooglinsARescatar;
	private int cantidadPooglins;
	private Puerta puertaComienzo;
	private Puerta puertaSalida;
	
	// hay que sacar  este vector...
	//private Habilidad[] habilidadesDisponibles;
	
	// Agregar el hashmap
	private HashMap habilidadesDisponibles;
	
	// Agregar variable Habilidad
	private Habilidad habilidad;
	
	private int contador = 0;
	
	public void comenzarTiempo(){
		timer = new Timer (1000, new ActionListener ()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	tiempoEnSegundos++;
		     }
		});
		timer.start();
	}
	
	public void terminarTiempo(){
		timer.stop();
	}

	public Habilidad getHabilidad() {
		return habilidad;
	}


	public void setHabilidad(Habilidad habilidad) {
		this.habilidad = habilidad;
	}


	
	public HashMap getHabilidadesDisponibles() {
		return habilidadesDisponibles;
	}


	public void setHabilidadesDisponibles(HashMap habilidades) {
		this.habilidadesDisponibles = habilidades;
	}



	private static Nivel nivel = null;  //Singleton

	
	/**Método getInstance que permite la utilización del
	 * patrón Singleton para la clase Nivel, desde cualquier
	 * lugar de la aplicación puedo obtener una instancia
	 * de esta clase que luego de que se la haya invocado una 
	 * vez, siempre va a ser la misma.
	 * @return
	 */
	public static Nivel getInstance(){
		if ( nivel == null ) nivel = new Nivel();
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
	
	
	/**Ver si el escenario se va a pasar en una lista o como se van
	 * a pasar las cosas para saber como cargamos la matriz etc
	 * Guido.-
	 * Lo dejo comentado y uso el constructor por defecto para
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
		Pooglin pooglin;
		
		if(getTiempoEnSegundos() == 0) System.out.println("Perdiste..");
			
		if(contador < this.pooglins.length){	
			pooglin = (Pooglin)this.pooglins[contador];
			
			if ((pooglin.getPosicionX() == this.puertaComienzo.getPosicionX())&&(pooglin.getPosicionY() == puertaComienzo.getPosicionY())){//si el pooglin actual No esta muerto
				Terreno terrenoActual = revisarNivel(pooglin.getPosicionX(),pooglin.getPosicionY(),pooglin);
				pooglin.vivir();
				terrenoActual.accionarTerreno(pooglin);//ver si voy a devolver un Terreno Guido.-  
				actualizarMatriz(terrenoActual);
			}
			else{
				contador++;
			}
		}
			
			for(int i=0;i<contador;i++){
				pooglin=(Pooglin)this.pooglins[i];
				int posicionX=pooglin.getPosicionX();
				int posicionY=pooglin.getPosicionY();	
								
				if (alcanzoSalida(posicionX,posicionY)){//"Mato" y borro al pooglin que salio.-
					Habilidad matarse=pooglin.getMatarse();
					matarse.utilizar(pooglin);
					pooglin.borrarse();
				}
				
				if (!pooglinMuerto(pooglin)){//si el pooglin actual No esta muerto
					Terreno terrenoActual = revisarNivel(posicionX,posicionY,pooglin);
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

	
	/**
	 * @param posicionX
	 * @param posicionY
	 * @return
	 */
	private boolean estaEnLaEntrada(int posicionX, int posicionY) {
		int coordenadaXpuertaEntrada=this.puertaComienzo.getPosicionX();
		int coordenadaYpuertaEntrada=this.puertaComienzo.getPosicionY();
		if((coordenadaXpuertaEntrada==posicionX)&&(coordenadaYpuertaEntrada==posicionY))
			return true;
		else return false;
	}

	
	/**Método que devuelve el terreno dado por la posición X e Y.
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
				terrenoActual = this.matrizNivel[posicionX+direccion][posicionY];
			}
		}
		
		if(velocidad.getVelocidadY()>0) terrenoActual = this.matrizNivel[posicionX][posicionY+1];
		
		return terrenoActual;
}
		
	
	/**Método encargado de obtener los pooglins cercanos a una
	 * determinada posicion del nivel. Devuelve un ArrayList
	 * que contiene los pooglins que cumplen con esta condición.
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
			
			if((posicionX==posicionXpooglin)&&(posicionY==posicionYpooglin+1)) pooglinsCercanos.add(pooglin);
			if((posicionX==posicionXpooglin+1)&&(posicionY==posicionYpooglin+1)) pooglinsCercanos.add(pooglin);
			if((posicionX==posicionXpooglin-1)&&(posicionY==posicionYpooglin+1)) pooglinsCercanos.add(pooglin);
			//if((posicionY==posicionYpooglin+1)||(posicionY==posicionYpooglin+1)) pooglinsCercanos.add(pooglin);
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
		//hay que acomodar el codigo, esto es provisorio
		//edgardo....
		if((((Pooglin)pooglin).getHabilidad() instanceof Morir)){
			((Pooglin)pooglin).getHabilidad().utilizar(((Pooglin)pooglin));			
			}
		
		if((((Pooglin)pooglin).getHabilidad() != null)&&((Pooglin)pooglin).estaVivo()){
		Terreno terrenoActual = matrizNivel[((Pooglin) pooglin).getPosicionX()][((Pooglin) pooglin).getPosicionY()];
		((Pooglin) pooglin).usarHabilidad(terrenoActual,((Pooglin)pooglin));
		actualizarMatriz(terrenoActual);
		}
		
	}
	
	
	//Seter's agregados automáticamete.-
	/**
	 * @param matrizNivel
	 */
	public void setMatrizNivel(Terreno[][] matrizNivel) {
		this.matrizNivel = matrizNivel;
	}

	
	/**
	 * @param pooglins
	 */
	public void setPooglins(Personaje[] pooglins) {
		this.pooglins = pooglins;
	}

		
	/**
	 * @return
	 */
	public Personaje[] getPooglins() {
		return this.pooglins;
	}

	
	/**
	 * @param pooglinsARescatar
	 */
	public void setPooglinsARescatar(int pooglinsARescatar) {
		this.pooglinsARescatar = pooglinsARescatar;
	}

	
	/**
	 * @return
	 */
	public int getPooglinsARescatar() {
		return this.pooglinsARescatar;
	}

	
	/**
	 * @param cantidadPooglins
	 */
	public void setCantidadPooglins(int cantidadPooglins) {
		this.cantidadPooglins = cantidadPooglins;
	}

	
	/**
	 * @return
	 */
	public int getCantidadPooglins() {
		return this.cantidadPooglins;
	}

	
	/**
	 * @param puertaComienzo
	 */
	public void setPuertaComienzo(Puerta puertaComienzo) {
		this.puertaComienzo = puertaComienzo;
	}
	

	/**
	 * @return
	 */
	public Puerta getPuertaComienzo() {
		return this.puertaComienzo;
	}

	
	/**
	 * @param puertaSalida
	 */
	public void setPuertaSalida(Puerta puertaSalida) {
		this.puertaSalida = puertaSalida;
	}
	
	
	/**
	 * @return
	 */
	public Puerta getPuertaSalida() {
		return this.puertaSalida;
	}
	
	/**
	 * @param habilidadesDisponibles
	 
	public void setHabilidadesDisponibles(Habilidad[] habilidadesDisponibles) {
		this.habilidadesDisponibles = habilidadesDisponibles;
	}
	)/
	
	/**
	 * @return
	 */
	public int getContador() {
		return contador;
	}


	/**
	 * @param contador
	 */
	public void setContador(int contador) {
		this.contador = contador;
	}
	
	
	/**Devuelve el tamaño del largo del nivel en la coordenada x.-
	 * @return int
	 */
	public int getTamanioTerrenoX(){
		return this.matrizNivel.length;  
	}
	
	
	/**Devuelve el tamaño del largo del nivel en la coordenada y.-
	 * @return int
	 */
	public int getTamanioTerrenoY(){
		if ( this.matrizNivel[0] != null ) return this.matrizNivel[0].length;
		else return 0;
			
	}
	
	
	/**Devuelve el terreno en la posición (x,y)
	 * @param x
	 * @param y
	 * @return Terreno
	 */
	public Terreno getTerreno(int x, int y){
		return this.matrizNivel[x][y];
	}
	
	
	/**Devuelve la cantidad de pooglins.-
	 * @return int
	 */
	public int getTamanioPooglins(){
		return this.pooglins.length;
	}
	

	/**Devuelve el i-ésimo pooglin (el primer pooglin es el Nº 0)
	 * @param indice
	 * @return Personaje
	 */
	public Pooglin getPooglin(int indice){
		return (Pooglin)this.pooglins[indice];
	}
	
	
	/**Me indica la "altura del piso" en que se encuentra el personaje.-
     * @since 18/10/08
     * @param pooglin
     * @param campo
     */
    /** private int alturaPooglin(Personaje pooglin) {
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

 
    /**Método que inicia el proceso de el guardado de todos los objetos instanciados
     * para luego exportarlos a un archivo en disco, en formato XML.
     * @author Mart.-
     * @param nombre -> es el nombre del archivo con su extensión (por EJ: "pooglins.xml")
     */
    public boolean guardarXML(String nombre){
    	System.out.println("Saving...");
		Persistencia guarda = new Persistencia(); //Creo un objeto de clase Persistencia.-
		this.guardar(guarda.crearRaiz());  //Guardo todos los atributos.-
		guarda.guardarDocumento(nombre);  //Guardo todos los objetos en un XML
		System.out.println("Saved!!!");
    	return true;
    }

    /**Método que inicia el proceso de carga de todos los objetos guardados
     * en formato XML para luego instanciarlos en memoria.-
     * @author Mart.-
     * @param nombre -> es el nombre del archivo con su extensión (por EJ: "pooglins.xml")
     */
    public boolean cargarXML(String nombre){
    	System.out.println("Loading...");
		Persistencia carga = new Persistencia();  //Creo un objeto de clase Persistencia.-
		this.cargar(carga.cargarRaiz(nombre));  //Cargo todos los atributos.-
		System.out.println("Loaded!!!");
    	return true;
    }    
    

	/**Método que instancia todos los objetos de esta clase, 
	 * solo guarda los atributos de esta "capa de datos", 
	 * si existiera una "capa" mas profunda, delega la tarea
	 * a la clase que se encuentre contenida en esa próxima "capa".- 
	 * @param elementoPadre
	 */
	public void cargar(Element elementoPadre){
		Iterator<?> iter = elementoPadre.elementIterator();
		while( iter.hasNext() ){
			Element elemento = (Element)iter.next();
			String texto = elemento.getName();
			
		   //Cargo matrizNivel.-
		   if ( texto.equals( "matrizNivel" ) ){
				Iterator<?> iter2 = elemento.elementIterator();
				int i = 0; 
				int j = 0;
				while( iter2.hasNext() ){
					Element elementoHijo = (Element)iter2.next();
					if ( (i) < (Integer.parseInt (( elementoHijo.attributeValue("x") )) ) )
						i = Integer.parseInt(( elementoHijo.attributeValue("x") ));
					if ( (j) < (Integer.parseInt(( elementoHijo.attributeValue("y") )) ) )
						j = Integer.parseInt(( elementoHijo.attributeValue("y") ));
				}
				Terreno[][] matrizNiv = new Terreno[i+1][j+1];
				iter2 = elemento.elementIterator();
				i = 0;
				j = 0;
				while( iter2.hasNext() ){
					Element elementoHijo = (Element)iter2.next();
					i = Integer.parseInt((elementoHijo.attributeValue("x")));
					j = Integer.parseInt((elementoHijo.attributeValue("y")));
					String tipo = elementoHijo.attributeValue("tipo");
					if ( tipo.equals( "AgujeroNegro" ) ){
						matrizNiv[i][j] = new AgujeroNegro(i,j);
					}
					if ( tipo.equals( "Fuego" ) ){
						matrizNiv[i][j] = new Fuego(i,j);
					}
					if ( tipo.equals( "Hielo" ) ){
						matrizNiv[i][j] = new Hielo(i,j);
					}
					if ( tipo.equals( "Roca" ) ){
						matrizNiv[i][j] = new Roca(i,j);
					}
					if ( tipo.equals( "Tierra" ) ){
						matrizNiv[i][j] = new Tierra(i,j);
					}
					if ( tipo.equals( "Vacio" ) ){
						matrizNiv[i][j] = new Vacio(i,j);
					}
				}
				this.matrizNivel = matrizNiv;
			}
			
			//Cargo pooglins.-
			if ( texto.equals( "pooglins" ) ){
				Iterator<?> iter2 = elemento.elementIterator();
				int indicePooglin = 0;
				while( iter2.hasNext() ){
					iter2.next();
					indicePooglin++;
				}
				Personaje [] vectorPooglins = new Personaje[indicePooglin];
				iter2 = elemento.elementIterator();
				indicePooglin = 0;
				while( iter2.hasNext() ){
					Element elementoHijo = (Element)iter2.next();
					vectorPooglins[indicePooglin] = new Pooglin(elementoHijo);
					indicePooglin++;
				}
				this.pooglins = vectorPooglins;
			}
			
			//Cargo pooglinsARescatar.-
			if ( texto.equals( "pooglinsARescatar" ) ){
				this.pooglinsARescatar = Integer.parseInt( (elemento.attributeValue("valor")) );
			}
			
			//Cargo cantidadPooglins.-
			if ( texto.equals( "cantidadPooglins" ) ){
				this.pooglinsARescatar = Integer.parseInt( (elemento.attributeValue("valor")) );
			}
			
			//Cargo puertaComienzo.-
			if ( texto.equals( "puertaComienzo" ) ){
				this.puertaComienzo = new Puerta(elemento);
			}
			
			//Cargo puertaSalida.-
			if ( texto.equals( "puertaSalida" ) ){
				this.puertaSalida = new Puerta(elemento);
			}
			
		/*	//Cargo habilidadesDisponibles.-
			if ( texto.equals( "habilidadesDisponibles" ) ){
				Iterator<?> iter2 = elemento.elementIterator();
				int indiceHabilidad = 0;
				while( iter2.hasNext() ){
					iter2.next();
					indiceHabilidad++;
				}
				Habilidad[] vectorHabilidades = new Habilidad[indiceHabilidad];
				iter2 = elemento.elementIterator();
				indiceHabilidad = 0;
				while( iter2.hasNext() ){
					Element elementoHijo = (Element)iter2.next();
					String textoHijo = elementoHijo.attributeValue("tipo");
					if ( textoHijo.equals( "Congelamiento" ) ){
						vectorHabilidades[indiceHabilidad] = new Congelamiento();
					}
					if ( textoHijo.equals( "Morir" ) ){
						vectorHabilidades[indiceHabilidad] = new Morir();
					}
					if ( textoHijo.equals( "Platillo" ) ){
						vectorHabilidades[indiceHabilidad] = new Platillo();
					}
					if ( textoHijo.equals( "RayoLaser" ) ){
						vectorHabilidades[indiceHabilidad] = new RayoLaser();
					}
					if ( textoHijo.equals( "Taladro" ) ){
						vectorHabilidades[indiceHabilidad] = new Taladro();
					}
					if ( textoHijo.equals( "Teletransportarse" ) ){
						vectorHabilidades[indiceHabilidad] = new Teletransportarse();
					}
					if ( textoHijo.equals( "Tunel" ) ){
						vectorHabilidades[indiceHabilidad] = new Tunel();
					}
					indiceHabilidad++;
				}
				this.habilidadesDisponibles = vectorHabilidades; 
			}
*/			
			   //Cargo contador.-
            if ( texto.equals( "contador" ) ) this.contador = Integer.parseInt( (elemento.attributeValue("valor")) );

            //Cargo habilidadesDisponibles.-
            if ( texto.equals( "habilidadesDisponibles" ) ){
                    HashMap<String,String> mapa = new HashMap<String,String>();
                    Iterator<?> iter2 = elemento.elementIterator();
                    while( iter2.hasNext() ){
                            Element elementoHijo = (Element)iter2.next();
                            String textoHijo = elementoHijo.getName();
                            if ( textoHijo.equals( "Congelamiento" ) ) mapa.put( textoHijo , elementoHijo.attributeValue("valor") );
                            if ( textoHijo.equals( "Morir" ) ) mapa.put( textoHijo , elementoHijo.attributeValue("valor") );
                            if ( textoHijo.equals( "Platillo" ) ) mapa.put( textoHijo , elementoHijo.attributeValue("valor") );
                            if ( textoHijo.equals( "RayoLaser" ) ) mapa.put( textoHijo , elementoHijo.attributeValue("valor") );
                            if ( textoHijo.equals( "Taladro" ) ) mapa.put( textoHijo , elementoHijo.attributeValue("valor") );
                            if ( textoHijo.equals( "Teletransportarse" ) ) mapa.put( textoHijo , elementoHijo.attributeValue("valor") );
                            if ( textoHijo.equals( "Tunel" ) ) mapa.put( textoHijo , elementoHijo.attributeValue("valor") );
                    }
                    this.habilidadesDisponibles = mapa;
            
            }
            
            //Cargo habilidad.-
            if ( texto.equals( "habilidad" ) ){
                    String textoHijo = elemento.attributeValue("tipo");
                    if ( textoHijo.equals( "Congelamiento" ) ) this.habilidad = new Congelamiento();
                    if ( textoHijo.equals( "Morir" ) ) this.habilidad = new Morir();
                    if ( textoHijo.equals( "Platillo" ) ) this.habilidad = new Platillo();
                    if ( textoHijo.equals( "RayoLaser" ) ) this.habilidad = new RayoLaser();
                    if ( textoHijo.equals( "Taladro" ) ) this.habilidad = new Taladro();
                    if ( textoHijo.equals( "Teletransportarse" ) ) this.habilidad = new Teletransportarse();
                    if ( textoHijo.equals( "Tunel" ) ) this.habilidad = new Tunel();
            }
            
    } 
}

    
    
	/**Método que guarda dentro del elemento asignado por parámetro todos los objetos
	 * de esta clase que se instanciaron en el curso del programa como nuevos elementos
	 * hijos del asignado, solo guarda los atributos de esta "capa de datos", 
	 * si existiera una "capa" mas profunda, delega la tarea a la clase que se encuentre
	 * contenida en esa próxima "capa".- 
	 * @param elementoPadre
	 */
	public void guardar(Element elementoPadre){
		//Guardo la matriz.-
		Element elementoHijo = elementoPadre.addElement("matrizNivel");
		for (int i = 0 ; i < this.matrizNivel.length ; i++ ){
			for (int j = 0 ; j < this.matrizNivel[i].length ; j++ ){
				Element elementoHijo2 = elementoHijo.addElement("Terreno");
				elementoHijo2.addAttribute( "x" , Integer.toString(i) );
				elementoHijo2.addAttribute( "y" , Integer.toString(j) );
				
				Object elemento = this.matrizNivel[i][j];
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
		for (int i = 0 ; i < this.pooglins.length ; i++ ){
			Element elementoHijo2 = elementoHijo.addElement("pooglinNumero"+i);
			((Pooglin)this.pooglins[i]).guardar(elementoHijo2);
		}
				
		//Guardo pooglinsARescatar.-
		elementoHijo = elementoPadre.addElement("pooglinsARescatar");
		elementoHijo.addAttribute("valor", Integer.toString(this.pooglinsARescatar) );
		
		//Guardo cantidadPooglins.-
		elementoHijo = elementoPadre.addElement("cantidadPooglins");
		elementoHijo.addAttribute("valor", Integer.toString(this.cantidadPooglins) );
		
		//Guardo la puertaComienzo.- 
		elementoHijo = elementoPadre.addElement("puertaComienzo");
		this.puertaComienzo.guardar(elementoHijo);
		
		//Guardo la puertaSalida.-
		elementoHijo = elementoPadre.addElement("puertaSalida");
		this.puertaSalida.guardar(elementoHijo);
		
		/*//Guardo las habilidadesDisponibles.-
		elementoHijo = elementoPadre.addElement("habilidadesDisponibles");
		for (int i = 0 ; i < this.habilidadesDisponibles.length ; i++ ){
			Element elementoHijo2 = elementoHijo.addElement("habilidadNumero"+i);
	
			Object elemento = this.habilidadesDisponibles[i];
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
				if ( elemento instanceof Tunel ) {
					elementoHijo2.addAttribute( "tipo" , "Tunel" );
				}
		}*/
		
		
		//Guardo contador.-
        elementoHijo = elementoPadre.addElement("contador");
        elementoHijo.addAttribute("valor",( (Integer)this.contador).toString() );
        
        
        //Guardo habilidadesDisponibles.- 
        elementoHijo = elementoPadre.addElement("habilidadesDisponibles");
        Element elementoHijo2 = elementoHijo.addElement( "Congelamiento" );
        elementoHijo2.addAttribute( "valor" , (String)this.habilidadesDisponibles.get("Congelamiento") );
        elementoHijo2 = elementoHijo.addElement( "Morir" );
        elementoHijo2.addAttribute( "valor" , (String)this.habilidadesDisponibles.get("Morir") );
        elementoHijo2 = elementoHijo.addElement( "Platillo" );
        elementoHijo2.addAttribute( "valor" , (String)this.habilidadesDisponibles.get("Platillo") );
        elementoHijo2 = elementoHijo.addElement( "RayoLaser" );
        elementoHijo2.addAttribute( "valor" , (String)this.habilidadesDisponibles.get("RayoLaser") );
        elementoHijo2 = elementoHijo.addElement( "Taladro" );
        elementoHijo2.addAttribute( "valor" , (String)this.habilidadesDisponibles.get("Taladro") );
        elementoHijo2 = elementoHijo.addElement( "Teletransportarse" );
        elementoHijo2.addAttribute( "valor" , (String)this.habilidadesDisponibles.get("Teletransportarse") );
        elementoHijo2 = elementoHijo.addElement( "Tunel" );
        elementoHijo2.addAttribute( "valor" , (String)this.habilidadesDisponibles.get("Tunel") );
        
        
        //Guardo habilidad.-
        elementoHijo = elementoPadre.addElement("habilidad");
        Habilidad habilidad = this.habilidad;
        if ( habilidad instanceof Congelamiento ) elementoHijo.addAttribute( "tipo" , "Congelamiento" );
        if ( habilidad instanceof Morir ) elementoHijo.addAttribute( "tipo" , "Morir" );
        if ( habilidad instanceof Platillo ) elementoHijo.addAttribute( "tipo" , "Platillo" );
        if ( habilidad instanceof RayoLaser ) elementoHijo.addAttribute( "tipo" , "RayoLaser" );
        if ( habilidad instanceof Taladro ) elementoHijo.addAttribute( "tipo" , "Taladro" );
        if ( habilidad instanceof Teletransportarse ) elementoHijo.addAttribute( "tipo" , "Teletransportarse" );
        if ( habilidad instanceof Tunel ) elementoHijo.addAttribute( "tipo" , "Tunel" );
}




	public void sacarHabilidad() {
		this.habilidad = null;
		
	}
	
}
