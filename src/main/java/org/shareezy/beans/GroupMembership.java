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

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.shareezy.entities.Benutzer;
import org.shareezy.entities.Gruppe;
import org.shareezy.entities.Ressource;

/**
 * Eigene Gruppenzugehörigkeit beantragen/entfernen
 * 
 * @author Maxim Slipachuk
 */
@SessionScoped
@Named("GroupMembership")
public class GroupMembership implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject private Benutzer benutzer;
	@Inject private EntityManagerFactory emf;
	@Inject private Gruppe gruppe;	
	private List<Gruppe> gruppenliste;
	private List<Gruppe> filteredgruppen;

	

	/**
	 * Wird bei Klick auf 'Hinzufuegen' aufgerufen.
	 * 
	 * @return gibt nichts zurück damit sich die View nicht Verändert
	 * 
	 */

	public String sendAnfrage() {				
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		//Query q = em.createQuery("select r from Gruppe r");		
		gruppe.getVerwalter().getEmail(); //email von Verwalter
		em.getTransaction().commit();
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
	 * getGrListe hol sich aus der Datenbank die gruppenlise 
	 * und listet diese in der View
	 */
	@SuppressWarnings("unchecked")
	public void getGrListe() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select r from Gruppe r");
		gruppenliste = q.getResultList();
		em.getTransaction().commit();
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
