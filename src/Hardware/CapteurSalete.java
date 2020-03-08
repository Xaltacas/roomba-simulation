package Hardware;
import java.awt.Color;

import Geometrie.Cercle;
import Piece.Element;
import Piece.Tache;

/**
 * 
 * @author Adrien
 *
 */
public class CapteurSalete extends Capteur{
	
	/**
	 * 
	 * @param r robot qui possède ce capteur
	 * @param nrayon rayon du capteur
	 */
	public CapteurSalete(Robot r,int nrayon) {
		super(r,new Cercle(r.getPosX(),r.getPosY(),nrayon));
	}
	
	/**
	 * 
	 * @return vrai si le robot a aspiré une saleté
	 */
	public boolean detect() {
		this.UpdatePos();
		for(Element elem : robot.getEnv().getElems()) {
			if(elem instanceof Tache && this.forme.intersect(elem.getForme())) {
				Tache et = (Tache) elem;
				if(elem.getColor() != Color.white) {
					System.out.println(robot.toString());
					System.out.println("detection de " + elem.toString()+" le robot l'a nettoyée");
				}
				et.aspirer();
				return true;
			}
		}
		return true;
	}

}
