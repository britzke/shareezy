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
package org.shareezy.beans;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletContext;

import org.shareezy.entities.Benutzer;

/**
 * Die Klasse RegestrieurungsBean stellt Methoden zur Verfügung die dazu genutzt
 * werden damit sich der Nutzer anmelden kann.
 * 
 * @author Maurice Engelskirchen
 * @author e1_cakir
 * @author burghard.britzke bubi@charmides.in-berlin.de
 */

@RequestScoped
@Named
public class RegistrierungBean {
	
	@Inject
	private EntityManagerFactory emf;
	@Inject
	private Benutzer benutzer;

	/**
	 * Erzeugt eine neue RegistrierungBean. Initialisiert den Benutzer.
	 */
	
	public RegistrierungBean() {
		benutzer = new Benutzer();
	}

	/**
	 * Prüft ob die Spezifischen Daten(username, e-mail) schon in einem
	 * Datansatz vorhanden sind. Sind die Spezifischen Daten noch nicht
	 * vorhanden, wird die Methode datensatzEinfügen() aufgerufen.
	 * 
	 * @param passwortWiederholen
	 *            Der Inhalt des textfeldes passwort wiederholen.
	 * @return null da kein Seitenwechsel stattfindet.
	 */
	public String datensatzPrüfen() {
		return null;

	}

	/**
	 * Fügt der Entität "Benutzer" der Datenbank einen neuen Datensatz mit den
	 * vom Benutzer eingegebenen Daten hinzu. Danach wird die Methode
	 * validierungsEmail() aufgerufen.
	 * 
	 * @return null da kein Seitenwechsel stattfindet.
	 */
	public String datensatzEinfügen() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(benutzer);
		et.commit();
		em.close();
		return null;
	}

	/**
	 * Versendet eine E-Mail zur Validierung der E-Mailadresse, die für den
	 * Benutzer angegeben wurde. Die Parameter für die Kommunikation mit dem
	 * Mailserver werden aus dem ContextAttribut "mail.properties" gelesen.
	 * 
	 * @param facesContext
	 *            Der Context der JSF-Infrastruktur
	 * @return null da kein Seitenwechsel stattfindet.
	 */
	public String validierungsEmail(FacesContext facesContext) {

		ExternalContext externalContext = facesContext.getExternalContext();
		try {
			ServletContext servletContext = (ServletContext) externalContext
					.getContext();
			Properties properties = (Properties) servletContext
					.getAttribute("org.shareezy.MAIL_PROPERTIES");

			Session session = Session.getInstance(properties);
			Address[] addresses = InternetAddress.parse(benutzer.getEmail());

			Message message = new MimeMessage(session);
			message.setRecipients(Message.RecipientType.TO, addresses);
			message.setSubject("[shareezy] Validierung der Registrierung");

			String validationUrl = externalContext.getRequestPathInfo()
					+ getMD5emailValidationHash();

			message.setText("Hallo,\r"
					+ "auf dem Portal [shareezy] wurde eine Registrierung "
					+ "mit der E-Mailadresse '"
					+ benutzer.getEmail()
					+ "'durchgeführt.\r"
					+ "Wenn die Registrierung abgeschlossen werden soll,\r"
					+ "so kann dies nur durch Anwahl des folgenden Verweises geschehen:\r\r"
					+ validationUrl + "\r\r" + "Mit freundlichem Gruß\r");

			Transport.send(message);
		} catch ( MessagingException | UnsupportedEncodingException | NoSuchAlgorithmException e) {
			FacesMessage message = new FacesMessage();
			message.setSummary("Fehler beim Versenden der E-Mail zur Valitation");
			message.setDetail(e.getLocalizedMessage());
			message.setSeverity(FacesMessage.SEVERITY_FATAL);
			facesContext.addMessage(null, message);
		}
		return null;
	}

	/**
	 * Erzeugt einen Hashwert zum Validieren der E-Mailadresse des Benutzers.
	 * 
	 * @return der Hashwert, der über das Internet an den Registrator versandt
	 *         werden kann, ohne dass Dritte damit validiert werden können.
	 * @throws UnsupportedEncodingException
	 *             wenn das System die Kodierung UTF-8 nicht unterstützt
	 *             (unwahrscheinlich)
	 * @throws NoSuchAlgorithmException
	 *             wenn das Systen den Digest-Algorithmus MD5 nicht unterstützt
	 *             (unwahrscheinlich)
	 */
	private String getMD5emailValidationHash()
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		String digestSource = "" + benutzer.getRegistration()
				+ benutzer.getVorname() + benutzer.getNachname()
				+ benutzer.getKurzname() + benutzer.getEmail();
		String result = null;
		byte[] bytesOfDigestSource = digestSource.getBytes("UTF-8");
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] digest = md.digest(bytesOfDigestSource);
		result = new String(digest);
		return result;
	}
}
