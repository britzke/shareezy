/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	Maxim Slipachuk
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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.Before;
import org.shareezy.beans.GroupMembership;
import org.shareezy.entities.Benutzer;
import org.shareezy.entities.Gruppe;

/**
 * Testet die GroupMembershipBean
 * 
 * @author e1_slipachuk
 * @author burghard.britzke
 */
public class GroupMembershipTest {

	private GroupMembership proband;	
	private EntityTransaction transaction;

	private Benutzer verwalter;
	private Gruppe gruppe;
	public Query q;
	public List<Gruppe> gruppenliste;
	private EntityManager em;
	private EntityManagerFactory emf; 


	/**
	 * Setzt den Probanden und die Testumgebung vor jedem Test auf. 
	 * @throws Exception
	 */
	@Before
	public void setup()throws NoSuchFieldException, SecurityException,
	IllegalArgumentException, IllegalAccessException {
		
		proband = new GroupMembership();
		gruppe = mock(Gruppe.class);
		verwalter = mock(Benutzer.class);
		
		emf = mock(EntityManagerFactory.class);
		em = mock(EntityManager.class);
		when(emf.createEntityManager()).thenReturn(em);
		//q = mock(Query.class);
		//when(em.createQuery("select r from Gruppe r")).thenReturn(q);		
		//when(q.getResultList()).thenReturn(gruppenliste);
		when(gruppe.getVerwalter()).thenReturn(verwalter);
		when(gruppe.getVerwalter().getEmail()).thenReturn("tesetEMALI1");
		 gruppe.setVerwalter(verwalter);
		 verwalter.setEmail("testEmail");
		
		
		
		
		
		transaction = mock(EntityTransaction.class);
		when(em.getTransaction()).thenReturn(transaction);		
		
		Class<? extends GroupMembership> clazz = proband.getClass();
		Field field = clazz.getDeclaredField("emf");		
		field.setAccessible(true);		
		field.set(proband, emf);
		
		
		field = clazz.getDeclaredField("gruppe");		
		field.setAccessible(true);	
		field.set(proband, gruppe);
		
		
				
	}
	

	/**
	 * Test method for {@link org.shareezy.beans.GroupMembership#sendAnfrage()}.
	 * Testet, ob <i>keine</i> Navigation zu einem anderen View eingeleitet
	 * wird.
	 */
	
	//@Test
	//public void testSendAnfrage() {
		
		//String antwort = proband.sendAnfrage();	
		//verify(gruppe.getVerwalter().getEmail());
		//assertNull("muss null sein", antwort);		
	//}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.GroupMembership#knopfGruppeVerlassen()}.
	 * Testet, ob <i>keine</i> Navigation zu einem anderen View eingeleitet
	 * wird.
	 */
	/*@Test
	public void testKnopfGruppeVerlassen() {
		String antwort = proband.knopfGruppeVerlassen();
		assertNull(antwort);
	}*/
}
