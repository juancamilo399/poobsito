package aplicacion;

import java.awt.geom.RectangularShape;
import java.io.*;
/**
 * la clase representa un jugador definido por un nombre, unas vidas ,
 *  un puntaje y una plataforma que puede controlar
 * @author Juan Camilo Rojas & Juan Camilo Angel
 *
 */
public class Jugador implements Serializable{
	private int lives;
	private int score;
	private String name;
	protected Plataforma platform;
	/**
	 * Construye un nuevo objeto de tipo jugador con un valor por defecto de vidas, de puntaje y una plataforma
	 * en una posicion por defecto
	 */
	public Jugador(int x,int y) {
		lives=3;
		score=0;
		platform=new Plataforma(x,y);
	}
	/**
	 * retorna el numero de vida del jugador
	 * @return el numero de vidas del jugador
	 */
	public int getLives() {
		return lives;
	}
	/**
	 * retorna el nombre del jugador como un string	
	 * @return el nombre del jugador
	 */
	public String getName() {
		return name;
	}
	/**
	 * retorna la puntuacion actual del jugador como un entero
	 * @return la puntuacion actual del jugador
	 */
	public int getScore() {
		return score;
	}
	/**
	 * retorna la plataforma que maneja el jugador como un objeto de tipo Plataforma
	 * @return la plataforma que controla el jugador
	 */
	public Plataforma getPlatform() {
		return platform;
	}
	/**
	 * ordena a la plataforma que se mueva a la derecha
	 */
	public void moverPlataformaDerecha() {
		platform.setDx(Plataforma.DERECHA);
	}
	/**
	 * ordena a la plataforma que se mueva a la izquierda
	 */
	public void moverPlataformaIzquierda() {
		platform.setDx(Plataforma.IZQUIERDA);
	}
	/**
	 * mueve la plataforma y verifica si se debe cambiar una plataforma con poder por una normal
	 */
	public void moverPlataforma() {
		comprobarUsos();
		platform.move();
	}
	/**
	 * reduce las vidas del jugador
	 */
	public void setVidas(int vidas) {
		lives=vidas;
	}
	/**
	 * asigna una nueva plataforma a este jugador
	 * @param plataforma la plataforma que se va a asignar
	 */
	public void setPlataforma(Plataforma plataforma) {
		platform=plataforma;
	}
	/**
	 * ordena a la plataforma a verificar si existe una colision  entre la parte derecha de la barra y
	 * la figura entrante
	 * @param inShape la figura entrante
	 * @return true si existe colision;false si no
	 */
	public void reactToCollision(Bola bola) {
		platform.reactToCollision(bola);
	}
	/**
	 * ordena a la plataforma a verificar si existe una colision entre esta y un objeto entrante
	 * @param inShape la figura entrante
	 * @return true si existe colision;false si no
	 */
	public boolean collision(RectangularShape inShape) {
		return platform.collision(inShape);
	}
	/**
	 * a�ade una cantidad al puntaje del jugador
	 * @param puntos la cantidad de puntos a a�adir
	 */
	public void sumarPuntos(int puntos) {
		score+=puntos;
	}
	/**
	 * establece el nombre del jugador
	 * @param name el nombre que se le quiere dar
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * usa la habilidad especial de la plataforma, si la plataforma se queda sin
	 * usos cambia la plataforma por una plataforma normal
	 */
	public void usarHabilidadPlataforma() {
		platform.usarHabilidad();
		comprobarUsos();
		
	}
	
	/**
	 * comprueba si la plataforma aun tiene usos de su habilidad
	 */
	protected void comprobarUsos() {
		if(platform.getUses()==0) {
			platform=new Plataforma(platform.getX(),platform.getY(),platform.getHeight(),platform.getWidth());
		}
	} 
	/**
	 * Describe el comportamiento que tiene un jugador al colisionar
	 * con la plataforma de otro jugador
	 * @param jugador el jugador con el que se genera la colision
	 */
	public void reactToCollision(Jugador jugador) {
		jugador.getPlatform().reactToCollision(platform);
		platform.reactToCollision(jugador.getPlatform());
		Plataforma temp=jugador.getPlatform();
		jugador.setPlataforma(platform);
		setPlataforma(temp);
	}
	/**
	 * detiene la plataforma
	 */
	public void detener() {
		platform.setDx(Plataforma.QUIETO);
	}

}
