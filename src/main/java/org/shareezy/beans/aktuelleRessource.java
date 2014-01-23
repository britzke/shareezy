/**
 * 
 */
package org.shareezy.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import org.shareezy.annotations.AktuelleRessource;
import org.shareezy.entities.Ressource;

/**
 * @author e1_treibmann
 * Diese Klasse beinhaltet die aktuelle Ressource, welche gerade in Benutzung ist.
 * 
 *
 */
@Named
@SessionScoped
public class aktuelleRessource implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Produces
	@AktuelleRessource
	private Ressource ressource;

	public Ressource getRessource() {
		return ressource;
	}

	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}

}
