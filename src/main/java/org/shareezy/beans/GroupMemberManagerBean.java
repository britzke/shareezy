package org.shareezy.beans;

@ManagedBean(name="MemberManager")
public class GroupMemberManagerBean {
	
	private GroupMemberManagerBean{
		
	}
	
	public void addUser(){ //-> Wird bei Klick auf Hinzufügen und Annehmen aufgerufen
		// Schreibt einen neuen Benutzerdatensatz in die Gruppentabelle
		}
	public void deleteUser(){ //-> Wird bei Klick auf Entfernen aufgerufen
		// Entfernt einen Benutzerdatensatz aus der Gruppentabelle
		}
	public void deleteRequest(){ //-> Wird bei Klick auf Ablehnen aufgerufen
		// Entfernt die Anfrage eines Benutzers im Reiter Anfragen in der Gruppendetailansicht

		}

}
