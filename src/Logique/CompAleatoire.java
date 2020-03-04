package Logique;
import Hardware.Robot;
import java.util.Random;

public class CompAleatoire extends Comportement{
	
	Random rand;
	
	public CompAleatoire() {
		rand = new Random();
	}
	
	public void move(Robot r) {
		if(r.cdState() || r.cfState() || r.cgState()) {
			r.move(r.getDiametre()/Math.PI, -r.getDiametre()/Math.PI, r.getDiametre());
			r.move(1, 1, r.getDiametre());
			//System.out.println("rotate "+ r.cdState() +" "+ r.cfState() +" "+ r.cgState());
		}else {
			
			r.move((20+rand.nextDouble()*80)/100, (20+rand.nextDouble()*80)/100, r.getDiametre());
		}
	}

}
