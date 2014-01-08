/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	Vanessa Krohn
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.shareezy.test.unit;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.shareezy.beans.CalendarBean;

/**
 * JUnit-Test zum Testen der Beans und dessen Methoden.
 * 
 * @author Vanessa Krohn
 * 
 */
public class CalendarBeanTest {
	private CalendarBean proband;

	/**
	 * Erzeugt einen neuen Probanden der zu testenden Klasse.
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
		assertNull("Muss Null sein!", sc);
	}

	/**
	 * Testmethode für die Methode today() testet ob der Rückgabewert null ist
	 * wenn nicht, dann wird eine Error-Message angezeigt
	 * {@link org.shareezy.beans.CalendarBean#today()}.
	 */
	@Test
	public void testToday() {
		Calendar today = proband.today();
		assertNull(today);
	}
}
