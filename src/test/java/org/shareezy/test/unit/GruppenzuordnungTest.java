/**
 * 
 */
package org.shareezy.test.unit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.shareezy.beans.Bla;
import org.shareezy.beans.Gruppenzuordnung;

/**
 * @author e1_hermann
 *
 */
public class GruppenzuordnungTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		/*
	    Gruppenzuordnung i; 
		i=new Gruppenzuordnung();
	    int[] meinarray = {1,3,4,5};
	    */
		Bla tester = new Bla();
	    assertEquals("10 x 5 must be 50", 50, tester.multiply(10, 5));
		
	}

	/**
	 * Test method for {@link org.shareezy.beans.Gruppenzuordnung#mitgliederabfragen()}.
	 */
	@Test
	public void testMitgliederabfragen() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.shareezy.beans.Gruppenzuordnung#ressourcestatus()}.
	 */
	@Test
	public void testRessourcestatus() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.shareezy.beans.Gruppenzuordnung#mitgliedentfernen()}.
	 */
	@Test
	public void testMitgliedentfernen() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.shareezy.beans.Gruppenzuordnung#addressourcen(int)}.
	 */
	@Test
	public void testAddressourcen() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.shareezy.beans.Gruppenzuordnung#editressource()}.
	 */
	@Test
	public void testEditressource() {
		fail("Not yet implemented");
	}

}
