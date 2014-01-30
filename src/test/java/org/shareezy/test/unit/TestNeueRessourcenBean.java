/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	Thomas Klawitter
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

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.lang.reflect.Field;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
	@Mock
	private EntityManagerFactory emf;
	@Mock
	public EntityManager em;
	@Mock
	private EntityTransaction transaction;
	@Mock
	private Ressource ressource;

	/**
	 * Die Annotation <code>Before</code> sorgt dafür das vor dem Test die
	 * folgende Methode ausgeführt wird, damit der Test vorbereitet werden kann.
	 * Außerßerdem wird ein NeureRessourceBean Objekt erstellt und proband
	 * zugewiesen. Dieser Proband wird noch nciht genutzt.
	 */
	@Before
	public void aufbau() throws Exception {
		// Hiermit wird sichergestellt, dass die @Mock Annotationen verfügbar
		// sind.
		MockitoAnnotations.initMocks(this);
		proband = new NeueRessourceBean();
		when(emf.createEntityManager()).thenReturn(em);
		when(em.getTransaction()).thenReturn(transaction);
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
	public void testLoescheRessource() {
		String rueckgabewert = proband.loescheRessource(ressource);
		verify(emf).createEntityManager();
		verify(em).getTransaction();
		verify(transaction).begin();
		verify(em).merge(ressource);
		verify(em).remove(any());
		// 2 Variante für Testing der remove Methode - Intention: Es soll
		// sichergestellt werden, dass ein Ressourcenobjekt gelöscht wird.
		// verify(em).remove(em.merge(ressource));
		verify(transaction).commit();
		verify(em).close();
		assertEquals(rueckgabewert,"RessourcenListen.xhtml");

	}

	@Test
	public void testSpeichern() {
		proband.speichern();
		verify(emf).createEntityManager();
		verify(em, times(2)).getTransaction();
		verify(em).persist(any());
		verify(em).close();

	}
}
