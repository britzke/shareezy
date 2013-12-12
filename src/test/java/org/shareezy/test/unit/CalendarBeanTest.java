/**
 * 
 */
package org.shareezy.test.unit;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.shareezy.beans.CalendarBean;

/**
 * @author e1_krohn
 * 
 */
public class CalendarBeanTest {
	private CalendarBean proband;

	/**
	 * Erzeugt ein neuen Probanden der zu testenden Klasse.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		proband = new CalendarBean();
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.CalendarBean#scheduleController()}.
	 */
	@Test
	public void testScheduleController() {
		//fail("Not yet implemented");
		//assertNull("Muesste Null sein", null);
		
		String sc = proband.scheduleController();
		assertEquals(null, sc);
	}
 
	/**
	 * Test method for {@link org.shareezy.beans.CalendarBean#today()}.
	 */
	@Test
	public void testToday() {
		Calendar today = proband.today();
		assertEquals(null, today);
	}

}
