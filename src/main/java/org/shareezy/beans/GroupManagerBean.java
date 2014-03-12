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
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

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

	private static final long serialVersionUID = 1L;
	private String groupName;
	private ArrayList<Gruppe> groups = new ArrayList<Gruppe>();
	private Benutzer benutzer;
	private List<Ressource> groupRessourcen;

	/**
	 * Wird ausgeführt wenn der User auf "Neue Gruppe" (@issue9/Schritt 1)
	 * klickt. Öffnet einen Dialog (@issue9/Schritt 2) und der user wird
	 * aufgefordert eine Gruppen-ID einzugeben
	 * 
	 * @return null - Soll in der selben View bleiben
	 */
	public String newGroupClick() {
		return null;
	}

	public GroupManagerBean() {
		// Test initialisierungen - TODO: Diese Daten sollen durch entsprechende
		// Daten aus der Datenbank ersetzt werden
		groupRessourcen = new ArrayList<Ressource>();
		Gruppe test1 = new Gruppe();
		test1.setName("Gruppe1");
		Gruppe test2 = new Gruppe();
		test2.setName("Gruppe2");
		Gruppe test3 = new Gruppe();
		test3.setName("Gruppe3");
		groups.add(test1);
		groups.add(test2);
		groups.add(test3);

	}

	/**
	 * Wird ausgeführt wenn der User auf "Erstellen" (@issue9/Schritt 2) klickt.
	 * Erzeugt eine neue Gruppe in der Datenbank Leitet den User zur
	 * Gruppen-Ansicht (@issue9/Schritt 3) der neuen Gruppe
	 * 
	 * @return null - Soll in der selben View bleiben
	 */
	public String createNewGroupClick() {
		// EntityManager em = emf.createEntityManager();
		// EntityTransaction t = em.getTransaction();
		// t.begin();

		Gruppe newGroup = new Gruppe();
		newGroup.setName(groupName);
		newGroup.setVerwalter(benutzer);
		groups.add(newGroup);
		// em.persist(newGroup);
		return null;
	}

	public String groupClick(Gruppe g) {
		System.out.println("Select Gruppe: " + g.getName());
		return null;
	}

	public String deleteGroupClick(Gruppe g) {
		groups.remove(g);
		System.out.println("Lösche Gruppe: " + g.getName());
		return null;
	}

	/**
	 * Wird ausgeführt wenn der User auf "Neue Ressource" (@issue9/Schritt 3)
	 * klickt. Leitet den User zum Dialog "Ressource hinzufügen"
	 * 
	 * @return null - Soll in der selben View bleiben
	 */
	public String createNewRessourceClick() {
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
	public String showMembersClick() {
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
	public String addMembersClick() {

		return null;
	}

	/**
	 * Wird ausgeführt wenn der User auf "Einladen" (@issue9/Schritt 3.2)
	 * klickt. Versendet entsprechende Einladungen an Benutzer.
	 * 
	 * @return null - Soll in der selben View bleiben
	 */
	public String inviteMembersClick() {
		return null;
	}

	public List<Ressource> getGroupRessourcen() {
		return groupRessourcen;
	}

	public void setGroupRessourcen(ArrayList<Ressource> groupRessourcen) {
		this.groupRessourcen = groupRessourcen;
	}

	public ArrayList<Gruppe> getGroups() {
		return groups;
	}

	public void setGroups(ArrayList<Gruppe> groups) {
		this.groups = groups;
	}

	public String getGroupName() {
		System.out.println("getGroupName: " + groupName);
		return groupName;
	}

	public void setGroupName(String groupName){

		this.groupName = groupName;
	}

}
