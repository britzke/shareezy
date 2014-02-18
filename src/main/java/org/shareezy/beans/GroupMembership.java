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
package org.shareezy.beans;

import java.io.Serializable;
import java.util.Properties;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;

/**
 * Eigene Gruppenzugehörigkeit beantragen/entfernen
 * 
 * @author Maxim Slipachuk
 */
@SessionScoped
@Named("GroupMembership")
public class GroupMembership implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Wird bei Klick auf 'Hinzufuegen' aufgerufen.
	 * 
	 * @return gibt nichts zurück damit sich die View nicht Verändert
	 * 
	 */

	public String sendAnfrage(FacesContext facesContext) {

		ExternalContext externalContext = facesContext.getExternalContext();
		try {
			ServletContext servletContext = (ServletContext) externalContext
					.getContext();
			Properties properties = (Properties) servletContext
					.getAttribute("org.shareezy.MAIL_PROPERTIES");

			Session session = Session.getInstance(properties);
			Address[] addresses = InternetAddress.parse("testEmail");

			Message message = new MimeMessage(session);
			message.setRecipients(Message.RecipientType.TO, addresses);
			message.setSubject("[shareezy] Validierung der Registrierung");
			//
			// String validationUrl = externalContext.getRequestPathInfo()
			// + getMD5emailValidationHash();

			message.setText("testEmail anfrage");

			Transport.send(message);
		} catch (MessagingException e) {
			FacesMessage message = new FacesMessage();
			message.setSummary("Fehler beim Versenden der E-Mail zur Valitation");
			message.setDetail(e.getLocalizedMessage());
			message.setSeverity(FacesMessage.SEVERITY_FATAL);
			facesContext.addMessage(null, message);
		}
		return null;

	}

	/**
	 * Wird bei Klick auf 'Gruppe Verlassen' aufgerufen
	 * 
	 * @return gibt nichts zurück damit sich die View nicht Veraendert
	 */

	public String knopfGruppeVerlassen() {
		return null;
	}
}
