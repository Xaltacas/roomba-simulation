package Geometrie;

public class Rectangle extends Forme{

	private double posX,posY;
	private double length,height;
	
	public Rectangle(double x, double y, double len, double hei){
		this.posX = x;
		this.posY = y;
		this.length = len;
		this.height = hei;
	}
	
	public String toString(){
		return "rectangle de coin ["+posX+","+posY+"] et de hauteur "+height+" et de longeur "+length;
	}
	
	public double getPosX() {
		return this.posX;
	}
	
	public double getPosY() {
		return this.posY;
	}
	
	public double getLength() {
		return this.length;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public void move(double nposX, double nposY, double alpha) {
		this.posX = nposX;
		this.posY = nposY;
	}
	
	
	public boolean intersect(Cercle c) {
		double nearestX = Math.max(posX, Math.min(c.getPosX(), posX + length));
		double nearestY = Math.max(posY, Math.min(c.getPosY(), posY + height));
		
		double deltaX = c.getPosX() - nearestX;
		double deltaY = c.getPosY() - nearestY;
		
		return (deltaX * deltaX + deltaY * deltaY) <= (c.getRayon() * c.getRayon());
	}
	
	public boolean intersect(Rectangle r) {
		//not usefull here
		return false;
	}
	
	public  boolean intersect(Arc a) {
		
		double nearestX = Math.max(posX, Math.min(a.getPosX(), posX + length));
		double nearestY = Math.max(posY, Math.min(a.getPosY(), posY + height));
		
		if(((a.getPosX() - nearestX) * (a.getPosX() - nearestX) + (a.getPosY() - nearestY) * (a.getPosY() - nearestY))
				<= (a.getRayon()*a.getRayon())) {
			double angle = Math.atan2((a.getPosY() - nearestY),-(a.getPosX()-nearestX));
			angle = normalizeAngle(angle);
			double a1 = normalizeAngle(a.getAlphaRef()+a.getAlpha1());
			double a2 = normalizeAngle(a.getAlphaRef()+a.getAlpha2());
			
			if((angle > a1 && angle < a2) || (a2 < a1 && ( angle > a1 || angle < a2)))
				return true;
		}
		return false;
	}
}
