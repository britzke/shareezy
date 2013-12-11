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
	 * @return
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 */
	public List<Benutzer> getBenutzers() {
		return this.benutzer;
	}

	/**
	 * @param benutzer
	 */
	public void setBenutzers(List<Benutzer> benutzer) {
		this.benutzer = benutzer;
	}

	/**
	 * @return
	 */
	public Benutzer getBenutzer() {
		return this.verwalter;
	}

	/**
	 * @param verwalter
	 */
	public void setVerwalter(Benutzer verwalter) {
		this.verwalter = verwalter;
	}

	/**
	 * @return
	 */
	public List<Ressource> getRessourcens() {
		return this.ressourcen;
	}

	/**
	 * @param ressourcen
	 */
	public void setRessourcen(List<Ressource> ressourcen) {
		this.ressourcen = ressourcen;
	}
}