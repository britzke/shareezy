/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	e1_cakir,
 * 						Maurice Engelskirchen
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.shareezy.beans.BenutzerBean;
import org.shareezy.entities.Benutzer;
import org.shareezy.test.unit.mock.MockFacesContext;

/**
 * Testet die RegistrierungBean
 * 
 * @author e1_cakir
 * @author Maurice Engelskirchen
 * @author burghard.britzke (bubi@charmides.in-berlin.de)
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ Session.class, Transport.class })
public class BenutzerBeanTest {

	private BenutzerBean proband;
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction et;
	private FacesContext facesContext;
	private HtmlInputSecret kennwort;
	private HtmlInputSecret kennwortWiederholung;
	private HtmlInputSecret altesKennwort;
	private UIComponent parent;

	/**
	 * Setzt den Probanden auf.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		emf = mock(EntityManagerFactory.class);
		em = mock(EntityManager.class);
		when(emf.createEntityManager()).thenReturn(em);

		et = mock(EntityTransaction.class);
		when(em.getTransaction()).thenReturn(et);

		proband = new BenutzerBean();
		proband.setKennwort("secret");

		Class<? extends BenutzerBean> clazz = proband.getClass();
		Field field = clazz.getDeclaredField("emf");
		field.setAccessible(true);
		field.set(proband, emf);

		facesContext = new MockFacesContext();

		kennwort = new HtmlInputSecret();
		kennwort.setId("kennwort");
		kennwortWiederholung = new HtmlInputSecret();
		kennwortWiederholung.setId("kennwortWiederholung");
		altesKennwort = new HtmlInputSecret();
		altesKennwort.setId("altesKennwort");

		parent = new HtmlPanelGrid();
		kennwort.setParent(parent);
	}

	/**
	 * Testet, ob der Validator eine FacesMessage zum FacesContext hinzufügt,
	 * wenn die Werte der Komponente mit der ID "kennwort" den Wert 'null
	 * enthält.
	 * {@link org.shareezy.beans.RegestrierungsBean#validiereKennwort()}.
	 */
	@Test
	public void testValidiereKennwortSubmittedValueIsNull() {
		parent.getChildren().add(kennwortWiederholung);
		parent.getChildren().add(altesKennwort);
		kennwortWiederholung.setValue("notSecret");
		proband.validiereKennwort(facesContext, kennwort, null);

		Iterator<FacesMessage> mi = facesContext.getMessages();
		boolean warningSet = false;
		while (mi.hasNext()) {
			FacesMessage m = mi.next();
			if (m.getSeverity().equals(FacesMessage.SEVERITY_WARN)) {
				warningSet = true;
			}
		}
		assertTrue(
				"Es muss ein Warnhinweis gesetzt werden, wenn das Kennwort den Wert 'null' hat",
				warningSet);
	}

	/**
	 * Testet, ob der Validator eine ValidatorException wirft, wenn die Werte
	 * der Komponente mit der ID "kennwort" sich unterscheiden vom Wert in der
	 * Komponente mit der ID kennwortWiederholung.
	 * {@link org.shareezy.beans.RegestrierungsBean#validiereKennwort()}.
	 */
	@Test(expected = ValidatorException.class)
	public void testValidiereKennwortUnterschiedlich() {
		parent.getChildren().add(kennwortWiederholung);
		parent.getChildren().add(altesKennwort);
		kennwortWiederholung.setSubmittedValue("notSecret");
		proband.validiereKennwort(facesContext, kennwort, "secret");
	}

	/**
	 * Test testet, ob der Validator <i>keine<i> ValidatorException wirft, wenn
	 * der Wert in der Komponente "kennwort" gleich dem Wert in der Komponente
	 * "kennwortWiederholung"
	 * {@link org.shareezy.beans.RegestrierungsBean#validiereKennwort()}.
	 */
	@Test
	public void testValidiereKennwortGleich() {
		parent.getChildren().add(kennwortWiederholung);
		parent.getChildren().add(altesKennwort);
		kennwortWiederholung.setSubmittedValue("secret");
		try {
			proband.validiereKennwort(facesContext, kennwort, "secret");
		} catch (ValidatorException e) {
			e.printStackTrace();
			fail("Die Validierung darf für gleiche Kennwort nicht fehlschlagen");
		}
	}

	/**
	 * Testet, ob der Validator eine ValidatorException wirft, wenn die
	 * Kompoente mit der ID "kennwortWiederholen" nicht im View vorhanden ist.
	 */
	@Test
	public void testValidiereKennwortWiederholenKomponenteNichtImView() {
		parent.getChildren().add(altesKennwort);

		proband.validiereKennwort(facesContext, kennwort, "secret");

		Iterator<FacesMessage> mi = facesContext.getMessages();
		boolean warningSet = false;
		while (mi.hasNext()) {
			FacesMessage m = mi.next();
			if (m.getSeverity().equals(FacesMessage.SEVERITY_WARN)) {
				warningSet = true;
			}
		}
		assertTrue(
				"Es muss ein Warnhinweis gesetzt werden, wenn kein Feld mit dem Namen 'kennwortWiederholen' im View vorhanden ist",
				warningSet);
	}

	/**
	 * Testet, ob der Validator eine ValidatorException wirft, wenn die
	 * Kompoente mit der ID "altesKennwort" nicht im View vorhanden ist.
	 */
	@Test(expected = ValidatorException.class)
	public void testValidiereAltesKennwortKomponenteNichtImView() {
		parent.getChildren().add(kennwortWiederholung);
		kennwortWiederholung.setValue("secret");
		proband.validiereKennwort(facesContext, kennwort, "secret");

		Iterator<FacesMessage> mi = facesContext.getMessages();
		boolean warningSet = false;
		while (mi.hasNext()) {
			FacesMessage m = mi.next();
			if (m.getSeverity().equals(FacesMessage.SEVERITY_WARN)) {
				warningSet = true;
			}
		}
		assertTrue(
				"Es muss ein Warnhinweis gesetzt werden, wenn kein Feld mit dem Namen 'altesKennwort' im View vorhanden ist",
				warningSet);
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.RegestrierungsBean#datensatzPrüfen()}.
	 */
	@Test
	public void testDatensatzPrüfen() {
		String antwort = proband.datensatzPrüfen();
		assertEquals(null, antwort);
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.RegestrierungsBean#datensatzEinfügen()}.
	 * Testet, ob ein Datensatz eingefügt wird.
	 */
	@Test
	public void testDatensatzEinfügen() {

		String antwort = proband.datensatzEinfügen();

		assertNull("Die Antwort muss null sein", antwort);
		verify(emf).createEntityManager();
		verify(em).getTransaction();
		verify(et).begin();
		verify(em).persist(anyObject());
		verify(et).commit();
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.RegestrierungsBean#validierungsEmail()}.
	 * 
	 * @throws MessagingException
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@Test
	public void testValidierungsEmail() throws MessagingException,
			NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException {
		Benutzer benutzer = org.mockito.Mockito.mock(Benutzer.class);
		org.mockito.Mockito.when(benutzer.getEmail()).thenReturn(
				"shareezy@example.org");
		Field benutzerField = proband.getClass().getDeclaredField("benutzer");
		benutzerField.setAccessible(true);
		benutzerField.set(proband, benutzer);

		FacesContext facesContext = org.mockito.Mockito
				.mock(FacesContext.class);

		ExternalContext externalContext = org.mockito.Mockito
				.mock(ExternalContext.class);
		org.mockito.Mockito.when(facesContext.getExternalContext()).thenReturn(
				externalContext);

		ServletContext servletContext = org.mockito.Mockito
				.mock(ServletContext.class);
		org.mockito.Mockito.when(externalContext.getContext()).thenReturn(
				servletContext);

		mockStatic(Session.class);
		mockStatic(Transport.class);

		String antwort = proband.validierungsEmail(facesContext);

		assertNull("Die Antwort muss 'null' sein", antwort);
		verify(facesContext).getExternalContext();
		verify(externalContext).getContext();
		verify(servletContext).getAttribute(eq("org.shareezy.MAIL_PROPERTIES"));
		verifyStatic();
		Session.getInstance(any(Properties.class));
		verifyStatic();
		Transport.send(any(Message.class));
	}
}
