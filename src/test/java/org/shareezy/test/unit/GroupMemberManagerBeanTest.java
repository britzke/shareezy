package org.shareezy.test.unit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.shareezy.beans.GroupMemberManagerBean;

public class GroupMemberManagerBeanTest {

	private GroupMemberManagerBean proband;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		proband = new GroupMemberManagerBean();
	}

	@Test
	public void test() {
		assertEquals("Kein return", null, proband.addUser());
	}

}
