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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Parameter;
import javax.persistence.Query;
import javax.persistence.TemporalType;

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
	private Buchung buchung;
	private TimePickerBean proband;
	private EntityTransaction transaction;
	private EntityManager em;
	private EntityManagerFactory emf;
	private Query q;
	private List<Buchung> buchungList;

	class MockQuery implements Query{

		@Override
		public List getResultList() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object getSingleResult() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int executeUpdate() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Query setMaxResults(int maxResult) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getMaxResults() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Query setFirstResult(int startPosition) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getFirstResult() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Query setHint(String hintName, Object value) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<String, Object> getHints() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> Query setParameter(Parameter<T> param, T value) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query setParameter(Parameter<Calendar> param, Calendar value,
				TemporalType temporalType) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query setParameter(Parameter<Date> param, Date value,
				TemporalType temporalType) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query setParameter(String name, Object value) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query setParameter(String name, Calendar value,
				TemporalType temporalType) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query setParameter(String name, Date value,
				TemporalType temporalType) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query setParameter(int position, Object value) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query setParameter(int position, Calendar value,
				TemporalType temporalType) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query setParameter(int position, Date value,
				TemporalType temporalType) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Set<Parameter<?>> getParameters() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Parameter<?> getParameter(String name) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> Parameter<T> getParameter(String name, Class<T> type) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Parameter<?> getParameter(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> Parameter<T> getParameter(int position, Class<T> type) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isBound(Parameter<?> param) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public <T> T getParameterValue(Parameter<T> param) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object getParameterValue(String name) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object getParameterValue(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query setFlushMode(FlushModeType flushMode) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public FlushModeType getFlushMode() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query setLockMode(LockModeType lockMode) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public LockModeType getLockMode() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T unwrap(Class<T> cls) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
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

		proband = new TimePickerBean();
		
		buchungList = new ArrayList<Buchung>();
		buchungList.add(buchung);

		Class<? extends TimePickerBean> clazz = proband.getClass();
		Field field = clazz.getDeclaredField("emf");
		field.setAccessible(true);
		field.set(proband, emf);
		
		field = clazz.getDeclaredField("buchung");
		field.setAccessible(true);
		field.set(proband, new Buchung());
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
		verify(em).createQuery("select rückgabedatum from buchung");
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
