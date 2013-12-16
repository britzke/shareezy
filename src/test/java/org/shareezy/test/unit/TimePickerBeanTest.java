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
 * JUnit-Test zum Testen der Beans und dessen Methoden
 * 
 * @author Vanessa Krohn
 * 
 */
public class TimePickerBeanTest {

	private TimePickerBean proband;
	private Date timeframe;

	/**
	 * Erzeugt einen neuen Probanden der zutestenden Klasse.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		proband = new TimePickerBean();
	}

	/**
	 * Testmethode für getTimeframe() überprüft den Rückgabewert timeframe
	 * {@link org.shareezy.beans.TimePickerBean#getTimeframe()}.
	 */
	@Test
	public void testGetTimeframe() {
		Date tframe = proband.getTimeframe();
		assertEquals(timeframe, tframe);
	}

	/**
	 * Testmethode für checkDate(); hat keinen Rückgabewert
	 * {@link org.shareezy.beans.TimePickerBean#checkDate()}.
	 */
	@Test
	public void testCheckDate() {

	}

}
