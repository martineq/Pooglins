
/**Representa la habilidad que tiene un pooglin de congelarse.-
 * @author Mart
 * @since 18/10/08
 * 
 */
public class Congelamiento extends Comportamiento {

	public void utilizar(Personaje personaje) {
		Habilidad morir = ((Pooglin)personaje).getMatarse();
		morir.utilizar(personaje);
		//Me parece que en el caso de que use el congelamiento
		//tendría que cambiar el terreno "vacío" por un "hielo" con un setActivo()
		//pero en ese caso necesito el terreno, otra sería que esto lo cambie el Nivel
	}

	public void utilizar(Terreno terreno, Pooglin pooglin){
		
	}

	public void utilizar(Terreno terreno) {
		if (terreno instanceof Vacio){
			terreno.setActivo(false);
		}
	}

}
