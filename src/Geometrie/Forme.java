package Geometrie;

public abstract class Forme {
	
	
	public abstract String toString();
	
	public abstract void move(double posX, double posY, double alpha);
	
	public abstract boolean intersect(Cercle c);
	
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
