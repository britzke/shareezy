package org.shareezy.beans;

import javax.faces.bean.ManagedBean;

/**
 * Die Klasse RegestrieurungsBean stellt Methoden zur Verfügung die dazu genutzt
 * werden damit sich der Nutzer anmelden kann.
 * 
 * @author Maurice Engelskirchen
 * @version 1.0 11.12.2013
 * 
 */
@ManagedBean
public class RegestrierungsBean {

	/**
	 * Prüft ob die Spezifischen Daten(username, e-mail) schon in einem
	 * Datansatz vorhanden sind. Sind die Spezifischen Daten noch nicht
	 * vorhanden, wird die Methode datensatzEinfügen() aufgerufen.
	 * 
	 * @param name
	 *            Der Inhalt des textfeldes Nachname.
	 * @param vorname
	 *            Der Inhalt des textfeldes Vorname.
	 * @param username
	 *            Der Inhalt des textfeldes username.
	 * @param eMail
	 *            Der Inhalt des textfeldes e-Mail.
	 * @param passwort
	 *            Der Inhalt des textfeldes passwort.
	 * @param passwortWiederholen
	 *            Der Inhalt des textfeldes passwort wiederholen.
	 */
	public void datensatzPrüfen(String name, String vorname, String username,
			String eMail, String passwort, String passwortWiederholen) {

	}

	/**
	 * Fügt der Entität "Benutzer" der Datenbank einen neuen datensatz mit den
	 * vom Benutzer eingegebenen Daten hinzu. Danach wird die Methode
	 * dalidierungsEmail() aufgerufen.
	 * 
	 * @param name
	 *            Der Inhalt des textfeldes Nachname, den die Methode von
	 *            dantensatzPrüfen() übergeben bekommt.
	 * @param vorname
	 *            Der Inhalt des textfeldes Vornameden, die Methode von
	 *            dantensatzPrüfen() übergeben bekommt.
	 * @param username
	 *            Der Inhalt des textfeldes username, den die Methode von
	 *            dantensatzPrüfen() übergeben bekommt.
	 * @param eMail
	 *            Der Inhalt des textfeldes e-Mail, den die Methode von
	 *            dantensatzPrüfen() übergeben bekommt.
	 * @param passwort
	 *            Der Inhalt des textfeldes passwort, den die Methode von
	 *            dantensatzPrüen() übergeben bekommt.
	 * @param passwortWiederholen
	 *            Der Inhalt des textfeldes passwort wiederholen, den die Methode
	 *            von dantensatzPrüfen() übergeben bekommt.
	 */
	public void datensatzEinfügen(String name, String vorname, String username,
			String eMail, String passwort, String passwortWiederholen) {

	}

	/**
	 * Schickt bei Erfolgreicher Regestrierung eine bestätigungs e-mail an den
	 * Benutzer.
	 * 
	 * @param eMail
	 *            die e-mail Addresse des Benutzers, den den die Methode von
	 *            dantensatzEinfügen() übergeben bekommt.
	 */
	public void validierungsEmail(String eMail) {

	}

}
