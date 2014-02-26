/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	Vanessa Krohn
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

import java.awt.Image;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Query;
//import org.shareezy.entities.Ressource;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.shareezy.entities.Buchung;
import org.shareezy.entities.Ressource;

/**
 * Klasse ist zustaendig fuer die detailierte Ansicht der Ressourcen. Ansicht
 * besteht aus Bild, Beschreibung, Kalender und dem Buchungsbutton
 * 
 * @author Vanessa Krohn
 * @date 05/12/13
 */

@Named
@RequestScoped
public class RessourcenDetailBean {

	private EntityManagerFactory emf;
	@Inject
	private Ressource ressource;
	private Date timeframe;
	@Inject
	private Buchung buchung;

	/**
	 * Um den TimePicker zu oeffnen wird beim Klick auf den Buchungsbutton
	 * (Detailressourcenansicht) ausgefuehrt
	 */
	public String timePicker() {
		return null;
	}
	
	/**
	 * fügt der Entität "Buchung" der Datenbank einen neuen Datensatz mit den im
	 * TimePicker eingegebenen Daten hinzu.
	 * 
	 * @return null - immer
	 * 
	 */
	public String addDatensatz() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		buchung.setRückgabedatum(timeframe);
		em.persist(buchung);
		transaction.commit();

		em.close();
		return null;
	}

	/**
	 * wird durch Verwendung des TimePickers ausgefuehrt um den vom User
	 * ausgewaehlten Zeitraum im Textfeld auszugeben
	 */

	public Date getTimeframe() {
		return timeframe;
	}

	/**
	 * um Doppelbuchungen zu verhindern
	 * sucht Datensatz "ressourcen_id" in der Entitaet "Buchungen" und
	 * vergleicht die neuen Werte (Datum + Uhrzeit) mit den Werten aus der
	 * Datenbank Fehlermeldung wenn Ressource in dem gewuenschtem Zeitraum
	 * bereits vergeben ist + alternativen Terminvorschlag. Ist die Reservierung
	 * erfolgreich, wird in der Entitaet "Buchungen" ein neuer Datensatz (Datum
	 * + Uhrzeit) angelegt und die ressourcen_id und die user_id werden
	 * aktualisiert
	 * 
	 * wird beim Klick auf den Bestaetigungsbutton aufgerufen
	 */

	public void checkDate() {
	}

	public String action() {
		addDatensatz();
		return "";

	}
}
