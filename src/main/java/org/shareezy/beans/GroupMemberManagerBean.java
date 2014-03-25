/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	Timo Kuchling
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

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.shareezy.entities.Benutzer;
import org.shareezy.entities.BenutzerGruppe;
import org.shareezy.entities.Ressource;

/**
 * Beschreibung von GroupMemberManagerBean
 * 
 * <ol>
 * <li>
 * Ermöglicht das Hinzufügen/Entfernen von Benutzern in Gruppen<br>
 * </li>
 * <li>
 * Entfernt abgelehnte Aufnahmeanfragen</li>
 * </ol>
 * 
 * @author Timo Kuchling
 */
@SessionScoped
@Named("memberManager")
public class GroupMemberManagerBean implements Serializable {

	/**
	 * Für die Bean benötigte Eigenschaften
	 */
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction t;
	private Benutzer user = new Benutzer();
	private BenutzerGruppe userGrp = new BenutzerGruppe();
	private List<Ressource> grpDataListe;
	private List<Ressource> grpAnfListe;

	/**
	 * Die Methode AddUser dient dazu dem Benutzer eine Gruppe zuzuweisen
	 * <ol>
	 * <li>
	 * wird bei Klick auf 'Hinzufügen' und 'Annehmen' aufgerufen <br>
	 * </li>
	 * <li>
	 * falls addUser durch einen Klick auf 'Annehmen' aufgerufen wurde muss
	 * deleteRequest nach dem Hinzufügen aufgerufen werden <br>
	 * </li>
	 * <li>
	 * erstellt die Zuweisung in der AccountsGruppen Entität</li>
	 * </ol>
	 * 
	 * @return gibt nichts zurück damit sich die View nicht ändert
	 */
	public String addUser() {
		em = emf.createEntityManager();
		t = em.getTransaction();
		t.begin();
		em.persist(user);
		t.commit();
		em.close();
		return null;
	}

	/**
	 * Die Methode deleteUser dient dazu die Gruppenzuweisung eines Benutzers zu
	 * entfernen
	 * <ol>
	 * <li>
	 * wird bei Klick auf 'Entfernen' aufgerufen<br>
	 * </li>
	 * <li>
	 * löscht die Zuweisung in der AccountsGruppen Entität</li>
	 * </ol>
	 * 
	 * @return gibt nichts zurück damit sich die View nicht ändert
	 */
	public String deleteUser() {
		em = emf.createEntityManager();
		t = em.getTransaction();
		t.begin();
		em.remove(user);
		t.commit();
		em.close();
		return null;
	}

	/**
	 * Die Methode deleteRequest dient dazu eine Anfrage in der
	 * Gruppendetailansicht zu entfernen
	 * <ol>
	 * <li>
	 * wird bei Klick auf Ablehnen aufgerufen<br>
	 * </li>
	 * </ol>
	 * 
	 * @return gibt nichts zurück damit sich die View nicht ändert
	 */
	public String deleteRequest() {
		em = emf.createEntityManager();
		t = em.getTransaction();
		t.begin();
		em.remove(userGrp);
		t.commit();
		em.close();
		return null;
	}

	/**
	 * Die Methode sendRequest dient dazu eine Anfrage an den
	 * Benutzer zu senden
	 * <ol>
	 * <li>
	 * wird bei Klick auf Ablehnen aufgerufen<br>
	 * </li>
	 * </ol>
	 * 
	 * @return gibt nichts zurück damit sich die View nicht ändert
	 */
	public String sendRequest() {
		em = emf.createEntityManager();
		t = em.getTransaction();
		t.begin();
		em.persist(userGrp);
		t.commit();
		em.close();
		return null;
	}

	/**
	 * getGrpAnf hol sich aus der Datenbank die Anfragen der jeweiligen Gruppe
	 * und listet diese in der View
	 */

	@SuppressWarnings("unchecked")
	public void getGrpAnf() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select r from BenutzerGruppe r");
		grpAnfListe = q.getResultList();
		em.getTransaction().commit();
	}

	/**
	 * getGrpRes hol sich aus der Datenbank die Ressourcen der jeweiligen Gruppe
	 * und listet diese in der View
	 */
	@SuppressWarnings("unchecked")
	public void getGrpData() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select r from Gruppe r");
		grpDataListe = q.getResultList();
		em.getTransaction().commit();
	}

	/**
	 * @return the grpResListe
	 */
	public List<Ressource> getGrpDataListe() {
		return grpDataListe;
	}

	/**
	 * @param grpResListe
	 *            the grpResListe to set
	 */
	public void setGrpDataListe(List<Ressource> grpDataListe) {
		this.grpDataListe = grpDataListe;
	}

	/**
	 * @return the grpAnfListe
	 */
	public List<Ressource> getGrpAnfListe() {
		return grpAnfListe;
	}

	/**
	 * @param grpAnfListe
	 *            the grpAnfListe to set
	 */
	public void setGrpAnfListe(List<Ressource> grpAnfListe) {
		this.grpAnfListe = grpAnfListe;
	}
}
