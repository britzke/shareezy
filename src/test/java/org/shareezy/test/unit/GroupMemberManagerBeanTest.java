/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	Timo Kuchling
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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.shareezy.beans.GroupManagerBean;
import org.shareezy.beans.GroupMemberManagerBean;
import org.shareezy.entities.Benutzer;

public class GroupMemberManagerBeanTest {

	private GroupMemberManagerBean proband;
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction transaction;
	private Benutzer user;
	private String nullTest = null;

	/**
	 * Setzt den Probanden auf.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		proband = new GroupMemberManagerBean();
		user = mock(Benutzer.class);
		
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
		field.set(proband, user );
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.GroupMemberManagerBean#addUser()}.
	 * Testet, ob ein Datensatz eingefügt wird.
	 */
	@Test
	public void testAddUser() {
		String antwort = proband.addUser();
		assertNull("Die Antwort muss null sein", antwort);
		
		verify(emf).createEntityManager();
		verify(em).getTransaction();
		verify(transaction).begin();
		verify(em).persist(any());
		verify(transaction).commit();
		verify(em).close();
	}
	class MessagesArgumentMatcher extends ArgumentMatcher {
		String userKurzname = "test";
		GroupMemberManagerBean testProband = proband;
		Benutzer testUser = testProband.getUser();
		
		         public boolean matches(Object o) {
		        	 if(testUser.getKurzname() == userKurzname){
		        		 System.out.println("UserKurzname ist 'test'");
		        		 return true;
		        	 }
		             return false;
		         }
		     }

	/**
	 * Test method for
	 * {@link org.shareezy.beans.GroupMemberManagerBean#deleteUser()}.
	 * Testet, ob ein Datensatz gelöscht wird.
	 */
	@Test
	public void testDeleteUser() {
		String antwort = proband.deleteUser();
		assertNull("Die Antwort muss null sein", antwort);
		
		verify(emf).createEntityManager();
		verify(em).getTransaction();
		verify(transaction).begin();
		verify(em).remove(Mockito.argThat(new MessagesArgumentMatcher()));
		verify(transaction).commit();
		verify(em).close();
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.GroupMemberManagerBean#deleteRequest()}.
	 * Testet, ob ein Request gelöscht wird.
	 */
	@Test
	public void testDeleteRequest() {
		String antwort = proband.deleteRequest();
		assertNull(nullTest, antwort);
	}
	
	/**
	 * Test method for
	 * {@link org.shareezy.beans.GroupMemberManagerBean#sendRequest()}.
	 * Testet, ob ein Request gesendet wird.
	 */
	@Test
	public void testSendRequest() {
		String antwort = proband.sendRequest();
		assertNull(nullTest, antwort);
	}
}
