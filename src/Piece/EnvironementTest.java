package Piece;

import static org.junit.Assert.*;
import java.awt.Color;
import org.junit.Test;
import Geometrie.Cercle;
import Logique.CompAleatoire;
import Piece.Obstacle;

public class EnvironementTest {

	@Test
	public void testAddRobot() {
		Environement env = new Environement (400,400);
		Hardware.Robot r = new Hardware.Robot (34,100,300,env, new CompAleatoire());
		env.addRobot(r);
		r.equals(env.getRobot());
		assertEquals(r.getDiametre(),env.getRobot().getDiametre());
	}

	@Test
	public void testAddElem() {
		Environement env = new Environement (400,400);
		Tache t1 = new Tache (Color.black, new Cercle (175, 300, 25/2));
		env.addElem(t1);
		t1.equals(env.getElems().get(0));
	}

	@Test
	public void testRemoveElem() {
		Environement env = new Environement (400,400);
		Tache t1 = new Tache (Color.black, new Cercle (175, 300, 25/2));
		Tache t2 = new Tache (Color.black, new Cercle (17, 30, 25));
		env.addElem(t1);
		env.removeElem(t2);
		env.removeElem(t1);
		assertEquals(0,env.getElems().size());
	}

	@Test
	public void testGetNbTaches() {
		Environement env = new Environement (400,400);
		assertEquals(0,env.getNbTaches());
		
		Tache t1 = new Tache (Color.black, new Cercle (175, 300, 25/2));
		Tache t2 = new Tache (Color.black, new Cercle (17, 30, 25));
		Obstacle o1 = new Obstacle (Color.black, new Cercle (17, 30, 25));
		env.addElem(t1);
		env.addElem(t2);
		env.addElem(o1);
		assertEquals(2,env.getNbTaches());
	}

	@Test
	public void testToString() {
		Environement env = new Environement (400,400);
		assertEquals(env.toString(),"l'environement a une taille de 400 sur 400 et contient 0 elements");
		Tache t1 = new Tache (Color.black, new Cercle (175, 300, 25/2));
		Tache t2 = new Tache (Color.black, new Cercle (17, 30, 25));
		Obstacle o1 = new Obstacle (Color.black, new Cercle (17, 30, 25));
		env.addElem(t1);
		env.addElem(t2);
		env.addElem(o1);
		assertEquals(env.toString(),"l'environement a une taille de 400 sur 400 et contient 3 elements");
		env.removeElem(t1);
		assertEquals(env.toString(),"l'environement a une taille de 400 sur 400 et contient 2 elements");
	}

}
