package Geometrie;

public class Arc extends Forme{
	
	private double posX, posY, rayon;
	private double alpha1, alpha2;
	private double alphaRef; 
	
	public Arc(double x, double y, double nrayon, double nalpha1, double nalpha2){
		this.posX = x;
		this.posY = y;
		this.rayon = nrayon;
		if( nalpha1 < nalpha2 ) {
			this.alpha1 = nalpha1;
			this.alpha2 = nalpha2;
		}
		else {
			this.alpha1 = nalpha2;
			this.alpha2 = nalpha1;
		}

		this.alphaRef = 0;
	}
	
	public String toString(){
		return "arc de centre ["+posX+","+posY+"] de rayon "+rayon+" et de delimiteurs ["+alpha1+","+alpha2+"]";
	}
	
	public double getPosX() {
		return this.posX;
	}
	
	public double getPosY() {
		return this.posY;
	}	
	
	public double getRayon() {
		return this.rayon;
	}
	
	public double getAlpha1() {
		return this.alpha1;
	}
	
	public double getAlpha2() {
		return this.alpha2;
	}
	
	public double getAlphaRef() {
		return this.alphaRef;
	}
	
	public void move(double nposX, double nposY,double alpha) {
		this.posX = nposX;
		this.posY = nposY;
		this.alphaRef = alpha;
	}
	
	public boolean intersect(Cercle c) {
		if((c.getPosX() - posX) * (c.getPosX() - posX)+(c.getPosY() - posY) * (c.getPosY() - posY)
		   <= (c.getRayon() + rayon) * (c.getRayon() + rayon)) {
			
			double angle = Math.atan2(-(c.getPosY() - posY), c.getPosX() - posX);
			if(angle < 0) angle += 2*Math.PI;
			double a1 = (alphaRef+alpha1)%(2*Math.PI);
			double a2 = (alphaRef+alpha2)%(2*Math.PI);
			
			if((angle > a1 && angle < a2) || (a2 < a1 && ( angle > a1 || angle < a2)))
				return true;
		}
		return false;
	}
	
	public boolean intersect(Rectangle r) {
		
		double nearestX = Math.max(r.getPosX(), Math.min(posX, r.getPosX() + r.getLength()));
		double nearestY = Math.max(r.getPosY(), Math.min(posY, r.getPosY() + r.getHeight()));
		
		if(((posX - nearestX) * (posX - nearestX) + (posY - nearestY) * (posY - nearestY))
				<= (rayon*rayon)) {
			double angle = Math.atan2(-(nearestY - posY), nearestX - posX);
			angle = normalizeAngle(angle);
			double a1 = normalizeAngle(alphaRef+alpha1);
			double a2 = normalizeAngle(alphaRef+alpha2);
			
			if((angle > a1 && angle < a2) || (a2 < a1 && ( angle > a1 || angle < a2)))
				return true;
		}
		return false;
	}
	
	public  boolean intersect(Arc a) {
		//not usefull here
		return false;
	}
}
