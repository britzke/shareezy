/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	Tim Treibmann
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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.shareezy.beans.AktuelleRessourceBean;
import org.shareezy.beans.RessourceListen;
import org.shareezy.entities.Ressource;

/**
 * Eine TestUnit, in der verschiedene Funktionalitäten/Methoden der
 * {@link org.shareezy.beans.RessourcenListen} getestet werden können.
 * 
 * @author e1_treibmann
 * 
 */
public class TestRessourcenListen {

	private RessourceListen proband;
	@Mock
	private EntityManagerFactory emf;
	@Mock
	private EntityManager em;
	@Mock
	private EntityTransaction transaction;
	@Mock
	private Query query;
	private final String queryString = "select r from Ressource r";
	@Mock
	private List<Ressource> list;

	@Mock
	private Ressource ressource;
	@Mock
	private AktuelleRessourceBean aktRessourceBean;

	/**
	 * Diese Methode erstellt beim erstmaligen Testaufruf einen Probanden vom
	 * Typ RessourceListen
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		proband = new RessourceListen();

		Class<? extends RessourceListen> klasse = proband.getClass();
		Field field = klasse.getDeclaredField("emf");
		field.setAccessible(true);
		field.set(proband, emf);

		when(emf.createEntityManager()).thenReturn(em);
		when(em.getTransaction()).thenReturn(transaction);
		when(em.createQuery(queryString)).thenReturn(query);
		when(query.getResultList()).thenReturn(list);
		when(list.size()).thenReturn(0).thenReturn(1);
		

	}

	/**
	 * Dies ist eine Testmethode für die ressourceClickedmethode. Sie überprüft
	 * ob der Rückgabewert der Methode ressourceClicked mit ressourcendetail
	 * übereinstimmt
	 * {@link org.shareezy.beans.RessourceListen#ressourceClicked()}.
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	@Test
	public void testRessourceClicked() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Class<? extends RessourceListen> klasse = proband.getClass();
		Field field = klasse.getDeclaredField("aktuelleressource");
		field.setAccessible(true);
		field.set(proband, aktRessourceBean);
		
		String nav = proband.ressourceClicked(ressource);
		verify(aktRessourceBean).setRessource(ressource);
		assertEquals("ressourcendetail", nav);
	}

	/**
	 * Dies ist eine Testmethode für die GetRessourcenListemethode. Es wird
	 * überprüft ob ein EntityManager erzeugt wird. Es wird überprüft ob
	 * Transactions ausgeführt werden. Es wird überprüft ob eine bestimmte Query
	 * durchgeführt wird. Es wird überprüft ob ein Resultset erstellt wird. Es
	 * wird überprüft ob alle Zweige der If-Anweisung abgefragt werden. Je nach
	 * Konditionen. Es wird der Rückgabewert überprüft.
	 */
	@Test
	public void testQueryRessourcenListe() {
		proband.queryRessourcenListe();
		verify(emf).createEntityManager();
		verify(em, times(2)).getTransaction();
		verify(em).createQuery(queryString);
		verify(query).getResultList();
	}

}
