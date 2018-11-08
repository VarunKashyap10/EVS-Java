package com.ntl.EVS.util;

import com.ntl.evs.bean.CredentialsBean;
import com.ntl.evs.dao.CredentialsDAO;
import com.ntl.evs.dao.ProfileDAO;
import com.ntl.evs.dao.impl.CredentialsDaoImpl;
import com.ntl.evs.dao.impl.ProfileDaoImpl;
import com.utl.evs.util.Authentication;
import com.utl.evs.util.User;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;

import junit.framework.TestCase;

public class UserTest extends TestCase {
	
	CredentialsDaoImpl cred=mock(CredentialsDaoImpl.class);
	Authentication a=mock(Authentication.class);
	ProfileDaoImpl pd=mock(ProfileDaoImpl.class);
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	@Before
	public void beforeStart() {
		
	}
	
	public void testLogin() {
		//fail("Not yet implemented");
		CredentialsBean user=new CredentialsBean("VK9999","qwerty1","A",0);
		when(a.authenticate(user)).thenReturn(true);
		when(a.autherize(user.getUserID())).thenReturn("A");
		User u=new User(cred,a,pd);
		assertEquals("A",u.login(user));
	}

	public void testLogout() {
		CredentialsBean user=new CredentialsBean("VK9999","qwerty1","A",0);
		when(cred.findById("VK9999")).thenReturn(user);
		when(a.changeLoginStatus(user, user.getLoginStatus())).thenReturn(true);
		User u=new User(cred,a,pd);
		assertEquals(true,u.logout("VK9999"));
		//fail("Not yet implemented");
	}

	public void testChangePassword() {
		//fail("Not yet implemented");
	}

	public void testResgister() {
		//fail("Not yet implemented");
	}

}
