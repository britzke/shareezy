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
import static org.mockito.Mockito.*;
import java.lang.reflect.Field;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
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
	private EntityManagerFactory emf;
	private EntityManager em;
	private Query q;

	/**
	 * Erzeugt einen neuen Probanden der zu testenden Klasse.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		emf = mock(EntityManagerFactory.class);
		em = mock(EntityManager.class);
		when(emf.createEntityManager()).thenReturn(em);
		q = mock(Query.class);
		when(em.createQuery("select b from Buchnung where ressourcen= :aktuelleRessource")).thenReturn(q);
		proband = new CalendarBean();
		
		Class<? extends CalendarBean> clazz = proband.getClass();
		Field field = clazz.getDeclaredField("emf");
		field.setAccessible(true);
		field.set(proband, emf);
	}

	/**
	 * Testmethode für die Methode scheduleController() testet ob der
	 * Rückgabewert null ist wenn nicht, dann wird eine Error-Message angezeigt
	 * {@link org.shareezy.beans.CalendarBean#scheduleController()} .
	 */
	@Test
	public void testScheduleController() {
		String sc = proband.scheduleController();
		assertNull("Die Methode scheduleController() muss mit Null antworten", sc);
		verify(emf).createEntityManager();
		verify(em).createQuery(eq("select b from Buchnung where ressourcen= :aktuelleRessource"));
	}
}
