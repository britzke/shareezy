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

/**
 * Primärschlüsselobjekte für die Datensätze der Tabelle BUCHUNGEN.
 * 
 * @author burghard.britzke (bubi@charmides.in-berlin.de)
 */
@Embeddable
public class BuchungPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private java.util.Date ausleihdatum;

	@Column(name = "BENUTZER_ID_AUSLEIHER", insertable = false, updatable = false)
	private int benutzerIdAusleiher;

	@Column(name = "RESSOURCEN_ID", insertable = false, updatable = false)
	private int ressourcenId;

	/**
	 * Antwortet mit dme Ausleihdatum, des Primärschlüssels.
	 * 
	 * @return Das Ausleihdatum des Primärschlüssels
	 */
	public java.util.Date getAusleihdatum() {
		return this.ausleihdatum;
	}

	/**
	 * Setzt das Ausleihdatum des Primärschlüssels.
	 * 
	 * @param ausleihdatum
	 *            Das Ausleihdatum, das für den Primärschlüssel gesetzt werden
	 *            soll.
	 */
	public void setAusleihdatum(java.util.Date ausleihdatum) {
		this.ausleihdatum = ausleihdatum;
	}

	/**
	 * Antwortet mit der Id des Ausleihers.
	 * 
	 * @return Die Id des Ausleihers
	 */
	public int getBenutzerIdAusleiher() {
		return this.benutzerIdAusleiher;
	}

	/**
	 * Setzt die Id des Ausleihers im Primärschlüssel für die Buchungen.
	 * 
	 * @param benutzerIdAusleiher
	 *            Die Id des Ausleihers, die gesetzt werden soll.
	 */
	public void setBenutzerIdAusleiher(int benutzerIdAusleiher) {
		this.benutzerIdAusleiher = benutzerIdAusleiher;
	}

	/**
	 * Antwortet mit der Id der Ressource in diesem Primärschlüssel.
	 * 
	 * @return Die Id der Ressource in diesem Primärschlüssel
	 */
	public int getRessourcenId() {
		return this.ressourcenId;
	}

	/**
	 * Setzt die Id für die Ressource in diesem Primärschlüssel.
	 * 
	 * @param ressourcenId
	 *            Die Id für die Ressource, die in diesem Primärschlüssel
	 *            gesetzt werden soll.
	 */
	public void setRessourcenId(int ressourcenId) {
		this.ressourcenId = ressourcenId;
	}

	/**
	 * Antwortet, ob das angegebene Objekt gleich diesem ist.
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BuchungPK)) {
			return false;
		}
		BuchungPK castOther = (BuchungPK) other;
		return this.ausleihdatum.equals(castOther.ausleihdatum)
				&& (this.benutzerIdAusleiher == castOther.benutzerIdAusleiher)
				&& (this.ressourcenId == castOther.ressourcenId);
	}

	/**
	 * Antwortet mit einem eindeutigen Kennzeichen dieses Objekts.
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ausleihdatum.hashCode();
		hash = hash * prime + this.benutzerIdAusleiher;
		hash = hash * prime + this.ressourcenId;

		return hash;
	}
}