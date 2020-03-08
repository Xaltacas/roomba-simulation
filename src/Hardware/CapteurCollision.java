package Hardware;
import Geometrie.*;
import Piece.Element;

/**
 * 
 * @author Adrien
 *
 *classe représentant un capteur de collision
 */
public class CapteurCollision extends Capteur {
	
	/**
	 * 
	 * @param r robot qui possède ce capteur
	 * @param nrayon rayon du cercle
	 * @param nalpha1 angle en radian du début de l'arc
	 * @param nalpha2 angle en radian de la fin de l'arc
	 */
	public CapteurCollision(Robot r, double nrayon, double nalpha1, double nalpha2) {
		super(r, new Arc(r.getPosX(),r.getPosY(),nrayon,nalpha1,nalpha2));
	}
	
	/**
	 * 
	 * @return vrai si il y a collision avec l'un des element de l'environnement du robot, faux sinon
	 */
	public boolean collide() {
		this.UpdatePos();
		for(Element elem : robot.getEnv().getElems()) {
			if(elem.getIsSolid() && this.forme.intersect(elem.getForme())) {
				//System.out.println(robot.toString());
				//System.out.println("capteur   " + forme.toString());
				
				//System.out.println("collision avec " + elem.toString());
				return true;
			}
		}
		
		return false;
	}

}
