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

import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
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

@Named
@RequestScoped
public class CalendarBean {
	private EntityManagerFactory emf;
	@Inject
	private Buchung buchung;
	private boolean inCalendar;
	private Date timeframe;

	public CalendarBean() {
	}

	/**
	 * Bucht ein User eine bestimmte Ressource, werden die Werte Ausleihdatum
	 * und Rückgabedatum in die Datenbank gespeichert. Diese Daten werden
	 * ausgelesen, und dieser Zeitraum (vom Ausleihzeitpunkt bis zur Rückgabe)
	 * wird im Kalender farblich (rot) markiert. Die Methode wird durch
	 * <em>schedule.xhml</em> (View) angesprochen. Sie wird aufgerufen, sobald
	 * ein Benutzer eine Ressource erfolgreich gebucht hat (Anwahl der
	 * Schaltfläche zur Bestätigung unterhalb des <em>TimePickers</em>).
	 * 
	 * @returns null - immer, da keine Navigation zu einer anderen Seite
	 *          eineleitet wird.
	 *          
	 * Diese Methode ist noch unfertig!
	 */
	public String scheduleController() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select b from Buchnung where ressourcen= :aktuelleRessource");
		@SuppressWarnings("unchecked")
		List<Buchung> buchungList = q.getResultList();
		for (Buchung b : buchungList) {
			if (b.getRückgabedatum().equals(buchung.getRückgabedatum())) {
				setInCalendar(true);
			}
		}
		return null;
	}

	public Date getTimeframe() {
		return timeframe;
	}

	public boolean isInCalendar() {
		return inCalendar;
	}

	public void setInCalendar(boolean inCalendar) {
		this.inCalendar = inCalendar;
	}
}
