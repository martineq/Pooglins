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
	
	@Override
	public void utilizar(Personaje personaje) {
		Habilidad morir = ((Pooglin)personaje).getMatarse();
		morir.utilizar(personaje);
	}

	public void utilizar(Terreno terreno, Pooglin pooglin){
		Habilidad morir = pooglin.getMatarse();
		morir.utilizar(pooglin);
		if (terreno instanceof Vacio){
			System.out.println("desactive el terreno 3");			
			terreno.setActivo(false);
			pooglin.sacarHabilidad();
		}	
	}

	@Override
	public String toString(){
		return "Congelamiento";
	}

}
