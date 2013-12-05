package org.shareezy.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * 
 */

/**
 * @author e1_klawitter Die Annotation ManagedBean sorgt dafür, dass diese
 *         classe als MBean erkannt wird SessionScoped sorgt dafür das die Bean
 *         nur bis zum ende der Session lebt
 */
@ManagedBean
@SessionScoped
public class neueRessourceBean {

	/**
	 * neueRessource() ist die Actionmethode die eine BlankoRessource listet in
	 * die mit Eigenschaften zu füllen ist
	 * 
	 * @return null - d. h. der View wird nicht gewechselt.
	 */
	public String neueRessource() {
		return null;
	}

	/**
	 * Action-Routine für den View <code>neueResource</code>. Wird angesprochen,
	 * wenn der Benutzer die Schaltfläche <code>löschen</code> anwählt. Sorgt
	 * dafür, dass Resourcen aus der Ressourcenliste gelöscht werden können.
	 * 
	 * @return null - d. h. der View wird nicht gewechselt.
	 */
	public String loescheRessource() {
		return null;
	}

	/**
	 * speichern() ist dafür da die nun eingetragenen Eigenschaften der neu
	 * angelegten Ressource zu speichern.
	 * 
	 * @return null - d. h. der View wird nicht gewechselt.
	 */
	public String speichern() {
		return null;
	}
}
