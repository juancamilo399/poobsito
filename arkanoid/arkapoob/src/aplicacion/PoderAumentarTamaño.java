package aplicacion;

public class PoderAumentarTamaņo extends Poder {

	public PoderAumentarTamaņo(Arkapoob tablero, int xPosition, int yPosition) {
		super(tablero, xPosition, yPosition);
		// TODO Auto-generated constructor stub
	}


	public void reactToCollision(Plataforma plataforma) {
		plataforma.aumentarTamaņo();
		tablero.removerPoder(this);
	}

}
