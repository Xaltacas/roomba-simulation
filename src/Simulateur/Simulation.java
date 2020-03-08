package Simulateur;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


import javax.swing.*;
import Piece.*;
import Geometrie.*;
import Hardware.*;
import Logique.*;


public class Simulation implements ActionListener{

	/**
	 * boolean attente et boolean pause sont des variables static volatile partagées par toutes les fonctions de la classe 
	 */
	//variable de controle d'activation de la simulation 
	static volatile private boolean attente = true;
	static volatile private boolean pause = false;
	
	// création de boutons
	static JButton bouton = new JButton("Start");
	static JButton boutonStop = new JButton("Pause");
	
	/**
	 * @param e Evenement detecte
	 */
	//action a réaliser en cas de detection d'un Evennement 
	public void actionPerformed (ActionEvent e) {
		if (e.getSource()== bouton) { // cas ou l'evennement detecte est un clic sour le bouton start
			System.out.println("ici");
			attente = false;
		}
		if (e.getSource()==boutonStop) {// cas ou l'evennement detecte est un clic sour le bouton pause
			if (pause == true) {
				pause = false;
			}else {
				pause = true;
			}
		}
	}
	
	public static void main(String[] args) {
		
		// creation de l'environement
		Environement env = new Environement (400,400);
		// creation des murs de la piece
		Obstacle mur1 = new Obstacle(Color.black,new Geometrie.Rectangle(0,0,400,5));
		Obstacle mur2 = new Obstacle(Color.black,new Geometrie.Rectangle(0,0,5,400));
		Obstacle mur3 = new Obstacle(Color.black,new Geometrie.Rectangle(395,0,5,400));
		Obstacle mur4 = new Obstacle(Color.black,new Geometrie.Rectangle(0,395,400,5));
		// cretion des taches de la piece
		Tache t1 = new Tache (Color.black, new Cercle (200, 40, 15));
		Tache t2 = new Tache (Color.black, new Cercle (350, 50, 6));
		Tache t3 = new Tache (Color.black, new Cercle (30, 150, 10));
		Tache t4 = new Tache (Color.black, new Cercle (135, 175, 12));
		Tache t5 = new Tache (Color.black, new Cercle (245, 160, 8));
		Tache t6 = new Tache (Color.black, new Cercle (230, 290, 33/2));
		Tache t7 = new Tache (Color.black, new Cercle (40, 370, 10));
		Tache t8 = new Tache (Color.black, new Cercle (350, 350, 15));
		// creation des Obstacles de la piece
		Obstacle o1 = new Obstacle (Color.LIGHT_GRAY,new Cercle(50,50,25));
		Obstacle o2 = new Obstacle (Color.LIGHT_GRAY,new Cercle (300, 180, 20));
		Obstacle o3 = new Obstacle (Color.LIGHT_GRAY,new Cercle (100, 280, 30));
		
		// ajout des Elements a l'environement
		env.addElem(mur1);
		env.addElem(mur2);
		env.addElem(mur3);
		env.addElem(mur4);
		env.addElem(t1);
		env.addElem(t2);
		env.addElem(t3);
		env.addElem(t4);
		env.addElem(t5);
		env.addElem(t6);
		env.addElem(t7);
		env.addElem(t8);
		env.addElem(o1);
		env.addElem(o2);
		env.addElem(o3);
		
		// création du robot et ajout à l'environement 
		Hardware.Robot r = new Hardware.Robot (34,100,300,env, new CompAleatoire());
		env.addRobot(r);
		
		// on enregistre la simulation comme listener
		bouton.addActionListener(new Simulation());
		boutonStop.addActionListener(new Simulation());
		

		//Nouvelle fenetre
		JFrame ma_fenetre = new JFrame();
		//ajout d'un titre à la fenetre
		ma_fenetre.setTitle("roomba simulation");
		//la taille fenetre fixe
		ma_fenetre.setResizable(false);
		//mise au blanc du fond de la fenetre
		ma_fenetre.setBackground(Color.white);
		//permet la feneture de la fenetre et l'arret du programme en cliquant sur l'icone de fermeture de la fenetre
		ma_fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		IHMRoomba IHM = new IHMRoomba(env);// Nouvel objet IHMRoomba
		IHM.setPreferredSize(new Dimension(env.getSizeX(),env.getSizeY()));//taille de la fenetre
		ma_fenetre.setContentPane(IHM);//le contenu est l'objet IHM
		ma_fenetre.add(bouton);// ajout du bouton Start
		ma_fenetre.pack();
		ma_fenetre.setVisible(true);
		
		while (attente) { // attend que la consigne Stat soit envoyee
			
		}
		bouton.setVisible(false); // la simulation lancee le bouton start disparait
		ma_fenetre.add(boutonStop);//ajout du bouton pause
		
		while (true) {
			
			if (pause) { // attend le temps que la consigne pause soit mise à false
				
			}else {
				
			r.updatePos();//met à jour les positions du robot
			try {Thread.sleep(10);}
			catch(Exception e) {}
			IHM.repaint();//appel la fonction paint de IHMRoomba
			}
		}
	}

}
