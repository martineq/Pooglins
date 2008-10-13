
/**
 * @author mart
 *
 */
public class Velocidad {

	//sirve para que las otras clases indiquen la direccion
	public enum Direccion {ARRIBA,ABAJO,IZQUIERDA,DERECHA}
		 
	private Direccion direccion;
	private int modulo;
	private Direccion avance; //para saber como venia caminando (en caso de haber caido)
	
	public Velocidad(Direccion direccion,int modulo){
		this.setDireccion(direccion);
		this.setModulo(modulo);
		this.setAvance(direccion);
	}
	
	public void setModulo(int modulo){
		this.modulo = modulo;
	}
	
	public int getModulo(){
		return modulo;
	}
	
	public void setDireccion(Direccion direccion){
		this.direccion = direccion;
	}
	
	public Direccion getDireccion(){
		return this.direccion;
	}

	public void setAvance(Direccion avance) {
		this.avance = avance;
	}

	public Direccion getAvance() {
		return avance;
	}
}
