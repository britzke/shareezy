/** 
 * 
 */
package org.shareezy.beans;

import javax.faces.bean.ManagedBean;

/**
 * Die Klasse AccountBearbeitenBean stellt Methoden zur Verfügung, die dafür
 * genutzt werden das der Nutzer seinen Account bearbeiten kann.
 * 
 * @author Maurice Engelskirchen
 * @version 1.0 11.12.2013
 * 
 */
@ManagedBean
public class AccountBearbeitenBean {
	/**
	 * Prüft die Eingabe des nutzer. Abhängig davon gibt er eine fehlermeldung
	 * aus, prüftt die eingabe mit den in der Datenbank gespeicherten referens
	 * Daten oder ruft direkt die Methode DatensatzÄndern() auf.
	 * 
	 * @return null da kein Seitenwechsel stattfindet.
	 */

	public String eingabePrüfen() {
		return null;
	}

	/**
	 * Die Metode Datensatz ändern überschreibt den zur "User_Id" Gehörenden
	 * Datensatz mit dem von Benutzer eingegebenen Daten.
	 * 
	 * @return null da kein Seitenwechsel stattfindet.
	 */
	public String datensatzÄndern() {
		return null;
	}

}