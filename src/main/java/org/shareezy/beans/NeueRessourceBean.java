package org.shareezy.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * 
 */

/**
 *  Die Annotation ManagedBean sorgt dafür, dass diese
 *  Klasse als ManagedBean erkannt wird.
 *  SessionScoped sorgt dafür das diese ManagedBean
 *  nur bis zum Ende der Session lebt.
 *  
 *  @author ThomasKlawitter
 *  @version 12.12.2013
 */
@ManagedBean
@SessionScoped
public class NeueRessourceBean {

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
	public String loescheRessource() {
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
