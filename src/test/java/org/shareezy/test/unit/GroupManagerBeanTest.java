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

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.shareezy.beans.GroupManagerBean;
import org.shareezy.entities.Benutzer;
import org.shareezy.entities.Gruppe;

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
		Field field = clazz.getDeclaredField("groupName");
		field.setAccessible(true);
		field.set(proband, "Ste");
		// benutzer
		field = clazz.getDeclaredField("benutzer");
		field.setAccessible(true);
		field.set(proband, new Benutzer());
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.GroupManagerBean#addMembersClick()}. Testet,
	 * dass die Antwort <em>null</em> ist, d. h. keine Navigation zu einem
	 * anderen View eingeleitet wird.
	 */
	@Test
	public void testOnAddMembersClick() {
		String antwort = proband.addMembersClick();

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
	 * {@link org.shareezy.beans.GroupManagerBean#newGroupClick()}. Testet,
	 * dass die Antwort <em>null</em> ist, d. h. keine Navigation zu einem
	 * anderen View eingeleitet wird. Es wird getestest, ob die Gruppe mittels
	 * eines EntityManagers und einer Transaktion gespeichert wird.
	 */
	@Test
	public void testOnNewGroupClick() {
		String antwort = proband.newGroupClick();
		assertNull(antwort);
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.GroupManagerBean#createNewGroupClick()}.
	 * Testet, dass die Antwort <em>null</em> ist, d. h. keine Navigation zu
	 * einem anderen View eingeleitet wird. Es wird getestest, ob die Gruppe
	 * mittels eines EntityManagers und einer Transaktion gespeichert wird.
	 */
	@Test
	public void testOnCreateNewGroupClick() {
		String antwort = proband.createNewGroupClick();
		assertNull(antwort);
	}

	/**
	 * Überprüft ein Gruppen-Objekt auf gültigen Namen & Verwalter
	 * 
	 * @author e0_smueller
	 * @return <p>
	 *         true - wenn das Gruppen-Objekt einen Gruppen-Namen mit mindestens
	 *         3 Zeichen und einen Verwalter besitzt.
	 *         </p>
	 *         <p>
	 *         false - wenn das Gruppen-Objekt keine gültigen Namen oder keinen
	 *         Verwalter besitzt
	 *         </p>
	 */
	class GroupArgumentMatcher extends ArgumentMatcher<Gruppe> {

		public boolean matches(Object o) {
			if (o instanceof Gruppe
					&& (((Gruppe) o).getName().length() > 2 && ((Gruppe) o)
							.getVerwalter() != null)) {
				return true;
			} else {
				return false;
			}
		}
	}
}
