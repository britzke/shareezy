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
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.shareezy.entities.Ressource;

/**
 * Klasse ist zustaendig fuer die detailierte Ansicht der Ressourcen. Ansicht
 * besteht aus Bild, Beschreibung, Kalender und dem Buchungsbutton
 * 
 * @author Vanessa Krohn
 * @date 05/12/13
 */

public class RessourcenDetailBean {
	
	private EntityManagerFactory emf;
	private Ressource ressource;
    private Ressource bestimmteRessource;
	private Image pic;
	private String summary;
	
	/**
	 * erzeugt eine neue RessourcenDetailBean
	 * initialisiert Ressource
	 */
	public RessourcenDetailBean() {
		ressource = new Ressource();
		if(ressource == bestimmteRessource){
			this.ressource.getId();
		}
	}
	
	/**
	 * liest aus der Entität "Ressource" der Datenbank einen Datensatz aus
	 * 
	 */
	public String selectDatensatz() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select re from Ressource where id=bestimmteId");
		
		List<Ressource> ressource = q.getResultList();
	
		return null;
	}
	
	/**
	 * Um den TimePicker zu oeffnen wird beim Klick auf den Buchungsbutton
	 * (Detailressourcenansicht) ausgefuehrt
	 */
	public String timePicker() {
		return null;
	}

	/**
	 * zeigt ein Bild der Ressource an
	 * 
	 */
	public Image resourcePic() {
		return pic;
	}

	/**
	 * zustaendig fuer die Beschreibung der Ressource
	 * 
	 */
	public String resourceSummary() {
		return summary;
	}
}
