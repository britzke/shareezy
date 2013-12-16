/**
 * 
 */
package org.shareezy.test.unit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.shareezy.beans.Gruppenzuordnung;

/**
 * @author e1_hermann
 *
 */
public class GruppenzuordnungTest {
	
	public Gruppenzuordnung proband;
	public String account_id;
	public String accounts_id;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		/*
	    Gruppenzuordnung i; 
		i=new Gruppenzuordnung();
		*/
		
		proband = new Gruppenzuordnung();
	   
		
	}

	/**
	 * Test method for {@link org.shareezy.beans.Gruppenzuordnung#mitgliederabfragen()}.
	 */
	@Test
	public void testMitgliederabfragen() {
		String a = proband.mitgliederabfragen();
		assertEquals(account_id, a);
	}

	/**
	 * Test method for {@link org.shareezy.beans.Gruppenzuordnung#ressourcestatus()}.
	 */
	@Test
	public void testRessourcestatus() {
		String b = proband.mitgliederabfragen();
		assertEquals(accounts_id, b);
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
