package Hardware;
import Piece.Environement;
import Logique.Comportement;

public class Robot {

	private int diametre;
	private int posX;
	private int posY;
	private float alpha;
	private Environement env;
	private Capteur contdroit;
	private Capteur contface;
	private Capteur contmilieu;
	private Capteur sal;
	private Comportement comp;
	
	public Robot(int ndiametre, int nposX,int nposY, Environement nenv, Comportement ncomp) {
		this.diametre = ndiametre;
		this.posX = nposX;
		this.posY = nposY;
		this.env = nenv;
		
		this.comp = ncomp;
		
	}
	
	
	public void move() {
		//TODO
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	public void draw() {
		//TODO
	}
	
	public String toString(){
		return "robot en ["+posX+","+posY+"]";
	}
	public void setComportement() {
		//TODO
	}
	
}
