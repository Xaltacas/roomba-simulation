package Hardware;
import Geometrie.*;
import Piece.Element;

public class CapteurCollision extends Capteur {
	
	public CapteurCollision(Robot r, double nrayon, double nalpha1, double nalpha2) {
		super(r, new Arc(r.getPosX(),r.getPosY(),nrayon,nalpha1,nalpha2));
	}
	
	public boolean collide() {
		this.UpdatePos();
		/*
		for(Element elem : robot.getEnv().getElems()) {
			if(this.forme.intersect(elem.getForme()))
				return true;
		}
		*/
		for(Element elem : robot.getEnv().getElems()) {
			if(elem.getForme().intersect(new Cercle(robot.getPosX(),robot.getPosY(),robot.getDiametre()/2))) {
				System.out.println("robot   " + robot.toString());
				System.out.println("capteur   " + forme.toString());
				
				System.out.println("collision avec " + elem.toString());
				return true;
			}
		}
		
		return false;
	}

}
