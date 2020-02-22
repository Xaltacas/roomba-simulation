package Simulateur;
import java.awt.*;
import javax.swing.*;
import Geometrie.Forme;
import Piece.Environement;
import Piece.Element;
//import Simulateur.Fenetre;
import Piece.Tache;
import Geometrie.Forme;
import Geometrie.Cercle;

public class Simulation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Environement env = new Environement (800,800);
		Tache t1 = new Tache (Color.red, new Cercle (200, 200, 50));
		Tache t2 = new Tache (Color.black, new Cercle (200, 200, 50));
		//System.out.println (t1);
		env.addElem(t1);
		env.addElem(t2);
		
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
