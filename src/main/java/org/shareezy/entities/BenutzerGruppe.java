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
import javax.persistence.*;

/**
 * Entity implementation class for Entity: BenutzerGruppen
 * 
 */
@Entity
@IdClass(BenutzerGruppePK.class)
@Table(name = "BENUTZERGRUPPEN")
public class BenutzerGruppe implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "BENUTZER_ID")
	private int benutzerId;
	@Id
	@Column(name = "GRUPPEN_ID")
	private int gruppenId;
	@Column(name = "\"bestätigt\"")
	private boolean bestätigt;

	@ManyToOne
	@JoinColumn(name = "benutzer_id", referencedColumnName = "id", updatable = false, insertable = false)
	private Benutzer benutzer;

	@ManyToOne
	@JoinColumn(name = "gruppen_id", referencedColumnName = "id", updatable = false, insertable = false)
	private Gruppe gruppe;

	/**
	 * Antworted mit der Benutzer-ID der Benutzergruppe.
	 * 
	 * @return Die Benutzer-ID der Benutzergruppe
	 */
	public int getBenutzerId() {
		return this.benutzerId;
	}

	/**
	 * Setzt die Benutzer-ID der Benutzergruppe
	 * 
	 * @param benutzerId
	 *            Die Benutzer-Id für die Benutzergruppe
	 */
	public void setBenutzerId(int benutzerId) {
		this.benutzerId = benutzerId;
	}

	/**
	 * Antwortet mit der Gruppen-ID der Benutzergruppe.
	 * 
	 * @return Die Gruppen-Id der Benutzergruppe.
	 */
	public int getGruppenId() {
		return this.gruppenId;
	}

	/**
	 * Setzt die Gruppen-ID der Benutzergruppe.
	 * 
	 * @param gruppenId
	 *            Die Gruppen-ID für die Benutzergruppe
	 */
	public void setGruppenId(int gruppenId) {
		this.gruppenId = gruppenId;
	}

	/**
	 * Antwortet ob die Zugehörigkeit ind er Benutzergruppe für den
	 * entsprechenden Benutzer bereits bestätigt wurde.
	 * 
	 * @return TRUE, wenn die Zugehörigkeit des Benutzers in der Benutzergruppe
	 *         bereits bestätigt ist.<br/>
	 *         FALSE, wenn die Zugehörigkeit des Benutzers in der Benutzergruppe
	 *         noch nicht bestätigt ist.
	 */
	public boolean isBestätigt() {
		return this.bestätigt;
	}

	/**
	 * Setzt den Bestätigungsstatus der Zuordnung des Benutzers zu der
	 * referenzierten Gruppe
	 * 
	 * @param bestätigt
	 *            TRUE, wenn die Zuordnung bestätigt ist, FALSE ansonsten.
	 */
	public void setBestätigt(boolean bestätigt) {
		this.bestätigt = bestätigt;
	}
}
