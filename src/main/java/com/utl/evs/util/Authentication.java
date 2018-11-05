package com.utl.evs.util;


import com.ntl.evs.bean.CredentialsBean;
import com.ntl.evs.dao.CredentialsDAO;
import com.ntl.evs.dao.impl.CredentialsDaoImpl;

public class Authentication {
	
	CredentialsDaoImpl cred;
	
	public Authentication() {
		cred=new CredentialsDaoImpl();
	}
	
	public Authentication(CredentialsDaoImpl cre){
		this.cred=cre;
	}
	
	public boolean authenticate(CredentialsBean user) {
		try {
			System.out.println("aa");

		//credentialsDAO cred= new credentialsDaoImpl();
		System.out.println("a3");
		CredentialsBean test=cred.findById(user.getUserID()); 
		System.out.println("a4");
		if(test.getPassword().equals(user.getPassword())) {
			if(test.getLoginStatus()==user.getLoginStatus()) {
				//return changeLoginStatus(user,user.getLoginStatus());
				return true;
			}
			else {
				System.out.println("User already logged in.!");
				return changeLoginStatus(user,user.getLoginStatus());
			}
		}
		else {
			System.out.println("Password does not match!");
		}
		
		return false;
		}
		catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return false;
		}
	}
	
	String autherize(String userId) {
		//credentialsDAO cred= new credentialsDaoImpl();
		CredentialsBean test=cred.findById(userId);
		System.out.println(test.toString());
		return test.getUserType();
		//return null;
	}
	
	boolean changeLoginStatus(CredentialsBean user, int loginStatus) {
		
		user.setLoginStatus((loginStatus+1)%2);
		//System.out.println();
		//credentialsDAO cred=new credentialsDaoImpl();
		return cred.updateCredentials(user);
		//return true;
	}
	
	public boolean alreadyLoggedIn(CredentialsBean user) {
		//credentialsDAO cred= new credentialsDaoImpl();
		CredentialsBean test=cred.findById(user.getUserID()); 
		if(test.getLoginStatus()==1) {
			return true;
		}
		return false;
	}
	
	public boolean isAdminUser(CredentialsBean user) {
		//credentialsDAO cred= new credentialsDaoImpl();
		CredentialsBean test=cred.findById(user.getUserID()); 
		if(test.getUserType().equals("A")) {
			return true;
		}
		return false;
		
	}

}
