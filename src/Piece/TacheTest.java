package Piece;

import static org.junit.Assert.*;
import org.junit.Test;
import Geometrie.Cercle;
import java.awt.*;

public class TacheTest {

	@Test
	public void testToString() {
		Tache t1 = new Tache (Color.black, new Cercle (175, 300, 25/2));
		assertEquals(t1.toString(),"la tache est de forme Cercle de centre [175.0,300.0] et de rayon 12.0");
	}
	
	@Test
	public void testAspirer() {
		Tache t1 = new Tache (Color.black, new Cercle (175, 300, 25/2));
		t1.aspirer();
		assertEquals(t1.getColor(),Color.white);
	}

}
