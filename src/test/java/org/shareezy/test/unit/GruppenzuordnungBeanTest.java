/**
 * 
 */
package org.shareezy.test.unit;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

import java.lang.reflect.Field;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;
import org.shareezy.beans.GroupManagerBean;
import org.shareezy.beans.GruppenzuordnungBean;

/**
 * @author e1_hermann
 *
 */
public class GruppenzuordnungBeanTest {
	
	public EntityManager em;
	public EntityManagerFactory emf;
	public GruppenzuordnungBean proband;
	public EntityTransaction transaction;

	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		proband = new GruppenzuordnungBean();
		emf=mock(EntityManagerFactory.class);
		em=mock(EntityManager.class);
		when(emf.createEntityManager()).thenReturn(em);
		when(em.getTransaction()).thenReturn(transaction);
		
	}
	
	Class<? extends GruppenzuordnungBean> clazz = proband.getClass();
	/*
    Field field = clazz.getDeclaredField("emf");
    
    field.setAccessible(true);
    field.set(proband, emf);
    */
	/**
	 * Test method for {@link org.shareezy.beans.GruppenzuordnungBean#setUp()}.
	 */
	@Test
	public void testSetUp() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.shareezy.beans.GruppenzuordnungBean#mitgliederabfragen()}.
	 */
	@Test
	public void testMitgliederabfragen() {
		verify(emf).createEntityManager();
		verify(em).getTransaction();
		verify(transaction).begin();
		verify(em).persist(any());
	}

	/**
	 * Test method for {@link org.shareezy.beans.GruppenzuordnungBean#ressourcestatus()}.
	 */
	@Test
	public void testRessourcestatus() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.shareezy.beans.GruppenzuordnungBean#mitgliedentfernen()}.
	 */
	@Test
	public void testMitgliedentfernen() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.shareezy.beans.GruppenzuordnungBean#addressourcen(int)}.
	 */
	@Test
	public void testAddressourcen() {
		fail("Not yet implemented");
		
	}

	/**
	 * Test method for {@link org.shareezy.beans.GruppenzuordnungBean#editressource()}.
	 */
	@Test
	public void testEditressource() {
		
		fail("Not yet implemented");
	}

}
