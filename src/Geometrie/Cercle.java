package Geometrie;

public class Cercle extends Forme {
	
	private int posX,posY;
	private int rayon;
	
	public Cercle(int x, int y, int nrayon){
		this.posX = x;
		this.posY = y;
		this.rayon = nrayon;
	}
	
	public String toString(){
		return "Cercle de centre ["+posX+","+posY+"] et de rayon" + rayon;
	}
	
	public void draw(){
		//TODO
	}

	public void move(int nposX, int nposY) {
		this.posX = nposX;
		this.posY = nposY;
	}
	
	
	
}
