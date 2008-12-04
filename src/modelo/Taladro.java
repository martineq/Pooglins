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
//		System.out.println("ee"+cantidadExcavaciones);
		if ( this.getCantidadExcavaciones() < MAX_EXCAVACIONES ){
//			System.out.println(terreno.getPosicionX() + " " + terreno.getPosicionY());
//			System.out.println(pooglin.getPosicionX() + " " + pooglin.getPosicionY());
			
			if (terreno instanceof Tierra){
//				System.out.println("entre en tierra");
				cantidadExcavaciones++;
				terreno.setActivo(false);
				Velocidad velocidad = ((Pooglin) pooglin).getVelocidad();
				velocidad.setVelocidadY(Velocidad.VELOCIDAD_NORMAL);
				((Pooglin) pooglin).setVelocidad(velocidad);		
			}
		}
				
		else{ ((Pooglin) pooglin).sacarHabilidad();
		System.out.println("saco habilidad");
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

	public String toString(){
		return "Taladro";
	}
}
