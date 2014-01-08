/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	Kevin Wegner
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
import org.shareezy.beans.LoginBean;

/**
 * Eine TestUnit, in der verschiedene Funktionalitäten oder Methoden der
 * {@link org.shareezy.beans.LoginBean} getestet werden können.
 * 
 * @author Kevin Wegner
 * @author burghard.britzke bubi@charmides.in-berlin.de
 */
public class LoginBeanTest {

	private LoginBean proband;

	/**
	 * Initialisiert den Probanden und seine Testumgebung für alle Tests.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		proband = new LoginBean();
	}

	/**
	 * Test method for {@link org.shareezy.beans.LoginBean#login()}. Prüft, dass
	 * der Proband mit <em>null</em> antwortet, d. h. es wird keine Navigation
	 * zu einer anderen Seite eingeleitet.
	 */
	@Test
	public void testLogin() {

		String p = proband.login();
		assertEquals(null, p);
	}
}
