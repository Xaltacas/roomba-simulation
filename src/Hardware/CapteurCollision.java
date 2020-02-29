package Hardware;
import Geometrie.Arc;
import Piece.Element;

public class CapteurCollision extends Capteur {
	
	public CapteurCollision(Robot r, int nrayon, double nalpha1, double nalpha2) {
		super(r, new Arc(r.getPosX(),nrayon,r.getPosY(),nalpha1,nalpha2));
	}
	
	public boolean collide() {
		this.UpdatePos();
		for(Element elem : robot.getEnv().getElems()) {
			if(this.forme.intersect(elem.getForme()))
				return true;
		}
		return false;
	}

}
