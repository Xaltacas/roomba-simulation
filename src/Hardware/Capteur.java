package Hardware;
import Geometrie.Forme;
import Piece.Element;


/**
 * 
 * @author Adrien
 *
 *Classe abstraite de représentation des capteurs
 */
public abstract class Capteur {
	
	protected Robot robot;
	protected Forme forme;
	
	/**
	 * 
	 * @param r robot qui possède ce capteur
	 * @param f forme du capteur
	 */
	public Capteur(Robot r, Forme f) {
		this.robot = r;
		this.forme = f;
	}
	
	/**
	 * met a jour la position du capteur par rapport a la position du robot a sui il est ataché
	 */
	protected void UpdatePos() {
		this.forme.move(robot.getPosX(),robot.getPosY(),robot.getAlpha());
	}

}
