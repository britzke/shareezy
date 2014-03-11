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

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.shareezy.beans.NeueRessourceBean;
import org.shareezy.entities.Ressource;
import org.shareezy.entities.Typ;

/**
 * Eine Testklasse/Testcase zum testen der NeueRessourcenBean.
 * 
 * @author Klawitter, Mueller, Chenaux, Treibmann
 *
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
	@Mock
	private Query query;
	@Mock
	private Typ typ;

	/**
	 * Erzeugt eine Testumgebung für den Probanden.
	 */
	@Before
	public void aufbau() throws Exception {
	
		ArrayList<Typ> typliste = new ArrayList<Typ>();
		typliste.add(typ);
		MockitoAnnotations.initMocks(this);
		proband = new NeueRessourceBean();
		when(emf.createEntityManager()).thenReturn(em);
		when(em.getTransaction()).thenReturn(transaction);
		when(em.createQuery((String)any())).thenReturn(query);
		when(query.getResultList()).thenReturn(typliste);
		Class<? extends NeueRessourceBean> klasse = proband.getClass();
		Field field = klasse.getDeclaredField("emf");
		field.setAccessible(true);
		field.set(proband, emf);
		field = klasse.getDeclaredField("em");
		field.setAccessible(true);
		field.set(proband, em);
	}

	/**
	 * In der testSpeichern() Methode wird getestet ob zu speichernden Daten
	 * an das ressource Objekt gemerged werden.
	 */
	
	@Test
	public void testSpeichern() {
		
		proband.setRessource(ressource);
		proband.setTyp(typ);
		proband.speichern();
		verify(emf).createEntityManager();
		verify(em, times(2)).getTransaction();
		verify(em).merge(any());
		verify(em).close();

	}
	
	/**
	 * In der testInit() Methode wird ein leeres ressourcen Objekt 
	 * in die Datenbank geschrieben, dieses wird später befüllt.
	 */
	@Test
	public void testInit(){
		
		proband.init();
		verify(emf).createEntityManager();
		verify(em).getTransaction();
		verify(em).persist(any());
		verify(em).close();
	}

}
