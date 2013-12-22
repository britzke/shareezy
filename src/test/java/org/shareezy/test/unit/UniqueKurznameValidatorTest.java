/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	burghard.britzke (bubi@charmides.in-berlin.de)
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

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.util.List;

import javax.faces.validator.ValidatorException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.shareezy.entities.Benutzer;
import org.shareezy.validators.UniqueKurznameValidator;

/**
 * Testet den UniqueKurznameValidator.
 * 
 * @author burghard.britzke (mailto:bubi@charmides.in-berlin.de)
 * @see UniqueKurznameValidator
 */
public class UniqueKurznameValidatorTest {

	private UniqueKurznameValidator proband;
	private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;
	private Query query;
	private List<Benutzer> result;

	/**
	 * Setzt die Testumgebung für alle Tests auf.
	 * @throws java.lang.Exception
	 */
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		proband = new UniqueKurznameValidator();

		result = mock(List.class);
		when(result.size()).thenReturn(0).thenReturn(2);
		query = mock(Query.class);
		when(query.getResultList()).thenReturn(result);
		entityManager = mock(EntityManager.class);
		when(entityManager.createQuery(anyString())).thenReturn(query);

		entityManagerFactory = mock(EntityManagerFactory.class);
		when(entityManagerFactory.createEntityManager()).thenReturn(
				entityManager);

		Field emfField = proband.getClass().getDeclaredField(
				"entityManagerFactory");
		emfField.setAccessible(true);
		emfField.set(proband, entityManagerFactory);
	}

	/**
	 * Test method for
	 * {@link org.shareezy.validators.UniqueKurznameValidator#validate(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)}
	 * . Testet, ob eine ValidatorException geworfen wird, wenn es bereits einen
	 * Kurznamen in der Datenbank gibt, der dem zu validierenden Kurznamen
	 * entspricht.
	 */
	@Test(expected = ValidatorException.class)
	public void testValidate() {
		proband.validate(null, null, "test");
		// Exception wird erst beim zweiten Test geworfen
		proband.validate(null, null, "test");
		verify(entityManagerFactory).createEntityManager();
		verify(entityManager).createQuery(anyString());
		verify(query).setParameter(eq("kurzname"), anyString());
		verify(query).getResultList();
		verify(result).size();
	}
}
