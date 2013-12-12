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
	 * @param neuesPasswort
	 *            Der Inhalt des Textfeldes neues Passwort.
	 * @param neuesPasswortWiederholen
	 *            Der Inhalt des Textfeldes neues Passwort Wiederholen.
	 * @param altesPasswort
	 *            Der Inhalt des Textfeldes altes Passwort.
	 * @param eMail
	 *            Der Inhalt des Textfeldes eMail.
	 * 
	 */

	public void eingabePrüfen(String neuesPasswort,
			String neuesPasswortWiederholen, String altesPasswort, String eMail) {

	}

	/**
	 * Die Metode Datensatz ändern überschreibt den zur "User_Id" Gehörenden
	 * Datensatz mit dem von Benutzer eingegebenen Daten.
	 * 
	 * @param eMail
	 *            Der Inhnhalt des Textfeldes e-mail, der beim aufruf von der
	 *            Methode eingabePrüfen übergeben wird.
	 * @param neuesPassword
	 *            Der Inhnhalt des Textfeldes neues Passwort, der beim aufruf
	 *            von der Methode eingabePrüfen übergeben wird.
	 */
	public void datensatzÄndern(String eMail, String neuesPassword) {

	}

}