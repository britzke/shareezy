/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	Tim Treibmann
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

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.shareezy.entities.Ressource;

/**
 * Diese Klasse stellt die Eigenschaften und Funktinen für das Listen von
 * Ressourcen zur Verfügung. Ressourcen werden in der Ressourcenansicht.xhtml,
 * EigeneRessourcen.xhtml, Gruppenverwaltung.xhtml und eigeneBuchungen.xhtml
 * gelistet.
 * 
 * @author treibmann
 * 
 */
@Named
@RequestScoped
public class RessourceListen {

	@Inject
	private EntityManagerFactory emf;

	@Inject
	private AktuelleRessourceBean aktuelleressource;

	private List<Ressource> filteredRessource;

	private List<Ressource> listeRessourcen;

	/**
	 * Die Methode ressourceClicked speichert die vom User, in der
	 * Ressourcenliste, angewählte Ressource in der Eigenschat aktuelle
	 * Ressource ab. Damit wird ein Wiederverwenden der angewählte Ressource
	 * ermöglicht.
	 * 
	 * @return "ressourcendetail" gibt die ressourcendetail zurück wenn auf
	 *         einen Ressourcennamen geklickt wurde.
	 */
	public void ressourceClicked(Ressource ressource) {
		aktuelleressource.setRessource(ressource);
	}

	/**
	 * Die Methode getRessourcenListe gibt eine Liste aller Ressourcen in der
	 * Datenbank zurück.
	 * 
	 * @return Liste von Ressourcenobjekten.
	 */
	public List<Ressource> getRessourcenListe() {
		return listeRessourcen;
	}

	/**
	 * Die Methode init initialisiert einmalig eine RessourcenListe. Dies
	 * geschieht durch den Aufruf der Methode queryRessourcenListe().
	 */
	@PostConstruct
	private void init() {
		if (listeRessourcen == null) {
			queryRessourcenListe();
		}
	}

	/**
	 * Die Methode queryRessourcenListe erstellt einen Datenbankzugriff und
	 * liefert über ein Select Statement alle, in die Datenbank eingetragenen
	 * Ressourcenobjekte zurück und speichert dieses Resultset in die Variable
	 * listeRessourcen.
	 */
	@SuppressWarnings("unchecked")
	public void queryRessourcenListe() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select r from Ressource r");
		listeRessourcen = q.getResultList();
		em.getTransaction().commit();
		if (listeRessourcen.size() == 0) {
			listeRessourcen = new ArrayList<Ressource>();
		}

	}

	/**
	 * Gettermethode für die Eigenschaft FilteredRessource. Wird benötigt um das
	 * Filtern von Ressourcen auf XML-Ebene zu ermöglichen.
	 * 
	 * @return the filteredRessource
	 */
	public List<Ressource> getFilteredRessource() {
		return filteredRessource;
	}

	/**
	 * Settermethode für die Eigenschaft FilteredRessource. Wird benötigt um das
	 * Filtern von Ressourcen auf XML-Ebene zu ermöglichen.
	 * 
	 * @param filteredRessource
	 *            the filteredRessource to set
	 */
	public void setFilteredRessource(List<Ressource> filteredRessource) {
		this.filteredRessource = filteredRessource;
	}
}
