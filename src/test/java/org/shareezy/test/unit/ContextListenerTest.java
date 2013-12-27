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

import static org.mockito.Mockito.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.junit.Before;
import org.junit.Test;
import org.shareezy.ContextListener;

/**
 * Testet den ContextListener
 * 
 * @author burghard.britzke (bubi@charmides.in-berlin.de)
 */
public class ContextListenerTest {

	private static final String MAIL_SMTP_WORD = "mail.smtp.word";
	private static final String MAIL_SMTP_USER = "mail.smtp.user";
	private static final String MAIL_SMTP_PORT = "mail.smtp.port";
	private static final String MAIL_SMTP_HOST = "mail.smtp.host";
	private static final String MAIL_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";
	private static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
	private static final String MAIL_FROM = "mail.from";
	private ContextListener proband;
	private ServletContextEvent servletContextEvent;
	private ServletContext servletContext;

	/**
	 * Setzt die Testumgebung für die Tests des ContextListeners auf. Erzeugt
	 * einen Probanden.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		servletContextEvent = mock(ServletContextEvent.class);

		servletContext = mock(ServletContext.class);
		when(servletContextEvent.getServletContext()).thenReturn(servletContext);
		when(servletContext.getInitParameter(MAIL_FROM)).thenReturn("application@example.org");
		when(servletContext.getInitParameter(MAIL_SMTP_AUTH)).thenReturn("true");
		when(servletContext.getInitParameter(MAIL_SMTP_STARTTLS_ENABLE)).thenReturn("true");
		when(servletContext.getInitParameter(MAIL_SMTP_HOST)).thenReturn("example.org");
		when(servletContext.getInitParameter(MAIL_SMTP_PORT)).thenReturn("587");
		when(servletContext.getInitParameter(MAIL_SMTP_USER)).thenReturn("shareezy");
		when(servletContext.getInitParameter(MAIL_SMTP_WORD)).thenReturn("secret");

		proband = new ContextListener();
	}

	/**
	 * Test method for
	 * {@link org.shareezy.ContextListener#contextInitialized(javax.servlet.ServletContextEvent)}
	 * . Testet, dass die Context-Parameter korrekt gelesen werden und als
	 * Kontext-Attribut mit dem Namen "mail.properties" in einem
	 * Properties-Objekt gespeichert werden.
	 */
	@Test
	public void testContextInitialized() {
		proband.contextInitialized(servletContextEvent);
		
		verify(servletContext).getInitParameter(MAIL_FROM);
		verify(servletContext).getInitParameter(MAIL_SMTP_STARTTLS_ENABLE);
		verify(servletContext).getInitParameter(MAIL_SMTP_AUTH);
		verify(servletContext).getInitParameter(MAIL_SMTP_HOST);
		verify(servletContext).getInitParameter(MAIL_SMTP_PORT);
		verify(servletContext).getInitParameter(MAIL_SMTP_USER);
		verify(servletContext).getInitParameter(MAIL_SMTP_WORD);
		verify(servletContext).setAttribute(eq("mail.properties"),anyObject());
	}

	/**
	 * Test method for
	 * {@link org.shareezy.ContextListener#contextDestroyed(javax.servlet.ServletContextEvent)}
	 * . Wird nicht benötigt, da contextDestroyed(...) nicht benötigt wird.
	 */
	@Test
	public void testContextDestroyed() {
	}
}
