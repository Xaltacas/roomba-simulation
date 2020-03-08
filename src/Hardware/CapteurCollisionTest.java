package Hardware;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import Geometrie.Cercle;
import Logique.CompAleatoire;
import Piece.Environement;
import Piece.Obstacle;
import Piece.Tache;

public class CapteurCollisionTest {

	@Test
	public void testCollide() {
		Environement env = new Environement (400,400);
		Obstacle o = new Obstacle (Color.LIGHT_GRAY,new Cercle (100, 280, 30));

		env.addElem(o);
		Hardware.Robot r = new Hardware.Robot (34,80,300,env, new CompAleatoire());
		env.addRobot(r);
		
		assertTrue(r.cgState());
		assertFalse(r.cdState());
		
	}

}
