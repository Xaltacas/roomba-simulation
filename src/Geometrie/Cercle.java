package Geometrie;

public class Cercle extends Forme {
	
	private double posX,posY;
	private double rayon;
	
	public Cercle(double x, double y, double nrayon){
		this.posX = x;
		this.posY = y;
		this.rayon = nrayon;
	}
	
	public String toString(){
		return "Cercle de centre ["+posX+","+posY+"] et de rayon" + rayon;
	}
	
	public double getPosX() {
		return this.posX;
	}
	
	public double getPosY() {
		return this.posY;
	}
	
	public double getRayon() {
		return this.rayon;
	}

	public void move(double nposX, double nposY,double alpha) {
		this.posX = nposX;
		this.posY = nposY;
	}
	
	public boolean intersect(Cercle c1) {
		return ((c1.getPosX() - posX) * (c1.getPosX() - posX)+
				(c1.getPosY() - posY) * (c1.getPosY() - posY)
				<= (c1.getRayon() + rayon) * (c1.getRayon() + rayon));
	}
	
	public boolean intersect(Rectangle r) {
		double nearestX = Math.max(r.getPosX(), Math.min(posX, r.getPosX() + r.getLength()));
		double nearestY = Math.max(r.getPosY(), Math.min(posY, r.getPosY() + r.getHeight()));
		
		double deltaX = posX - nearestX;
		double deltaY = posY - nearestY;
		
		return (deltaX * deltaX + deltaY * deltaY) <= (rayon*rayon);
	}
	
	public  boolean intersect(Arc a) {
		//todo
		return true;
	}
	
	
	
	
}
