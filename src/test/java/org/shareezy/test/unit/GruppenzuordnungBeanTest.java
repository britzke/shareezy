/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	e1_herrmann
 * 						burghard.britzke (bubi@charmides.in-berlin.de)
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
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
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
import org.shareezy.beans.GruppenzuordnungBean;
import org.shareezy.entities.Gruppe;
import org.shareezy.entities.Ressource;
 
/**
 * Testet die GruppenzuordnungsBean.
 * 
 * @author e1_hermann
 * @author burghard.britzke (bubi@charmides.in-berlin.de)
 */
public class GruppenzuordnungBeanTest {
	
	private EntityTransaction et;
	private EntityManager em;
	private EntityManagerFactory emf;
	private GruppenzuordnungBean proband;
	private List<Ressource> res;
	private List<Gruppe> grp;
	
	private String qstring = "SELECT * from RESSOURCEN, VERFÜGBARKEITEN where ID!=RESSORCEN_ID;";
	private Query query;

	/**
	 * Initalisierung der Testumgebung für alle Tests der GruppenzuordnungBean.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		proband = new GruppenzuordnungBean();
		emf = mock(EntityManagerFactory.class);
		em = mock(EntityManager.class);
		et = mock(EntityTransaction.class);
		query = mock(Query.class);
		when(emf.createEntityManager()).thenReturn(em);
		when(em.createQuery(eq(qstring))).thenReturn(query);
		when(em.getTransaction()).thenReturn(et);
		
		Class<? extends GruppenzuordnungBean> clazz = proband.getClass();
		
		Field f = proband.getClass().getDeclaredField("emf");
		f.setAccessible(true);
		f.set(proband, emf);
		
		
	}


	/**
	 * Test method for
	 * {@link org.shareezy.beans.GruppenzuordnungBean#mitgliederabfragen()}.
	 * Überprüft, ob das Objekt mit einem null-Objekt antwortet.
	 */
	@Test
	public void testMitgliederabfragen() {
		String antwort = proband.mitgliederabfragen();
		assertNull("die Antwort muss null sein", antwort);
		
		verify(emf).createEntityManager();
		verify(em).createQuery(eq(qstring));
		verify(em).close();
		
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.GruppenzuordnungBean#ressourcegruppe()}.
	 */
	@Test
	public void testressourcegruppe() {

	}
}