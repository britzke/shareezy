package org.shareezy.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.shareezy.entities.Ressource;

/**
 * 
 */

/**
 *  Die Annotation ManagedBean sorgt dafür, dass diese
 *  Klasse als ManagedBean erkannt wird.
 *  SessionScoped sorgt dafür das diese ManagedBean
 *  nur bis zum Ende der Session lebt.
 *  
 *  @author ThomasKLawitter
 *  @version 12.12.2013
 */
@ManagedBean
@SessionScoped
public class NeueRessourceBean {
	
	private EntityManagerFactory emf;
	
	public NeueRessourceBean(){
		
	}

	/**
	 * Action-Routine für den View <code>neueRessource</code>.Wird angesprochen,
	 * wenn der Benutzer die Schaltfläche <code>neueRessoure</code> anwählt.
	 * Sorgt dafür das eine neue Ressource erzeugt wird,
	 * deren Werte der Benutzer festlegen kann.
	 * 
	 * @return null - d. h. der View wird nicht gewechselt.
	 */
	public String neueRessource() {
		return null;
	}

	/**
	 * Action-Routine für den View <code>neueRessource</code>. Wird angesprochen,
	 * wenn der Benutzer die Schaltfläche <code>löschen</code> anwählt. Sorgt
	 * dafür, dass Ressourcen aus der Ressourcenliste gelöscht werden können.
	 * 
	 * @return null - d. h. der View wird nicht gewechselt.
	 */
	public String loescheRessource(Ressource ressource) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction ent = em.getTransaction();
		ent.begin();
		ressource=em.merge(ressource);
		em.remove(ressource);
		ent.commit();
		em.close();
		return null;
	}

	/**
	 * Action-Routine für den View <code>neueRessource</code>. Wird angesprochen,
	 * wenn der Benutzer die Schaltfläche <code>speichern</code> anwählt. Sorgt
	 * dafür, dass die neu eingesetzten Werte für diese Ressource in der Datenbank gespeichert wird.
	 * 
	 * @return null - d. h. der View wird nicht gewechselt.
	 */
	public String speichern() {
		return null;
	}
}
