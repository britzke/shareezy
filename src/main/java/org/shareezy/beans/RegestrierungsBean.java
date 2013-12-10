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
	 */
	public void datensatzPrüfen() {

	}

	/**
	 * Fügt der Entität "Benutzer" der Datenbank einen neuen datensatz mit den
	 * vom Benutzer eingegebenen Daten hinzu.
	 */
	public void datensatzEinfügen() {

	}

	/**
	 * Schickt bei Erfolgreicher Regestrierung eine bestätigungs e-mail an den
	 * Benutzer.
	 */
	public void validierungsEmail() {

	}

}
