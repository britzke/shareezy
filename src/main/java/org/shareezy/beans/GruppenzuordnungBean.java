/**
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

import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.shareezy.beans.GruppenzuordnungBean;
import org.shareezy.entities.Benutzer;
import org.shareezy.entities.Gruppe;
import org.shareezy.entities.Ressource;

/**
 * Bean für die Gruppenzuordnung. Es wird geprüft welche Mitglieder Ressourcen
 * innerhalb der Gruppe verwalten können. Abfrage des Status der Ressource Wenn
 * jemand aus der Gruppe entfernt wird/geht. Welche Ressource zur Gruppe
 * hinzugefügt wird. Nachträgliches bearbeiten der ressourcen zu gruppe/ID.
 * Ressource der gruppe hinzufügen.
 * 
 * @author e1_hermann
 * @author burghard.britzke bubi@charmides.in-berlin.de
 */
@SessionScoped
@Named("GruppenzuordnungBean")
public class GruppenzuordnungBean {

	private List<Ressource> res;

	private List<Gruppe> grp;

	private EntityManagerFactory emf;

	public EntityManager em;
	private boolean authenticated;

	private Benutzer benutzer;

	public GruppenzuordnungBean() {
		benutzer = new Benutzer();
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	/**
	 * 
	 * @return null - immer
	 */
	public String mitgliederabfragen() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		Gruppe gruppe = new Gruppe();
		em.persist(gruppe);
		/*
		 * Query qr = em.createQuery(
		 * "SELECT a.ID FROM Ressource a, b.ID FROM Gruppe b FROM Ressource b "
		 * );
		 */
		Query qr = em
				.createQuery("SELECT shareezy.RESSOURCEN.ID, shareezy.GRUPPEN.ID FROM shareezy.RESSOURCEN INNER JOIN shareezy.GRUPPEN ON shareezy.GRUPPEN.ID=shareezy.RESSOURCEN.ID;");
		List<Ressource> abgleich = qr.getResultList();
		System.out.println(qr);
		tr.commit();
		
		//abgleich.add(index, element);
		/*
		 * Query qr2 = em.createQuery("SELECT b FROM Gruppe b"); List<Gruppe>
		 * abgleich2 = qr.getResultList();
		 */
		return null;
	}

	public void ressourcegruppe() {
		// benutzer.addRessource();
	}
}
