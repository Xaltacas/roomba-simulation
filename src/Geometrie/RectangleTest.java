package Geometrie;

import static org.junit.Assert.*;

import org.junit.Test;

public class RectangleTest {

	@Test
	public void testToString() {
		Rectangle r = new Rectangle(1,1,2,2);

		assertEquals(r.toString(),"rectangle de coin [1.0,1.0] et de hauteur 2.0 et de longeur 2.0");
	}

	@Test
	public void testMove() {
		Rectangle r = new Rectangle(1,1,2,2);

		r.move(3,3,0);
			
		assertEquals(r.toString(),"rectangle de coin [3.0,3.0] et de hauteur 2.0 et de longeur 2.0");
	}

	@Test
	public void testIntersectCercle() {
		Rectangle r = new Rectangle(1,1,2,2);
		
		assertTrue(r.intersect(new Cercle(0,0,2)));
		assertFalse(r.intersect(new Cercle(3,5,1)));

		r.move(3,3,0);
		
		assertFalse(r.intersect(new Cercle(0,0,2)));
		assertTrue(r.intersect(new Cercle(3,5,1)));
	}

	@Test
	public void testIntersectArc() {
		Rectangle r = new Rectangle(1,1,2,2);
		
		assertTrue(r.intersect(new Arc(0,0,2,-Math.PI/2,0)));
		assertFalse(r.intersect(new Arc(0,0,2,0,Math.PI/2)));

		r.move(3,3,0);
		
		assertFalse(r.intersect(new Arc(0,0,2,-Math.PI/2,0)));
		assertTrue(r.intersect(new Arc(2,6,2,0,Math.PI/2)));
	}

}
