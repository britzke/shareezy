/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	Maxim Slipachuk
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.shareezy.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 * Eigene Gruppenzugehörigkeit beantragen/entfernen
 * 
 * @author Maxim Slipachuk
 */
@ManagedBean
public class GroupMembership implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * Wird bei Klick auf 'Hinzufuegen' aufgerufen.
	 * 
	 * @return gibt nichts zurück damit sich die View nicht Verändert
	 */
	public String sendAnfrage() {
		return null;
	}

	/**
	 * Wird bei Klick auf 'Gruppe Verlassen' aufgerufen
	 * 
	 * @return gibt nichts zurück damit sich die View nicht Veraendert
	 */
	public String knopfGruppeVerlassen() {
		return null;
	}
	
	public String anfrageAbgesendet() {  
        return "Anfrage an Verwalter gesendet!";  
    } 
      

	public String leaveTheGroupp() {  
		return"Sie sind aus dies Community ausgetreten!";  
    }  
	/*Pop-Up Windows mit Bestätigung Button. */
    public void destroyWorld(ActionEvent actionEvent){  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "System Error",  "Please try again later.");  
          
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
}
