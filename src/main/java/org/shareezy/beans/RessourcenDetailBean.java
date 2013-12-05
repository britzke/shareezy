package org.shareezy.beans;
import java.awt.Image;

/**
 * Klasse ist zuständig für die detailierte Ansicht der Ressourcen.
 * Ansicht besteht aus Bild, Beschreibung, Kalender und dem Buchungsbutton
 * 
 * @author Vanessa Krohn
 * @date 05/12/13
 */

public class RessourcenDetailBean {

	/**
	 * Um den TimePicker zu öffnen
	 * wird beim Klick auf den Buchungsbutton (Detailressourcenansicht) ausgeführt
	 */
	public void timePicker(){
	}
	
	/**
	 * zeigt ein Bild der Ressource an
	 * 
	 */
	public Image resourcePic(){
		return null;
	}
	
	/**
	 * zuständig für die Beschreibung der Ressource 
	 * 
	 */
	public String resourceSummary(){
		return null;
	}
}
