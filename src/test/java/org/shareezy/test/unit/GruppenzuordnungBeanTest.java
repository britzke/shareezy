package org.shareezy.test.unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.Field;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.shareezy.beans.GruppenzuordnungBean;

/**
 * @author e1_hermann
 * 
 */
public class GruppenzuordnungBeanTest {

	private EntityManager em;
	private EntityManagerFactory emf;
	private GruppenzuordnungBean proband;
	private Query query;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		proband = new GruppenzuordnungBean();
		emf = mock(EntityManagerFactory.class);
		em = mock(EntityManager.class);
		query = mock(Query.class);
		when(emf.createEntityManager()).thenReturn(em);
		when(em.createQuery(anyString())).thenReturn(query);
		
		Field f = proband.getClass().getDeclaredField("emf");
		f.setAccessible(true);
		f.set(proband, emf);
	}

	/**
	 * Test method for {@link org.shareezy.beans.GruppenzuordnungBean#setUp()}.
	 */
	@Test
	public void testSetUp() {

	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.GruppenzuordnungBean#mitgliederabfragen()}.
	 * Überprüft, ob das Objekt mit einem null-Objekt antwortet.
	 */
	@Test
	public void testMitgliederabfragen() {
		String antwort = proband.mitgliederabfragen();
		assertNull(antwort);
		verify(emf).createEntityManager();
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.GruppenzuordnungBean#ressourcestatus()}.
	 */
	@Test
	public void testRessourcestatus() {

	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.GruppenzuordnungBean#mitgliedentfernen()}.
	 */
	@Test
	public void testMitgliedentfernen() {

	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.GruppenzuordnungBean#addressourcen(int)}.
	 */
	@Test
	public void testAddressourcen() {

	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.GruppenzuordnungBean#editressource()}.
	 */
	@Test
	public void testEditressource() {

	}
}
