package Geometrie;

/**
 * 
 * @author Adrien
 *
 *Classe représentant un cercle
 */
public class Cercle extends Forme {
	
	private double posX,posY;
	private double rayon;
	
	/**
	 * 
	 * @param x coordonnée X du centre du cercle
	 * @param y coordonnée Y du centre du cercle
	 * @param nrayon rayon du cercle
	 */
	public Cercle(double x, double y, double nrayon){
		this.posX = x;
		this.posY = y;
		this.rayon = nrayon;
	}
	
	public String toString(){
		return "Cercle de centre ["+posX+","+posY+"] et de rayon " + rayon;
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

	/**
	 * @param nposX nouvelle coordonnée X du centre du cercle
	 * @param nposY nouvelle coordonnée Y du centre du cercle
	 * @param alpha inutile ici
	 * 
	 */
	public void move(double nposX, double nposY,double alpha) {
		this.posX = nposX;
		this.posY = nposY;
	}
	
	/**
	 * @param c Cercle contre lequel on test l'intersection
	 * @return vrai si il y a intersection avec le cercle c, faux sinon
	 */
	public boolean intersect(Cercle c) {
		return ((c.getPosX() - posX) * (c.getPosX() - posX)+
				(c.getPosY() - posY) * (c.getPosY() - posY)
				<= (c.getRayon() + rayon) * (c.getRayon() + rayon));
	}
	
	/**
	 * @param r Rectangle contre lequel on test l'intersection
	 * @return vrai si il y a intersection avec le rectangle r, faux sinon
	 */
	public boolean intersect(Rectangle r) {
		double nearestX = Math.max(r.getPosX(), Math.min(posX, r.getPosX() + r.getLength()));
		double nearestY = Math.max(r.getPosY(), Math.min(posY, r.getPosY() + r.getHeight()));
		
		double deltaX = posX - nearestX;
		double deltaY = posY - nearestY;
		
		return (deltaX * deltaX + deltaY * deltaY) <= (rayon*rayon);
	}
	
	/**
	 * 
	 * @param a Arc contre lequel on test l'intersection
	 * @return vrai si il y a intersection avec l'Arc a, faux sinon
	 */
	public  boolean intersect(Arc a) {
		if((a.getPosX() - posX) * (a.getPosX() - posX)+(a.getPosY() - posY) * (a.getPosY() - posY)
		   <= (a.getRayon() + rayon) * (a.getRayon() + rayon)) {
			double angle = Math.atan2(-(posY - a.getPosY()),posX - a.getPosX());
			angle = normalizeAngle(angle);
			double a1 = normalizeAngle(a.getAlphaRef()+a.getAlpha1());
			double a2 = normalizeAngle(a.getAlphaRef()+a.getAlpha2());
			
			if((angle > a1 && angle < a2) || (a2 < a1 && ( angle > a1 || angle < a2)))
				return true;
		}
		return false;
	}
	
	
	
	
}
