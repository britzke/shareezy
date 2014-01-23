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

import javax.annotation.ManagedBean;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.shareezy.entities.Buchung;
import org.shareezy.entities.Ressource;

/**
 * Klasse ist zustaendig fuer den TimePicker und die vom User eingestellten Daten (Datum + Uhrzeit)
 * 
 * @author Vanessa Krohn 
 * @date 05/12/13
 */
@Named
public class TimePickerBean {

	private Date timeframe;
	
	private EntityManagerFactory emf;
	private Buchung buchung;

	/**
	 * erzeugt eine neue TimePickerBean
	 * initialisiert Buchung
	 */
	public TimePickerBean() {
		buchung = new Buchung();
	}
	
	/**
	 * fügt der Entität "Buchung" der Datenbank einen neuen Datensatz mit den
	 * im TimePicker eingegebenen Daten hinzu.
	 * 
	 */
	public String addDatensatz() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select rückgabedatum from buchung");
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		buchung.setRückgabedatum(timeframe);
		em.persist(buchung);
		transaction.commit();
		
		List<Buchung> buchungList = q.getResultList();
		for(Buchung b : buchungList){
			
		}
	
		em.close();
		return null;
	}
	
	/**
	 * wird durch Verwendung des TimePickers ausgefuehrt
	 * um den vom User ausgewaehlten Zeitraum im Textfeld auszugeben
	 */
	
	public Date getTimeframe(){
		return timeframe;
	}

    /**
	 * um Doppelbuchungen zu verhindern
	 * 
	 * sucht Datensatz "ressourcen_id" in der Entitaet "Buchungen" und vergleicht die 
	 * neuen Werte (Datum + Uhrzeit) mit den Werten aus der Datenbank
	 * Fehlermeldung wenn Ressource in dem gewuenschtem Zeitraum bereits vergeben 
	 * ist + alternativen Terminvorschlag
	 * Ist die Reservierung erfolgreich, wird in der Entitaet "Buchungen" ein neuer Datensatz
	 * (Datum + Uhrzeit) angelegt und die ressourcen_id und die user_id werden aktualisiert
	 * 
	 * wird beim Klick auf den Bestaetigungsbutton aufgerufen
	 */
	
    public void checkDate(){
    } 
    
    public String action(){
    	System.out.println("funktioniert!");
    	addDatensatz();
		return "";
    	
    }
}
