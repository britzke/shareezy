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

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.shareezy.entities.Buchung;

/**
 * Klasse ist zustaendig fuer die Kalender der Ressourcen. Das aktuelle Datum
 * und die Buchungen der Ressouren werden im Kalender angegeben.
 * 
 * @author Vanessa Krohn
 */

public class CalendarBean {
	private EntityManagerFactory emf;
	private Buchung buchung;

	/**
	 * Liest die neuen, vom User geaenderten Daten aus der Datenbank aus und
	 * laesst sie im Kalender erscheinen. Die Methode wird durch
	 * <em>schedule.xhml</em> (View) angesprochen. Sie wird aufgerufen, sobald
	 * ein Benutzer eine Ressource erfolgreich gebucht hat (Anwahl der
	 * Schaltfläche zur Bestätigung unterhalb des <em>TimePickers</em>).
	 * 
	 * @returns null - immer, da keine Navigation zu einer anderen Seite
	 *          eineleitet wird.
	 */
	public String scheduleController() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select b from Buchung where rückgabedatum= :rückgabedatum and ausleiher= :ausleiher");
		return null;
	}

	/**
	 * Markiert das aktuelle Datum im Kalender wird aufgerufen, wenn der, auf
	 * der Detailressourcenansicht befindliche Kalender geladen wird
	 * 
	 * @returns null - immer, da keine Navigation zu einer anderen Seite
	 *          eineleitet wird.
	 */
	public Calendar today() {
		return null;
	}
}
