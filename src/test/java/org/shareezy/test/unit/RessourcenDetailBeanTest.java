/**
 * 
 */
package org.shareezy.test.unit;

import static org.junit.Assert.*;

import java.awt.Image;

import org.junit.Before;
import org.junit.Test;
import org.shareezy.beans.RessourcenDetailBean;

/**
 * JUnit-Test zum Testen der Beans und dessen Methoden
 * 
 * @author Vanessa Krohn
 * 
 */
public class RessourcenDetailBeanTest {

	private RessourcenDetailBean proband;

	/**
	 * Erzeugt einen neuen Probanden der zutestenden Klasse.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		proband = new RessourcenDetailBean();
	}

	/**
	 * Testmethode für testTimePicker()
	 * {@link org.shareezy.beans.RessourcenDetailBean#timePicker()}.
	 */
	@Test
	public void testTimePicker() {
		String picker = proband.timePicker();
		assertEquals(null, picker);
	}

	/**
	 * Testmethode für resourcePic() überprüft den Rückgabewert pic
	 * {@link org.shareezy.beans.RessourcenDetailBean#resourcePic()}.
	 */
	@Test
	public void testResourcePic() {
		Image bild = proband.resourcePic();
		assertEquals(pic, bild);
	}

	/**
	 * Testmethode für resourceSummary() überprüft den Rückgabewert summary
	 * {@link org.shareezy.beans.RessourcenDetailBean#resourceSummary()}.
	 */
	@Test
	public void testResourceSummary() {
		String sum = proband.resourceSummary();
		assertEquals(summary, sum);
	}

}
