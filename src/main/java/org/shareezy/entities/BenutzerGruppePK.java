/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2014  burghard.britzke
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

/**
 * ID class for entity: BenutzerGruppen
 * 
 */
public class BenutzerGruppePK implements Serializable {

	private int benutzerId;
	private int gruppenId;
	private static final long serialVersionUID = 1L;

	/**
	 * Antwortet mit der Benutzer-ID des Primärschlüssels.
	 * 
	 * @return Benutzer-ID des Primärschlüssels
	 */
	public int getBenutzerId() {
		return this.benutzerId;
	}

	/**
	 * Setzt die Benutzer-ID des Primärschlüssels.
	 * 
	 * @param benutzerId
	 *            Die Benutzer-ID des Primärschlüssels
	 */
	public void setBenutzerId(int benutzerId) {
		this.benutzerId = benutzerId;
	}

	/**
	 * Antwortet mit der Gruppen-ID des Primärschlüssels.
	 * 
	 * @return Die Gruppen-ID des Primärschlüssels.
	 */
	public int getGruppenId() {
		return this.gruppenId;
	}

	/**
	 * Setzt die Gruppen-ID des Primärschlüssels.
	 * 
	 * @param gruppenId
	 *            Die Gruppen-ID des Primärschlüssels.
	 */
	public void setGruppenId(int gruppenId) {
		this.gruppenId = gruppenId;
	}

	/**
	 * Stellt fest, ob eine BenutzergruppeId-Objekt gleich einem anderen ist.
	 * 
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof BenutzerGruppePK)) {
			return false;
		}
		BenutzerGruppePK other = (BenutzerGruppePK) o;
		return true && getBenutzerId() == other.getBenutzerId()
				&& getGruppenId() == other.getGruppenId();
	}

	/**
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getBenutzerId();
		result = prime * result + getGruppenId();
		return result;
	}
}
