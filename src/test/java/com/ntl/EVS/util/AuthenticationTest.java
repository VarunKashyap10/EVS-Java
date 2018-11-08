package com.ntl.EVS.util;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

import org.mockito.Mock;

import com.ntl.evs.bean.CredentialsBean;
import com.ntl.evs.dao.impl.CredentialsDaoImpl;
import com.utl.evs.util.Authentication;

import junit.framework.TestCase;

public class AuthenticationTest extends TestCase {

	//@Mock
	CredentialsDaoImpl cred=mock(CredentialsDaoImpl.class);
	

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	@Before
	public void beforeTestSetup() {
		

		System.out.println(cred);
	}
	
	@Test
	public void testAuthenticate() {
		CredentialsBean cre=new CredentialsBean("VK9999","qwerty1","A",0);
		when(cred.findById("VK9999")).thenReturn(cre);
		Authentication auth=new Authentication(cred);
		assertEquals("Failed to auth",true,auth.authenticate(new CredentialsBean("VK9999","qwerty1","",0)));
//		fail("Not yet implemented");
	}
	@Test
	public void testAutherize() {
		CredentialsBean cre=new CredentialsBean("VK9999","qwerty1","A",0);
		when(cred.findById("VK9999")).thenReturn(cre);
		Authentication auth=new Authentication(cred);
		assertEquals("Failed  to test autherize","A",auth.autherize("VK9999"));
		//fail("Not yet implemented");
	}
	@Test
	public void testChangeLoginStatus() {
		CredentialsBean cre=new CredentialsBean("VK9999","qwerty1","A",0);
		when(cred.findById("VK9999")).thenReturn(cre);
		//fail("Not yet implemented");
		Authentication auth=new Authentication(cred);
		assertEquals("Failed to test change login status",true,auth.changeLoginStatus(cre,cre.getLoginStatus()));
	}
	@Test
	public void testAlreadyLoggedIn() {
		CredentialsBean cre=new CredentialsBean("VK9999","qwerty1","A",0);
		when(cred.findById("VK9999")).thenReturn(cre);
		//fail("Not yet implemented");
		Authentication auth=new Authentication(cred);
		assertEquals("Failed to test Already Logged In",false,auth.alreadyLoggedIn(cre));
	}
	@Test
	public void testIsAdminUser() {
		CredentialsBean cre=new CredentialsBean("VK9999","qwerty1","A",0);
		when(cred.findById("VK9999")).thenReturn(cre);
		Authentication auth=new Authentication(cred);
		assertEquals("Failed to test AdminUser",true,auth.isAdminUser(cre));
	}

}
