/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	Tim Treibmann
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
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import org.shareezy.annotations.AktuelleRessource;
import org.shareezy.entities.Ressource;

/**
 * Die AktuelleRessourceBean dient dafür, die vom Benutzer, aus der
 * Ressourcenliste, ausgewählte Ressource zwischenzuspeichern und eine Session
 * lang verfügbar zu machen. Somit wird verhindert, dass diese betimmte
 * Ressource innerhalb einer Session verloren geht. Somit können mehrere Beans
 * auf die vom Benutzer ausgewählte Ressource zugreifen.
 * 
 * @author treibmann
 * @param ressource 	Speichert die aktuelle Ressource.
 * 
 */
@Named
@SessionScoped
public class AktuelleRessourceBean implements Serializable {

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
