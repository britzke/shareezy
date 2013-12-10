package org.shareezy.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Guppenverwaltung, Gruppen hinzufügen & Gruppen editieren
 * 
 * @author Steven Müller
 * @version 1.0
 */
@ManagedBean(name = "groupManager")
@SessionScoped
public class GroupManagerBean {

	/**
	 * Wird ausgeführt wenn der User auf "Neue Gruppe" (@issue9/Schritt 1)
	 * klickt
	 * <p>
	 * Öffnet einen Dialog (@issue9/Schritt 2) und der user wird aufgefordert
	 * eine Gruppen-ID einzugeben
	 * 
	 * @return null - Soll in der selben View bleiben
	 */
	public String onNewGroupClick() {
		return null;
	}

	/**
	 * Wird ausgeführt wenn der User auf "Erstellen" (@issue9/Schritt 2) klickt
	 * <p>
	 * Erzeugt eine neue Gruppe in der Datenbank Leitet den User zur
	 * Gruppen-Ansicht (@issue9/Schritt 3) der neuen Gruppe
	 * 
	 * @return null - Soll in der selben View bleiben
	 */
	public String onCreateNewGroupClick() {
		return null;
	}

	/**
	 * Wird ausgeführt wenn der User auf "Neue Ressource" (@issue9/Schritt 3)
	 * klickt
	 * <p>
	 * Leitet den User zum Dialog "Ressource hinzufügen"
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
	 * Wird ausgeführt wenn der User auf "Einladen" (@issue9/Schritt 3.2) klickt
	 * <p>
	 * Versendet entsprechende Einladungen an User
	 * 
	 * @return null - Soll in der selben View bleiben
	 */
	public String onInviteMembersClick() {
		return null;
	}
}