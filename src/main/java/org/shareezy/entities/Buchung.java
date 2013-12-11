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

	//bi-directional many-to-one association to Benutzer
	@ManyToOne
	@JoinColumn(name="BENUTZER_ID_AUSLEIHER")
	private Benutzer ausleiher;

	//bi-directional many-to-one association to Ressourcen
	@ManyToOne
	private Ressource ressourcen;

	/**
	 * @return
	 */
	public BuchungPK getId() {
		return this.id;
	}

	/**
	 * @param id
	 */
	public void setId(BuchungPK id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public Date getRückgabedatum() {
		return this.rückgabedatum;
	}

	/**
	 * @param rückgabedatum
	 */
	public void setRückgabedatum(Date rückgabedatum) {
		this.rückgabedatum = rückgabedatum;
	}

	/**
	 * @return
	 */
	public Benutzer getBenutzer() {
		return this.ausleiher;
	}

	/**
	 * @param benutzer
	 */
	public void setBenutzer(Benutzer benutzer) {
		this.ausleiher = benutzer;
	}

	/**
	 * @return
	 */
	public Ressource getRessourcen() {
		return this.ressourcen;
	}

	/**
	 * @param ressourcen
	 */
	public void setRessourcen(Ressource ressourcen) {
		this.ressourcen = ressourcen;
	}

}