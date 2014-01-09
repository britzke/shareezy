/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	Maurice Engelskirchen
 * 						Burak Cakir
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
import org.mockito.Mock;
import org.shareezy.beans.AccountBearbeitenBean;
import org.shareezy.beans.GroupMemberManagerBean;
import org.shareezy.entities.Benutzer;
import org.shareezy.entities.Ressource;

/**
 * Testet die Übersetzungseinheit <i>(Compilation Unit)</i>
 * {@link org.shareezy.beans.AccountBearbeitenBean}.
 *   
 * @author cakir
 * @author burghard.britzke bubi@charmides.in-berlin.de
 */
public class AccountBearbeitenBeanTest {
	private AccountBearbeitenBean proband;
	private EntityTransaction transaction;
	private EntityManager em;
	private EntityManagerFactory emf;
	private Benutzer user;


	/**
	 * Erzeugt ein neuen Probanden der zu testenden Klasse.
	 * 
	 * @throws java.lang.Exception
	 *             Wenn eine Situation auftritt, die in der Methode nich
	 *             berücksitigt wurde.
	 */
	@Before
	public void setUp() throws Exception {
		proband = new AccountBearbeitenBean();
		emf = mock(EntityManagerFactory.class);
		em = mock(EntityManager.class);
		transaction = mock(EntityTransaction.class);
		user = mock(Benutzer.class);
				
		when(em.getTransaction()).thenReturn(transaction);
		when(emf.createEntityManager()).thenReturn(em);
		
		Class<? extends AccountBearbeitenBean> clazz = proband.getClass();
		Field field = clazz.getDeclaredField("emf");
		field.setAccessible(true);
		field.set(proband, emf);
	}

	/**
	 * Test-Methode für
	 * {@link org.shareezy.beans.AccountBearbeitenBean#eingabePrüfen(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}
	 * . Testet, dass die Antwort <em>null</em> ist, d.h. es findet keine
	 * Navigation zu einer andern Seite statt.
	 */
	@Test
	public void testEingabePrüfen() {
		String antwort = proband.eingabePrüfen();
		assertNull(antwort);
	}

	/**
	 * Test-Methode für
	 * {@link org.shareezy.beans.AccountBearbeitenBean#datensatzÄndern(java.lang.String, java.lang.String)}
	 * . Testet, dass die Antwort <em>null</em> ist, d.h. es findet keine
	 * Navigation zu einer andern Seite statt.
	 */
	@Test
	public void testDatensatzÄndern() {
		String antwort = proband.datensatzÄndern();
		assertNull(antwort);
		
		verify(emf).createEntityManager();
		verify(em).getTransaction();
		verify(transaction).begin();
		verify(em).remove(any());
		verify(transaction).commit();
		verify(em).close();
		verify(em).remove(em.merge(user));
	}
}
