package org.shareezy.beans;

import java.awt.Image;

/**
 * Klasse ist zustaendig fuer die detailierte Ansicht der Ressourcen. Ansicht
 * besteht aus Bild, Beschreibung, Kalender und dem Buchungsbutton
 * 
 * @author Vanessa Krohn
 * @date 05/12/13
 */

public class RessourcenDetailBean {

	private Image pic;
	private String summary;

	/**
	 * Um den TimePicker zu oeffnen wird beim Klick auf den Buchungsbutton
	 * (Detailressourcenansicht) ausgefuehrt
	 */
	public String timePicker() {
		return null;
	}

	/**
	 * zeigt ein Bild der Ressource an
	 * 
	 */
	public Image resourcePic() {
		return pic;
	}

	/**
	 * zustaendig fuer die Beschreibung der Ressource
	 * 
	 */
	public String resourceSummary() {
		return summary;
	}
}
