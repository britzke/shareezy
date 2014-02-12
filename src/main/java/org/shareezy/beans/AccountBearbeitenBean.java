/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	Maurice Engelskirchen
 * 						Burak Cakir
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

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.shareezy.entities.Benutzer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 * Die Klasse AccountBearbeitenBean stellt Methoden zur Verfügung, die dafür
 * genutzt werden das der Nutzer seinen Account bearbeiten kann.
 * 
 * @author Maurice Engelskirchen, Burak Cakir
 */
@ManagedBean
public class AccountBearbeitenBean

{
	private EntityManagerFactory emf;
	private EntityManager em;
	private Benutzer user;
	private EntityTransaction t;
	private String altesPasswort;
	private String eingabePasswort;
	private String eingabePasswortWiederholen;
	private String eingabePasswortAlt;
	private String eMail;

	@ManagedProperty("#{facesContext}")
	FacesContext faces;

	/**
	 * Antwortet mit dem Wert des faces
	 * @return the faces
	 */
	public FacesContext getFaces() {
		return faces;
	}

	/**
	 * @param faces the faces to set
	 */
	public void setFaces(FacesContext faces) {
		this.faces = faces;
	}

	/**
	 * Prüft die Eingabe des nutzer. Abhängig davon gibt er eine fehlermeldung
	 * aus, prüftt die eingabe mit den in der Datenbank gespeicherten referens
	 * Daten oder ruft direkt die Methode DatensatzÄndern() auf.
	 * 
	 * @return null da kein Seitenwechsel stattfindet.
	 */

	public String eingabePrüfen() {
		altesPasswort = "";

		if (eingabePasswort.equals("")) {
			datensatzÄndern();
		} else {
			if (eingabePasswort.equals(eingabePasswortWiederholen)) {
				if (eingabePasswort.equals(eingabePasswortAlt)) {
					faces.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Altes passwort sollte nicht gleich neuen passwort sein",
									"Sample error message"));
				} else {
					if (eingabePasswortAlt.equals(altesPasswort)) {
						datensatzÄndern();

					} else {
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"Das eingegebene Passwort ist falsch.",
								"Sample error message"));
					}

				}
			} else {
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Die Passwörter müssen übereinstimmen.",
						"Sample error message"));
			}
		}

		return null;
	}

	/**
	 * Die Metode Datensatz ändern überschreibt den zur "User_Id" Gehörenden
	 * Datensatz mit dem von Benutzer eingegebenen Daten.
	 * 
	 * @return null da kein Seitenwechsel stattfindet.
	 */
	public String datensatzÄndern() {
		 em = emf.createEntityManager();
		 t = em.getTransaction();
		 t.begin();
		 em.merge(user);
		 t.commit();
		 em.close();
		return null;
	}

	/**
	 * @return the eingabePasswort
	 */
	public String getEingabePasswort() {
		return eingabePasswort;
	}

	/**
	 * @param eingabePasswort
	 *            the eingabePasswort to set
	 */
	public void setEingabePasswort(String eingabePasswort) {
		this.eingabePasswort = eingabePasswort;
	}

	/**
	 * @return the eingabePasswortAlt
	 */
	public String getEingabePasswortAlt() {
		return eingabePasswortAlt;
	}

	/**
	 * @param eingabePasswortAlt
	 *            the eingabePasswortAlt to set
	 */
	public void setEingabePasswortAlt(String eingabePasswortAlt) {
		this.eingabePasswortAlt = eingabePasswortAlt;
	}

	/**
	 * @return the eMail
	 */
	public String geteMail() {
		return eMail;
	}

	/**
	 * @param eMail
	 *            the eMail to set
	 */
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	/**
	 * @return the eingabePasswortWiederholen
	 */
	public String getEingabePasswortWiederholen() {
		return eingabePasswortWiederholen;
	}

	/**
	 * @param eingabePasswortWiederholen
	 *            the eingabePasswortWiederholen to set
	 */
	public void setEingabePasswortWiederholen(String eingabePasswortWiederholen) {
		this.eingabePasswortWiederholen = eingabePasswortWiederholen;
	}
}
