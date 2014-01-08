/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	Maurice Engelskirchen
 * 						Burak Cakir
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
 * Die Klasse AccountBearbeitenBean stellt Methoden zur Verfügung, die dafür
 * genutzt werden das der Nutzer seinen Account bearbeiten kann.
 * 
 * @author Maurice Engelskirchen, Burak Cakir
 */
@ManagedBean
public class AccountBearbeitenBean {
	/**
	 * Prüft die Eingabe des nutzer. Abhängig davon gibt er eine fehlermeldung
	 * aus, prüftt die eingabe mit den in der Datenbank gespeicherten referens
	 * Daten oder ruft direkt die Methode DatensatzÄndern() auf.
	 * 
	 * @return null da kein Seitenwechsel stattfindet.
	 */

	public String eingabePrüfen() {
		return null;
	}

	/**
	 * Die Metode Datensatz ändern überschreibt den zur "User_Id" Gehörenden
	 * Datensatz mit dem von Benutzer eingegebenen Daten.
	 * 
	 * @return null da kein Seitenwechsel stattfindet.
	 */
	public String datensatzÄndern() {
		return null;
	}
}