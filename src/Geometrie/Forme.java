package Geometrie;

public abstract class Forme {
	
	public abstract void draw();
	
	public abstract String toString();
	
	public abstract void move(int posX, int posY);
	
	public boolean intersect(Forme f){
		//TODO	
		return true;
	}
	
}
