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
	
	public boolean intersect(Cercle c) {
		return ((c.getPosX() - posX) * (c.getPosX() - posX)+
				(c.getPosY() - posY) * (c.getPosY() - posY)
				<= (c.getRayon() + rayon) * (c.getRayon() + rayon));
	}
	
	public boolean intersect(Rectangle r) {
		double nearestX = Math.max(r.getPosX(), Math.min(posX, r.getPosX() + r.getLength()));
		double nearestY = Math.max(r.getPosY(), Math.min(posY, r.getPosY() + r.getHeight()));
		
		double deltaX = posX - nearestX;
		double deltaY = posY - nearestY;
		
		return (deltaX * deltaX + deltaY * deltaY) <= (rayon*rayon);
	}
	
	public  boolean intersect(Arc a) {
		if((a.getPosX() - posX) * (a.getPosX() - posX)+(a.getPosY() - posY) * (a.getPosY() - posY)
		   <= (a.getRayon() + rayon) * (a.getRayon() + rayon)) {
			double angle = Math.atan2(posY - a.getPosY(),posX - a.getPosX()) + Math.PI;
			double a1 = (a.getAlphaRef()+a.getAlpha1())%2*Math.PI;
			double a2 = (a.getAlphaRef()+a.getAlpha2())%2*Math.PI;
			
			if((angle > a1 && angle < a2) || (a2 < a1 && ( angle > a1 || angle < a2)))
				return true;
		}
		return false;
	}
	
	
	
	
}
