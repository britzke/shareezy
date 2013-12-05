package org.shareezy.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="MemberManager")
public class GroupMemberManagerBean {
	
	public GroupMemberManagerBean(){
		
	}
	
	/** Die Methode AddUser dient dazu dem Benutzer eine Gruppe zuzuweisen
	 * 
	 *  - wird bei Klick auf 'Hinzufügen' und 'Annehmen' aufgerufen
	 *  - erstellt die Zuweisung in der AccountsGruppen Entität
	 */
	public void addUser(){ 
		
		}
	
	/** Die Methode deleteUser dient dazu die Gruppenzuweisung eines Benutzers zu entfernen
	 * 
	 *  - wird bei Klick auf 'Entfernen' aufgerufen
	 *  - löscht die Zuweisung in der AccountsGruppen Entität
	 */
	public void deleteUser(){ 
		}
	
	/** Die Methode deleteRequest dient dazu eine Anfrage in der Gruppendetailansicht zu entfernen
	 * 
	 *  - wird bei Klick auf Ablehnen aufgerufen
	 */
	public void deleteRequest(){ 
	}
}
