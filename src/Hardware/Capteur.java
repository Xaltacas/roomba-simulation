package Hardware;
import Geometrie.Forme;

public abstract class Capteur {
	
	protected Robot robot;
	protected Forme forme;
	
	public Capteur(Robot r, Forme f) {
		this.robot = r;
		this.forme = f;
	}
	
	protected void UpdatePos() {
		this.forme.move(robot.getPosX(),robot.getPosY());
	}

}