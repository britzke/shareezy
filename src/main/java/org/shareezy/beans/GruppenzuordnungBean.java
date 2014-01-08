/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	e1_herrmann
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

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Bean für die Gruppenzuordnung. Es wird geprüft welche Mitglieder Ressourcen
 * innerhalb der Gruppe verwalten können. Abfrage des Status der Ressource Wenn
 * jemand aus der Gruppe entfernt wird/geht. Welche Ressource zur Gruppe
 * hinzugefügt wird. Nachträgliches bearbeiten der ressourcen zu gruppe/ID.
 * Ressource der gruppe hinzufügen.
 * 
 * @author e1_hermann
 * @author burghard.britzke bubi@charmides.in-berlin.de
 **/
@ManagedBean
@SessionScoped
public class GruppenzuordnungBean {

	public String gruppenersteller;
	public String leitunguebertragen;
	public String mitglied;
	public String account_id;
	public String accounts_id;
	public EntityManagerFactory emf;
	public EntityManager em;


	/**
	 * Welches Mitglied ist berechtigt zum abfragen/erstellen/verwalten von
	 * Ressourcen
	 * 
	 * @return accountID
	 */
	public String mitgliederabfragen() {
		return account_id;

	}

	/**
	 * Abfrage des status der ressource
	 * 
	 * @return
	 */
	public String ressourcestatus() {

		return accounts_id;

	}

	/**
	 * Mitglied aus der Gruppe entfernen/gruppenID
	 * 
	 * @return
	 */
	public String mitgliedentfernen() {
		return null;
	}

	/**
	 * Ressource zur gruppe hinzufügen. Erstmal aus der View abfragen, dann
	 * Datenbankabfrage
	 * 
	 * @return
	 */
	public String addressourcen(int ressourcenid) {
		return null;
	}

	/**
	 * bearbeiten der ressource
	 * 
	 * @return
	 */
	public String editressource() {
		return null;
	}

}
