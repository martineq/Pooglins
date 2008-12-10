package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.dom4j.Element;


/**Clase que representa el campo de juego donde se encuentran los personajes
 * y los distintos tipos de terrenos. Implementa la interfaz Escenario.- 
 * @author guido
 */
public class Nivel implements Escenario, ObjetoVivo {
	private Terreno[][] matrizNivel;
	private int duracionDelJuego;
	private Personaje[] pooglins;
	private int pooglinsARescatar;
	private int cantidadPooglins;
	private Puerta puertaComienzo;
	private Puerta puertaSalida;
	@SuppressWarnings("unchecked")
	private HashMap habilidadesDisponibles;
	private Habilidad habilidad;
	private int cantidadDePooglinQueSalieron = 0;
	private static Nivel nivel = null;  //Singleton
	private int tiempoRestante;
	TiempoEnSegundos tiempo;
	
	
	/**Método getInstance que permite la utilización del
	 * patrón Singleton para la clase Nivel, desde cualquier
	 * lugar de la aplicación puedo obtener una instancia
	 * de esta clase que luego de que se la haya invocado una 
	 * vez, siempre va a ser la misma.
	 * @return Nivel
	 */
	public static Nivel getInstance(){
		if ( nivel == null ) nivel = new Nivel();
		return nivel;
	}
	
	public boolean isCargado(){
		if(pooglins == null) return false;
		else return true;
	}
	
	/**Constructor Privado, para obtener una instancia debe
	 * hacerse mediante el uso de getInstance()dado que Nivel
	 * es un Singleton.
	 * 
	 */
	private Nivel(){
		this.tiempo = TiempoEnSegundos.getInstance();
		this.tiempoRestante = (duracionDelJuego - tiempo.getTiempoEnSegundos());
		//De momento lo defino asi.-	
	}

	public int getDuracionDelJuego() {
		return duracionDelJuego;
	}

	public void setDuracionDelJuego(int duracionDelJuego) {
		this.duracionDelJuego = duracionDelJuego;
	}

	public Terreno[][] getMatrizNivel() {
		return matrizNivel;
	}

	public int getTiempoQueFaltaEnSegundos() {
		this.tiempoRestante = (duracionDelJuego - tiempo.getTiempoEnSegundos());
		return tiempoRestante;
	}
	
	public Habilidad getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(Habilidad habilidad) {
		this.habilidad = habilidad;
	}

	@SuppressWarnings("unchecked") 
	public HashMap getHabilidadesDisponibles() {
		return habilidadesDisponibles;
	}

	@SuppressWarnings("unchecked")
	public void setHabilidadesDisponibles(HashMap habilidades) {
		this.habilidadesDisponibles = habilidades;
	}

	public void vivir() {
		Pooglin pooglin;
	
		if(cantidadDePooglinQueSalieron < this.pooglins.length){	
			pooglin = (Pooglin)this.pooglins[cantidadDePooglinQueSalieron];
			if ((pooglin.getPosicionX() == this.puertaComienzo.getPosicionX())&&(pooglin.getPosicionY() == puertaComienzo.getPosicionY())){//si el pooglin actual No esta muerto
				Terreno terrenoActual = revisarNivel(pooglin);
				pooglin.vivir();
				terrenoActual.accionarTerreno(pooglin);  
				//actualizarMatriz(terrenoActual);
			}
			else{
				cantidadDePooglinQueSalieron++;
			}
		}
			
		for(int i=0;i<cantidadDePooglinQueSalieron;i++){
			pooglin = (Pooglin)this.pooglins[i];
			int posicionX = pooglin.getPosicionX();
			int posicionY = pooglin.getPosicionY();	
						
			if (alcanzoSalida(posicionX,posicionY)){
				Habilidad matarse=pooglin.getMatarse();
				matarse.utilizar(pooglin);
				pooglin.borrarse();
			}
			
			if ((!pooglinMuerto(pooglin))&&(pooglin.getPosicionX()>0)){
				Terreno terrenoActual = revisarNivel(pooglin);
				pooglin.vivir();
				if(cantidadDePooglinQueSalieron < this.pooglins.length) pooglin.vivir();
				terrenoActual.accionarTerreno(pooglin);
				actualizarMatriz(terrenoActual);
				activarHabilidad(pooglin);
			}	
			else {
			sacarPooglinMuerto(pooglin);
			}
					
		}
	}

	/**
	 * @param posicionX
	 * @param posicionY
	 * @return boolean
	 */
	@SuppressWarnings("unused")
	private boolean estaEnLaEntrada(int posicionX, int posicionY) {
		int coordenadaXpuertaEntrada=this.puertaComienzo.getPosicionX();
		int coordenadaYpuertaEntrada=this.puertaComienzo.getPosicionY();
		if((coordenadaXpuertaEntrada==posicionX)&&(coordenadaYpuertaEntrada==posicionY))
			return true;
		else return false;
	}

	/**Método que devuelve el terreno dado por la posición X e Y.
	 * @return Terreno
	 */
	public Terreno revisarNivel(Personaje pooglin){
		Velocidad velocidad=((Pooglin)pooglin).getVelocidad();
		int posicionX =((Pooglin)pooglin).getPosicionX();
		int posicionY =((Pooglin)pooglin).getPosicionY();
		
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
	 * @return Collection
	 */
	@SuppressWarnings("unchecked")
	public Collection obtenerPooglinsCercanos(int posicionX,int posicionY){
		Collection pooglinsCercanos= new ArrayList();
		for(int i=0;i<this.pooglins.length;i++){
			Pooglin pooglin= (Pooglin)this.pooglins[i];
			int posicionXpooglin=pooglin.getPosicionX();
			int posicionYpooglin=pooglin.getPosicionY();
			
			if((posicionX==posicionXpooglin)&&(posicionY==posicionYpooglin+1)) pooglinsCercanos.add(pooglin);
			if((posicionX==posicionXpooglin+1)&&(posicionY==posicionYpooglin+1)) pooglinsCercanos.add(pooglin);
			if((posicionX==posicionXpooglin-1)&&(posicionY==posicionYpooglin+1)) pooglinsCercanos.add(pooglin);
		}

		return pooglinsCercanos;
	}
	
	/**Metodo publico que decide si debe o no terminarse el juego
	 * en cada uno de los turnos. Si la cantidad de 
	 * pooglins que quedan vivos es 0 y la cantidad de pooglins a 
	 * rescatar no lo es, decide que debe terminarse el juego, en 
	 * caso contrario, el juego continua.
	 * @return boolean
	 */
	public boolean juegoPerdido(){
		if (((this.cantidadPooglins == 0)&&(this.pooglinsARescatar != 0))||(nivel.getTiempoQueFaltaEnSegundos() == 0)) return true;
		return false;
	}
	
	
	public boolean juegoGanado(){
		if (this.pooglinsARescatar == 0) return true;
		return false;
	}
	
	/**Metodo privado que chequea si el pooglin actual alcanzo
	 * la salida y disminuye la cantidad de pooglins a rescatar
	 * asi como tambien la cantidad de pooglins en el nivel.-
	 * @param posicionX
	 * @param posicionY
	  * @return boolean
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
	
	private void sacarPooglinMuerto(Personaje pooglin){
		boolean revisado = ((Pooglin)pooglin).estaRevisado();
		if ((!revisado)){
			this.cantidadPooglins--;
			((Pooglin)pooglin).setRevisado(true);
			((Pooglin)pooglin).borrarse();
		}
	}
	
	private boolean pooglinMuerto(Personaje pooglin){
		boolean estaVivo=((Pooglin)pooglin).estaVivo();
		if ((!estaVivo)){ 
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
		if(((Pooglin)pooglin).getHabilidad() == null)  return;
		String nombreHabilidad= ((Pooglin)pooglin).getHabilidad().getClass().getName();
		if ((!nombreHabilidad.equals("modelo.Taladro"))&&(!nombreHabilidad.equals("modelo.RayoLaser"))&&(!nombreHabilidad.equals("modelo.Platillo"))){
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
	 * @return Personaje[]
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
	 * @return int
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
	 * @return int
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
	 * @return Puerta
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
	 * @return Puerta
	 */
	public Puerta getPuertaSalida() {
		return this.puertaSalida;
	}
	
	/**
	 * @return int
	 */
	public int getContador() {
		return cantidadDePooglinQueSalieron;
	}

	/**
	 * @param contador
	 */
	public void setContador(int contador) {
		this.cantidadDePooglinQueSalieron = contador;
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
	 * @return Pooglin
	 */
	public Pooglin getPooglin(int indice){
		return (Pooglin)this.pooglins[indice];
	}
	


    /**Método que inicia el proceso de el guardado de todos los objetos instanciados
     * para luego exportarlos a un archivo en disco, en formato XML.
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
	@SuppressWarnings("unchecked")
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
					if ( tipo.equals( "AgujeroNegro" ) ) matrizNiv[i][j] = new AgujeroNegro(i,j);
					if ( tipo.equals( "Fuego" ) ) matrizNiv[i][j] = new Fuego(i,j);
					if ( tipo.equals( "Hielo" ) ) matrizNiv[i][j] = new Hielo(i,j);
					if ( tipo.equals( "Roca" ) ) matrizNiv[i][j] = new Roca(i,j);
					if ( tipo.equals( "Tierra" ) ) matrizNiv[i][j] = new Tierra(i,j);
					if ( tipo.equals( "Vacio" ) ) matrizNiv[i][j] = new Vacio(i,j);
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
				Pooglin [] vectorPooglins = new Pooglin[indicePooglin];
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
			if ( texto.equals( "pooglinsARescatar" ) ) this.pooglinsARescatar = Integer.parseInt( (elemento.attributeValue("valor")) );
			
			//Cargo cantidadPooglins.-
			if ( texto.equals( "cantidadPooglins" ) ) this.cantidadPooglins = Integer.parseInt( (elemento.attributeValue("valor")) );
			
			//Cargo puertaComienzo.-
			if ( texto.equals( "puertaComienzo" ) ) this.puertaComienzo = new Puerta(elemento);
			
			//Cargo puertaSalida.-
			if ( texto.equals( "puertaSalida" ) ) this.puertaSalida = new Puerta(elemento);
			
		
			//Cargo contador.-
            if ( texto.equals( "contador" ) ) this.cantidadDePooglinQueSalieron = Integer.parseInt( (elemento.attributeValue("valor")) );

            //Cargo habilidadesDisponibles.-
            if ( texto.equals( "habilidadesDisponibles" ) ){
                    HashMap mapa = new HashMap();
                    Iterator<?> iter2 = elemento.elementIterator();
                    while( iter2.hasNext() ){
                            Element elementoHijo = (Element)iter2.next();
                            String textoHijo = elementoHijo.getName();
                            if ( textoHijo.equals( "Congelamiento" ) ) mapa.put( textoHijo , Integer.parseInt( (elementoHijo.attributeValue("valor")) ) );
                            if ( textoHijo.equals( "Morir" ) ) mapa.put( textoHijo , Integer.parseInt( (elementoHijo.attributeValue("valor")) ) );
                            if ( textoHijo.equals( "Platillo" ) ) mapa.put( textoHijo , Integer.parseInt( (elementoHijo.attributeValue("valor")) ) );
                            if ( textoHijo.equals( "RayoLaser" ) ) mapa.put( textoHijo , Integer.parseInt( (elementoHijo.attributeValue("valor")) ) );
                            if ( textoHijo.equals( "Taladro" ) ) mapa.put( textoHijo , Integer.parseInt( (elementoHijo.attributeValue("valor")) ) );
                            if ( textoHijo.equals( "Teletransportarse" ) ) mapa.put( textoHijo , Integer.parseInt( (elementoHijo.attributeValue("valor")) ) );
                            if ( textoHijo.equals( "Tunel" ) ) mapa.put( textoHijo , Integer.parseInt( (elementoHijo.attributeValue("valor")) ) );
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
                    if ( textoHijo.equals( "null" ) ) this.habilidad = null;
            } 
         
          //Cargo duracionDelJuego.-
            if ( texto.equals( "duracionDelJuego" ) ) this.duracionDelJuego = Integer.parseInt( (elemento.attributeValue("valor")) );   
            
          //Cargo tiempoRestante.-
          if ( texto.equals( "tiempoRestante" ) ) this.tiempoRestante = Integer.parseInt( (elemento.attributeValue("valor")) );   
 
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
				if ( elemento instanceof AgujeroNegro ) elementoHijo2.addAttribute( "tipo" , "AgujeroNegro" );
				if ( elemento instanceof Fuego ) elementoHijo2.addAttribute( "tipo" , "Fuego" );
				if ( elemento instanceof Hielo ) elementoHijo2.addAttribute( "tipo" , "Hielo" );
				if ( elemento instanceof Roca ) elementoHijo2.addAttribute( "tipo" , "Roca" );
				if ( elemento instanceof Tierra ) elementoHijo2.addAttribute( "tipo" , "Tierra" );
				if ( elemento instanceof Vacio ) elementoHijo2.addAttribute( "tipo" , "Vacio" );
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
		
		//Guardo contador.-
        elementoHijo = elementoPadre.addElement("contador");
        elementoHijo.addAttribute("valor",( (Integer)this.cantidadDePooglinQueSalieron).toString() );
        
        //Guardo habilidadesDisponibles.- 
        elementoHijo = elementoPadre.addElement("habilidadesDisponibles");
        Element elementoHijo2 = elementoHijo.addElement( "Congelamiento" );
        elementoHijo2.addAttribute( "valor" , ( this.habilidadesDisponibles.get("Congelamiento")).toString() );
        elementoHijo2 = elementoHijo.addElement( "Morir" );
        elementoHijo2.addAttribute( "valor" , ( this.habilidadesDisponibles.get("Morir") ).toString() );
        elementoHijo2 = elementoHijo.addElement( "Platillo" );
        elementoHijo2.addAttribute( "valor" , ( this.habilidadesDisponibles.get("Platillo") ).toString() );
        elementoHijo2 = elementoHijo.addElement( "RayoLaser" );
        elementoHijo2.addAttribute( "valor" ,  ( this.habilidadesDisponibles.get("RayoLaser") ).toString() );
        elementoHijo2 = elementoHijo.addElement( "Taladro" );
        elementoHijo2.addAttribute( "valor" ,  ( this.habilidadesDisponibles.get("Taladro") ).toString() );
        elementoHijo2 = elementoHijo.addElement( "Teletransportarse" );
        elementoHijo2.addAttribute( "valor" ,  ( this.habilidadesDisponibles.get("Teletransportarse") ).toString() );
        elementoHijo2 = elementoHijo.addElement( "Tunel" );
        elementoHijo2.addAttribute( "valor" ,  ( this.habilidadesDisponibles.get("Tunel") ).toString() );
        
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
        if ( habilidad == null ) elementoHijo.addAttribute( "tipo" , "null" );
        
        //Guardo duracionDelJuego.-
		elementoHijo = elementoPadre.addElement("duracionDelJuego");
		elementoHijo.addAttribute("valor", Integer.toString(this.duracionDelJuego) );
		
		//Guardo tiempoRestante.-
		elementoHijo = elementoPadre.addElement("tiempoRestante");
		elementoHijo.addAttribute("valor", Integer.toString(this.tiempoRestante) );
	}

	public void sacarHabilidad() {
		this.habilidad = null;
	}
}
