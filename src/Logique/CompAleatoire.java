package Logique;
import Hardware.Robot;
import java.util.Random;

public class CompAleatoire extends Comportement{
	
	Random rand;
	boolean rotating;
	int rotatecpt;
	
	public CompAleatoire() {
		rand = new Random();
		rotating = false;
	}
	
	public void move(Robot r) {
		boolean cdState = r.cdState();
		boolean cfState = r.cfState();
		boolean cgState = r.cgState();
		
		if((cdState || cfState || cgState) && !rotating) {
			System.out.println("le "+r.toString()+" a detecté un obstacle et commence a tourner.");
			rotating = true;
			rotatecpt = 0;
			//System.out.println("rotate "+ cdState +" "+ cfState +" "+ cgState);
		}
		else if(rotating){
			//System.out.println(rotatecpt);
			if (rotatecpt < 60) 
				r.move(1, -1);
			else if(rotatecpt < 65)
				r.move(1, 1);
			else rotating =false;
			rotatecpt++;
		}
		else{
			r.move((20+rand.nextDouble()*80)/100, (20+rand.nextDouble()*80)/100);
		}
	}

}
