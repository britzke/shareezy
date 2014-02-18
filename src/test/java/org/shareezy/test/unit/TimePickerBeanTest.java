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
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
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
	private Buchung buchung;
	private TimePickerBean proband;
	private EntityTransaction transaction;
	private EntityManager em;
	private EntityManagerFactory emf;
	private Query q;
	private List<Buchung> buchungList;
	
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
		q = mock(Query.class);
		when(em.createQuery("select rückgabedatum from buchung")).thenReturn(q);
		transaction = mock(EntityTransaction.class);
		when(em.getTransaction()).thenReturn(transaction);
		
		buchung = new Buchung();

		proband = new TimePickerBean();
		
		buchungList = new ArrayList<Buchung>();
		buchungList.add(buchung);

		Class<? extends TimePickerBean> clazz = proband.getClass();
		Field field = clazz.getDeclaredField("emf");
		field.setAccessible(true);
		field.set(proband, emf);
		
		field = clazz.getDeclaredField("buchung");
		field.setAccessible(true);
		field.set(proband, buchung);
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
		assertNull(antwort);
		verify(emf).createEntityManager();
		verify(em).getTransaction();
		verify(transaction).begin();
		verify(em).persist(eq(buchung));
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
