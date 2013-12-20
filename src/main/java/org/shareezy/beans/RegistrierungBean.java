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

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.shareezy.entities.Benutzer;

/**
 * Die Klasse RegestrieurungsBean stellt Methoden zur Verfügung die dazu genutzt
 * werden damit sich der Nutzer anmelden kann.
 * 
 * @author Maurice Engelskirchen
 * @author burghard.britzke mailto:bubi@charmides.in-berlin.de
 * @version 1.0 11.12.2013
 * 
 */
@ManagedBean
public class RegistrierungBean {

	private EntityManagerFactory emf;
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
	 * Fügt der Entität "Benutzer" der Datenbank einen neuen datensatz mit den
	 * vom Benutzer eingegebenen Daten hinzu. Danach wird die Methode
	 * dalidierungsEmail() aufgerufen.
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
	 * Schickt bei Erfolgreicher Regestrierung eine bestätigungs e-mail an den
	 * Benutzer.
	 * 
	 * @return null da kein Seitenwechsel stattfindet.
	 */
	public String validierungsEmail() {
		return null;

	}

}
