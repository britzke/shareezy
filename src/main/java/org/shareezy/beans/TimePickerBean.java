package org.shareezy.beans;
import java.util.Date;

/**
 * Klasse ist zustaendig fuer den TimePicker und die vom User eingestellten Daten (Datum + Uhrzeit)
 * 
 * @author Vanessa Krohn
 * @date 05/12/13
 */

public class TimePickerBean {

	private Date timeframe;
	
	/**
	 * wird durch Verwendung des TimePickers ausgefuehrt
	 * um den vom User ausgewaehlten Zeitraum im Textfeld auszugeben
	 */
	
	public Date getTimeframe(){
		return timeframe;
	}


    /**
	 * um Doppelbuchungen zu verhindern
	 * 
	 * sucht Datensatz "ressourcen_id" in der Entitaet "Buchungen" und vergleicht die 
	 * neuen Werte (Datum + Uhrzeit) mit den Werten aus der Datenbank
	 * Fehlermeldung wenn Ressource in dem gewuenschtem Zeitraum bereits vergeben 
	 * ist + alternativen Terminvorschlag
	 * Ist die Reservierung erfolgreich, wird in der Entitaet "Buchungen" ein neuer Datensatz
	 * (Datum + Uhrzeit) angelegt und die ressourcen_id und die user_id werden aktualisiert
	 * 
	 * wird beim Klick auf den Bestaetigungsbutton aufgerufen
	 */
	
    public void checkDate(){
    } 
}
