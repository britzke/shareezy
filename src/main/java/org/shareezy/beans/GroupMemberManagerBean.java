package org.shareezy.beans;

import javax.faces.bean.ManagedBean;

/** Beschreibung von GroupMemberManagerBean 
*
* @author Timo Kuchling
* @Beschreibung
*  - Ermöglicht das Hinzufügen/Entfernen von Benutzern in Gruppen
*  - Entfernt abgelehnte Aufnahmeanfragen
* @version Dez 5, 2013 - 09:30Uhr
*/
@ManagedBean(name="MemberManager")
public class GroupMemberManagerBean {
	
	/** Die Methode AddUser dient dazu dem Benutzer eine Gruppe zuzuweisen
	 * @Beschreibung
	 *  - wird bei Klick auf 'Hinzufügen' und 'Annehmen' aufgerufen <br>
	 *  - falls addUser durch einen Klick auf 'Annehmen' aufgerufen wurde muss deleteRequest
	 *    nach dem Hinzufügen aufgerufen werden <br>
	 *  
	 *  - erstellt die Zuweisung in der AccountsGruppen Entität
	 *  @return gibt nichts zurück damit sich die View nicht ändert
	 */
	public String addUser(){
		return null; 
		}
	
	/** Die Methode deleteUser dient dazu die Gruppenzuweisung eines Benutzers zu entfernen
	 * @Beschreibung
	 *  - wird bei Klick auf 'Entfernen' aufgerufen<br>
	 *  - löscht die Zuweisung in der AccountsGruppen Entität
	 *  @return gibt nichts zurück damit sich die View nicht ändert
	 */
	public String deleteUser(){
		return null; 
		}
	
	/** Die Methode deleteRequest dient dazu eine Anfrage in der Gruppendetailansicht zu entfernen
	 * @Beschreibung
	 *  - wird bei Klick auf Ablehnen aufgerufen<br>
	 *  - 
	 *  @return gibt nichts zurück damit sich die View nicht ändert
	 */
	public String deleteRequest(){
		return null; 
	}
	
}
