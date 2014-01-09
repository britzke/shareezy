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
package org.shareezy.test.unit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.shareezy.beans.RessourceListen;

/**
 *  Eine TestUnit, in der verschiedene Funktionalitäten/Methoden der 
 * {@link org.shareezy.beans.RessourcenListen} getestet werden können.
 * @author e1_treibmann
 *
 */
public class TestRessourcenListen {

	private RessourceListen proband;
	/**
	 * Diese Methode erstellt beim erstmaligen Testaufruf einen Probanden vom Typ RessourceListen
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		 proband = new RessourceListen();
	}

	/**
	 * Dies ist eine Testmethode für die ressourceClickedmethode. Sie überprüft ob der Rückgabewert der Methode ressourceClicked mit
	 * ressourcendetail übereinstimmt
	 * {@link org.shareezy.beans.RessourceListen#ressourceClicked()}.
	 */
	@Test
	public void testRessourceClicked() {
		String nav = proband.ressourceClicked();
		assertEquals("ressourcendetail", nav);
		
	}

}
