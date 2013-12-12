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
	 * Antwortet mit der Id des Benutzers.
	 * 
	 * @return Die Id des Benutzers
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Setzt die Id des Benutzers.
	 * 
	 * @param id
	 *            Die Id, die für den Benutzer gesetzt werden soll.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Antwortet mit der E-Mail des Benuters.
	 * 
	 * @return Die E-Mailadresse des Benutzers
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Setzt die E-Mailadresse des Benutzers.
	 * 
	 * @param email
	 *            Die E-Mailadresse, die für den Benutzer gesetzt werden soll.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Antwortet mit dem Kennwort des Benutzers.
	 * 
	 * @return Das Kennwort des Benutzers
	 */
	public String getKennwort() {
		return this.kennwort;
	}

	/**
	 * Setzt das Kennwort des Benutzers.
	 * 
	 * @param kennwort
	 *            Das Kennwort, das gesetzt werden soll.
	 */
	public void setKennwort(String kennwort) {
		this.kennwort = kennwort;
	}

	/**
	 * Antwortet mit dem Kurznamen des Benutzers.
	 * 
	 * @return Der Kurzname des Benutzers
	 */
	public String getKurzname() {
		return this.kurzname;
	}

	/**
	 * Setzt den Kurzname des Benutzers.
	 * 
	 * @param kurzname
	 *            Der Kurzname, der gesetzt werden soll
	 */
	public void setKurzname(String kurzname) {
		this.kurzname = kurzname;
	}

	/**
	 * Antowrtet mit dem Nachnamen des Benutzers.
	 * 
	 * @return Der Nachname des Benutzers
	 */
	public String getNachname() {
		return this.nachname;
	}

	/**
	 * Setzt den Nachname des Benutzers.
	 * 
	 * @param nachname
	 *            Der Nachname, der gesetzt werden soll.
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	/**
	 * Antwortet mit dem Vornamen des Benutzers.
	 * 
	 * @return Der Vorname des Benutzers
	 */
	public String getVorname() {
		return this.vorname;
	}

	/**
	 * Setzt den Vorname des Benutzers.
	 * 
	 * @param vorname
	 *            Der Vorname, der gesetzt werden soll
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * Antowrtet mit der Liste der Gruppen, in der der Benutzer registiert ist.
	 * 
	 * @return Die Liste der Gruppen, in der der Benutzer registriert ist
	 */
	public List<Gruppe> getGruppen() {
		return this.gruppen;
	}

	/**
	 * Setzt die Liste der Gruppen, in der der Benutzer registriert ist.
	 * 
	 * @param gruppen
	 *            die Liste der Gruppen, in der der Benutzer registriert ist
	 */
	public void setGruppen(List<Gruppe> gruppen) {
		this.gruppen = gruppen;
	}

	/**
	 * Antwortet mit der Liste der Buchungen für einen Benutzer.
	 * 
	 * @return Die Liste der Buchungen für den Benutzer
	 */
	public List<Buchung> getBuchungen() {
		return this.buchungen;
	}

	/**
	 * Setzt die Liste der Buchungen für den Benutzer.
	 * 
	 * @param buchungen
	 *            Die Liste der Buchungen für den Benutzer
	 */
	public void setBuchungen(List<Buchung> buchungen) {
		this.buchungen = buchungen;
	}

	/**
	 * Fügt eine Buchung zur Liste der Buchungen für den Benutzer hinzu.
	 * 
	 * @param buchung
	 *            Die Buchung, die der Liste der Buchungen hinzugefügt werden
	 *            soll
	 * @return Die Buchung, die hinzugefügt wurde
	 */
	public Buchung addBuchung(Buchung buchung) {
		getBuchungen().add(buchung);
		buchung.setBenutzer(this);

		return buchung;
	}

	/**
	 * Löscht eine Buchung aus der Liste der Buchungen für den Benuzter.
	 * 
	 * @param buchung
	 *            Die Buchung, die aus der Liste der Buchungen gelöscht werden
	 *            soll
	 * @return Die Buchung, die gelöscht wurde
	 */
	public Buchung removeBuchungen(Buchung buchung) {
		getBuchungen().remove(buchung);
		buchung.setBenutzer(null);

		return buchung;
	}

	/**
	 * Antwortet mit der Liste der Ressourcen, dieses Benutzers.
	 * 
	 * @return Die Liste der Ressourcen, dieses Benutzers
	 */
	public List<Ressource> getRessourcen() {
		return this.ressourcen;
	}

	/**
	 * Setzt die Liste der Ressourcen für diesen Benutzer.
	 * 
	 * @param ressourcen
	 *            Die Liste der Ressourcen für diesen Benutzer
	 */
	public void setRessourcen(List<Ressource> ressourcen) {
		this.ressourcen = ressourcen;
	}

	/**
	 * Fügt eine Ressource der Liste von Ressourcen für diesen Benutzer hinzu.
	 * 
	 * @param ressourc
	 *            Die Ressouce, die der Liste der Ressourcen hinzugefügt werden
	 *            soll
	 * @return Die Ressouce, die hinzugefügt wurde
	 */
	public Ressource addRessource(Ressource ressource) {
		getRessourcen().add(ressource);
		ressource.setBenutzer(this);

		return ressource;
	}

	/**
	 * Löscht eine Ressource aus der Liste der Ressourcen für den Benutzer.
	 * 
	 * @param ressource
	 *            Die Ressouce, die gelöscht werden soll
	 * @return Die Ressource, die gelöscht wurde
	 */
	public Ressource removeRessourcen(Ressource ressource) {
		getRessourcen().remove(ressource);
		ressource.setBenutzer(null);

		return ressource;
	}
}