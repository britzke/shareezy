/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	Steven Müller
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

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.shareezy.entities.Benutzer;
import org.shareezy.entities.Gruppe;
import org.shareezy.entities.Ressource;

/**
 * Guppenverwaltung, Gruppen hinzufügen & Gruppen editieren
 * 
 * @author Steven Müller
 */
@Named("groupManager")
@SessionScoped
public class GroupManagerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory emf;
	private String groupName;
	private Benutzer benutzer;
	private ArrayList<Ressource> groupRessourcen = new ArrayList<Ressource>();


	/**
	 * Wird ausgeführt wenn der User auf "Neue Gruppe" (@issue9/Schritt 1)
	 * klickt.
	 * Öffnet einen Dialog (@issue9/Schritt 2) und der user wird aufgefordert
	 * eine Gruppen-ID einzugeben
	 * 
	 * @return null - Soll in der selben View bleiben
	 */
	public String onNewGroupClick() {
		return null;
	}

	public GroupManagerBean() {
		groupRessourcen.add(generateTestRessources());
		groupRessourcen.add(generateTestRessources());
		groupRessourcen.add(generateTestRessources());
		groupRessourcen.add(generateTestRessources());
	}
	
	public Ressource generateTestRessources(){
		Ressource res = new Ressource();
		res.setName("TestRessource");
		return res;
	}
	
	
	/**
	 * Wird ausgeführt wenn der User auf "Erstellen" (@issue9/Schritt 2) klickt.
	 * Erzeugt eine neue Gruppe in der Datenbank Leitet den User zur
	 * Gruppen-Ansicht (@issue9/Schritt 3) der neuen Gruppe
	 * 
	 * @return null - Soll in der selben View bleiben
	 */
	public String onCreateNewGroupClick() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Gruppe gruppe = new Gruppe();
		gruppe.setVerwalter(benutzer);
		gruppe.setName(groupName);
		em.persist(gruppe);

		return null;
	}

	/**
	 * Wird ausgeführt wenn der User auf "Neue Ressource" (@issue9/Schritt 3)
	 * klickt. Leitet den User zum Dialog "Ressource hinzufügen"
	 * 
	 * @return null - Soll in der selben View bleiben
	 */
	public String onCreateNewRessourceClick() {
		return null;
	}

	/**
	 * Wird ausgeführt wenn der User auf "Mitglieder" (@issue9/Schritt 3.1)
	 * klickt
	 * <p>
	 * Listet alle Mitglieder
	 * 
	 * @return null - Soll in der selben View bleiben
	 */
	public String onShowMembersClick() {
		return null;
	}

	/**
	 * Wird ausgeführt wenn der User auf "Mitglieder hinzufügen"
	 * (@issue9/Schritt 3.1) klickt
	 * <p>
	 * Zeigt den Hinzufügen-Dialog (@issue9/Schritt 3.2)
	 * 
	 * @return null - Soll in der selben View bleiben
	 */
	public String onAddMembersClick() {
		
		return null;
	}

	/**
	 * Wird ausgeführt wenn der User auf "Einladen" (@issue9/Schritt 3.2) klickt.
	 * Versendet entsprechende Einladungen an Benutzer.
	 * 
	 * @return null - Soll in der selben View bleiben
	 */
	public String onInviteMembersClick() {
		return null;
	}

	
	public ArrayList<Ressource> getGroupRessourcen() {
		return groupRessourcen;
	}

	public void setGroupRessourcen(ArrayList<Ressource> groupRessourcen) {
		this.groupRessourcen = groupRessourcen;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}