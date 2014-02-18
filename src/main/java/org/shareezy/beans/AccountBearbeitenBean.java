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
	private String eMail;
	private String eingabePasswort;
	/**
	 * Prüft die Eingabe des nutzer. Abhängig davon gibt er eine fehlermeldung
	 * aus, prüftt die eingabe mit den in der Datenbank gespeicherten referens
	 * Daten oder ruft direkt die Methode DatensatzÄndern() auf.
	 * 
	 * @return null da kein Seitenwechsel stattfindet.
	 */

	public String eingabePrüfen() {
		// EntityManager em = emf.createEntityManager();
		// altesPasswort = user.getKennwort();
		// em.persist(user);

		return null;
	}

	/**
	 * Die Metode Datensatz ändern überschreibt den zur "User_Id" Gehörenden
	 * Datensatz mit dem von Benutzer eingegebenen Daten.
	 * 
	 * @return null da kein Seitenwechsel stattfindet.
	 */
	public String datensatzÄndern() {
		System.out.println("Methode ausgeführt");
		// em = emf.createEntityManager();
		// t = em.getTransaction();
		// t.begin();
		// em.merge(user);
		// t.commit();
		// em.close();
		return null;
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

	public String getEingabePasswort() {
		return eingabePasswort;
	}

	public void setEingabePasswort(String eingabePasswort) {
		this.eingabePasswort = eingabePasswort;
	}
}
