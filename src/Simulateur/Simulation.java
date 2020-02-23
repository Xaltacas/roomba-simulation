package Simulateur;
import java.awt.*;
import javax.swing.*;
import Piece.*;
import Geometrie.*;
import Logique.*;
import Logique.Comportement;


public class Simulation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Environement env = new Environement (400,400);
		Obstacle mur1 = new Obstacle(Color.black,new Geometrie.Rectangle(0,0,400,5));
		Obstacle mur2 = new Obstacle(Color.black,new Geometrie.Rectangle(0,0,5,400));
		Obstacle mur3 = new Obstacle(Color.black,new Geometrie.Rectangle(395,0,5,400));
		Obstacle mur4 = new Obstacle(Color.black,new Geometrie.Rectangle(0,395,400,5));
		Tache t1 = new Tache (Color.green, new Cercle (200, 200, 50));
		Tache t2 = new Tache (Color.green, new Cercle (100, 100, 100));
		Obstacle o1 = new Obstacle (Color.black,new Cercle(300,300,25));
		
		env.addElem(mur1);
		env.addElem(mur2);
		env.addElem(mur3);
		env.addElem(mur4);
		env.addElem(t1);
		env.addElem(t2);
		env.addElem(o1);
		
		Robot r = new Robot (34,200,200,env, new Comportement ncomp());
		JFrame ma_fenetre = new JFrame();
		ma_fenetre.setTitle("roomba simulation");
		//ma_fenetre.setLocationRelativeTo(null);
		ma_fenetre.setResizable(false);
		ma_fenetre.setBackground(Color.white);
		ma_fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		IHMRoomba IHM = new IHMRoomba(env);
		IHM.setPreferredSize(new Dimension(env.getSizeX(),env.getSizeY()));
		
		ma_fenetre.setContentPane(IHM);
		ma_fenetre.pack();
		ma_fenetre.setVisible(true);
		
	}

}
