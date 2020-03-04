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
		return "rectangle de coin ["+posX+","+posY+"] et de hauteur "+height+" et de longeur"+length;
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
		double nearestX = Math.max(posX, Math.min(c.getPosX(), posX + length));//395
		double nearestY = Math.max(posY, Math.min(c.getPosY(), posY + height));//126
		
		double deltaX = c.getPosX() - nearestX;//-17
		double deltaY = c.getPosY() - nearestY;//0
		
		return (deltaX * deltaX + deltaY * deltaY) <= (c.getRayon() * c.getRayon());
	}
	
	public boolean intersect(Rectangle r) {
		//not usefull here
		return false;
	}
	
	public  boolean intersect(Arc a) {
		//todo
		return true;
	}
}
