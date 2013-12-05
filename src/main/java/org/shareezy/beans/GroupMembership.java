package org.shareezy.beans;

import javax.faces.bean.ManagedBean;

/**
 * @author e1_slipachuk
 * 
 * GroupMembership ist eine Klasse/Funktion für 
 * "eigene Gruppenzugehörigkeit beantragen/entfernen".
 *  
 *
 */
@ManagedBean
public class GroupMembership {	
	/*userName - Username bzw. User-ID(in unser Fall als String)
	 newGroupp - Neue Gruppe  
	 myGroupp -  user existiert schon in diese Gruppe.*/
	public GroupMembership(){			
	}
	/*Der user erstellt eine Anfrage für eine Gruppe*/
	public String sendAnfrage( ){				
		return null;
	}
	
	/*Der user will eine Gruppe verlassen*/
	public String knopfGruppeVerlassen(){		
		return null;
	}
	
}
