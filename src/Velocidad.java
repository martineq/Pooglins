/**
 * 
 */

/**
 * @author pc
 *
 */
public class Velocidad {

	//sirve para que las otras clases indiquen la direccion
	public enum Direccion {ARRIBA,ABAJO,IZQUIERDA,DERECHA}
	public enum Modulo {CERO,UNO,DOS,TRES}
	 
	private Direccion direccion;
	private Modulo modulo;
	private Modulo avance;  //para saber como venia caminando (en caso de haber caido)
	
	public Velocidad(Direccion direccion,Modulo modulo){
		this.setDireccion(direccion);
		this.setModulo(modulo);
		this.setAvance(modulo);
	}
	
	public void setModulo(Modulo modulo){
		this.modulo = modulo;
	}
	
	public Modulo getModulo(){
		return modulo;
	}
	
	public void setDireccion(Direccion direccion){
		this.direccion = direccion;
	}
	
	public Direccion getDireccion(){
		return this.direccion;
	}

	public void setAvance(Modulo avance) {
		this.avance = avance;
	}

	public Modulo getAvance() {
		return avance;
	}
}
