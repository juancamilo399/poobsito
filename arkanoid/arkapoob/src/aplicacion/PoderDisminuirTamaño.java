package aplicacion;

public class PoderDisminuirTamaņo extends Poder {

	public PoderDisminuirTamaņo(Arkapoob tablero, int xPosition, int yPosition) {
		super(tablero, xPosition, yPosition);
		// TODO Auto-generated constructor stub
	}

	public void reactToCollision(Plataforma plataforma) {
		plataforma.disminuirTamaņo();
		tablero.removerPoder(this);
	}

}
