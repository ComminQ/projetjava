package net.stri.fdjava.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import net.stri.fdjava.views.Direction;

/**
 * test JUnit pour la direction
 * @author Fabien CAYRE (Computer)
 *
 * @date 30/04/2021
 */
public class SalleTest {

	@Test
	public void testDirection() {
		Direction direction = Direction.getByTag("N");
		assertEquals("N", direction.getTag());
		assertEquals(Direction.NORD, direction);
	}
	
	@Test
	public void testDirectionOppositeNordSud() {
		Direction direction = Direction.getByTag("N");
		Direction opposite = direction.opposite();
		assertEquals("S", opposite.getTag());
		assertEquals(Direction.SUD, opposite);
	}
	
	@Test
	public void testDirectionOppositeEstOuest() {
		Direction direction = Direction.getByTag("E");
		Direction opposite = direction.opposite();
		assertEquals("O", opposite.getTag());
		assertEquals(Direction.OUEST, opposite);
	}
	
}
