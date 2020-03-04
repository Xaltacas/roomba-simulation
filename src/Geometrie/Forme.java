package Geometrie;

public abstract class Forme {
	
	
	public abstract String toString();
	
	public abstract void move(double posX, double posY, double alpha);
	
	public abstract boolean intersect(Cercle c1);
	
	public abstract boolean intersect(Rectangle r);
	
	public abstract boolean intersect(Arc a);
	
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
	
}
