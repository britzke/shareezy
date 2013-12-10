package org.shareezy.beans;

import javax.faces.bean.ManagedBean;

/**
 * Eigene Gruppenzugehörigkeit beantragen/entfernen
 * 
 * @author Maxim Slipachuk
 * @version Dez 9, 2013
 */
@ManagedBean
public class GroupMembership {

	/**
	 * Default constructor
	 * */

	public GroupMembership() {
	}

	/**
	 * Wird bei Klick auf 'Hinzufuegen' aufgerufen
	 * 
	 * @param sendAnfrage
	 *            () erstellt eine Anfrage für eine Gruppe
	 * 
	 * @return gibt nichts zurück damit sich die View nicht Verändert
	 */
	public String sendAnfrage() {
		return null;
	}

	/**
	 * Wird bei Klick auf 'Gruppe Verlassen' aufgerufen
	 * 
	 * @param knopfGruppeVerlassen
	 *            () Der User wird aus eine Gruppe entfernt
	 * 
	 * @return gibt nichts zurück damit sich die View nicht Veraendert
	 */
	public String knopfGruppeVerlassen() {
		return null;
	}

}
