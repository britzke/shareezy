package org.shareezy.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * 
 * @author Steven Müller
 * @version 1.0
 * @Beschreibung Guppenverwaltung, Gruppen hinzufügen & Gruppen editieren
 * 
 */
@ManagedBean(name = "groupManager")
@SessionScoped
public class GroupManagerBean {

	/**
	 * Wird ausgeführt wenn der User auf "Neue Gruppe" (@issue9/Schritt 1)
	 * klickt
	 * 
	 * @Beschreibung Öffnet einen Dialog (Schritt 2) und der user wird
	 *               aufgefordert eine Gruppen-ID einzugeben
	 * 
	 * @return null - Soll in der selben View bleiben
	 */
	public String onNewGroupClick() {
		return null;
	}

	/**
	 * Wird ausgeführt wenn der User auf "Erstellen" (@issue9/Schritt 2) klickt
	 * 
	 * @Beschreibung Erzeugt eine neue Gruppe in der Datenbank Leitet den User
	 *               zur Gruppen-Ansicht (Schritt 3) der neuen Gruppe
	 * 
	 * @return null - Soll in der selben View bleiben
	 */
	public String onCreateNewGroupClick() {
		return null;
	}

	/**
	 * Wird ausgeführt wenn der User auf "Neue Ressource" (@issue9/Schritt 3)
	 * klickt
	 * 
	 * @Beschreibung Leitet den User zum Dialog "Ressource hinzufügen"
	 * 
	 * @return null - Soll in der selben View bleiben
	 */
	public String onCreateNewRessourceClick() {
		return null;
	}

	/**
	 * Wird ausgeführt wenn der User auf "Mitglieder" (@issue9/Schritt 3.1)
	 * klickt
	 * 
	 * @Beschreibung Listet alle Mitglieder
	 * 
	 * @return null - Soll in der selben View bleiben
	 */
	public String onShowMembersClick() {
		return null;
	}

	/**
	 * Wird ausgeführt wenn der User auf "Mitglieder hinzufügen"
	 * (@issue9/Schritt 3.1) klickt
	 * 
	 * @Beschreibung Zeigt den Hinzufügen-Dialog (Schritt 3.2)
	 * 
	 * @return null - Soll in der selben View bleiben
	 */
	public String onAddMembersClick() {
		return null;
	}

	/**
	 * Wird ausgeführt wenn der User auf "Einladen" (@issue9/Schritt 3.2) klickt
	 * 
	 * @Beschreibung Versendet entsprechende Einladungen an User
	 * 
	 * @return null - Soll in der selben View bleiben
	 */
	public String onInviteMembersClick() {
		return null;
	}
}