/**
 * 
 */
package org.shareezy.beans;

import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

/**
 * Der FacesContextProvider dient dazu, den FacesContext für eine Bean zur
 * Verfügung zu stellen, ohne dass diese statische Methoden benutzen muss. Die
 * Benutzung führt zu Schwierigkeiten beim Testen mit dem Mockito-Famework.
 * 
 * @author britzke
 * 
 */
public class FacesContextProvider {

	/**
	 * Antwortet mit dem FacesContext.
	 * 
	 * @return Der FacesContext
	 */
	@Produces
	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
}
