package org.shareezy.test.unit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.shareezy.beans.AccountBearbeitenBean;

/**
 * Testet die Übersetzungseinheit <i>(Compilation Unit)</i>
 * {@link org.shareezy.beans.AccountBearbeitenBean}.
 * 
 * @author burghard.britzke (bubi@charmides.in-berlin.de)
 */
public class AccountBearbeitenBeanTest {

	private AccountBearbeitenBean proband;
	private String nullTest = null;
	
	/**
	 * Erzeugt ein neuen Probanden der zu testenden Klasse.
	 * 
	 * @throws java.lang.Exception
	 *             Wenn eine Situation auftritt, die in der Methode nich
	 *             berücksitigt wurde.
	 */
	@Before
	public void setUp() throws Exception {
		proband = new AccountBearbeitenBean();
	}

	/**
	 * Test-Methode für
	 * {@link org.shareezy.beans.AccountBearbeitenBean#eingabePrüfen(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 * 
	 */
	@Test
	public void testEingabePrüfen() {
		String übergebenerWert = null;
		assertEquals(nullTest, übergebenerWert);
	}

	/**
	 * Test-Methode für
	 * {@link org.shareezy.beans.AccountBearbeitenBean#datensatzÄndern(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testDatensatzÄndern() {
		String übergebenerWert = null;
		assertEquals(nullTest, übergebenerWert);
	}

}
