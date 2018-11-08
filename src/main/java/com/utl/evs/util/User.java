package com.utl.evs.util;

import com.ntl.evs.bean.CredentialsBean;
import com.ntl.evs.bean.ProfileBean;
import com.ntl.evs.dao.CredentialsDAO;
import com.ntl.evs.dao.ProfileDAO;
import com.ntl.evs.dao.impl.CredentialsDaoImpl;
import com.ntl.evs.dao.impl.ProfileDaoImpl;

public class User {
	CredentialsDAO cred;
	Authentication a;
	ProfileDAO pd;

	public User() {
		cred=new CredentialsDaoImpl();
		a=new Authentication();
		pd=new ProfileDaoImpl();

	}
	public User(CredentialsDaoImpl c,Authentication a, ProfileDaoImpl p) {
		this.cred=c;
		this.a=a;
		this.pd=p;
	}

	//Main client=new Main();
	public String login(CredentialsBean credentialsBean) {
		System.out.println("Login");
		try {
			System.out.println("a1");
			if(a.authenticate(credentialsBean)) {
				System.out.println("a2");
				String temp=a.autherize(credentialsBean.getUserID());
				System.out.println("User tyoe returned -"+temp );
				switch(temp) {
				case "A":
					return "A"; 
				case "E":
					return "E";
				case "U":
					return "U";
				default:
					return "FAIL";
				}
			}
			return "FAIL";
		}
		catch(Exception err) {
			System.out.println(err);
			err.printStackTrace();
			return "FAIL";
		}
	}
	
	public boolean logout(String userId) {
		try {
			CredentialsBean user=cred.findById(userId);
			a.changeLoginStatus(user, user.getLoginStatus());
			return true;
		}catch(Exception err) {
			System.out.println(err);
			err.printStackTrace();
		}
		return false;
	}
	
	public String changePassword(CredentialsBean user, String newPass) {
		if(user.getLoginStatus()==1) {
			user.setPassword(newPass);
			cred.updateCredentials(user);
			return "SUCCESS";
		}
		
		return "FAIL";
	}
	
	public String resgister(ProfileBean profileBean) {
		System.out.println(profileBean.toString());
		pd.createProfile(profileBean);
		return null;
	}

}
