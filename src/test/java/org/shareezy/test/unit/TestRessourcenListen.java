/**
 * 
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
