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

import org.junit.Before;
import org.junit.Test;
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
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction transaction;
	private Ressource ressource;
	public boolean createEntityManager;
	public boolean getEntityTransaction;
	public boolean entBegin;
	public boolean mergeausgeführt;
	public boolean entCommit;
	public boolean entityManagerClose;
	public boolean emRemove;
	


	/**
	 * Die Annotation <code>Before</code> sorgt dafür das vor dem Test die
	 * folgende Methode ausgeführt wird, damit der Test vorbereitet werden kann.
	 * Außerßerdem wird ein NeureRessourceBean Objekt erstellt und proband
	 * zugewiesen. Dieser Proband wird noch nciht genutzt.
	 */
	@Before
	public void aufbau() throws Exception {
		proband = new NeueRessourceBean();
		emf= mock(EntityManagerFactory.class);
		em = mock(EntityManager.class);
		transaction = mock(EntityTransaction.class);
		ressource = mock(Ressource.class);
		
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
	public void testNeueRessource() {

		String rueckgabewert = proband.loescheRessource(ressource);
		verify(emf).createEntityManager();
		verify(em).getTransaction();
		verify(transaction).begin();
		verify(em).merge(ressource);
		verify(em).remove(any());
		//2 Variante für Testing der remove Methode - Intention: Es soll sichergestellt werden, dass ein Ressourcenobjekt gelöscht wird.
		//verify(em).remove(em.merge(ressource));
		verify(transaction).commit();
		verify(em).close();
	}

}
