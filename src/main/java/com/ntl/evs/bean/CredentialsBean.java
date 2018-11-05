package com.ntl.evs.bean;

public class CredentialsBean {
	private String userID;
	private String password;
	private String userType;
	private int loginStatus;
	public CredentialsBean(){
		userID="";
		password="";
		userType="";
		loginStatus=-1;
		
	}
	public CredentialsBean(String userid,String pass) {
		userID=userid;
		password=pass;
		userType="";
		loginStatus=0;
	}
	public CredentialsBean(String userid,String pass,String utype,int status) {
		userID=userid;
		password=pass;
		userType=utype;
		loginStatus=status;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}
	@Override
	public String toString() {
		return "User Credentials > "+userID+" | Password > "+password+" | UserType > "+userType+" | LoginStatus > "+loginStatus ;
		
	}
}
