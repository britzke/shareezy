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

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;
import org.shareezy.beans.AccountBearbeitenBean;
import org.shareezy.entities.Benutzer;

/**
 * Testet die Übersetzungseinheit <i>(Compilation Unit)</i>
 * {@link org.shareezy.beans.AccountBearbeitenBean}.
 *   
 * @author cakir
 * @author Maurice Engelskirchen
 * @author burghard.britzke bubi@charmides.in-berlin.de
 */
public class AccountBearbeitenBeanTest {

	/**
	 * Erzeugt ein neuen Probanden der zu testenden Klasse.
	 * 
	 * @throws java.lang.Exception
	 *             Wenn eine Situation auftritt, die in der Methode nich
	 *             berücksitigt wurde.
	 */

	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction transaction;
	private AccountBearbeitenBean proband;
	private Benutzer benutzer;

	@Before
	public void setUp() throws Exception {

		proband = new AccountBearbeitenBean();

		// Beschreibung der Klasse holen
		Class<? extends AccountBearbeitenBean> clazz = proband.getClass();

		emf = mock(EntityManagerFactory.class);
		em = mock(EntityManager.class);
		benutzer = mock(Benutzer.class);

		when(emf.createEntityManager()).thenReturn(em);

		transaction = mock(EntityTransaction.class);
		when(em.getTransaction()).thenReturn(transaction);
		
		FacesContext faces = mock(FacesContext.class);

		Field field = clazz.getDeclaredField("faces");
		field.setAccessible(true);
		field.set(proband, faces);
		
		field = clazz.getDeclaredField("emf");
		field.setAccessible(true);
		field.set(proband, emf);

		field = clazz.getDeclaredField("altesPasswort");
		field.setAccessible(true);
		field.set(proband, "altesPasswort");

		field = clazz.getDeclaredField("eingabePasswort");
		field.setAccessible(true);
		field.set(proband, "eingabePasswort");

	}

	/**
	 * Test-Methode für
	 * {@link org.shareezy.beans.AccountBearbeitenBean#eingabePrüfen(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}
	 * . Testet, dass die Antwort <em>null</em> ist, d.h. es findet keine
	 * Navigation zu einer andern Seite statt.
	 */

	@Test
	public void testEingabePrüfen() {

		final String PASSWORT = "123";
		when(benutzer.getKennwort()).thenReturn(PASSWORT);
		proband.setEingabePasswort(PASSWORT);

		proband.eingabePrüfen();

	}

	/**
	 * Test-Methode für
	 * {@link org.shareezy.beans.AccountBearbeitenBean#datensatzÄndern(java.lang.String, java.lang.String)}
	 * . Testet, dass die Antwort <em>null</em> ist, d.h. es findet keine
	 * Navigation zu einer andern Seite statt.
	 */
	@Test
	public void testDatensatzÄndern() {
		
		proband.datensatzÄndern();
		verify(emf).createEntityManager();
		verify(em).getTransaction();
		verify(transaction).begin();
		verify(transaction).commit();
		verify(em).close();
	}
}








