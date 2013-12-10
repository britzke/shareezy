package org.shareezy.beans;

import javax.faces.bean.ManagedBean;

/** Beschreibung von GroupMemberManagerBean 
*
* @author Timo Kuchling
* <ol><li>
*  Ermöglicht das Hinzufügen/Entfernen von Benutzern in Gruppen<br>
*  </li><li>
*  Entfernt abgelehnte Aufnahmeanfragen
*  </li></ol>
* @version Dez 10, 2013 - 09:30Uhr
*/
@ManagedBean(name="MemberManager")
public class GroupMemberManagerBean {
	
	/** Die Methode AddUser dient dazu dem Benutzer eine Gruppe zuzuweisen
	 * <ol><li>
	 *  wird bei Klick auf 'Hinzufügen' und 'Annehmen' aufgerufen <br>
	 *  </li><li>
	 *  falls addUser durch einen Klick auf 'Annehmen' aufgerufen wurde muss deleteRequest
	 *    nach dem Hinzufügen aufgerufen werden <br>
	 *  </li><li>
	 *  erstellt die Zuweisung in der AccountsGruppen Entität
	 *  </li></ol>
	 *  @return gibt nichts zurück damit sich die View nicht ändert
	 */
	public String addUser(){
		return null; 
		}
	
	/** Die Methode deleteUser dient dazu die Gruppenzuweisung eines Benutzers zu entfernen
	 * <ol><li>
	 *  wird bei Klick auf 'Entfernen' aufgerufen<br>
	 *  </li><li>
	 *  löscht die Zuweisung in der AccountsGruppen Entität
	 *  </li></ol>
	 *  @return gibt nichts zurück damit sich die View nicht ändert
	 */
	public String deleteUser(){
		return null; 
		}
	
	/** Die Methode deleteRequest dient dazu eine Anfrage in der Gruppendetailansicht zu entfernen
	 * <ol><li>
	 *  wird bei Klick auf Ablehnen aufgerufen<br>
	 *  </li></ol>
	 *  @return gibt nichts zurück damit sich die View nicht ändert
	 */
	public String deleteRequest(){
		return null; 
	}
	
}
