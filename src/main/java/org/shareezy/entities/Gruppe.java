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
 * Persistenzobjekte für den Datensätze aus der Tabelle GRUPPEN.
 * 
 * @author burghard.britzke (bubi@charmides.in-berlin.de)
 */
@Entity
@Table(name = "GRUPPEN")
public class Gruppe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String kennwort;

	private String name;

	// bi-directional many-to-many association to Benutzer
	@ManyToMany
	@JoinTable(name = "BENUTZERGRUPPEN", joinColumns = { @JoinColumn(name = "GRUPPEN_ID") }, inverseJoinColumns = { @JoinColumn(name = "BENUTZER_ID") })
	private List<Benutzer> benutzer;

	// bi-directional many-to-one association to Benutzer
	@ManyToOne
	@JoinColumn(name = "BENUTZER_ID_VERWALTER")
	private Benutzer verwalter;

	// bi-directional many-to-many association to Ressourcen
	@ManyToMany(mappedBy = "gruppen")
	private List<Ressource> ressourcen;

	/**
	 * Antwortet mit der Id der Gruppe.
	 * 
	 * @return Die Id der Gruppe
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Setzt die Id der Gruppe.
	 * 
	 * @param id
	 *            Die Id, die für die Gruppe gesetzt werden soll.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Antwortet mit dem Kennwort der Gruppe.
	 * 
	 * @return Das Kennwort der Gruppe
	 */
	public String getKennwort() {
		return this.kennwort;
	}

	/**
	 * Setzt das Kennwort für die Gruppe.
	 * 
	 * @param kennwort
	 *            Das Kennwort, dass für die Gruppe gesetzt werden soll
	 */
	public void setKennwort(String kennwort) {
		this.kennwort = kennwort;
	}

	/**
	 * Antwortet mit dem Namen dieser Gruppe.
	 * 
	 * @return Der Name dieser Gruppe
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Setzt den Namen dieser Gruppe
	 * 
	 * @param name
	 *            Der Name für diese Gruppe
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Antwortet mit der Liste der Mitglieder dieser Gruppe.
	 * 
	 * @return Die Liste der Mitglieder dieser Gruppe
	 */
	public List<Benutzer> getBenutzers() {
		return this.benutzer;
	}

	/**
	 * Setzt die Liste der Mitglieder dieser Gruppe.
	 * 
	 * @param benutzer
	 *            Die Liste der Mitglieder für diese Gruppe
	 */
	public void setBenutzers(List<Benutzer> benutzer) {
		this.benutzer = benutzer;
	}

	/**
	 * Antwortet mit dem Verwalter, dieser Gruppe.
	 * 
	 * @return Der Verwalter dieser Gruppe
	 */
	public Benutzer getVerwalter() {
		return this.verwalter;
	}

	/**
	 * Setzt den Verwalter für dies Gruppe.
	 * 
	 * @param verwalter
	 *            Der Verwalter, der gesetzt werden soll
	 */
	public void setVerwalter(Benutzer verwalter) {
		this.verwalter = verwalter;
	}

	/**
	 * Antwortet mit der Liste der Ressourcen, die in die Gruppe eingestellt
	 * sind.
	 * 
	 * @return Die Liste der Ressource für diese Gruppe
	 */
	public List<Ressource> getRessourcens() {
		return this.ressourcen;
	}

	/**
	 * Setzt die Liste der Ressourcen, die in die Gruppe eingestellt sind.
	 * 
	 * @param ressourcen
	 *            Die Liste der Ressourcen, die gesetzt werden soll
	 */
	public void setRessourcen(List<Ressource> ressourcen) {
		this.ressourcen = ressourcen;
	}
}