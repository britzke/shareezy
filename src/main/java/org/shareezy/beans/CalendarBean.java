package org.shareezy.beans;
import java.util.Calendar;

/**
 * Klasse ist zustaendig fuer die Kalender der Ressourcen.
 * Das aktuelle Datum und die Buchungen der Ressouren werden im Kalender angegeben.
 * 
 * @author Vanessa Krohn
 * @date 05/12/13
 */

public class CalendarBean {

	/**
	 * liest die neuen, vom User geänderten Daten aus der Datenbank aus und lässt sie im Kalender erscheinen
	 * wird aufgerufen sobald ein User eine Ressource erfolgreich gebucht hat
	 */
	public void scheduleController(){
	}
	
	/**
	 * markiert das aktuelle Datum im Kalender
	 * wird aufgerufen, wenn der, auf der Detailressourcenansicht befindliche Kalender geladen wird
	 */
	public Calendar today(){
		return null;
	}
}
