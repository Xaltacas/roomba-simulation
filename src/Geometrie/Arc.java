package Geometrie;

public class Arc extends Forme{
	
	private int posX, posY, rayon;
	private float alpha1, alpha2;
	
	public Arc(int x, int y, int nrayon, float nalpha1, float nalpha2){
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
	
	public float getAlpha1() {
		return this.alpha1;
	}
	
	public float getAlpha2() {
		return this.alpha2;
	}
	
	public void move(int nposX, int nposY) {
		this.posX = nposX;
		this.posY = nposY;
	}
}
