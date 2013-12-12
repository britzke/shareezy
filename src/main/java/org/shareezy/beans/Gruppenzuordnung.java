/**
 *Es wird geprüft welche Mitglieder Ressourcen inerhalb der Gruppe verwalten können.
 *Abfrage des Status der Ressource
 *Wenn jemand aus der Gruppe entfernt wird/geht.
 *Welche Ressource zur Gruppe hinzugefügt wird.
 *Nachträgliches bearbeiten der ressourcen zu gruppe/ID.
 *Ressource der gruppe hinzufügen.

 *@author e1_hermann
 *@version update 10.12.2013
 **/
package org.shareezy.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Id;

@ManagedBean
@SessionScoped
public class Gruppenzuordnung {

	public String gruppenersteller;
	public String leitunguebertragen;
	public String mitglied;
	@Id
	private String account_id;
	@Id
	private int accounts_id;

	/**
	 * Welches Mitglied ist berechtigt zum abfragen/erstellen/verwalten von
	 * Ressourcen
	 * 
	 * @return accountID
	 */
	public String mitgliederabfragen() {
		return account_id;
	}

	/**
	 * Abfrage des status der ressource
	 * 
	 * @return
	 */
	public int ressourcestatus() {

		return accounts_id;

	}

	/**
	 * Mitglied aus der Gruppe entfernen/gruppenID
	 * 
	 * @return
	 */
	public String mitgliedentfernen() {
		return null;
	}

	/**
	 * Ressource zur gruppe hinzufügen. Erstmal aus der View abfragen, dann
	 * Datenbankabfrage
	 * 
	 * @return
	 */
	public String addressourcen(int ressourcenid) {
		return null;
	}

	/**
	 * bearbeiten der ressource
	 * 
	 * @return
	 */
	public String editressource() {
		return null;
	}

}
