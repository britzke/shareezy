package org.shareezy.test.unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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
import org.shareezy.beans.GroupManagerBean;
import org.shareezy.entities.Benutzer;

public class GroupManagerBeanTest {

	public boolean closeSent;
	public boolean getTransactionSent;
	public boolean beginSent;
	public boolean commitSent;
	public boolean createEntityManagerSent;
	public boolean persistSent;
	public Benutzer benutzer;

	/**
	 * Eine MockTransaction ist eine EntityTransaction, die ausschließlich als
	 * Attrappe für Tests benutzt wird.
	 */
	public class MockTransaction implements EntityTransaction {

		/**
		 * Vermerkt, ob die Transaction gestartet wurde.
		 */
		@Override
		public void begin() {
			beginSent = true;
		}

		/**
		 * Vermerkt, ob die Transaction erfolgreich beendet wurde.
		 */
		@Override
		public void commit() {
			commitSent = true;
		}

		@Override
		public void rollback() {
		}

		// -------------------------------------------
		// Die Methoden unterhalb werden nicht benutzt
		@Override
		public boolean getRollbackOnly() {
			return false;
		}

		@Override
		public boolean isActive() {
			return false;
		}

		@Override
		public void setRollbackOnly() {
		}
	}

	/**
	 * Ein MockEntityManager ist ein EntityManager, der ausschließlich als
	 * Attrappe (MOCK) zum Testen verwendet wird.
	 */

	private GroupManagerBean proband;
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction transaction;

	/**
	 * Setzt den Probanden auf.
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

		proband = new GroupManagerBean();

		// Beschreibung der Klasse holen
		Class<? extends GroupManagerBean> clazz = proband.getClass();
		// Beschreibung der Eigenschaft holen
		Field field = clazz.getDeclaredField("emf");
		// Zugriff auf private Eigenschaft erlauben
		field.setAccessible(true);
		// EntityManagerFactory in den Proband inizieren
		field.set(proband, emf);
		
		field = clazz.getDeclaredField("name");
		field.setAccessible(true);
		field.set(proband,"StevensGroup");
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.GroupManagerBean#onAddMembersClick()}.
	 */
	@Test
	public void testOnAddMembersClick() {
		String antwort = proband.onAddMembersClick();

//		assertNull("die Antwort muss null sein", antwort);
//
//		assertNotNull("Der Benutzer darf nich 'null' sein", benutzer);
//		assertTrue(
//				"Die Transaktion muss erfolgreich abgeschlossen worden sein",
//				commitSent);
//		assertTrue("Der EntityManager muss geschlossen werden", closeSent);
	}

	@Test
	public void testOnCreateNewGroupClick() {
		String antwort = proband.onCreateNewGroupClick();

		verify(emf).createEntityManager();
		verify(em).getTransaction();
		verify(transaction).begin();
		verify(em).persist(any());

		

	}
}
