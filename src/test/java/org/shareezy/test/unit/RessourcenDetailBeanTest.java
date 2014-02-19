/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	Vanessa Krohn
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
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.Image;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.shareezy.beans.RessourcenDetailBean;
import org.shareezy.entities.Ressource;

/**
 * JUnit-Test zum Testen der Beans und dessen Methoden
 * 
 * @author Vanessa Krohn
 * 
 */
public class RessourcenDetailBeanTest {

	private RessourcenDetailBean proband;
	private Image pic;
	private String summary;

	public boolean createEntityManagerSent;
	public boolean createQuerySent;
	public Ressource ressource;
	public Query q;
	public List<Ressource> ressourceList;
	private EntityManager em;
	private EntityManagerFactory emf;

	/**
	 * Erzeugt einen neuen Probanden der zutestenden Klasse.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		emf = mock(EntityManagerFactory.class);
		em = mock(EntityManager.class);
		when(emf.createEntityManager()).thenReturn(em);
		q = mock(Query.class);
		when(em.createQuery("select re from Ressource re")).thenReturn(q);
		// ressourceList = mock(List.class);
		when(q.getResultList()).thenReturn(ressourceList);

		proband = new RessourcenDetailBean();

		// Class<? extends RessourcenDetailBean> clazz = proband.getClass();
		// Field field = clazz.getDeclaredField("emf");
		// field.setAccessible(true);
		// field.set(proband, emf);
	}

	/**
	 * Testmethode für selectDatensatz()
	 * {@link org.shareezy.beans.TimePickerBean#addDatensatz()}.
	 */
	@Test
	public void testSelectDatensatz() {

		String antwort = proband.selectDatensatz();
		assertNull("Muss Null sein", antwort);
		// verify(emf).createEntityManager();
		// verify(em).createQuery("select re from Ressource re");

	}

	/**
	 * Testmethode für testTimePicker()
	 * {@link org.shareezy.beans.RessourcenDetailBean#timePicker()}.
	 */
	@Test
	public void testTimePicker() {
		String picker = proband.timePicker();
		assertEquals(null, picker);
	}

	/**
	 * Testmethode für resourcePic() überprüft den Rückgabewert pic
	 * {@link org.shareezy.beans.RessourcenDetailBean#resourcePic()}.
	 */
	@Test
	public void testResourcePic() {
		Image bild = proband.resourcePic();
		assertEquals(pic, bild);
	}

	/**
	 * Testmethode für resourceSummary() überprüft den Rückgabewert summary
	 * {@link org.shareezy.beans.RessourcenDetailBean#resourceSummary()}.
	 */
	@Test
	public void testResourceSummary() {
		String sum = proband.resourceSummary();
		assertEquals(summary, sum);
	}

}
