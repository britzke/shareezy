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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Parameter;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.shareezy.beans.LoginBean;
import org.shareezy.entities.Benutzer;

/**
 * Eine TestUnit, in der verschiedene Funktionalitäten oder Methoden der
 * {@link org.shareezy.beans.LoginBean} getestet werden können.
 * 
 * @author Kevin Wegner
 * @author burghard.britzke bubi@charmides.in-berlin.de
 * @version 1.1
 */
public class LoginBeanTest {

	private static final String QUERY_STRING = "select b from Benutzer where kurzname= :kurzname and kennwort= :kennwort";
	private static final String TESTKENNWORT = "testkennwort";
	private static final String TESTBENUTZER = "testbenutzer";
	private LoginBean proband;
	public Benutzer benutzer;
	private EntityManagerFactory emf;
	private EntityManager em;
	private MockQuery q;

	private String nameParameter;
	private String kennwortParameter;
	private ArrayList<Benutzer> benutzerList;

	/**
	 * MockQueries speichern die gesetzten Parameter "name" und "kennwort" in
	 * die Eigenschaft "nameParameter" bzw. "kennwortParameter" für spätere
	 * Benutzung.
	 * 
	 * @author burghard.britzke bubi@charmides.in-berlin.de
	 * 
	 */
	class MockQuery implements Query {
		/**
		 * Speichert den Wert der Parameter mit den Namen "name" bzw. "kennwort"
		 * in die Eigenschaft "nameParameter" bzw. "kennwortParameter" zur
		 * späteren Nutzung.
		 * 
		 * @param name
		 *            Name des Parameters
		 * @param value
		 *            Wert des Parameters
		 * @returns null - immer
		 * @see javax.persistence.Query#setParameter(java.lang.String,
		 *      java.lang.Object)
		 */
		public Query setParameter(String name, Object value) {
			switch (name) {
			case "kurzname":
				nameParameter = (String) value;
				break;
			case "kennwort":
				kennwortParameter = (String) value;
			}
			return null;
		}

		// ----------------------------------------------------------------------------------
		// Nachfolgende Methode wird bei der Initialisierung des Objektes
		// "ge-stubbed", da getResultList() etwas anderes als null
		// liefern soll.
		//
		@SuppressWarnings("rawtypes")
		public List getResultList() {
			return null;
		}

		// ----------------------------------------------------------------------------------
		// Nachfolgende Methoden werden nicht benötigt
		public Object getSingleResult() {
			return null;
		}

		public int executeUpdate() {
			return 0;
		}

		public Query setMaxResults(int maxResult) {
			return null;
		}

		public int getMaxResults() {
			return 0;
		}

		public Query setFirstResult(int startPosition) {
			return null;
		}

		public int getFirstResult() {
			return 0;
		}

		public Query setHint(String hintName, Object value) {
			return null;
		}

		public Map<String, Object> getHints() {
			return null;
		}

		public <T> Query setParameter(Parameter<T> param, T value) {
			return null;
		}

		public Query setParameter(Parameter<Calendar> param, Calendar value,
				TemporalType temporalType) {
			return null;
		}

		public Query setParameter(Parameter<Date> param, Date value,
				TemporalType temporalType) {
			return null;
		}

		public Query setParameter(String name, Calendar value,
				TemporalType temporalType) {
			return null;
		}

		public Query setParameter(String name, Date value,
				TemporalType temporalType) {
			return null;
		}

		public Query setParameter(int position, Object value) {
			return null;
		}

		public Query setParameter(int position, Calendar value,
				TemporalType temporalType) {
			return null;
		}

		public Query setParameter(int position, Date value,
				TemporalType temporalType) {
			return null;
		}

		public Set<Parameter<?>> getParameters() {
			return null;
		}

		public Parameter<?> getParameter(String name) {
			return null;
		}

		public <T> Parameter<T> getParameter(String name, Class<T> type) {
			return null;
		}

		public Parameter<?> getParameter(int position) {
			return null;
		}

		public <T> Parameter<T> getParameter(int position, Class<T> type) {
			return null;
		}

		public boolean isBound(Parameter<?> param) {
			return false;
		}

		public <T> T getParameterValue(Parameter<T> param) {
			return null;
		}

		public Object getParameterValue(String name) {
			return null;
		}

		public Object getParameterValue(int position) {
			return null;
		}

		public Query setFlushMode(FlushModeType flushMode) {
			return null;
		}

		public FlushModeType getFlushMode() {
			return null;
		}

		public Query setLockMode(LockModeType lockMode) {
			return null;
		}

		public LockModeType getLockMode() {
			return null;
		}

		public <T> T unwrap(Class<T> cls) {
			return null;
		}
	}

	/**
	 * Antwortet mit einer neuen Instanz eines Testbenutzers, d. h. einem
	 * Benutzer-Objekt, dass als Kurzname den TESTBENUTZER hat und als Kenntowrt
	 * das TESTKENNWORT.
	 * <p>
	 * Eigentlich kann hierfür ein Konstruktor mit den Parametern kurzname und
	 * kennwort in der Klasse Benutzer dienen. Da aber zu Testzwecken nicht die
	 * Businessklassen geändert werden sollen, wird das in dieser
	 * testspezifischen Methode initialisiert.
	 * </p>
	 * 
	 * @return Neuer Benutzer mit Testkurzname und Testkennwort
	 */
	private Benutzer neuerBenutzerMitTestkurznameUndTestkennwort() {
		Benutzer b;
		b = new Benutzer();
		b.setKurzname(TESTBENUTZER);
		b.setKennwort(TESTKENNWORT);
		return b;
	}

	/**
	 * Setzt den Probanden und die Testumgebung vor jedem Test auf.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		proband = new LoginBean();

		emf = mock(EntityManagerFactory.class);
		em = mock(EntityManager.class);
		when(emf.createEntityManager()).thenReturn(em);

		q = new MockQuery();
		q = spy(q);
		when(em.createQuery(eq(QUERY_STRING))).thenReturn(q);

		benutzerList = new ArrayList<Benutzer>();
		Benutzer b = neuerBenutzerMitTestkurznameUndTestkennwort();
		benutzerList.add(b);

		Answer<List<Benutzer>> antwortListe = new Answer<List<Benutzer>>() {

			public List<Benutzer> answer(InvocationOnMock invocation)
					throws Throwable {
				List<Benutzer> antwort = new ArrayList<Benutzer>();

				for (Benutzer b : benutzerList) {
					if (b.getKurzname().equals(nameParameter)
							&& b.getKennwort().equals(kennwortParameter)) {
						antwort.add(b);
					}
				}
				return antwort;
			}
		};
		when(q.getResultList()).then(antwortListe);

		// Beschreibung der Klasse holen
		Class<? extends LoginBean> clazz = proband.getClass();
		// Beschreibung der Eigenschaft holen
		Field field = clazz.getDeclaredField("emf");
		// Zugriff auf private Eigenschaft erlauben
		field.setAccessible(true);
		// EntityManagerFactory in den Proband injizieren
		field.set(proband, emf);
		
		field = clazz.getDeclaredField("benutzer");
		field.setAccessible(true);
		b = neuerBenutzerMitTestkurznameUndTestkennwort();
		field.set(proband, b);
	}

	/**
	 * Test method for {@link org.shareezy.beans.LoginBean#login()}. Testet, ob
	 * <i>keine</i> Navigation zu einem anderen View eingeleitet wird. 
	 */
	@Test
	public void testLogin() {
		String antwort = proband.login();
		assertNull("muss null sein.", antwort);

		verify(emf).createEntityManager();
		verify(em).createQuery(eq(QUERY_STRING));
		verify(q).getResultList();
		
		verify(q).setParameter(eq("kurzname"), eq(TESTBENUTZER));
		verify(q).setParameter(eq("kennwort"), eq(TESTKENNWORT));

		verify(em).close();
	}
	
	/**
	 * Testet, dass die LoginBean ihre private Eigenschaft
	 * boolean authenticated auf den Wert „true“ setzt, wenn in der Datenbank
	 * ein Datensatz mit einem entsprechenden Benutzer vorhanden ist.
	 * 
	 * @throws NoSuchFieldException
	 *             Wenn keine Eigenschaft "authenticated" in der LoginBean
	 *             vorhanden ist.
	 * @throws IllegalArgumentException
	 *             Wenn das Objekt, aus dem der Inhalt des Fields geholt werden
	 *             soll ,nicht zu dem Field-Objekt passt
	 */
	@Test
	public void testLoginWithRightParametersSuccedes()
			throws NoSuchFieldException, IllegalAccessException {

		// initalisiere einen validen Benutzer in der LoginBean
		Benutzer rightBenutzer = neuerBenutzerMitTestkurznameUndTestkennwort();
		;
		Field benutzerField = proband.getClass().getDeclaredField("benutzer");
		benutzerField.setAccessible(true);
		benutzerField.set(proband, rightBenutzer);

		proband.login(); // teste

		// überprüfe, ob die Eigenschaft 'authenticated' den Wert 'true' hat
		Field authenticatedField = proband.getClass().getDeclaredField(
				"authenticated");
		authenticatedField.setAccessible(true);
		boolean authenticated = (Boolean) authenticatedField.get(proband);
		assertTrue("Die Eigenschaft 'authenticated' muss 'true' sein",
				authenticated);
	}

	/**
	 * Testet, dass die LoginBean ihre private Eigenschaft
	 * boolean authenticated auf den Wert „false“ setzt, wenn in der Datenbank
	 * ein Datensatz mit einem entsprechenden Benutzer nicht vorhanden ist.
	 * 
	 * @throws NoSuchFieldException
	 *             Wenn keine Eigenschaft "authenticated" in der LoginBean
	 *             vorhanden ist.
	 * @throws IllegalArgumentException
	 *             Wenn das Objekt, aus dem der Inhalt des Fields geholt werden
	 *             soll ,nicht zu dem Field-Objekt passt
	 */
	@Test
	public void testLoginWithWrongParametersFailes()
			throws NoSuchFieldException, IllegalAccessException {

		// falschen Benutzer in der LoginBean initialisieren
		Benutzer wrongBenutzer = new Benutzer();
		wrongBenutzer.setKurzname("falscher kurzname");
		wrongBenutzer.setKennwort("falsches Kennwort");
		
		Field benutzerField = proband.getClass().getDeclaredField("benutzer");
		benutzerField.setAccessible(true);
		benutzerField.set(proband, wrongBenutzer);

		proband.login(); // testen

		// auswerten
		Field authenticatedField = proband.getClass().getDeclaredField(
				"authenticated");
		authenticatedField.setAccessible(true);

		boolean authenticated = (Boolean) authenticatedField.get(proband);
		assertFalse("Die Eigenschaft 'authenticated' muss 'false' sein",
				authenticated);
	}
}