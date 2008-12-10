package modelo;

/**Taladro: Es una herramienta que permite destruir un terreno que sea Tierra.
 * @author lkolaric
 *
 */
public class Taladro extends Herramienta {
	
	private final static int MAX_EXCAVACIONES = 2;//* Velocidad.VELOCIDAD_NORMAL;
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
				cantidadExcavaciones++;
				terreno.setActivo(false);
				Velocidad velocidad = (pooglin).getVelocidad();
				velocidad.setVelocidadY(Velocidad.VELOCIDAD_NORMAL);
				(pooglin).setVelocidad(velocidad);		
			}
		}			
		else{ (pooglin).sacarHabilidad();
		}
	}

	/**
	 * @return int
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

	@Override
	public String toString(){
		return "Taladro";
	}
}
