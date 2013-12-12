/**
 * 
 */
package org.shareezy.test.unit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.shareezy.beans.RessourceListen;

/**
 * @author e1_treibmann
 *
 */
public class TestRessourcenListen {

	private RessourceListen proband;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		 proband = new RessourceListen();
	}

	/**
	 * Test method for {@link org.shareezy.beans.RessourceListen#ressourceClicked()}.
	 */
	@Test
	public void testRessourceClicked() {
		String nav = proband.ressourceClicked();
		assertEquals("ressourcendetail", nav);
		
	}

}
