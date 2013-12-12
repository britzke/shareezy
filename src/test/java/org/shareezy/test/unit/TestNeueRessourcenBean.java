/**
 * 
 */
package org.shareezy.test.unit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.shareezy.beans.NeueRessourceBean;
import org.shareezy.beans.RessourceListen;

/**
 * Eine Testklasse/Testcase zum testen der NeueRessourcenBean
 * @author e1_klawitter
 */
public class TestNeueRessourcenBean {
	/**
	 * Es wird ein Proband für die Klasse NeueRessourcenBean referenciert
	 */
	 NeueRessourceBean proband;
	 
	 /**
	  * Die Annotation <code>Before</code> sorgt dafür das vor dem Test die folgende Methode ausgeführt wird,
	  * damit der Test vorbereitet werden kann.
	  * Außerßerdem wird ein NeureRessourceBean Objekt erstellt und proband zugewiesen.
	  * Dieser Proband wird noch nciht genutzt.
	  */
	 @Before
		public void aufbau()  {
			 proband  = new NeueRessourceBean();
		}
	 /**
	  * Die Annotation Test identifiziert die Methode als Testfall.
	  * Der Test schlägt automatisch fehl, um zu gucken ob 
	  */
	@Test
	public void testNeueRessource()
	{
		fail();
	}

}
