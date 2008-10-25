
/**RayoLaser: clase que permite destruir un terreno Tierra, mediante
 * una serie finita de 4 disparos de Laser. Esta clase, en su método
 * principal evalúa que la resistencia del terreno sea distinta de cero, y 
 * cuando sea cero, quiere decir que el terreno esta destruido y que ya no esta
 * mas activo.-
 * @author lkolaric
 *
 */
public class RayoLaser extends Herramienta {

	public void utilizar(Terreno terreno) {
		if (terreno instanceof Tierra){
			((Tierra) terreno).setResistencia(((Tierra) terreno).getResistencia() - 1);
			if (((Tierra) terreno).getResistencia() == 0){
				terreno.setActivo(false);
			}
		}
	}
	
	public void utilizar(Terreno terreno, Pooglin pooglin){
		
	}
	
}
