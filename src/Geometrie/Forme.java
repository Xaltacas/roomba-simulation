package Geometrie;

/**
 * 
 * @author Adrien
 * 
 * Classe abstraite de repr�sentation des formes
 *
 */
public abstract class Forme {
	
	
	public abstract String toString();
	
	public abstract void move(double posX, double posY, double alpha);
	
	public abstract boolean intersect(Cercle c);
	
	public abstract boolean intersect(Rectangle r);
	
	public abstract boolean intersect(Arc a);
	
	/**
	 * 
	 * @param f forme contre laquelle on teste l'intersection
	 * @return vrai si il y a intersection avec cette forme, faux sinon
	 */
	public boolean intersect(Forme f) {
		if (f instanceof Cercle) {
			Cercle cf = (Cercle) f;
			
			return this.intersect(cf);
		}
		else if (f instanceof Rectangle) {
			Rectangle rf = (Rectangle) f;
			
			return this.intersect(rf);
		}
		else if (f instanceof Arc) {
			Arc af = (Arc) f;
			
			return this.intersect(af);
		}
		return true;
	}
	
	/**
	 * 
	 * @param angle angle a normaliser
	 * @return l'angle normalis� entre 0 et 2*pi
	 */
	protected double normalizeAngle(double angle) {
		double res = angle;
		
		while(res < 0) {
			res += Math.PI*2;
		}
		while(res >= 2*Math.PI) {
			res -= Math.PI*2;
		}
		return res;
	}
	
}
