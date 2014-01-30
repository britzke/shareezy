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

import java.util.List;

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
public class LoginBean {

	private EntityManagerFactory emf;
	private Benutzer benutzer;
	private boolean authenticated;
	
	private String benutzername="";
	private String kennwort ="";

	public LoginBean() {
		benutzer = new Benutzer();
	}

	/**
	 * @return the authenticated
	 */
	public boolean isAuthenticated() {
		return authenticated;
	}

	/**
	 * @param authenticated
	 *            the authenticated to set
	 */
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
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
		EntityManager em = emf.createEntityManager();
		Query q = em
				.createQuery("select b from Benutzer where kurzname= :kurzname and kennwort= :kennwort");
		q.setParameter("kurzname", benutzer.getKurzname());
		q.setParameter("kennwort", benutzer.getKennwort());
		List<Benutzer> benutzerList = q.getResultList();
		for (Benutzer b : benutzerList) {
			if (b.getKurzname().equals(benutzer.getKurzname())
					&& b.getKennwort().equals(benutzer.getKennwort())) {
				setAuthenticated(true);
				break;
			}
		}
		em.close();
		System.out.println("Username: "+benutzername+"Kennwort: "+kennwort);
		return null;
	}
	
	// ++++++++++++++++ Getter & Setter +++++++++++++++++++++++
	/**
	 * @return the benutzername
	 */
	public String getBenutzername() {
		return benutzername;
	}

	/**
	 * @param benutzername the benutzername to set
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
	 * @param kennwort the kennwort to set
	 */
	public void setKennwort(String kennwort) {
		this.kennwort = kennwort;
	}
}
