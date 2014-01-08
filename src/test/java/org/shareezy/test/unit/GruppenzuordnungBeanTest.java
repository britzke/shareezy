/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	e1_herrmann
 * 						burghard.britzke (bubi@charmides.in-berlin.de)
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

import java.util.List;
import java.util.Map;

import javax.persistence.Cache;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.SynchronizationType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;

import org.junit.Before;
import org.junit.Test;
import org.shareezy.beans.GruppenzuordnungBean;

/**
 * Testet die GruppenzuordnungsBean.
 * 
 * @author e1_hermann
 * @author burghard.britzke (bubi@charmides.in-berlin.de)
 */
public class GruppenzuordnungBeanTest {

	public GruppenzuordnungBean proband;
	public String account_id;
	public String accounts_id;

	/**
	 * Attrappe für ein EntityManager-Objekt zum Testen der
	 * GruppenzuordnungBean.
	 * 
	 * @author britzke
	 */
	public class MockEntityManager implements EntityManager {
		public EntityManager createEntityManager() {
			return new MockEntityManager();
		}

		@Override
		public void clear() {
		}

		@Override
		public void close() {
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

		@Override
		public Query createQuery(String arg0) {
			return null;
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
		public EntityTransaction getTransaction() {
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
		public void persist(Object arg0) {
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
	}

	/**
	 * Attrappe für eine EntityManagerFactory zum Testen der
	 * GruppenzuordnungsBean.
	 * 
	 * @author e1_herrmann
	 * @author britzke
	 */
	public class MockEntityManagerFactory implements EntityManagerFactory {

		@Override
		public EntityManager createEntityManager() {
			return null;
		}

		@Override
		public EntityManager createEntityManager(Map map) {
			return null;
		}

		@Override
		public EntityManager createEntityManager(
				SynchronizationType synchronizationType) {
			return null;
		}

		@Override
		public EntityManager createEntityManager(
				SynchronizationType synchronizationType, Map map) {
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
		public boolean isOpen() {
			return false;
		}

		@Override
		public void close() {
		}

		@Override
		public Map<String, Object> getProperties() {
			return null;
		}

		@Override
		public Cache getCache() {
			return null;
		}

		@Override
		public PersistenceUnitUtil getPersistenceUnitUtil() {
			return null;
		}

		@Override
		public void addNamedQuery(String name, Query query) {

		}

		@Override
		public <T> T unwrap(Class<T> cls) {
			return null;
		}

		@Override
		public <T> void addNamedEntityGraph(String graphName,
				EntityGraph<T> entityGraph) {
		}
	}

	/**
	 * Initalisierung der Testumgebung für alle Tests der GruppenzuordnungBean.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		proband = new GruppenzuordnungBean();
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.Gruppenzuordnung#mitgliederabfragen()}.
	 */
	@Test
	public void testmitgliederabfragen() {
		String a = proband.mitgliederabfragen();
		assertEquals(account_id, a);
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.Gruppenzuordnung#ressourcestatus()}.
	 */
	@Test
	public void testRessourcestatus() {
		String b = proband.mitgliederabfragen();
		assertEquals(accounts_id, b);
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.Gruppenzuordnung#mitgliedentfernen()}.
	 */
	@Test
	public void testMitgliedentfernen() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.Gruppenzuordnung#addressourcen(int)}.
	 */
	@Test
	public void testAddressourcen() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.Gruppenzuordnung#editressource()}.
	 */
	@Test
	public void testEditressource() {
		fail("Not yet implemented");
	}
}
