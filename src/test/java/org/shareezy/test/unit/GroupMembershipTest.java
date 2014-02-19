/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	Maxim Slipachuk
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;
import org.shareezy.beans.GroupMembership;

/**
 * Testet die GroupMembershipBean
 * 
 * @author e1_slipachuk
 * @author burghard.britzke
 */
public class GroupMembershipTest {

	private GroupMembership proband;
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction transaction;

	/**
	 * Setzt den Probanden und die Testumgebung vor jedem Test auf.
	 * 
	 * @throws Exception
	 */
	@Before
	public void struktur() {
		proband = new GroupMembership();
		emf = mock(EntityManagerFactory.class);
		em = mock(EntityManager.class);
		transaction = mock(EntityTransaction.class);
		
		when(emf.createEntityManager()).thenReturn(em);
		when(em.getTransaction()).thenReturn(transaction);

	}

	/**
	 * Test method for {@link org.shareezy.beans.GroupMembership#sendAnfrage()}.
	 * Testet, ob <i>keine</i> Navigation zu einem anderen View eingeleitet
	 * wird.
	 */
	@Test
	public void testSendAnfrage() {
		String antwort = proband.sendAnfrage();
		assertNull(antwort);
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.GroupMembership#knopfGruppeVerlassen()}.
	 * Testet, ob <i>keine</i> Navigation zu einem anderen View eingeleitet
	 * wird.
	 */
	@Test
	public void testKnopfGruppeVerlassen() {
		String antwort = proband.knopfGruppeVerlassen();
		assertNull(antwort);
	}
}
