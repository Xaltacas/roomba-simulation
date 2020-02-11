package Geometrie;

public class Arc extends Forme{
	int posX,posY;
	float alpha1,alpha2;
	
	public Arc(int x, int y, float nalpha1, float nalpha2){
		this.posX = x;
		this.posY = y;
		this.alpha1 = nalpha1;
		this.alpha2 = nalpha2;
	}
	
	public String toString(){
		return "arc de centre ["+posX+","+posY+"] et de delimiteurs ["+alpha1+","+alpha2+"]";
	}
	
	public void draw(){
		//TODO
	}
}
