/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2014  	burghard.britzke (bubi@charmides.in-berlin.de)
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

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Speichert den Status des aktuellen Benutzer und stellt ihn den einzelnen
 * Komponenten der Applikation bei Bedarf zur Verfügung.
 * 
 * @author burghard.britzke mailto:bubi@charmides.in-berlin.de
 */
@Named
@SessionScoped
public class BenutzerStatus implements Serializable {
	private static final long serialVersionUID = 1L;
	private boolean authenticated;

	/**
	 * Antwortet mit dem Wert des authenticated
	 * 
	 * @return the authenticated
	 */
	public boolean isAuthenticated() {
		return authenticated;
	}

	/**
	 * @param authenticated
	 *            the authenticated to set
	 */
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

}
