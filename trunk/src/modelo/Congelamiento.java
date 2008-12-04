package modelo;

/**Representa la habilidad que tiene un pooglin de congelarse.-
 * @author Mart
 * @since 18/10/08
 * 
 */
public class Congelamiento extends Comportamiento {

	/**Constructor de Congelamiento.-
	 * @since 18/10/08 
	 */
	public Congelamiento(){
		
	}
	
	public void utilizar(Personaje personaje) {
		Habilidad morir = ((Pooglin)personaje).getMatarse();
		morir.utilizar(personaje);
		//Me parece que en el caso de que use el congelamiento
		//tendría que cambiar el terreno "vacío" por un "hielo" con un setActivo()
		//pero en ese caso necesito el terreno, otra sería que esto lo cambie el Nivel
	}

	public void utilizar(Terreno terreno, Pooglin pooglin){
		Habilidad morir = pooglin.getMatarse();
		morir.utilizar(pooglin);
		
		System.out.println("Utilizo congelamiento");
		System.out.println("en X="+terreno.getPosicionX()+" Y="+terreno.getPosicionY());
		
		if (terreno instanceof Vacio){
			System.out.println("desactive el terreno 3");			
			terreno.setActivo(false);
			pooglin.sacarHabilidad();
		}	
	}

//	public void utilizar(Terreno terreno) {
//		System.out.println("Utilizo congelamiento");
//		System.out.println("en X="+terreno.getPosicionX()+" Y="+terreno.getPosicionY());
//		
//		if (terreno instanceof Vacio){
//			System.out.println("desactive el terreno 2");
//			
//			terreno.setActivo(false);
//		}
//	}
	
	public String toString(){
		return "Congelamiento";
	}

}
