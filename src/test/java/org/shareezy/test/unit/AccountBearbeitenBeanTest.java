/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	Maurice Engelskirchen
 * 						Burak Cakir
 * 						burghard.britzke bubi@charmides.in-berlin.de
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
import org.shareezy.beans.AccountBearbeitenBean;

/**
 * Testet die Übersetzungseinheit <i>(Compilation Unit)</i>
 * {@link org.shareezy.beans.AccountBearbeitenBean}.
 * 
 * @author e1_cakir
 * @author burghard.britzke bubi@charmides.in-berlin.de
 */
public class AccountBearbeitenBeanTest {

	private AccountBearbeitenBean proband;

	/**
	 * Erzeugt ein neuen Probanden der zu testenden Klasse.
	 * 
	 * @throws java.lang.Exception
	 *             Wenn eine Situation auftritt, die in der Methode nich
	 *             berücksitigt wurde.
	 */
	@Before
	public void setUp() throws Exception {
		proband = new AccountBearbeitenBean();
	}

	/**
	 * Test-Methode für
	 * {@link org.shareezy.beans.AccountBearbeitenBean#eingabePrüfen(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}
	 * . Testet, dass die Antwort <em>null</em> ist, d.h. es findet keine
	 * Navigation zu einer andern Seite statt.
	 */
	@Test
	public void testEingabePrüfen() {
		String antwort = proband.eingabePrüfen();
		assertNull(antwort);
	}

	/**
	 * Test-Methode für
	 * {@link org.shareezy.beans.AccountBearbeitenBean#datensatzÄndern(java.lang.String, java.lang.String)}
	 * . Testet, dass die Antwort <em>null</em> ist, d.h. es findet keine
	 * Navigation zu einer andern Seite statt.
	 */
	@Test
	public void testDatensatzÄndern() {
		String antwort = proband.datensatzÄndern();
		assertNull(antwort);
	}
}
