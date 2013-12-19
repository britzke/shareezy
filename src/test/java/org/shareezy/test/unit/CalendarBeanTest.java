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
 * JUnit-Test zum Testen der Beans und dessen Methoden
 * 
 * @author Vanessa Krohn
 * 
 */
public class CalendarBeanTest {
	private CalendarBean proband;

	/**
	 * Erzeugt einen neuen Probanden der zutestenden Klasse.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		proband = new CalendarBean();
	}

	/**
	 * Testmethode für die Methode scheduleController() testet ob der
	 * Rückgabewert null ist wenn nicht, dann wird eine Error-Message angezeigt
	 * {@link org.shareezy.beans.CalendarBean#scheduleController()} .
	 */
	@Test
	public void testScheduleController() {
		String sc = proband.scheduleController();
		assertEquals(null, sc);
		assertNull("Muss Null sein!", null);
	}

	/**
	 * Testmethode für die Methode today() testet ob der Rückgabewert null ist
	 * wenn nicht, dann wird eine Error-Message angezeigt
	 * {@link org.shareezy.beans.CalendarBean#today()}.
	 */
	@Test
	public void testToday() {
		Calendar today = proband.today();
		assertEquals(null, today);
		assertNull("Muss Null sein!", null);
	}

}
