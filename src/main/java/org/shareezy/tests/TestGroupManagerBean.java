package org.shareezy.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.shareezy.beans.GroupManagerBean;

public class TestGroupManagerBean {

	GroupManagerBean gmb ;
	
	@Before
	public void createNewBean(){
		gmb = new GroupManagerBean();
	}
	
	@Test
	public void testNewGroupClick(){
		assertEquals("onNewGroupClick() muss 'null' sein ",null,gmb.onNewGroupClick());
	}
	
	@After
	public void after(){
		if(gmb!=null) System.out.println("After: "+gmb);
		assertNotNull("Gmb wurde initialisiert", gmb);
	}

}
