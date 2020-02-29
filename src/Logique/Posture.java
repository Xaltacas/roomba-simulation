package Logique;

/**
 * Represente la position (coordonnees et orientation) d'un robot a deux roues
 */
public class Posture implements Cloneable
{
  private int x, y;
  private double theta;
  /**
   * Constructeur
   */
  /**
   * Cree une nouvelle posture
   * @param x Coordonnee x initiale
   * @param y Coordonnee y initiale
   * @param theta Angle initial
   */
  public Posture(int x, int y, double theta)
  {
    this.x = x;
    this.y = y;
    this.theta = theta;
  }
  
  // Accesseurs
  public int getX() { return this.x; }
  public int getY() { return this.y; }
  public double getTheta() { return theta; }
  public Object clone() { return new Posture(x, y, theta); }

  /**
   * Fait tourner une posture autour de l'origine du repere
   * @param alpha Angle de la rotation
   */
  public Posture rotate(double alpha)
  {
    double x_ = Math.cos(alpha) * getX() - Math.sin(alpha) * getY();
    double y_ = Math.cos(alpha) * getY() + Math.sin(alpha) * getX();
    x = (int) x_;
    y = (int) y_;
    theta = normalize_angle(alpha + theta);
    return this;
  }
  
  /**
   * Deplace un robot en fonction de la distance parcourue par 
   * chaque roue
   * @param d_l distance parcourue par la roue gauche
   * @param d_r distance parcourue par la roue droite
   * @param ecartRoues distance entre les deux roues
   */
  public Posture move(int d_l, int d_r,
		      int ecartRoues)
  {
    double alpha = (double)(d_r - d_l) / ecartRoues;
    Posture p = null;
    if (alpha > 1e-20  || alpha < -1e-20)
      {
	double r = (d_l / alpha) + (double) ecartRoues / 2;
	double d_x = (Math.cos(alpha) - 1) * r;
	double d_y = Math.sin(alpha) * r;
	p = new Posture((int)d_x,(int) d_y, alpha);
	p.rotate(this.getTheta() - Math.PI / 2);
	p.theta = alpha;
      }
    else
      {
	p = new Posture((int) (d_l * Math.cos(this.getTheta())),
					(int) (d_l * Math.sin(this.getTheta())),
						0);
      }

    this.x += p.x;
    this.y += p.y;
    this.theta = normalize_angle(p.theta + this.theta);

    return this;
  }
  
  /**
   * Methode toString: permet d'afficher la posture
   */
  public String toString()
  {
    return x + " " + y + " " + theta;
  }
  
  /**
   * Convertit un angle pour qu'il soit dans [-PI;PI] (et non dans [0;2*PI] ou ailleurs)
   * @param a Angle a convertir
   * @return L'angle a remis dans [-PI;PI]
   */
  protected double normalize_angle(double a)
  {
    while (a > 2* Math.PI)
      a -= 2 * Math.PI;
    while (a < 0)
      a += 2 * Math.PI;
    return a;
  }  
}