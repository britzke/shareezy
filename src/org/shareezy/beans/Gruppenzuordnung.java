/**
 *Es wird geprüft welche Mitglieder Ressourcen inerhalb der Gruppe verwalten können.mitglieder?
 *Wenn jemand aus der Gruppe entfernt wird/geht
 *Welche Ressource zur Gruppe hinzugefügt wird
 *Nachträgliches bearbeiten der ressourcen zu gruppe/ID
 *Ressource der gruppe hinzufügen
 **/
package org.shareezy.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Gruppenzuordnung {
	
	public String gruppe;
	public String mitglied;
	
	/**
	 * Mitglied aus der Gruppe entfernen/gruppenID
	 * @return
	 */
	public String  gruppentfernen(){
		return null;
		}
	
	/**
	 * welches Mitglied ist berechtigt zum abfragen/erstellen/verwalten von Ressourcen
	 * @return
	 */
	public String mitgliederabfragen(){
		return null;
	}
	
	/**	
	 * ressource zur gruppe hinzufügen
	 * @return
	 */
	public String ressourcenid(){
		return null;
	}
	
	/**
	 * bearbeiten der ressource
	 * @return
	 */
    public String ressourceedit(){
    	return null;
    }
    
}
	


