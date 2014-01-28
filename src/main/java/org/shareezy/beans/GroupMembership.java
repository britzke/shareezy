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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.primefaces.event.DashboardReorderEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;
import org.shareezy.entities.Benutzer;


/**
 * Eigene Gruppenzugehörigkeit beantragen/entfernen
 * 
 * @author Maxim Slipachuk
 */
@ManagedBean
public class GroupMembership implements Serializable{
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;	
	private Benutzer benutzer;
	private boolean bestätigt;
	private boolean administrator;
	private DashboardModel model;  
	
	public GroupMembership(){		
		/**
		 * GruppenListe mit Button "Der Community beitreten" 
		 * und "Die Community verlassen"
		 * */
		model = new DefaultDashboardModel();  
        DashboardColumn column1 = new DefaultDashboardColumn();  
        DashboardColumn column2 = new DefaultDashboardColumn();  
        DashboardColumn column3 = new DefaultDashboardColumn();  
          
        column1.addWidget("sports");  
        column1.addWidget("finance");  
          
        column2.addWidget("lifestyle");  
        column2.addWidget("weather");  
          
        column3.addWidget("politics");  
  
        model.addColumn(column1);  
        model.addColumn(column2);  
        model.addColumn(column3); 
	}
	 public void handleReorder(DashboardReorderEvent event) {  
	        FacesMessage message = new FacesMessage();  
	        message.setSeverity(FacesMessage.SEVERITY_INFO);  
	        message.setSummary("Reordered: " + event.getWidgetId());  
	        message.setDetail("Item index: " + event.getItemIndex() + ", Column index: " + event.getColumnIndex() + ", Sender index: " + event.getSenderColumnIndex());  
	          
	        addMessage(message);  
	    }        
	      
	    private void addMessage(FacesMessage message) {  
	        FacesContext.getCurrentInstance().addMessage(null, message);  
	    }  
	      
	    public DashboardModel getModel() {  
	        return model;  
	    }  
	    
	
	public String GroupMembership(){

		entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		return "";
	}

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
