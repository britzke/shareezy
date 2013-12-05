package org.shareezy.beans;

import javax.faces.bean.ManagedBean;

/**
 * In dieser Bean findet die Überprüfung der Anmeldungsdaten des Benutzers statt.
 * Der Benutzer muss seinen Benutzernamen und sein Passwort in die entsprechenden 
 * Eingabefelder der View eintragen. Diese werden in die jeweiligen Eigenschaften 
 * der Bean geschrieben.
 * @author wegner
 * @version 1.0
 */
@ManagedBean
public class LoginBean {

	/**
	 * In dieser Methode werden die Eingaben des Benutzers, mit den entsprechenden Daten 
	 * der Datenbank verglichen. Stimmen Benutzername und Passwort jeweils überein, 
	 * ist die Anmeldung erfolgreich.
	 * @return
	 */	
	public String login(){
		return null;}
}
