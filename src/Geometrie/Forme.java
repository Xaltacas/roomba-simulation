package Geometrie;

public abstract class Forme {
	
	
	public abstract String toString();
	
	public abstract void move(int posX, int posY, double alpha);
	
	public boolean intersect(Forme f){
		if (this instanceof Cercle && f instanceof Cercle) {
			Cercle cthis = (Cercle) this;
			Cercle cf = (Cercle) f;
			
			return CCintersect(cthis,cf);
		}
		else if (this instanceof Rectangle && f instanceof Cercle) {
			Rectangle rthis = (Rectangle) this;
			Cercle cf = (Cercle) f;
			
			return CRintersect(cf,rthis);
		}
		else if (f instanceof Rectangle && this instanceof Cercle) {
			Rectangle rf = (Rectangle) f;
			Cercle cthis = (Cercle) this;
			
			return CRintersect(cthis,rf);
		}
		return true;
	}
	
	/**
	 * 
	 * @param c1 Cercle 1 
	 * @param c2 Cercle 2
	 * @return vrai si il y a intersection entre les deux cercle, faux sinon
	 */
	private boolean CCintersect(Cercle c1,Cercle c2) {
		return (Math.pow(c1.getPosX() - c2.getPosX(),2)+
				Math.pow(c1.getPosY() - c2.getPosY(),2)
				<= Math.pow(c1.getRayon() + c2.getRayon(),2));
	}
	
	/**
	 * 
	 * @param c Cercle
	 * @param r Rectangle
	 * @return vrai si il y a intersection entre le cercle et le rectangle, faux sinon
	 */
	private boolean CRintersect(Cercle c,Rectangle r) {
		int nearestX = Math.max(r.getPosX(), Math.min(c.getPosX(), r.getPosX() + r.getLength()));
		int nearestY = Math.max(r.getPosY(), Math.min(c.getPosY(), r.getPosY() + r.getHeight()));
		
		int deltaX = c.getPosX() - nearestX;
		int deltaY = c.getPosY() - nearestY;
		
		return (deltaX * deltaX + deltaY * deltaY) <= (c.getRayon() * c.getRayon());
	}
	
	private boolean ACintersect(Cercle c, Arc a) {
		//TODO
		return true;
		
	}
	
}
