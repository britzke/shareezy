package org.shareezy.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "groupManager")
@SessionScoped
public class GroupManagerBean {
	GroupManagerBean() {
		System.out.println("GroupManagerBean");
	}

	/** Wird ausgeführt wenn der User auf "Neue Gruppe" (Schritt 1) klickt */
	public String onNewGroupClick() {
		return null;
		// Öffnet einen Dialog (Schritt 2) und der user wird aufgefordert eine
		// Gruppen-ID einzugeben
	}

	/** Wird ausgeführt wenn der User auf "Erstellen" (Schritt 2) klickt */
	public String onCreateNewGroupClick() {
		return null;
		// Erzeugt eine neue Gruppe in der Datenbank
		// Leitet den User zur Gruppen-Ansicht (Schritt 3) der neuen Gruppe
	}

	/** Wird ausgeführt wenn der User auf "Neue Ressource" (Schritt 3) klickt */
	public String onCreateNewRessourceClick() {
		return null;
		// Leitet den User zum Dialog "Ressource hinzufügen"
	}

	/** Wird ausgeführt wenn der User auf "Mitglieder" (Schritt 3.1) klickt */
	public String onShowMembersClick() {
		return null;
		// Listet alle Mitglieder
	}

	/**
	 * Wird ausgeführt wenn der User auf "Mitglieder hinzufügen" (Schritt 3.1)
	 * klickt
	 */
	public String onAddMembersClick() {
		return null;
		// Zeigt den Hinzufügen-Dialog (Schritt 3.2)
	}

	/** Wird ausgeführt wenn der User auf "Einladen" (Schritt 3.2) klickt */
	public String onInviteMembersClick() {
		return null;
		// Versendet entsprechende Einladungen an User
	}
}