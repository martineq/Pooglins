


/**RayoLaser: clase que permite destruir un terreno Tierra, mediante
 * una serie finita de 4 disparos de Laser. Esta clase, en su metodo
 * principal evalua que la resitencia del terreno sea distinta de cero, y 
 * cuando sea cero, quiere decir que el terreno esta destruido y que ya no esta
 * mas activo.S
 * @author lkolaric
 *
 */
public class RayoLaser extends Herramienta {

	public void utilizar(Terreno terreno) {
		if (terreno instanceof Tierra){
			if (((Tierra) terreno).getResistencia() == 0){
				terreno.setActivo(false);
			}
		}
	}

	public void utilizar(Terreno terreno, Pooglin pooglin) {
		// TODO Auto-generated method stub
		
	}
	
}
