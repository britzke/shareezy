/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013, 2014
 * 						Timo Kuchling
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
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.shareezy.beans.GroupMemberManagerBean;
import org.shareezy.entities.Benutzer;
import org.shareezy.entities.BenutzerGruppe;

/**
 * Testet die GroupMemberManagerBean
 * 
 * @author Timo Kuchling
 * @author burghard.britzke
 */
public class GroupMemberManagerBeanTest {

	private GroupMemberManagerBean proband;
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction transaction;
	private Benutzer user;
	private BenutzerGruppe userGrp = new BenutzerGruppe();
	private String nullTest = null;
	private int testBenutzerHash;
	private int testUserGrpHash;

	/**
	 * Setzt den Probanden und die Testumgebung auf.
	 * 
	 * @throws SecurityException
	 *             Wenn ein Security-Manager das Reflection verhindert
	 * @throws NoSuchFieldException
	 *             Wenn der Proband keine Eigenschaft "emf" hat
	 * @throws IllegalAccessException
	 *             Wenn nicht auf die Eigenschaft zugegriffen werden darf
	 *             (setAccessible(true) fehlt - Fehler im Test)
	 * @throws IllegalArgumentException
	 *             Wenn die Eigenschaft in ein anderes als das Probanden-Objekt
	 *             injiziert wird (Fehler im Test)
	 */
	@Before
	public void setUp() throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {
		proband = new GroupMemberManagerBean();
		user = new Benutzer();
		userGrp = new BenutzerGruppe();
		// Sichere Objekt Identität für den BenutzerArgumentMatcher
		testBenutzerHash = user.hashCode();
		testUserGrpHash = userGrp.hashCode();

		emf = mock(EntityManagerFactory.class);
		em = mock(EntityManager.class);
		when(emf.createEntityManager()).thenReturn(em);

		transaction = mock(EntityTransaction.class);
		when(em.getTransaction()).thenReturn(transaction);

		// Beschreibung der Klasse holen
		Class<? extends GroupMemberManagerBean> clazz = proband.getClass();
		// Beschreibung der Eigenschaft holen
		Field field = clazz.getDeclaredField("emf");
		// Zugriff auf private Eigenschaft erlauben
		field.setAccessible(true);
		// EntityManagerFactory in den Proband inizieren
		field.set(proband, emf);

		field = clazz.getDeclaredField("user");
		field.setAccessible(true);
		field.set(proband, user);

		field = clazz.getDeclaredField("userGrp");
		field.setAccessible(true);
		field.set(proband, userGrp);

	}

	/**
	 * Überprüft nach jedem Test, ob bestimmte Nachrichten während des Tests
	 * gesandt wurden.
	 */
	@After
	public void tearDown() {
		verify(emf).createEntityManager();
		verify(em).getTransaction();
		verify(transaction).begin();
		//
		verify(transaction).commit();
		verify(em).close();
	}

	/**
	 * Der BenutzerArgumentMatcher ist ein ArgumentMatcher, der sicherstellt, ob
	 * ein Benutzer als Argument geliefert wurde, dessen hashCode dem Kode
	 * entspricht, der in der Variablen 'testBenutzerHash' gespeichert ist.
	 * 
	 * @author Timo Kuchling
	 * @author burghard.britzke bubi@charmides.in-berlin.de
	 * @see ArgumentMatcher
	 */
	class BenutzerArgumentMatcher extends ArgumentMatcher<Benutzer> {

		/**
		 * Stellt sicher, dass als Argument ein Benutzer mit dem hashCode
		 * übergeben wurde, der in der variablen "testBenutzerHash gespeichert
		 * wurde.
		 * 
		 * @see ArgumentMatcher#matches(Object)
		 */
		public boolean matches(Object argument) {
			if (argument instanceof Benutzer
					&& (argument.hashCode() == testBenutzerHash)) {
				return true;
			} else {
				return false;
			}
		}
	}

	class BenutzerGruppeArgumentMatcher extends ArgumentMatcher<BenutzerGruppe> {

		/**
		 * Stellt sicher, dass als Argument ein BenutzerGruppe Objekt mit dem hashCode
		 * übergeben wurde, der in der variablen "testUserGrpHash gespeichert
		 * wurde.
		 * 
		 * @see ArgumentMatcher#matches(Object)
		 */
		public boolean matches(Object argument) {
			if (argument instanceof BenutzerGruppe
					&& (argument.hashCode() == testUserGrpHash)) {
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.GroupMemberManagerBean#addUser()}. Testet, ob
	 * ein Datensatz eingefügt wird.
	 */
	@Test
	public void testAddUser() {
		String antwort = proband.addUser();
		assertNull("Die Antwort muss null sein", antwort);

		verify(em).persist(Mockito.argThat(new BenutzerArgumentMatcher()));
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.GroupMemberManagerBean#deleteUser()}. Testet,
	 * ob ein Datensatz gelöscht wird.
	 */
	@Test
	public void testDeleteUser() {
		String antwort = proband.deleteUser();
		assertNull("Die Antwort muss null sein", antwort);
		
		verify(em).remove(Mockito.argThat(new BenutzerArgumentMatcher()));
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.GroupMemberManagerBean#deleteRequest()}.
	 * Testet, ob eine Anfrage für eine Gruppenmitgliedschaft gelöscht wird.
	 */
	@Test
	public void testDeleteRequest() {
		String antwort = proband.deleteRequest();
		assertNull(nullTest, antwort);

		verify(em).remove(Mockito.argThat(new BenutzerGruppeArgumentMatcher()));
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.GroupMemberManagerBean#sendRequest()}. Testet,
	 * ob ein Request gesendet wird.
	 */
	@Test
	public void testSendRequest() {
		String antwort = proband.sendRequest();
		assertNull(nullTest, antwort);

		verify(em).persist(Mockito.argThat(new BenutzerGruppeArgumentMatcher()));
	}
}
