package Geometrie;

/**
 * 
 * @author Adrien
 *
 * Classe représentant un rectangle
 */
public class Rectangle extends Forme{

	private double posX,posY;
	private double length,height;
	
	
	/**
	 * 
	 * @param x coordonnée X du coin superieur gauche 
	 * @param y coordonnée Y du coin superieur gauche 
	 * @param len longueur du rectangle
	 * @param hei hauteur du rectangle
	 */
	public Rectangle(double x, double y, double len, double hei){
		this.posX = x;
		this.posY = y;
		this.length = len;
		this.height = hei;
	}
	
	public String toString(){
		return "rectangle de coin ["+posX+","+posY+"] et de hauteur "+height+" et de longeur "+length;
	}
	
	public double getPosX() {
		return this.posX;
	}
	
	public double getPosY() {
		return this.posY;
	}
	
	public double getLength() {
		return this.length;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	/**
	 * @param nposX nouvelle coordonnée X du coin superieur gauche 
	 * @param nposY nouvelle coordonnée Y du coin superieur gauche 
	 * @param alpha inutile ici
	 * 
	 */
	public void move(double nposX, double nposY, double alpha) {
		this.posX = nposX;
		this.posY = nposY;
	}
	
	/**
	 * @param c Cercle contre lequel on test l'intersection
	 * @return vrai si il y a intersection avec le cercle c, faux sinon
	 */
	public boolean intersect(Cercle c) {
		double nearestX = Math.max(posX, Math.min(c.getPosX(), posX + length));
		double nearestY = Math.max(posY, Math.min(c.getPosY(), posY + height));
		
		double deltaX = c.getPosX() - nearestX;
		double deltaY = c.getPosY() - nearestY;
		
		return (deltaX * deltaX + deltaY * deltaY) <= (c.getRayon() * c.getRayon());
	}
	
	/**
	 * Not yet implemented
	 * 
	 * @param r Rectangle contre lequel on test l'intersection
	 * @return false
	 */
	public boolean intersect(Rectangle r) {
		//not usefull here
		return false;
	}
	
	
	/**
	 * 
	 * @param a Arc contre lequel on test l'intersection
	 * @return vrai si il y a intersection avec l'Arc a, faux sinon
	 */
	public  boolean intersect(Arc a) {
		
		double nearestX = Math.max(posX, Math.min(a.getPosX(), posX + length));
		double nearestY = Math.max(posY, Math.min(a.getPosY(), posY + height));
		
		if(((a.getPosX() - nearestX) * (a.getPosX() - nearestX) + (a.getPosY() - nearestY) * (a.getPosY() - nearestY))
				<= (a.getRayon()*a.getRayon())) {
			double angle = Math.atan2((a.getPosY() - nearestY),-(a.getPosX()-nearestX));
			angle = normalizeAngle(angle);
			double a1 = normalizeAngle(a.getAlphaRef()+a.getAlpha1());
			double a2 = normalizeAngle(a.getAlphaRef()+a.getAlpha2());
			
			if((angle > a1 && angle < a2) || (a2 < a1 && ( angle > a1 || angle < a2)))
				return true;
		}
		return false;
	}
}
