
/**
 * 
 */

/**
 * @author mart
 *
 */
public class Pooglin implements Personaje {

	private int posicionX;
	private int posicionY;
	private int altura;
	private Velocidad velocidad;
	private Habilidad habilidad;
	private boolean habilidadActivada; //me dice si active o no la habilidad
	private boolean vivo;
	

	public Pooglin(int posicionX,int posicionY){
		this.setVivo(true);
		this.setposicionX(posicionX);
		this.setposicionY(posicionY);
		this.setAltura(0);
		this.setHabilidad(null);
		this.velocidad = new Velocidad(Velocidad.Direccion.DERECHA,Velocidad.Modulo.DOS);
		this.setHabilidadActivada(false);
	}
	
	
	/* (non-Javadoc)
	 * @see Personaje#mover()
	 */
	@Override
	public void mover() {
		
		if ( !(this.estaVivo()) && ( (this.velocidad.getDireccion() != (Velocidad.Direccion.ABAJO)  ) ) ){
			// como la condicion de vivo es falsa y no estoy cayendo, en este monento muere
			this.velocidad.setModulo(Velocidad.Modulo.CERO);
		}
		
		if ( velocidad.getDireccion() == Velocidad.Direccion.DERECHA ){
			this.setposicionX(getPosicionX()+1);
		}
		if ( velocidad.getDireccion() == Velocidad.Direccion.IZQUIERDA ){
			this.setposicionX(getPosicionX()-1);
		}
		if ( velocidad.getDireccion() == Velocidad.Direccion.ARRIBA ){
			this.setposicionY(getPosicionY()+1);
		}
		if ( velocidad.getDireccion() == Velocidad.Direccion.ABAJO ){
			this.setposicionY(getPosicionY()-1);
		}
	}
	

	@Override
	public int getPosicionX(){
		return this.posicionX;
	}
	
	@Override
	public void setposicionX(int x){
		this.posicionX = x;
	}
	
	@Override
	public void setposicionY(int y){
		this.posicionY = y;
	}
	
		@Override
	public int getPosicionY(){
		return this.posicionY;
	}

	@Override
	public int getAltura() {
		return this.altura;
	}

	@Override
	public void subirAltura() {
		setAltura(this.altura++);
		return;
	}

	@Override
	public void bajarAltura() {
		setAltura(this.altura--);
		return;
	}

	public void setAltura(int altura) {
		this.altura = altura;
		return;
	}
	
	@Override
	public Habilidad getHabilidad() {
		return this.habilidad;
	}

	@Override
	public void setHabilidad(Habilidad habilidad) {
		this.habilidad = habilidad;
	}
	
	@Override
	public void morir() {
		this.setVivo(false);
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}	
	
	public boolean estaVivo(){
		return this.vivo;		
	}
	
	public boolean isHabilidadActivada() {
		return habilidadActivada;
	}

	public void setHabilidadActivada(boolean habilidadActivada) {
		this.habilidadActivada = habilidadActivada;
	}
	
	public void abrirParacaidas() {
		this.velocidad.setModulo(Velocidad.Modulo.UNO);
		//agrego algo grafico
	}
	
}
