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
 * @author e1_krohn
 * 
 */
public class RessourcenDetailBeanTest {
	
	private RessourcenDetailBean proband;

	/**
	 * Erzeugt ein neuen Probanden der zu testenden Klasse.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		proband = new RessourcenDetailBean();
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.RessourcenDetailBean#timePicker()}.
	 */
	@Test
	public void testTimePicker() {
		String picker = proband.timePicker();
		assertEquals(null, picker);
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.RessourcenDetailBean#resourcePic()}.
	 */
	@Test
	public void testResourcePic() {
		Image pic = proband.resourcePic();
		assertEquals(null, pic);
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.RessourcenDetailBean#resourceSummary()}.
	 */
	@Test
	public void testResourceSummary() {
		String summary = proband.resourceSummary();
		assertEquals(null, summary);
	}

}
