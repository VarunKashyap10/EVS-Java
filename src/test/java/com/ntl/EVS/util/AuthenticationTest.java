package com.ntl.EVS.util;

import static org.mockito.Mockito.when;

import org.junit.Test;

import static org.mockito.Mockito.mock;

import org.mockito.Mock;

import com.ntl.evs.bean.CredentialsBean;
import com.ntl.evs.dao.impl.CredentialsDaoImpl;
import com.utl.evs.util.Authentication;

import junit.framework.TestCase;

public class AuthenticationTest extends TestCase {

	//@Mock
	//credentialsDaoImpl cred;

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	@Test
	public void testAuthenticate() {
		CredentialsDaoImpl cred=mock(CredentialsDaoImpl.class);
		CredentialsBean cre=new CredentialsBean("VK9999","qwerty1","A",0);
		when(cred.findById("VK9999")).thenReturn(cre);
		System.out.println(cred);
		Authentication auth=new Authentication(cred);
		assertEquals("Failed to auth",true,auth.authenticate(new CredentialsBean("VK9999","qwerty1","",0)));
//		fail("Not yet implemented");
	}

	public void testAutherize() {
		//fail("Not yet implemented");
	}

	public void testChangeLoginStatus() {
		//fail("Not yet implemented");
	}

	public void testAlreadyLoggedIn() {
		//fail("Not yet implemented");
	}

	public void testIsAdminUser() {
		//fail("Not yet implemented");
	}

}
