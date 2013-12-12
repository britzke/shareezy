package org.shareezy.test.unit;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.shareezy.beans.LoginBean;


/**
 * @author e1_wegner
 */
public class LoginBeanTest {

	private LoginBean proband;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		proband = new LoginBean();
	}

	/**
	 * Test method for {@link org.shareezy.beans.LoginBean#login()}.
	 */
	@Test
	public void testLogin() {
		
		String p = proband.login();
		assertEquals(null, p);		
	}

}
