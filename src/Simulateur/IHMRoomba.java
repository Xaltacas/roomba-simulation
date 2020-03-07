package Simulateur;
import java.awt.*;
import javax.swing.*;
import Piece.Environement;
import Piece.Element;
import Geometrie.Cercle;
import  java.lang.*;
public class IHMRoomba extends JPanel {
	
	//Attribut
	private Environement env;
	private int prev_x;
	private int prev_y;
	
	
	//Constructeur 
	
	IHMRoomba (Environement nenv){
		this.env = nenv;
	
		/*this.ma_fenetre = new JFrame();
		this.ma_fenetre.setTitle("roomba simulation");
		this.ma_fenetre.setSize(env.getSizeX(),env.getSizeY());
		this.ma_fenetre.setLocationRelativeTo(null);
		this.ma_fenetre.setResizable(false);
		this.ma_fenetre.setBackground(Color.white);
		this.ma_fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.ma_fenetre.setVisible(true);*/
		
	}
	
	
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		
		
		for (int i =0; i<env.getElems().size();i++) { // ajoute les éléments 
			
			
			if(env.getElems().get(i).getForme() instanceof Cercle) {
				Cercle ncercle = (Cercle) env.getElems().get(i).getForme();
				g2.setColor(env.getElems().get(i).getColor());
				g2.fillOval((int)ncercle.getPosX()- (int) ncercle.getRayon(),(int)ncercle.getPosY() - (int) ncercle.getRayon(),(int) ncercle.getRayon()*2,(int)ncercle.getRayon()*2);
				g2.setColor(Color.black );
				g2.drawOval((int)ncercle.getPosX()- (int) ncercle.getRayon(),(int)ncercle.getPosY() - (int) ncercle.getRayon(),(int) ncercle.getRayon()*2,(int)ncercle.getRayon()*2);
			}
			
			else if (env.getElems().get(i).getForme() instanceof Geometrie.Rectangle) {
				Geometrie.Rectangle nrect = (Geometrie.Rectangle) env.getElems().get(i).getForme();
				g2.fillRect((int)nrect.getPosX(),(int)nrect.getPosY(),(int) nrect.getLength(),(int)nrect.getHeight());
				g2.drawRect((int)nrect.getPosX(),(int)nrect.getPosY(),(int) nrect.getLength(),(int)nrect.getHeight());
			}
			
			g2.setColor(Color.red);
			g2.fillOval((int)env.getRobot().getPosX() - env.getRobot().getDiametre()/2,(int)env.getRobot().getPosY()- env.getRobot().getDiametre()/2, env.getRobot().getDiametre(), env.getRobot().getDiametre());
			g2.setColor(Color.black );
			g2.drawOval((int)env.getRobot().getPosX() - env.getRobot().getDiametre()/2,(int)env.getRobot().getPosY()- env.getRobot().getDiametre()/2, env.getRobot().getDiametre(), env.getRobot().getDiametre());
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
			
			System.out.println("alpha degres "+ Math.toDegrees(env.getRobot().getAlpha())+ "  alpha rad " + alpha);
			g2.fillPolygon(X1, Y1, 4);
			g2.fillPolygon(X2, Y2, 4);
			//g2.fillOval((int)(XA-Math.cos(alpha+Math.PI/2)*env.getRobot().getDiametre()/2),(int)(YA-Math.sin(alpha+Math.PI/2)*env.getRobot().getDiametre()/2),env.getRobot().getDiametre()/3,env.getRobot().getDiametre()/3);
			
			/*g2.setColor(Color.black);
			g2.fillRect(prev_x,prev_y,34,34);
			g2.setColor(Color.red);
			g2.fillOval(env.getRobot().getPosX(),env.getRobot().getPosY(), 34, 34);
			g2.dispose();
			prev_x=env.getRobot().getPosX();
			prev_y=env.getRobot().getPosY();*/
			
		}
		
	}
	
	
}
