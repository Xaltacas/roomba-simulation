package Hardware;
import Piece.Environement;
import Logique.Comportement;
import Logique.Posture;

public class Robot {

	private int diametre;
	private Environement env;
	private CapteurCollision contdroit;
	private CapteurCollision contface;
	private CapteurCollision contgauche;
	private CapteurSalete sal;
	private Comportement comp;
	private Posture p;
	
	
	public Robot(int ndiametre, int nposX, int nposY, Environement nenv, Comportement ncomp) {
		this.diametre = ndiametre;
		this.env = nenv;
		this.comp = ncomp;
		
		p = new Posture(nposX,nposY,0);
		
		this.contdroit = new CapteurCollision(this, this.diametre/2, -1./2.*Math.PI, -1./6.*Math.PI);
		this.contface = new CapteurCollision(this, this.diametre/2, 1./6.*Math.PI, 11./6.*Math.PI);
		this.contgauche = new CapteurCollision(this, this.diametre/2, 1./6.*Math.PI,  1./2.*Math.PI);
		this.sal = new CapteurSalete(this,5);
		

		
	}
	
	
	public void updatePos() {
		comp.move(this);
		sal.detect();
	}
	
	public void move(double d_l, double d_r) {
		p.move(d_l, d_r, diametre);
	}
	
	public double getPosX() {return this.p.getX();}
	
	public double getPosY() {return this.p.getY();}
	
	public int getDiametre() {return this.diametre;}
	
	public double getAlpha() {return this.p.getTheta();}
	
	public Environement getEnv() {return this.env;}
	
	public boolean cdState() {return contdroit.collide();}
	
	public boolean cfState() {return contface.collide();}
	
	public boolean cgState() {return contgauche.collide();}
	
	public String toString(){return "robot en ["+p.getX()+","+p.getY()+"]";}
	
	public void setComportement(Comportement ncomp) {
		this.comp = ncomp;
	}
}
