package Piece;

import static org.junit.Assert.*;
import java.awt.Color;
import org.junit.Test;
import Geometrie.Cercle;
public class ObstacleTest {

	
	@Test
	public void testToString() {
		Obstacle o1 = new Obstacle (Color.black, new Cercle (175, 300, 25/2));
		assertEquals(o1.toString(),"l'obstacle est de forme Cercle de centre [175.0,300.0] et de rayon 12.0");
	}

}
