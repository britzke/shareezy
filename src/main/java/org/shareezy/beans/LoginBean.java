/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013, 2014
 * 			  	Kevin Wegner
 *				burghard.britzke bubi@charmides.in-berlin.de
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
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.shareezy.entities.Benutzer;

/**
 * In dieser Bean findet die Überprüfung der Anmeldungsdaten des Benutzers
 * statt. Der Benutzer muss seinen Benutzernamen und sein Passwort in die
 * entsprechenden Eingabefelder der View eintragen. Diese werden in die
 * jeweiligen Eigenschaften der Bean geschrieben.
 * 
 * @author wegner
 * @author burghard.britzke bubi@charmides.in-berlin.de
 */
@Named
@RequestScoped
public class LoginBean {

	@Inject
	private EntityManagerFactory emf;

	@Inject
	FacesContext facesContext;

	@Inject
	BenutzerStatus benutzerStatus;

	private String benutzername;
	private String kennwort;

	public LoginBean() {
		kennwort = "";
		benutzername = "";
	}

	/**
	 * In dieser Methode werden die Eingaben des Benutzers, mit den
	 * entsprechenden Daten der Datenbank verglichen. Stimmen Benutzername und
	 * Passwort jeweils überein, ist die Anmeldung erfolgreich.
	 * 
	 * @return null, damit kein Seitenwechsel stattfindet.
	 */
	@SuppressWarnings("unchecked")
	public String login() {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] bytesOfDigestSource = kennwort.getBytes("UTF-8");
			byte[] digest = md.digest(bytesOfDigestSource);
			String hexStringDiggest = Benutzer.hexDigitString(digest);

			EntityManager em = emf.createEntityManager();
			Query q = em
					.createQuery("select b.kurzname,b.kennwortHash from Benutzer b where b.kurzname= :kurzname and b.kennwortHash= :kennwortHash");
			q.setParameter("kurzname", benutzername);
			q.setParameter("kennwortHash", hexStringDiggest);
			List<Benutzer> benutzerList = q.getResultList();
			if (benutzerList != null && !benutzerList.isEmpty()) {
				benutzerStatus.setAuthenticated(true);
			}
			em.close();
		} catch (NoSuchAlgorithmException e) {
			FacesMessage message = new FacesMessage(
					"Keine UTF-8 Unterstützung",
					"Das UTF-8 Encoding wird auf diesem System nicht unterstützt'.");
			facesContext.addMessage("Anmeldung Fehlgeschlagen", message);

		} catch (UnsupportedEncodingException e) {
			FacesMessage message = new FacesMessage("Kein MD5 Algorithmus",
					"Auf diesem System existiert keine Implementierung des MD5-Algorithmus'.");
			facesContext.addMessage("Anmeldung Fehlgeschlagen", message);
		}
		if (!benutzerStatus.isAuthenticated()) {
			FacesMessage message = new FacesMessage("Anmeldung fehlgeschlagen",
					"Die Kombination aus 'Name' und 'Kennwort' passt nicht.");
			facesContext.addMessage("Anmeldung Fehlgeschlagen", message);
		}
		return null;
	}

	// ++++++++++++++++ Getter & Setter +++++++++++++++++++++++
	/**
	 * Antwortet mit dem Wert des benutzername
	 * 
	 * @return the benutzername
	 */
	public String getBenutzername() {
		return benutzername;
	}

	/**
	 * @param benutzername
	 *            the benutzername to set
	 */
	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	/**
	 * @return the kennwort
	 */
	public String getKennwort() {
		return kennwort;
	}

	/**
	 * @param kennwort
	 *            the kennwort to set
	 */
	public void setKennwort(String kennwort) {
		this.kennwort = kennwort;
	}
}
