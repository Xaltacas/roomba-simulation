package Logique;
import Hardware.Robot;
import java.util.Random;

public class CompAleatoire extends Comportement{
	
	Random rand;
	
	public CompAleatoire() {}
	
	public void move(Robot r) {
		r.move(rand.nextInt(20)-10, rand.nextInt(20)-10, r.getDiametre());
	}

}
