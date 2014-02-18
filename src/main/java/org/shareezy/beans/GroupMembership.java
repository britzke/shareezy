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
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.shareezy.entities.Benutzer;

/**
 * Eigene Gruppenzugehörigkeit beantragen/entfernen
 * 
 * @author Maxim Slipachuk
 */
@ManagedBean
public class GroupMembership implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final String PERSISTENCE_UNIT_NAME = "shareezy";
	  private static EntityManagerFactory factory;

	  public static void main(String[] args) {
	    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();
	    // read the existing entries and write to console
	    Query q = em.createQuery("select t from Todo t");
	    List<Benutzer> benList = q.getResultList();
	    for (Benutzer todo : benList) {
	      System.out.println("benutzerID");
	    }
	    em.getTransaction().begin();
	    Benutzer todo = new Benutzer();	    
	    em.persist(todo);
	    em.getTransaction().commit();

	    em.close();
	  }
	

	/**
	 * Wird bei Klick auf 'Hinzufuegen' aufgerufen.
	 * 
	 * @return gibt nichts zurück damit sich die View nicht Verändert
	 * 
	 */
	public String sendAnfrage() {
		return null;
	}

	/**
	 * Wird bei Klick auf 'Gruppe Verlassen' aufgerufen
	 * 
	 * @return gibt nichts zurück damit sich die View nicht Veraendert
	 */
	public String knopfGruppeVerlassen() {
		return null;
	}	
}
