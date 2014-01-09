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
import java.lang.reflect.Field;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.shareezy.beans.TimePickerBean;
import org.shareezy.entities.Buchung;

/**
 * JUnit-Test zum Testen der Beans und dessen Methoden
 * 
 * @author Vanessa Krohn
 * 
 */

public class TimePickerBeanTest {

	private Date timeframe;

	public boolean closeSent;
	public boolean getTransactionSent;
	public boolean beginSent;
	public boolean commitSent;
	public boolean createEntityManagerSent;
	public boolean persistSent;
	public Buchung buchung;

	private TimePickerBean proband;
	private EntityTransaction transaction;
	private EntityManager em;
	private EntityManagerFactory emf;

	/**
	 * Erzeugt einen neuen Probanden der zutestenden Klasse.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		emf = mock(EntityManagerFactory.class);
		em = mock(EntityManager.class);
		when(emf.createEntityManager()).thenReturn(em);
		transaction = mock(EntityTransaction.class);
		when(em.getTransaction()).thenReturn(transaction);

		proband = new TimePickerBean();

		Class<? extends TimePickerBean> clazz = proband.getClass();
		Field field = clazz.getDeclaredField("emf");
		field.setAccessible(true);
		field.set(proband, emf);
	}

	/**
	 * Testmethode für addDatensatz()
	 * {@link org.shareezy.beans.TimePickerBean#addDatensatz()}. Testet mittels
	 * eines EntityManagers und einer Transaction, ob ein Datensatz hinzugefügt
	 * wird.
	 */
	@Test
	public void testAddDatensatz() {
		String antwort = proband.addDatensatz();
		verify(emf).createEntityManager();
		verify(em).getTransaction();
		verify(transaction).begin();
		verify(em).persist(buchung);
		verify(transaction).commit();
		verify(em).close();
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
