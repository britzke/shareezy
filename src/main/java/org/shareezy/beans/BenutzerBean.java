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

import java.security.MessageDigest;
import java.util.List;
import java.util.Properties;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
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
public class BenutzerBean {
	static final char[] HEX_DIGIT = "0123456789ABCDEF".toCharArray();

	// @FacesValidator(value = "emailAddressValidator")

	@Inject
	private EntityManagerFactory emf;

	private Benutzer benutzer;
	private String kennwort;
	private String kennwortAlt;

	/**
	 * Erzeugt eine neue RegistrierungBean. Initialisiert den Benutzer.
	 */
	public BenutzerBean() {
		benutzer = new Benutzer();
	}

	/**
	 * Validiert, ob das eingegebene Kennwort mit dem Kennwort in dem Feld
	 * "kennwortWiederholung" übereinstimmt, und ob es sich von dem Kennwort in
	 * dem Feld "altesKennwort" unterscheidet. Wenn im Formular kein Feld mit
	 * der ID "kennwortWiederholung" existiert, wird eine Warnung angezeigt.
	 * Wenn im Formular kein Feld mit der ID "altesKennwort" existiert, wird
	 * eine Warnung angezeigt.
	 * 
	 * @param ctx
	 *            Der FacesContext
	 * @param component
	 *            Die Komponente, die validiert werden soll
	 * @param value
	 *            Der Wert, der validiert werden soll
	 * @throws ValidatorException
	 */
	public void validiereKennwort(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		boolean kennwortWiederholungVorhanden = false;
		boolean altesKennwortVorhanden = false;

		String kennwort = (String) value;
		if (kennwort != null && !kennwort.equals("")) {
			UIComponent parent = component.getParent();
			List<UIComponent> siblings = parent.getChildren();
			for (UIComponent sibling : siblings) {

				if (sibling.getId().equals("kennwortWiederholung")) {
					kennwortWiederholungVorhanden = true;
					String kennwortWiederholung = (String) ((EditableValueHolder) sibling)
							.getSubmittedValue();
					if (!kennwort.equals(kennwortWiederholung)) {
						FacesMessage message = new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"Kennworte unterschiedlich",
								"Das Kennwort und die Kennwortwiederholung stimmen nicht überein.");
						throw new ValidatorException(message);
					}
				}

				if (sibling.getId().equals("altesKennwort")) {
					altesKennwortVorhanden = true;
					String altesKennwort = (String) ((EditableValueHolder) sibling)
							.getSubmittedValue();
					if (kennwort.equals(altesKennwort)) {
						FacesMessage message = new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"Kennworte gleich",
								"Neues und altes Kennwort dürfen nicht übereinstimmen.");
						throw new ValidatorException(message);
					}
				}
			}
			if (!altesKennwortVorhanden) {
				FacesMessage m = new FacesMessage(
						FacesMessage.SEVERITY_WARN,
						"Eingabefeld 'altesKennwort' fehlt",
						"Das Eingabefeld mit der ID 'altesKennwort' ist in dem Formular nicht vorhanden."
								+ "Die Validierung kann nicht durchgeführt werden.");
				facesContext.addMessage(null, m);
			}
			if (!kennwortWiederholungVorhanden) {
				FacesMessage m = new FacesMessage(
						FacesMessage.SEVERITY_WARN,
						"Eingabefeld 'kennwortWiederholung' fehlt",
						"Das Eingabefeld mit der ID 'kennwortWiederholung' ist in dem Formular nicht vorhanden."
								+ "Die Validierung kann nicht durchgeführt werden.");
				facesContext.addMessage(null, m);
			}
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Kennwort-Feld nicht'required'",
					"Das Kennwort-Feld sollte im View mit dem Attribut 'required' markiert sein");
			facesContext.addMessage("", message);
		}
	}

	/**
	 * Validiert die E-Mail des Benutzers
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validateEmail(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		String.valueOf(value);
		boolean valid = true;

		if (!valid) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Invalid email address",
					"The email address you entered is not valid.");
			throw new ValidatorException(message);
		}
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
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] bytesOfDigestSource = kennwort.getBytes("UTF-8");
			byte[] digest = md.digest(bytesOfDigestSource);
			benutzer.setKennwortHash(hexDigitString(digest));

			String digestSource = "" + benutzer.getRegistration()
					+ benutzer.getVorname() + benutzer.getNachname()
					+ benutzer.getKurzname() + benutzer.getEmail();
			bytesOfDigestSource = digestSource.getBytes("UTF-8");
			digest = md.digest(bytesOfDigestSource);

			benutzer.setValidationHash(hexDigitString(digest));
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(benutzer);
			et.commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
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

			// TODO check validationHash (nach ascii konvertieren)
			String validationUrl = externalContext.getRequestPathInfo()
					+ benutzer.getValidationHash();

			message.setText("Hallo,\r"
					+ "auf dem Portal [shareezy] wurde eine Registrierung "
					+ "mit der E-Mailadresse '"
					+ benutzer.getEmail()
					+ "'durchgeführt.\r"
					+ "Wenn die Registrierung abgeschlossen werden soll,\r"
					+ "so kann dies nur durch Anwahl des folgenden Verweises geschehen:\r\r"
					+ validationUrl + "\r\r" + "Mit freundlichem Gruß\r");

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
	 * Konvertiert das angegebene Byte-Array in eine Zeichenkette mit
	 * hexadezimalen Ziffern.
	 * 
	 * @param bytes
	 *            das zu konvertierende Byte-Array
	 * @return Hexadezimale Zeichenkette mit des Byte-Array
	 */
	private String hexDigitString(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = HEX_DIGIT[v >>> 4];
			hexChars[j * 2 + 1] = HEX_DIGIT[v & 0x0F];
		}
		return new String(hexChars);
	}

	/**
	 * Antwortet mit dem Wert des benutzers.
	 * 
	 * @return der Benutzer, der gerade registriert werde möchte.
	 */
	public Benutzer getBenutzer() {
		return benutzer;
	}

	/**
	 * Setzt den Benutzer, der registriert werden möchte.
	 * 
	 * @param benutzer
	 *            der Benutzer, der registriert werden möchte.
	 */
	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}

	/**
	 * Antwortet mit dem Wert des kennwort
	 * 
	 * @return das Kennwort
	 */
	public String getKennwort() {
		return kennwort;
	}

	/**
	 * Setzt de Wert für das Kennwort.
	 * 
	 * @param kennwort
	 *            der Wert für das Kennwort, das gesetzt werden soll
	 */
	public void setKennwort(String kennwort) {
		this.kennwort = kennwort;
	}

	/**
	 * Antwortet mit dem Wert des kennwortAlt
	 * 
	 * @return the kennwortAlt
	 */
	public String getKennwortAlt() {
		return kennwortAlt;
	}

	/**
	 * @param kennwortAlt
	 *            the kennwortAlt to set
	 */
	public void setKennwortAlt(String kennwortAlt) {
		this.kennwortAlt = kennwortAlt;
	}
}
