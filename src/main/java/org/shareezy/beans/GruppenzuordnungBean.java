/**
*
*/
package org.shareezy.beans;


import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.shareezy.beans.GruppenzuordnungBean;
import org.shareezy.entities.Gruppe;

/**
* @author e1_hermann
*
*/
@ManagedBean
@SessionScoped
public class GruppenzuordnungBean {
	
	/*
	public class DriverManager{
		
		public ResultSet resultset;
		Connection con=null;
		
		
		public void getConnection(){
			
			Statement stmt = con.createStatement();
			con = DriverManager.getConnection( "jdbc:derby://localhost:1527/sample", 
			        "test");
			
		}
	}
	*/

	
	public String account_id;
	public String accounts_id;
    public EntityManagerFactory emf;

	/**
	 * @throws java.lang.Exception
	 */
	
	/**
	 * Welches Mitglied ist berechtigt zum abfragen/erstellen/verwalten von Ressourcen
	 * @return 
	 */
	
	public String mitgliederabfragen() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Gruppe gruppe = new Gruppe();
        em.persist(gruppe);
		return account_id;
	
	}

        /**
         * Abfrage des Status der Ressource
         */
       
        public String ressourcestatus() {
        	return accounts_id;
                
        }

        /**
         * Welches Mitglied ist berechtigt zum abfragen/erstellen/verwalten von Ressourcen
         */
        public void mitgliedentfernen() {
        }

        /**
         * Ressource zur gruppe hinzufügen. Erstmal aus der View abfragen, dann Datenbankabfrage
         */
        public void addressourcen(int ressourcenid) {
        	return;
               
        }

        /**
         * Bearbeiten der Ressource
         */
        public void editressource() {
        	return;
               
        }

}

