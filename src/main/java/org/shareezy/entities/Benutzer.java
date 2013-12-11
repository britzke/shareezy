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
 * Klasse für Persistenz-Objekte der Datenbanktabelle BENUTZER.
 * 
 * @author burghard.britzke (bubi@charmides.in-berlin.de)
 */
@Entity
public class Benutzer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String email;

	private String kennwort;

	private String kurzname;

	private String nachname;

	private String vorname;

	// bi-directional many-to-many association to Gruppen
	@ManyToMany(mappedBy = "benutzer")
	private List<Gruppe> gruppen;

	// bi-directional many-to-one association to Buchungen
	@OneToMany(mappedBy = "ausleiher")
	private List<Buchung> buchungen;

	// bi-directional many-to-one association to Ressourcen
	@OneToMany(mappedBy = "benutzer")
	private List<Ressource> ressourcen;

	/**
	 * @return
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return
	 */
	public String getKennwort() {
		return this.kennwort;
	}

	/**
	 * @param kennwort
	 */
	public void setKennwort(String kennwort) {
		this.kennwort = kennwort;
	}

	/**
	 * @return
	 */
	public String getKurzname() {
		return this.kurzname;
	}

	/**
	 * @param kurzname
	 */
	public void setKurzname(String kurzname) {
		this.kurzname = kurzname;
	}

	/**
	 * @return
	 */
	public String getNachname() {
		return this.nachname;
	}

	/**
	 * @param nachname
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	/**
	 * @return
	 */
	public String getVorname() {
		return this.vorname;
	}

	/**
	 * @param vorname
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * @return
	 */
	public List<Gruppe> getGruppens1() {
		return this.gruppen;
	}

	/**
	 * @param gruppens1
	 */
	public void setGruppens1(List<Gruppe> gruppens1) {
		this.gruppen = gruppens1;
	}

	/**
	 * @return
	 */
	public List<Buchung> getBuchungens() {
		return this.buchungen;
	}

	/**
	 * @param buchungens
	 */
	public void setBuchungens(List<Buchung> buchungens) {
		this.buchungen = buchungens;
	}

	/**
	 * @param buchungen
	 * @return
	 */
	public Buchung addBuchungen(Buchung buchungen) {
		getBuchungens().add(buchungen);
		buchungen.setBenutzer(this);

		return buchungen;
	}

	/**
	 * @param buchungen
	 * @return
	 */
	public Buchung removeBuchungen(Buchung buchungen) {
		getBuchungens().remove(buchungen);
		buchungen.setBenutzer(null);

		return buchungen;
	}

	/**
	 * @return
	 */
	public List<Ressource> getRessourcen() {
		return this.ressourcen;
	}

	/**
	 * @param ressourcen
	 */
	public void setRessourcen(List<Ressource> ressourcen) {
		this.ressourcen = ressourcen;
	}

	/**
	 * @param ressourcen
	 * @return
	 */
	public Ressource addRessourcen(Ressource ressourcen) {
		getRessourcen().add(ressourcen);
		ressourcen.setBenutzer(this);

		return ressourcen;
	}

	/**
	 * @param ressource
	 * @return
	 */
	public Ressource removeRessourcen(Ressource ressource) {
		getRessourcen().remove(ressource);
		ressource.setBenutzer(null);

		return ressource;
	}
}