package Simulateur;
import java.awt.*;
import javax.swing.*;
import Piece.Environement;
import Piece.Element;
import Piece.Obstacle;
import Geometrie.Cercle;
import  java.lang.*;

/**
 * 
 * Class représentant un environement composé de murs d'Elements et d'un robot dans un JPanel 
 *
 */
public class IHMRoomba extends JPanel {
	
	//Attribut
	private Environement env;

	
	//Constructeur 
	/**
	 * Constructeur
	 */
	/**
	 * @param nenv environement à afficher
	 */
	IHMRoomba (Environement nenv){
		this.env = nenv;
	}
	/**
	 * Fonction appelée automatiquement quand JPanel est redesine a l'ecrant 
	 * permet l'affichage des differents Elements
	 */
	
	public void paint(Graphics g) {
		super.paint(g); // Dessine le contenu d'un panel
		Graphics2D g2 = (Graphics2D) g;
		
		// ajoute les éléments dans la fenetre 
		for (int i =0; i<env.getElems().size();i++) {  
			// Test l'instanciation de la forme de l'element dans le tableau d'element
			if(env.getElems().get(i).getForme() instanceof Cercle) { 
				// re-instancie la forme de l'Element pour pouvoir faire appel aux methdodes de la classe 
				Cercle ncercle = (Cercle) env.getElems().get(i).getForme(); 
				// récupération de la couleur de l'Element
				if (env.getElems().get(i) instanceof Obstacle) {
					g2.setColor(env.getElems().get(i).getColor()); 
					// dessine un disque plein
					g2.fillOval((int)ncercle.getPosX()- (int) ncercle.getRayon(),(int)ncercle.getPosY() - (int) ncercle.getRayon(),(int) ncercle.getRayon()*2,(int)ncercle.getRayon()*2);
					g2.setColor(Color.black );
					//dessine le contour du cercle
					g2.drawOval((int)ncercle.getPosX()- (int) ncercle.getRayon(),(int)ncercle.getPosY() - (int) ncercle.getRayon(),(int) ncercle.getRayon()*2,(int)ncercle.getRayon()*2);
				
				}else {
					g2.setColor(env.getElems().get(i).getColor()); 
					// dessine un disque plein
					g2.fillOval((int)ncercle.getPosX()- (int) ncercle.getRayon(),(int)ncercle.getPosY() - (int) ncercle.getRayon(),(int) ncercle.getRayon()*2,(int)ncercle.getRayon()*2);
				}
			}
			// même méthode dans le cas d'un Element rectangulaire
			else if (env.getElems().get(i).getForme() instanceof Geometrie.Rectangle) {
				Geometrie.Rectangle nrect = (Geometrie.Rectangle) env.getElems().get(i).getForme();
				g2.fillRect((int)nrect.getPosX(),(int)nrect.getPosY(),(int) nrect.getLength(),(int)nrect.getHeight());
				g2.setColor(Color.black );
				g2.drawRect((int)nrect.getPosX(),(int)nrect.getPosY(),(int) nrect.getLength(),(int)nrect.getHeight());
			}
			
			//Dessin du corps du Robot
			g2.setColor(Color.red);
			g2.fillOval((int)env.getRobot().getPosX() - env.getRobot().getDiametre()/2,(int)env.getRobot().getPosY()- env.getRobot().getDiametre()/2, env.getRobot().getDiametre(), env.getRobot().getDiametre());
			g2.setColor(Color.black );
			g2.drawOval((int)env.getRobot().getPosX() - env.getRobot().getDiametre()/2,(int)env.getRobot().getPosY()- env.getRobot().getDiametre()/2, env.getRobot().getDiametre(), env.getRobot().getDiametre());
			
			// Dessin des roues du Robot
			double alpha = env.getRobot().getAlpha();
			int XA = (int)env.getRobot().getPosX();
			int YA = (int)env.getRobot().getPosY();
			double s = Math.sin(alpha+Math.PI/2);
			double c = Math.cos(alpha+Math.PI/2);
			int d = env.getRobot().getDiametre();
			
			int[] X1 = {(int)(XA-c*13*d/24+d*s/4),(int)(XA-c*d/3+d*s/4),(int)(XA-c*d/3-d*s/4),(int)(XA-c*13*d/24-d*s/4)};
			int[] Y1 = {(int)(YA-s*13*d/24-d*c/4),(int)(YA-s*d/3-d*c/4),(int)(YA-s*d/3+d*c/4),(int)(YA-s*13*d/24+d*c/4)};
			
			int[] X2 = {(int)(XA+c*13*d/24+d*s/4),(int)(XA+c*d/3+d*s/4),(int)(XA+c*d/3-d*s/4),(int)(XA+c*13*d/24-d*s/4)};
			int[] Y2 = {(int)(YA+s*13*d/24-d*c/4),(int)(YA+s*d/3-d*c/4),(int)(YA+s*d/3+d*c/4),(int)(YA+s*13*d/24+d*c/4)};
			
			g2.fillPolygon(X1, Y1, 4);
			g2.fillPolygon(X2, Y2, 4);
			
			// dessin de la ligne d'orientaion du Robot
			g2.drawLine(XA, YA, (int)(XA+d/2*s), (int)(YA-d/2*c));
			
			
		}
		
	}
	
	
}
