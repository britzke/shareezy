/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	Tim Treibmann
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
 * Diese Klasse stellt die Eigenschaften und Funktinen für das Listen von Ressourcen zur Verfügung.
 * Ressourcen werden in der Ressourcenansicht.xhtml, EigeneRessourcen.xhtml, Gruppenverwaltung.xhtml und eigeneBuchungen.xhtml
 * gelistet.
 * 
 * @author e1_treibmann
 *
 */
@ManagedBean
public class RessourceListen {
	/**
	 * Die Methode ressourceClicked leitet bei einem Klick auf den Namen der Ressource, den Benutzer auf die Detailansicht der Ressource weiter.
	 * @return "ressourcendetail" gibt die ressourcendetail zurück wenn auf einen Ressourcennamen geklickt wurde.
	 */
	public String ressourceClicked(){
	return "ressourcendetail";
	}

}
