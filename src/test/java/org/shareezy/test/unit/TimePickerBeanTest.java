/**
 * 
 */
package org.shareezy.test.unit;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.shareezy.beans.TimePickerBean;

/**
 * @author e1_krohn
 * 
 */
public class TimePickerBeanTest {
	
	private TimePickerBean proband;
	private Date timeframe;

	/**
	 * Erzeugt ein neuen Probanden der zu testenden Klasse.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		proband = new TimePickerBean();
	}

	/**
	 * Test method for {@link org.shareezy.beans.TimePickerBean#getTimeframe()}.
	 */
	@Test
	public void testGetTimeframe() {
		Date tframe = proband.getTimeframe();
		assertEquals(timeframe, tframe);
	}

	/**
	 * Test method for {@link org.shareezy.beans.TimePickerBean#checkDate()}.
	 */
	@Test
	public void testCheckDate() {
		assertNull("Muesste Null sein", null);
	}

}
