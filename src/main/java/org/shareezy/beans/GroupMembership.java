/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	Maxim Slipachuk
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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.servlet.ServletContext;

import org.shareezy.entities.Benutzer;
import org.shareezy.entities.Gruppe;
import org.shareezy.entities.Ressource;

/**
 * Eigene Gruppenzugehörigkeit beantragen/entfernen
 * 
 * @author Maxim Slipachuk
 */
@RequestScoped
@Named
public class GroupMembership implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManagerFactory emf;
	private List<Gruppe> gruppenliste;
	private List<Gruppe> filteredgruppen;

	/**
	 * Wird bei Klick auf 'Anfrage' aufgerufen. Es wird dem Gruppeneigentümer
	 * eine AnfrageMessage zugesendet. Diese Message wird in der Datenbank
	 * gespeichert, bis sie vom Gruppeneigentümer abgelehnt oder angenommen
	 * wurde.
	 * 
	 * Die vom Benutzer ausgewählte Gruppe wird übergeben um somit den
	 * Gruppenverwalter zu ermitteln. Dann soll dem Gruppenverwalter eine
	 * automatisierte Nachricht zugeschickt werden. Diese Nachricht soll in
	 * einer Liste, mit dem Autor der Nachricht und der Gruppe deren Beitritt
	 * gewünscht ist, angezeigt werden. Außerdem wird dem Gruppenverwalter die
	 * Möglichkeit gegeben die Anfrage zu löschen. Dies bedeutet auch eine
	 * Löschung der Anfragenachricht in der Datenbank. Weiterhin ist es dem
	 * Gruppenverwalter auch möglich die Anfrage zu akzeptieren. Dadurch wird
	 * der Benutzer der jeweiligen Gruppe hinzugefügt und die Anfragenachricht
	 * gelöscht.
	 * 
	 * @return gibt nichts zurück damit sich die View nicht Verändert
	 * 
	 */

	public String sendAnfrage(Gruppe gruppe) {

		return null;
	}

	@PostConstruct
	private void init() {
		if (gruppenliste == null) {
			queryGruppenliste();
		}

	}

	@SuppressWarnings("unchecked")
	public void queryGruppenliste() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select r from Gruppe r");
		gruppenliste = q.getResultList();
		em.getTransaction().commit();
		if (gruppenliste.size() == 0) {
			gruppenliste = new ArrayList<Gruppe>();
		}
	}

	/**
	 * Wird bei Klick auf 'Gruppe Verlassen' aufgerufen
	 * 
	 * @return gibt nichts zurück damit sich die View nicht Veraendert
	 */

	public String knopfGruppeVerlassen() {
		return null;
	}

	public List<Gruppe> getGruppenliste() {
		return gruppenliste;
	}

	public void setGruppenliste(List<Gruppe> gruppenliste) {
		this.gruppenliste = gruppenliste;
	}

	public List<Gruppe> getFilteredgruppen() {
		return filteredgruppen;
	}

	public void setFilteredgruppen(List<Gruppe> filteredgruppen) {
		this.filteredgruppen = filteredgruppen;
	}
}
