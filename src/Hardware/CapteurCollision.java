package Hardware;
import Geometrie.Arc;

public class CapteurCollision extends Capteur {
	
	public CapteurCollision(Robot r, int nrayon, float nalpha1, float nalpha2) {
		super(r, new Arc(r.getPosX(),r.getPosY(),nalpha1,nalpha2));
	}
	
	public boolean Collide() {
		this.UpdatePos();
		//TODO
		return true;
	}

}
