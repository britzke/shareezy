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
	 * @param passwortWiederholen
	 *            Der Inhalt des textfeldes passwort wiederholen.
	 * @return null da kein Seitenwechsel stattfindet.
	 */
	public String datensatzPrüfen() {
		return null;

	}

	/**
	 * Fügt der Entität "Benutzer" der Datenbank einen neuen datensatz mit den
	 * vom Benutzer eingegebenen Daten hinzu. Danach wird die Methode
	 * dalidierungsEmail() aufgerufen.
	 * 
	 * @return null da kein Seitenwechsel stattfindet.
	 */
	public String datensatzEinfügen() {
		return null;

	}

	/**
	 * Schickt bei Erfolgreicher Regestrierung eine bestätigungs e-mail an den
	 * Benutzer.
	 * 
	 * @return null da kein Seitenwechsel stattfindet.
	 */
	public String validierungsEmail() {
		return null;

	}

}
