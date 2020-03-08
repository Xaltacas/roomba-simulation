package Geometrie;

import static org.junit.Assert.*;

import org.junit.Test;

public class CercleTest {

	@Test
	public void testToString() {
		Cercle c = new Cercle(1,1,1);
		
		assertEquals(c.toString(),"Cercle de centre [1.0,1.0] et de rayon 1.0");
	}

	@Test
	public void testMove() {
		Cercle c = new Cercle(1,1,1);
		
		c.move(3, 3, 0);
		
		assertEquals(c.toString(),"Cercle de centre [3.0,3.0] et de rayon 1.0");
	}

	@Test
	public void testIntersectCercle() {
		Cercle c = new Cercle(1,1,1);
		
		assertTrue(c.intersect(new Cercle(2,2,0.5)));
		assertFalse(c.intersect(new Cercle(1,4,1)));
		
		c.move(3, 3, 0);
		
		assertTrue(c.intersect(new Cercle(1,3,1)));
		assertFalse(c.intersect(new Cercle(1,4,1)));
		
	}

	@Test
	public void testIntersectRectangle() {
		Cercle c = new Cercle(2,2,2);
		
		assertTrue(c.intersect(new Rectangle(3,3,1,1)));
		assertTrue(c.intersect(new Rectangle(0,0,1,1)));
		assertFalse(c.intersect(new Rectangle(5,1,1,1)));
		
		c.move(3, 3, 0);
		
		assertTrue(c.intersect(new Rectangle(3,3,1,1)));
		assertFalse(c.intersect(new Rectangle(0,0,1,1)));
		
	}

	@Test
	public void testIntersectArc() {
		Cercle c = new Cercle(2,2,2);
		
		assertTrue(c.intersect(new Arc(4,4,1,Math.PI/2,Math.PI)));
		assertTrue(c.intersect(new Arc(2,5,1,0,Math.PI)));
		assertFalse(c.intersect(new Arc(3,5,1,0,Math.PI/2)));
				
		c.move(3, 3, 0);
		
		assertTrue(c.intersect(new Arc(3,5,1,0,Math.PI)));
	}

}
