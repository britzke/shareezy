/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	Steven Müller
 * 						burghard.britzke bubi@charmides.in-berlin.de
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
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;
import org.shareezy.beans.GroupManagerBean;
import org.shareezy.entities.Benutzer;

/**
 * Test für die GroupManagerBean.
 * 
 * @author Steven Müller
 * @author britzke bubi@charmides.in-berlin.de
 */
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
	 * 
	 * @author burghard.britzke bubi@charmides.in-berlin.de
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
	 * Setzt den Probanden und die Testumgebung für ihn auf.
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
		field.set(proband, "StevensGroup");
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.GroupManagerBean#onAddMembersClick()}. Testet,
	 * dass die Antwort <em>null</em> ist, d. h. keine Navigation zu einem
	 * anderen View eingeleitet wird.
	 */
	@Test
	public void testOnAddMembersClick() {
		String antwort = proband.onAddMembersClick();

		assertNull("die Antwort muss null sein", antwort);
		//
		// assertNotNull("Der Benutzer darf nich 'null' sein", benutzer);
		// assertTrue(
		// "Die Transaktion muss erfolgreich abgeschlossen worden sein",
		// commitSent);
		// assertTrue("Der EntityManager muss geschlossen werden", closeSent);
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.GroupManagerBean#onCreateNewGroupClick()}.
	 * Testet, dass die Antwort <em>null</em> ist, d. h. keine Navigation zu
	 * einem anderen View eingeleitet wird. Es wird getestest, ob die Gruppe
	 * mittels eines EntityManagers und einer Transaktion gespeichert wird.
	 */
	@Test
	public void testOnCreateNewGroupClick() {
		String antwort = proband.onCreateNewGroupClick();

		assertNull(antwort);
		verify(emf).createEntityManager();
		verify(em).getTransaction();
		verify(transaction).begin();
		verify(em).persist(any());
	}
}
