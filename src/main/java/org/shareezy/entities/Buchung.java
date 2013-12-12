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

/**
 * Klasse für die Persistenzobjekte der Datenbanktabelle BUCHUNGEN.
 * 
 * @author burghard.britzke (bubi@charmides.in-berlin.de)
 */
@Entity
@Table(name = "BUCHUNGEN")
public class Buchung implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BuchungPK id;

	@Temporal(TemporalType.DATE)
	private Date rückgabedatum;

	// bi-directional many-to-one association to Benutzer
	@ManyToOne
	@JoinColumn(name = "BENUTZER_ID_AUSLEIHER")
	private Benutzer ausleiher;

	// bi-directional many-to-one association to Ressourcen
	@ManyToOne
	private Ressource ressourcen;

	/**
	 * Antwortet mit der Id der Buchung.
	 * 
	 * @return Die Id der Buchung
	 */
	public BuchungPK getId() {
		return this.id;
	}

	/**
	 * Setzt die Id der Buchung.
	 * 
	 * @param id
	 *            Die Id, die in der Buchung gesetzt werden soll.
	 */
	public void setId(BuchungPK id) {
		this.id = id;
	}

	/**
	 * Antowrtet mit dem Rückgabedatum für diese Buchung.
	 * 
	 * @return Das Rückgabedatum für diese Buchung
	 */
	public Date getRückgabedatum() {
		return this.rückgabedatum;
	}

	/**
	 * Setzt das Rückgabedatum für diese Buchung.
	 * 
	 * @param rückgabedatum
	 *            Das Rückgabedatum, das für diese Buchung gesetzt werden soll.
	 */
	public void setRückgabedatum(Date rückgabedatum) {
		this.rückgabedatum = rückgabedatum;
	}

	/**
	 * Antwortet mit dem Benutzer für diese Buchung.
	 * 
	 * @return Der Benutzer für diese Buchung
	 */
	public Benutzer getBenutzer() {
		return this.ausleiher;
	}

	/**
	 * Setzt den Benutzer für diese Buchung.
	 * 
	 * @param benutzer
	 *            Der Benutzer, der für diese Buchung gesetzt werden soll
	 */
	public void setBenutzer(Benutzer benutzer) {
		this.ausleiher = benutzer;
	}

	/**
	 * Antwortet mit der Ressource aus der Buchung.
	 * 
	 * @return Die Ressouce aus der Buchung
	 */
	public Ressource getRessourcen() {
		return this.ressourcen;
	}

	/**
	 * Setzt eine Ressource für diese Buchung.
	 * 
	 * @param ressourcen
	 *            Die Ressource, die für die Buchung gesetzt werden soll
	 */
	public void setRessourcen(Ressource ressourcen) {
		this.ressourcen = ressourcen;
	}
}