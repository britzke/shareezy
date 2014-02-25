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
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
		Gruppe gruppe = new Gruppe();
		em.persist(gruppe);
		Query qy = em
				.createQuery("select b from Benutzer where benutzer= :benutzer and gruppe= :gruppe");
		qy.setParameter("benutzer", benutzer.getKurzname());
		@SuppressWarnings("unchecked")
		List<Benutzer> benutzerList = qy.getResultList();
		for (Benutzer b : benutzerList) {
			// für jedes benutzerobjekt b in der benutzerliste
			if (b.getKurzname().equals(benutzer.getKurzname())
			// wird abgefragt ob der kurzname der benutzers b gleich ist mit dem
			// eingetragenen benutzer aus der entity
					&& b.getKennwort().equals(benutzer.getKennwort())) {
				setAuthenticated(true);
				break;
			}
		}
		em.close();

		return null;
	}
	
	public void ressourcegruppe(){
		//benutzer.addRessource();
	}
}
