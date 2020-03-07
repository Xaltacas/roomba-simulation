package Geometrie;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArcTest {

	@Test
	public void testToString() {
		Arc a = new Arc(0,0,1,0,Math.PI/2);
		
		assertEquals(a.toString(),"arc de centre [0.0,0.0] de rayon 1.0 et de delimiteurs [0.0,"+Math.PI/2+"]");
	}

	@Test
	public void testMove() {
		Arc a = new Arc(0,0,1,0,Math.PI/2);
		a.move(1,1,0);
		assertEquals(a.toString(),"arc de centre [1.0,1.0] de rayon 1.0 et de delimiteurs [0.0,"+Math.PI/2+"]");
	}

	@Test
	public void testIntersectCercle() {
		Arc a = new Arc(0,3,1,0,Math.PI/2);
		
		assertTrue(a.intersect(new Cercle(1,2,1/2.)));
		assertFalse(a.intersect(new Cercle(1,4,1/2.)));
		assertFalse(a.intersect(new Cercle(-1,2,1/2.)));
		
		a.move(3, 3, Math.PI/2);
		
		assertTrue(a.intersect(new Cercle(2,2,1/2.)));
		assertFalse(a.intersect(new Cercle(2,4,1/2.)));
		assertFalse(a.intersect(new Cercle(4,2,1/2.)));
		
		
		a.move(3, 3, 3*Math.PI/2);

		assertTrue(a.intersect(new Cercle(4,4,0.5)));
	}

	@Test
	public void testIntersectRectangle() {
		Arc a = new Arc(0,3,2,0,Math.PI/2);
		
		assertTrue(a.intersect(new Rectangle(1,1,1,1)));
		assertFalse(a.intersect(new Rectangle(1,4,1,1)));

		a.move(5, 3, Math.PI/2);
		assertTrue(a.intersect(new Rectangle(3,1,1,1)));
		assertFalse(a.intersect(new Rectangle(3,4,1,1)));

	}


}
