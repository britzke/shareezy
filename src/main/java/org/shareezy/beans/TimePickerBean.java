package org.shareezy.beans;
import java.util.Date;

/**
 * Klasse ist zustaendig fuer den TimePicker und die vom User eingestellten Daten (Datum + Uhrzeit)
 * 
 * @author Vanessa Krohn
 * @date 05/12/13
 */

public class TimePickerBean {

	/**
	 * wird durch Verwendung des TimePickers ausgeführt
	 * um den vom User ausgewählten Zeitraum im Textfeld auszugeben
	 */
	
	private Date timeframe;
	
	public Date getTimeframe(){
		return timeframe;
	}


    /**
	 * um Doppelbuchungen zu verhindern
	 * 
	 * sucht Datensatz "ressourcen_id" in der Entität "Buchungen" und vergleicht die 
	 * neuen Werte (Datum + Uhrzeit) mit den Werten aus der Datenbank
	 * Fehlermeldung wenn Ressource in dem gewünschtem Zeitraum bereits vergeben 
	 * ist + alternativen Terminvorschlag
	 * Ist die Reservierung erfolgreich, wird in der Entität "Buchungen" ein neuer Datensatz
	 * (Datum + Uhrzeit) angelegt und die ressourcen_id und die user_id werden aktualisiert
	 * 
	 * wird beim Klick auf den Bestätigungsbutton aufgerufen
	 */
	
    public void checkDate(){
    } 




}
