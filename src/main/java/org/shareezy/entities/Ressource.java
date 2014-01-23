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
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the RESSOURCEN database table.
 * 
 * @author burghard.britzke (bubi@charmides.in-berlin.de)
 */
@Entity
@Table(name = "RESSOURCEN", schema="SHAREEZY")
public class Ressource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Lob
	private String beschreibung;

	@Lob
	private byte[] bild;

	@Temporal(TemporalType.DATE)
	private Date einstellungsdatum;

	@Temporal(TemporalType.DATE)
	private Date enddatum;

	private String name;

	@Temporal(TemporalType.DATE)
	private Date startdatum;

	// bi-directional many-to-one association to Buchungen
	@OneToMany(mappedBy = "ressourcen")
	private List<Buchung> buchungen;

	// bi-directional many-to-one association to Benutzer
	@ManyToOne
	@JoinColumn(name = "BENUTZER_ID_EIGENTÜMER")
	private Benutzer benutzer;

	// bi-directional many-to-one association to Typen
	@ManyToOne
	@JoinColumn(name = "typen_id", referencedColumnName = "id")
	private Typ typ;

	// bi-directional many-to-many association to Gruppen
	@ManyToMany
	@JoinTable(name = "VERFÜGBARKEITEN", joinColumns = { @JoinColumn(name = "RESSORCEN_ID") }, inverseJoinColumns = { @JoinColumn(name = "GRUPPEN_ID") })
	private List<Gruppe> gruppen;

	/**
	 * Antwortet mit der Id der Ressource.
	 * 
	 * @return Die Id der Ressource
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Setzt die Id für die Ressource
	 * 
	 * @param id
	 *            Die Id der Ressource
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getBeschreibung() {
		return this.beschreibung;
	}

	/**
	 * @param beschreibung
	 */
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	/**
	 * @return
	 */
	public byte[] getBild() {
		return this.bild;
	}

	/**
	 * @param bild
	 */
	public void setBild(byte[] bild) {
		this.bild = bild;
	}

	/**
	 * @return
	 */
	public Date getEinstellungsdatum() {
		return this.einstellungsdatum;
	}

	/**
	 * @param einstellungsdatum
	 */
	public void setEinstellungsdatum(Date einstellungsdatum) {
		this.einstellungsdatum = einstellungsdatum;
	}

	/**
	 * @return
	 */
	public Date getEnddatum() {
		return this.enddatum;
	}

	/**
	 * @param enddatum
	 */
	public void setEnddatum(Date enddatum) {
		this.enddatum = enddatum;
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
	public Date getStartdatum() {
		return this.startdatum;
	}

	/**
	 * @param startdatum
	 */
	public void setStartdatum(Date startdatum) {
		this.startdatum = startdatum;
	}

	/**
	 * @return
	 */
	public List<Buchung> getBuchungens() {
		return this.buchungen;
	}

	/**
	 * @param buchungen
	 */
	public void setBuchungens(List<Buchung> buchungen) {
		this.buchungen = buchungen;
	}

	/**
	 * @param buchungen
	 * @return
	 */
	public Buchung addBuchungen(Buchung buchungen) {
		getBuchungens().add(buchungen);
		buchungen.setRessourcen(this);

		return buchungen;
	}

	/**
	 * @param buchungen
	 * @return
	 */
	public Buchung removeBuchungen(Buchung buchungen) {
		getBuchungens().remove(buchungen);
		buchungen.setRessourcen(null);

		return buchungen;
	}

	/**
	 * Antwortet mit dem Eigentümer der Ressource.
	 * 
	 * @return Der Eigentümer der Ressource
	 */
	public Benutzer getBenutzer() {
		return this.benutzer;
	}

	/**
	 * Setzt den Eigentümer der Ressource.
	 * 
	 * @param benutzer
	 *            Der Benutzer, der als Eigentümer für diese Ressource gesetzt
	 *            werden soll.
	 */
	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}

	/**
	 * Antortet mit dem Typ der Ressource.
	 * 
	 * @return Der Typ der Ressource.
	 */
	public Typ getTyp() {
		return this.typ;
	}

	/**
	 * Setzt den Typ für diese Ressource.
	 * 
	 * @param type
	 *            Der Typ für die Ressource
	 */
	public void setTyp(Typ typ) {
		this.typ = typ;
	}

	/**
	 * Antwortet mit der Liste der Gruppen für diese Ressource.
	 * 
	 * @return Liste der Gruppen für diese Ressource.
	 */
	public List<Gruppe> getGruppens() {
		return this.gruppen;
	}

	/**
	 * Setzt die Liste der Gruppen fpr diese Ressource.
	 * 
	 * @param gruppen
	 *            Die Liste von Gruppen, die gesetzt werden soll
	 */
	public void setGruppens(List<Gruppe> gruppen) {
		this.gruppen = gruppen;
	}
}