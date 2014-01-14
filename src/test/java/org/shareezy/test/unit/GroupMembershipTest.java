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
import org.shareezy.beans.GroupMembership;
import org.shareezy.beans.NeueRessourceBean;
import org.shareezy.entities.Ressource;

/**
 * Testet die GroupMembershipBean
 * @author e1_slipachuk
 */
public class GroupMembershipTest {
	
	private GroupMembership proband;
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction transaction;
	
	
	
	@Before
	public void struktur() throws Exception {
		proband = new GroupMembership();
		emf= mock(EntityManagerFactory.class);
		em = mock(EntityManager.class);
		transaction = mock(EntityTransaction.class);
	
		
		when(emf.createEntityManager()).thenReturn(em);
		when(em.getTransaction()).thenReturn(transaction);
	

	}
	/**
	 * Test method for {@link org.shareezy.beans.GroupMembership#GroupMembership()}.
	 */
		
	/**
	 * Test method for {@link org.shareezy.beans.GroupMembership#sendAnfrage()}.
	 */
	@Test
	public void testSendAnfrage() {
		fail("sendet anfrage");
	}

	/**
	 * Test method for {@link org.shareezy.beans.GroupMembership#knopfGruppeVerlassen()}.
	 */
	@Test
	public void testKnopfGruppeVerlassen() {
		fail("leave the group");
	}
}
