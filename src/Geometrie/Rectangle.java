package Geometrie;

public class Rectangle extends Forme{

	private int posX,posY;
	private int length,height;
	
	public Rectangle(int x, int y, int len, int hei){
		this.posX = x;
		this.posY = y;
		this.length = len;
		this.height = hei;
	}
	
	public String toString(){
		return "rectangle de coin ["+posX+","+posY+"] et de hauteur "+height+" et de longeur"+length;
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	public int getLength() {
		return this.length;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public void move(int nposX, int nposY, double alpha) {
		this.posX = nposX;
		this.posY = nposY;
	}
}
