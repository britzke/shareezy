/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	Kevin Wegner
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

import static org.mockito.Mockito.*;
import java.lang.reflect.Field;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.junit.Before;
import org.junit.Test;
import org.shareezy.beans.LoginBean;
import org.shareezy.entities.Benutzer;

/**
 * Eine TestUnit, in der verschiedene Funktionalitäten oder Methoden der 
 * {@link org.shareezy.beans.LoginBean} getestet werden können.
 * @author Kevin Wegner
 * @version 1.1
 */
public class LoginBeanTest {

	private LoginBean proband;
	public Benutzer benutzer;
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction transaction;	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		proband = new LoginBean();
		emf = mock(EntityManagerFactory.class);		
		em = mock(EntityManager.class);
		transaction = mock(EntityTransaction.class);
		proband = mock(LoginBean.class);
		
		when(emf.createEntityManager()).thenReturn(em);		
		when(em.getTransaction()).thenReturn(transaction);
		//Abfrage des Rückgabewertes der Methode login().
		//when(proband.login()).thenReturn("failed"); 
		
		// Beschreibung der Klasse holen
		Class<? extends LoginBean> clazz = proband.getClass();
		// Beschreibung der Eigenschaft holen
		Field field = clazz.getDeclaredField("emf");
		// Zugriff auf private Eigenschaft erlauben
		field.setAccessible(true);
		// EntityManagerFactory in den Proband injizieren
		field.set(proband, emf);
	}

	/**
	 * Test method for {@link org.shareezy.beans.LoginBean#login()}.
	 */
	@Test
	public void testLogin() {
		String p = proband.login();
		//assertNull("muss null sein.", p);		
//		assertTrue("Es muss ein EntityManager aus einer Factory erzeugt worden sein",
//				createEntityManagerSent);
		verify(emf).createEntityManager();				
//		assertTrue(
//				"Es muss eine Transaction vom EntityManager abgefragt werden",
//				getTransactionSent);
		verify(em).getTransaction();
//		assertTrue("Die Transaktion muss gestartet werden.", beginSent);
		verify(transaction).begin();
//		assertTrue("Die Entity muss persistend sein.", persistSent);
		//verify(em).persist(any());
//		assertTrue(
//				"Die Transaktion muss erfolgreich abgeschlossen worden sein",
//				commitSend);
		verify(transaction).commit();
		verify(em).close();		
		
		//Abfrage des Rückgabewertes der Methode login().
		//verify(proband).login();		
	}
}