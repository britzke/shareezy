/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	Kevin Wegner
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
package org.shareezy.beans;

import javax.faces.bean.ManagedBean;

/**
 * In dieser Bean findet die Überprüfung der Anmeldungsdaten des Benutzers
 * statt. Der Benutzer muss seinen Benutzernamen und sein Passwort in die
 * entsprechenden Eingabefelder der View eintragen. Diese werden in die
 * jeweiligen Eigenschaften der Bean geschrieben.
 * 
 * @author wegner
 */
@ManagedBean
public class LoginBean {

	/**
	 * In dieser Methode werden die Eingaben des Benutzers, mit den
	 * entsprechenden Daten der Datenbank verglichen. Stimmen Benutzername und
	 * Passwort jeweils überein, ist die Anmeldung erfolgreich.
	 * 
	 * @return null, damit kein Seitenwechsel stattfindet.
	 */
	public String login() {
		return null;
	}
}
