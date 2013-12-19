/**
 * 
 */
package org.shareezy.test.unit;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
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
import org.shareezy.beans.NeueRessourceBean;
import org.shareezy.entities.Ressource;

/**
 * Eine Testklasse/Testcase zum testen der NeueRessourcenBean
 * 
 * @author e1_klawitter
 * @author tim treibmann
 */
public class TestNeueRessourcenBean {

	private NeueRessourceBean proband;
	private EntityManagerFactory emf;
	private Ressource ressource;
	public boolean createEntityManager;
	public boolean getEntityTransaction;
	public boolean entBegin;
	public boolean mergeausgeführt;
	public boolean entCommit;
	public boolean entityManagerClose;
	public boolean emRemove;

	/**
	 * Eine MockEntityManagerFactory ist eine EntityManagerFactory, die
	 * ausschließlich als Attrappe (MOCK) zum Testen verwendet wird.
	 * 
	 * @author Tim Treibmann
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
			createEntityManager = true;
			return new MockEntityManager();
		}

		// ------------------------------------------------------------
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

	/**
	 * Ein MockEntityManager ist ein EntityManager, der ausschließlich als
	 * Attrappe (MOCK) zum Testen verwendet wird.
	 * 
	 * @author Tim Treibmann
	 */
	private class MockEntityManager implements EntityManager {

		/**
		 * 
		 * Vermerkt, ob eine Transaction vom EntityManager abgefragt wurde.
		 * Antwortet mit einer MockTransaction.
		 */
		@Override
		public EntityTransaction getTransaction() {
			getEntityTransaction = true;
			return new MockEntityTransaction();
		}

		/**
		 * Vermerkt, ob der EntityManager geschlossen wurde.
		 */
		@Override
		public void close() {
			entityManagerClose = true;

		}

		/**
		 * Vermerkt, ob der EntityManager ein managesbares Objekt, welches er
		 * als Parameter übergeben bekam, entfernt wurde.
		 */
		@Override
		public void remove(Object arg0) {
			emRemove = true;
			ressource = null;

		}

		/**
		 * Vermerkt, ob von einen nicht managebarem Objekt eine managebare Kopie
		 * erstellt wurde
		 */
		@Override
		public <T> T merge(T arg0) {
			mergeausgeführt = true;
			return null;
		}

		// -----------------------------------------------------
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
	 * Eine MockTransaction ist eine EntityTransaction, die ausschließlich als
	 * Attrappe für Tests benutzt wird.
	 * 
	 * @author Tim Treibmann
	 */
	private class MockEntityTransaction implements EntityTransaction {

		/**
		 * Vermerkt, ob die Transaction gestartet wurde.
		 */
		@Override
		public void begin() {
			entBegin = true;
		}

		/**
		 * Vermerkt, ob die Transaction erfolgreich beendet wurde.
		 */
		@Override
		public void commit() {
			entCommit = true;

		}

		// -----------------------------
		@Override
		public boolean getRollbackOnly() {

			return false;
		}

		@Override
		public boolean isActive() {

			return false;
		}

		@Override
		public void rollback() {

		}

		@Override
		public void setRollbackOnly() {

		}
	}

	/**
	 * Eine MockRessource ist eine EntityRessource, die ausschließlich als
	 * Attrappe (MOCK) zum Testen verwendet wird.
	 * 
	 * @author e1_treibmann
	 * 
	 */
	private class MockRessource extends Ressource {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	}

	/**
	 * Die Annotation <code>Before</code> sorgt dafür das vor dem Test die
	 * folgende Methode ausgeführt wird, damit der Test vorbereitet werden kann.
	 * Außerßerdem wird ein NeureRessourceBean Objekt erstellt und proband
	 * zugewiesen. Dieser Proband wird noch nciht genutzt.
	 */
	@Before
	public void aufbau() throws Exception {
		proband = new NeueRessourceBean();
		emf = new MockEntityManagerFactory();
		ressource = new MockRessource();
		Class<? extends NeueRessourceBean> klasse = proband.getClass();
		Field field = klasse.getDeclaredField("emf");
		field.setAccessible(true);
		field.set(proband, emf);
	}

	/**
	 * Die Annotation Test identifiziert die Methode als Test. Es wird getestet
	 * ob ein Objekt aus der Datenbank gelösct wird.
	 */
	@Test
	public void testNeueRessource() {

		String rueckgabewert = proband.loescheRessource(ressource);
		assertNull("Der Rückgabewert muss Null sein", rueckgabewert);
		assertTrue("Es muss ein EntityManager erzeugt werden",
				createEntityManager);
		assertTrue("Es muss eine EntityTransaction zurückgeben werden",
				getEntityTransaction);
		assertTrue(
				"Es muss die methode begin() der Transaction ausgeführt werden",
				entBegin);
		assertTrue(
				"Es muss die methode merge() des EntityManagers ausgefürt werden",
				mergeausgeführt);
		assertTrue(
				"Es muss die methode remove des EntityManagers ausgeführt werden",
				emRemove);
		assertNull(ressource);
		assertTrue(
				"Es muss die methode commit() der Transaction ausgeführt werden",
				entCommit);
		assertTrue(
				"Es muss die methode close() des Entitymanagers durchgeführt werden",
				entityManagerClose);

	}

}
