package Geometrie;

public class Cercle extends Forme {
	
	int posX,posY,rayon;
		
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

}
