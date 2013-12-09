package org.shareezy.beans;

import javax.faces.bean.ManagedBean;

/**
 * 
 * @author Maxim Slipachuk
 * @Description Eigene Gruppenzugehörigkeit beantragen/entfernen.
 * @version Dez 9, 2013 
 */
@ManagedBean
public class GroupMembership {	
	
	public GroupMembership(){			
	}
	/** Die Methode sendAnfrage erstellt eine Anfrage fuer eine Gruppe
	 * @Description
	 *  - wird bei Klick auf 'Hinzufuegen' aufgerufen
	 *  	 
	 *  @return gibt nichts zurueck damit sich die View nicht Veraendert
	 */
	public String sendAnfrage( ){				
		return null;
	}
	/** 
	 * Mit Methode knopfGruppeVerlassen- wird der User aus eine Gruppe entfernt
	 * @Description
	 *  - wird bei Klick auf 'Gruppe Verlassen' aufgerufen
	 *  	 
	 *  @return gibt nichts zurueck damit sich die View nicht Veraendert
	 */
	public String knopfGruppeVerlassen(){		
		return null;
	}
	
}
