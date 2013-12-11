/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  burghard.britzke
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
package org.shareezy.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * Klasse für Persistenzobjekte der Datenbank-Tabelle TYPEN.
 * @author burghard.britzke (bubi@charmides.in-berlin.de)
 */
@Entity
@Table(name = "TYPEN")
public class Typ implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to Ressourcen
	@OneToMany(mappedBy="typ")
	private List<Ressource> ressourcen;

	/**
	 * Antowrtet mit der Id des Typs.
	 * @return Die Id des Typs
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Setzt die ID des Typs.
	 * @param id Die ID des Typs
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Antowrtet mit dem Namen des Typs.
	 * @return Der Name des Typs
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Setzt den Namen des Typs.
	 * @param name Der Name, der für den Typ gesetzt werden soll.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Antwortet mit der Liste der Ressourcen.
	 * @return Liste der Ressourcen
	 */
	public List<Ressource> getRessourcen() {
		return this.ressourcen;
	}
	
	/**
	 * Setzt die Liste der Ressourcen.
	 * @param ressourcen Liste der Ressourcen
	 */
	public void setRessourcens(List<Ressource> ressourcen) {
		this.ressourcen = ressourcen;
	}

	/**
	 * Fügt eine Ressource zur Liste der Ressourcen hinzu.
	 * @param ressourcen Ressource, die hinzugefügt werden soll.
	 * @return Die Ressource, die hinzugefügt wurde.
	 */
	public Ressource addRessourcen(Ressource ressourcen) {
		getRessourcen().add(ressourcen);
		ressourcen.setTyp(this);

		return ressourcen;
	}

	/**
	 * Löscht eine Ressource aus der Liste der Ressourcen.
	 * @param ressourcen Ressource, die gelöscht werden soll.
	 * @return Ressource, die gelöscht wurde.
	 */
	public Ressource removeRessourcen(Ressource ressourcen) {
		getRessourcen().remove(ressourcen);
		ressourcen.setTyp(null);

		return ressourcen;
	}
}