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

import java.awt.Image;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Cache;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Parameter;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.SynchronizationType;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;

import org.junit.Before;
import org.junit.Test;
import org.shareezy.beans.RessourcenDetailBean;
import org.shareezy.entities.Ressource;


/**
 * JUnit-Test zum Testen der Beans und dessen Methoden
 * 
 * @author Vanessa Krohn
 * 
 */
public class RessourcenDetailBeanTest {

	private RessourcenDetailBean proband;
	private Image pic;
	private String summary;
	
    public boolean createEntityManagerSent;
	public boolean createQuerySent;
	public Ressource ressource;
	public Query q;
	public List<Ressource> ressourceList;

	
	/**
	 * Ein MockEntityManager ist ein EntityManger, der ausschließlich als
	 * Attrappe (MOCK) für Tests dient.
	 *
	 */
	private class MockEntityManager implements EntityManager {

		/**
		 * Vermerkt, ob eine Transaction vom EntityManager abgefragt wurde.
		 * Antwortet mit einer MockTransaction.
		 */
	

		@Override
		public void close() {
		}

		public void persist(Object arg0) {
		}

		@Override
		public void clear() {
		}

		@Override
		public boolean contains(Object arg0) {
			return false;
		}

		@Override
		public <T> EntityGraph<T> createEntityGraph(Class<T> arg0) {
			return null;
		}

		@Override
		public EntityGraph<?> createEntityGraph(String arg0) {
			return null;
		}

		@Override
		public Query createNamedQuery(String arg0) {
			return null;
		}

		@Override
		public <T> TypedQuery<T> createNamedQuery(String arg0, Class<T> arg1) {
			return null;
		}

		@Override
		public StoredProcedureQuery createNamedStoredProcedureQuery(String arg0) {
			return null;
		}

		@Override
		public Query createNativeQuery(String arg0) {
			return null;
		}

		@Override
		public Query createNativeQuery(String arg0, Class arg1) {
			return null;
		}

		@Override
		public Query createNativeQuery(String arg0, String arg1) {
			return null;
		}

		/**
		 * Vermerkt, ob eine Query erzeugt wurde.
		 */
		@Override
		public Query createQuery(String arg0) {
			createQuerySent = true;
			
			return q;
		}

		@Override
		public <T> TypedQuery<T> createQuery(CriteriaQuery<T> arg0) {
			return null;
		}

		@Override
		public Query createQuery(CriteriaUpdate arg0) {
			return null;
		}

		@Override
		public Query createQuery(CriteriaDelete arg0) {
			return null;
		}

		@Override
		public <T> TypedQuery<T> createQuery(String arg0, Class<T> arg1) {
			return null;
		}

		@Override
		public StoredProcedureQuery createStoredProcedureQuery(String arg0) {
			return null;
		}

		@Override
		public StoredProcedureQuery createStoredProcedureQuery(String arg0,
				Class... arg1) {
			return null;
		}

		@Override
		public StoredProcedureQuery createStoredProcedureQuery(String arg0,
				String... arg1) {
			return null;
		}

		@Override
		public void detach(Object arg0) {

		}

		@Override
		public <T> T find(Class<T> arg0, Object arg1) {
			return null;
		}

		@Override
		public <T> T find(Class<T> arg0, Object arg1, Map<String, Object> arg2) {
			return null;
		}

		@Override
		public <T> T find(Class<T> arg0, Object arg1, LockModeType arg2) {
			return null;
		}

		@Override
		public <T> T find(Class<T> arg0, Object arg1, LockModeType arg2,
				Map<String, Object> arg3) {
			return null;
		}

		@Override
		public void flush() {
		}

		@Override
		public CriteriaBuilder getCriteriaBuilder() {
			return null;
		}

		@Override
		public Object getDelegate() {
			return null;
		}

		@Override
		public EntityGraph<?> getEntityGraph(String arg0) {
			return null;
		}

		@Override
		public <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> arg0) {
			return null;
		}

		@Override
		public EntityManagerFactory getEntityManagerFactory() {
			return null;
		}

		@Override
		public FlushModeType getFlushMode() {
			return null;
		}

		@Override
		public LockModeType getLockMode(Object arg0) {
			return null;
		}

		@Override
		public Metamodel getMetamodel() {
			return null;
		}

		@Override
		public Map<String, Object> getProperties() {
			return null;
		}

		@Override
		public <T> T getReference(Class<T> arg0, Object arg1) {
			return null;
		}

		@Override
		public boolean isJoinedToTransaction() {
			return false;
		}

		@Override
		public boolean isOpen() {
			return false;
		}

		@Override
		public void joinTransaction() {
		}

		@Override
		public void lock(Object arg0, LockModeType arg1) {
		}

		@Override
		public void lock(Object arg0, LockModeType arg1,
				Map<String, Object> arg2) {
		}

		@Override
		public <T> T merge(T arg0) {
			return null;
		}

		@Override
		public void refresh(Object arg0) {
		}

		@Override
		public void refresh(Object arg0, Map<String, Object> arg1) {
		}

		@Override
		public void refresh(Object arg0, LockModeType arg1) {
		}

		@Override
		public void refresh(Object arg0, LockModeType arg1,
				Map<String, Object> arg2) {
		}

		@Override
		public void remove(Object arg0) {
		}

		@Override
		public void setFlushMode(FlushModeType arg0) {
		}

		@Override
		public void setProperty(String arg0, Object arg1) {
		}

		@Override
		public <T> T unwrap(Class<T> arg0) {
			return null;
		}

		@Override
		public EntityTransaction getTransaction() {
			// TODO Auto-generated method stub
			return null;
		}
	}

	/**
	 * Ein MockEntityManager ist ein EntityManager, der ausschließlich als
	 * Attrappe (MOCK) zum Testen verwendet wird.
	 * 
	 */
	private class MockEntityManagerFactory implements EntityManagerFactory {

		/**
		 * Vermerkt, ob ein EntityManager über diese Factory erstellt wurde.
		 * Antwortet mit einem MockEntityManager.
		 * 
		 * @see MockEntityManager
		 */
		@Override
		public EntityManager createEntityManager() {
			createEntityManagerSent = true;
			return new MockEntityManager();
		}

		// ---------------------------------------------
		// Die Methoden unterhalb werden nicht verwendet
		@Override
		public <T> void addNamedEntityGraph(String arg0, EntityGraph<T> arg1) {
		}

		@Override
		public void addNamedQuery(String arg0, Query arg1) {
		}

		@Override
		public void close() {
		}

		@Override
		public EntityManager createEntityManager(Map arg0) {
			return null;
		}

		@Override
		public EntityManager createEntityManager(SynchronizationType arg0) {
			return null;
		}

		@Override
		public EntityManager createEntityManager(SynchronizationType arg0,
				Map arg1) {
			return null;
		}

		@Override
		public Cache getCache() {
			return null;
		}

		@Override
		public CriteriaBuilder getCriteriaBuilder() {
			return null;
		}

		@Override
		public Metamodel getMetamodel() {
			return null;
		}

		@Override
		public PersistenceUnitUtil getPersistenceUnitUtil() {
			return null;
		}

		@Override
		public Map<String, Object> getProperties() {
			return null;
		}

		@Override
		public boolean isOpen() {
			return false;
		}

		@Override
		public <T> T unwrap(Class<T> arg0) {
			return null;
		}
	}
	
	private class MockEntityQuery implements Query {

		@Override
		public int executeUpdate() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getFirstResult() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public FlushModeType getFlushMode() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<String, Object> getHints() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public LockModeType getLockMode() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getMaxResults() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Parameter<?> getParameter(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Parameter<?> getParameter(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> Parameter<T> getParameter(String arg0, Class<T> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> Parameter<T> getParameter(int arg0, Class<T> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T getParameterValue(Parameter<T> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object getParameterValue(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object getParameterValue(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Set<Parameter<?>> getParameters() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List getResultList() {
			ressourceList = q.getResultList();
			return ressourceList;
		}

		@Override
		public Object getSingleResult() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isBound(Parameter<?> arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Query setFirstResult(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query setFlushMode(FlushModeType arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query setHint(String arg0, Object arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query setLockMode(LockModeType arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query setMaxResults(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> Query setParameter(Parameter<T> arg0, T arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query setParameter(String arg0, Object arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query setParameter(int arg0, Object arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query setParameter(Parameter<Calendar> arg0, Calendar arg1,
				TemporalType arg2) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query setParameter(Parameter<Date> arg0, Date arg1,
				TemporalType arg2) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query setParameter(String arg0, Calendar arg1, TemporalType arg2) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query setParameter(String arg0, Date arg1, TemporalType arg2) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query setParameter(int arg0, Calendar arg1, TemporalType arg2) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query setParameter(int arg0, Date arg1, TemporalType arg2) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T unwrap(Class<T> arg0) {
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
		proband = new RessourcenDetailBean();
		EntityManagerFactory emf = new MockEntityManagerFactory();
		q = new MockEntityQuery();

		Class<? extends RessourcenDetailBean> clazz = proband.getClass();
		Field field = clazz.getDeclaredField("emf");
		field.setAccessible(true);
		field.set(proband, emf);
	}

	/**
	 * Testmethode für selectDatensatz()
	 * {@link org.shareezy.beans.TimePickerBean#addDatensatz()}.
	 */
	@Test
	public void testSelectDatensatz() {

		String antwort = proband.selectDatensatz();

		assertNull("Die Antwort muss null sein", antwort);
		assertTrue(
				"Es muss ein EntityManager aus einer Factory erzeugt worden sein",
				createEntityManagerSent);
		assertTrue(
				"Es muss eine Query erzeugt worden sein",
				createQuerySent);
		assertNotNull("Die Ressource darf nicht 'null' sein", ressource);
		assertNotNull("Die ResultList darf nicht 'null' sein", ressourceList);
	
	}
	
	/**
	 * Testmethode für testTimePicker()
	 * {@link org.shareezy.beans.RessourcenDetailBean#timePicker()}.
	 */
	@Test
	public void testTimePicker() {
		String picker = proband.timePicker();
		assertEquals(null, picker);
	}

	/**
	 * Testmethode für resourcePic() überprüft den Rückgabewert pic
	 * {@link org.shareezy.beans.RessourcenDetailBean#resourcePic()}.
	 */
	@Test
	public void testResourcePic() {
		Image bild = proband.resourcePic();
		assertEquals(pic, bild);
	}

	/**
	 * Testmethode für resourceSummary() überprüft den Rückgabewert summary
	 * {@link org.shareezy.beans.RessourcenDetailBean#resourceSummary()}.
	 */
	@Test
	public void testResourceSummary() {
		String sum = proband.resourceSummary();
		assertEquals(summary, sum);
	}

}
