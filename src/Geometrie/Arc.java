package Geometrie;

public class Arc extends Forme{
	
	private int posX, posY, rayon;
	private double alpha1, alpha2;
	
	public Arc(int x, int y, int nrayon, double nalpha1, double nalpha2){
		this.posX = x;
		this.posY = y;
		this.rayon = nrayon;
		this.alpha1 = nalpha1;
		this.alpha2 = nalpha2;
	}
	
	public String toString(){
		return "arc de centre ["+posX+","+posY+"] de rayon "+rayon+" et de delimiteurs ["+alpha1+","+alpha2+"]";
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}	
	
	public int getRayon() {
		return this.rayon;
	}
	
	public double getAlpha1() {
		return this.alpha1;
	}
	
	public double getAlpha2() {
		return this.alpha2;
	}
	
	public void move(int nposX, int nposY,double alpha) {
		this.posX = nposX;
		this.posY = nposY;
		this.alpha1 += alpha;
		this.alpha1 %= 2*Math.PI;
		this.alpha2 += alpha;
		this.alpha2 %= 2*Math.PI;
	}
}
