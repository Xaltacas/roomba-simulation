package Hardware;
import Geometrie.Cercle;

public class CapteurSalete extends Capteur{
	
	public CapteurSalete(Robot r,int nrayon) {
		super(r,new Cercle(r.getPosX(),r.getPosY(),nrayon));
	}
	public boolean detect() {
		this.UpdatePos();
		//TODO
		return true;
	}

}
