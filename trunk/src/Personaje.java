
/**
 * @author mart
 *
 */
public interface Personaje {

	public void mover();
	
	//Martin, te comente los get y los set xq NO VAN DECLARADOS en la
	//interface, tienen que ver con los atributos de la clase y no
	// con los metodos en si...cuando leas esto sacalos y actualiza
	//Guido.-
	
	//public int getPosicionX();
	
	//public void setposicionX(int x);
	
	//public int getPosicionY();
	
	//public void setposicionY(int y);
	
	//public int getAltura(); // Me dice a que "altura del piso se encuentra"
	
	public void subirAltura();
	
	public void bajarAltura();
	
	//public void setHabilidad(Habilidad habilidad );
	
	//public Habilidad getHabilidad();
	
	public void morir();
	
}
