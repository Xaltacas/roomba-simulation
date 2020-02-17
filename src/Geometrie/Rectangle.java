package Geometrie;

public class Rectangle extends Forme{

	private int posX,posY;
	private int lenght,height;
	
	public Rectangle(int x, int y, int len, int hei){
		this.posX = x;
		this.posY = y;
		this.lenght = len;
		this.height = hei;
	}
	
	public String toString(){
		return "rectangle de coin ["+posX+","+posY+"] et de hauteur "+height+" et de longeur"+lenght;
	}
	
	public void draw(){
		//TODO
	}
	
	public void move(int nposX, int nposY) {
		this.posX = nposX;
		this.posY = nposY;
	}
}
