package modelo;

/**Taladro: Es una herramienta que permite destruir un terreno que sea Tierra.
 * @author lkolaric
 *
 */
public class Taladro extends Herramienta {
	
	private final static int MAX_EXCAVACIONES = 5* Velocidad.VELOCIDAD_NORMAL;
	private int cantidadExcavaciones;
	
	/**
	 * Constructor de Taladro.-
	 */
	public Taladro(){
		this.setCantidadExcavaciones(0);
	}
	
	public void utilizar(Terreno terreno, Pooglin pooglin) {
		if ( this.getCantidadExcavaciones() < MAX_EXCAVACIONES ){
			if (terreno instanceof Tierra){
				this.setCantidadExcavaciones(this.getCantidadExcavaciones() + 1);
				terreno.setActivo(false);
				Velocidad velocidad = ((Pooglin) pooglin).getVelocidad();
				velocidad.setVelocidadY(Velocidad.VELOCIDAD_NORMAL);
				((Pooglin) pooglin).setVelocidad(velocidad);
			}
		}
	}

	/**
	 * @return
	 */
	public int getCantidadExcavaciones() {
		return cantidadExcavaciones;
	}

	/**
	 * @param cantidadExcavaciones
	 */
	public void setCantidadExcavaciones(int cantidadExcavaciones) {
		this.cantidadExcavaciones = cantidadExcavaciones;
	}

}
