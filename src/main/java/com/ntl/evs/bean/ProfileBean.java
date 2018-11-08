package com.ntl.evs.bean;

import java.sql.Date;
 import java.util.Random;

import com.ntl.evs.dao.CredentialsDAO;
import com.ntl.evs.dao.impl.CredentialsDaoImpl;

public class ProfileBean {

	private String userID;
	private String firstName;
	private String lastName;
	private String gender;
	private Date dateOfBirth; 
	private String city;
	private String street;
	private String location;
	private String state;
	private String pincode;
	private String mobileNo;
	private String emailID;
	private String password;
	
	public ProfileBean(){
		userID="";
		firstName="";
		lastName="";
		gender=""  ;
		dateOfBirth=null;
		city="";
		street="";
		location="";
		pincode="";
		mobileNo="";
		state="";
		emailID="";
		password="";
	}

	public ProfileBean(String fname, String lname,String gend,Date dob,String city,String location,String street,String state,String pin,String mobile,String email,String pass ){
		this.userID=generateUID(fname);
		this.firstName=fname;
		this.lastName=lname;
		this.gender=gend;
		this.dateOfBirth=dob;
		this.city=city;
		this.street=street;
		this.location=location;
		this.state=state;
		this.pincode=pin;
		this.mobileNo=mobile;
		this.emailID=email;
		this.password=pass;
		CredentialsBean cred=new CredentialsBean(this.userID,this.password,"U",0);
		CredentialsDAO c=new CredentialsDaoImpl();
		c.createCredentials(cred);
	}
	public ProfileBean(String uid,String fname, String lname,String gend,Date dob,String city,String location,String street,String state,String pin,String mobile,String email,String pass ){
		this.userID=uid;
		this.firstName=fname;
		this.lastName=lname;
		this.gender=gend;
		this.dateOfBirth=dob;
		this.city=city;
		this.street=street;
		this.location=location;
		this.state=state;
		this.pincode=pin;
		this.mobileNo=mobile;
		this.emailID=email;
		this.password=pass;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String generateUID(String fname){
		String uid=fname.substring(0,2);
		Random rand=new Random();
		int randomSuffix=rand.nextInt(9000);
		randomSuffix+=1000;
		uid+=randomSuffix;
		return uid;
	}
	@Override
	public String toString() {
		return "Profile > \n"+
				"User ID - "+this.userID+"\n"+
				"Name - "+this.firstName + " "+ this.lastName+"\n"+
				"Gender - "+this.gender+"\n"+
				"Date of Birth - "+this.dateOfBirth+"\n"+
				"Address - "+this.street+", "+this.city+", "+this.location+", "+this.pincode+"\n"+
				"Mobile No - "+this.mobileNo;
	}
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
