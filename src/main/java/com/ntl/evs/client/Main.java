package com.ntl.evs.client;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import com.ntl.evs.bean.CredentialsBean;
import com.ntl.evs.bean.ProfileBean;
import com.utl.evs.util.User;


public class Main {
	User user;
	Scanner sc=new Scanner(System.in);
	static Main client=new Main();
	User u=new User();
	static CredentialsBean currentUser=new CredentialsBean();

	public void InputProfile() {	
		System.out.println("Enter First Name : ");
		String uname=sc.nextLine();
		System.out.println("Enter Last Name : ");
		String lname=sc.nextLine();
		System.out.println("Enter Date Of Birth : (yyyy/mm/dd)");
		String dob=sc.nextLine();
		System.out.println("Enter Gender : ");
		String gender=sc.nextLine();
		System.out.println("Enter Street : ");
		String street=sc.nextLine();
		System.out.println("Enter Location : ");
		String location=sc.nextLine();
		System.out.println("Enter City : ");
		String city=sc.nextLine();
		System.out.println("Enter State : ");
		String state=sc.nextLine();
		System.out.println("Enter Pincode : ");
		String pincode=sc.nextLine();
		System.out.println("Enter Mobile Number : ");
		String mobile=sc.nextLine();
		System.out.println("Enter EmailID : ");
		String email=sc.nextLine();
		System.out.println("Enter Password : ");
		String pass=sc.nextLine();
		String[] dt=dob.split("/",3);
		LocalDate dob1=LocalDate.of(Integer.
				parseInt(dt[0]), Integer.parseInt(dt[1]),Integer.parseInt(dt[2]));
		Date dob2=Date.valueOf(dob1);
		ProfileBean newUser=new ProfileBean(uname,lname,gender,dob2,city,location,street,state,pincode,mobile,email,pass);
		User u=new User();
		u.resgister(newUser);
	}
	
	public static void main(String[] args) {
			//Main client=new Main();
		System.out.println("Welcome");
		Scanner sc1=new Scanner(System.in);
		boolean flag=true;
		while(flag) {
			client.showMessages();
			String option=sc1.next();
			sc1.nextLine();
			flag=client.selectOption(option);
		}
		sc1.close();
	}
	
	public boolean selectOption(String option) {
		User u=new User();
		NormalUser nu;
		AdminUser ad;
		ElectoralOfficerUser eo;
		switch(option) {
		case "1":
			currentUser=client.getLoginCredentials();
			String temp=u.login(currentUser);
			if(temp=="FAIL") {
				System.out.println("User does not exist. Please Register!");
				InputProfile();
				System.out.println("Sucessfully registered a new user!");
			}
			else if(temp=="U") {
				System.out.println("Successfully Login Complete! for a normal User");
				nu=new NormalUser(currentUser);
				nu.display();
			}
			else if(temp=="INVALID") {
				System.out.println("User already logged in.");
				nu=new NormalUser(currentUser);
				nu.display();
			}
			else if(temp=="A") {
				System.out.println("Admin User!");
				ad=new AdminUser(currentUser);
				ad.display();
			}
			else if(temp=="E") {
				System.out.println("Electoral Officer!");
				eo=new ElectoralOfficerUser(currentUser);
				eo.display();
			}
			return true;
		case "2":
			InputProfile();
			return true;
		case "3":
			System.out.println("GoodBye!!!");
			return false;
		default : 
			return true;
		}
		//return true;
	}

	public CredentialsBean getLoginCredentials() {
		System.out.println("Enter User ID");
		String uid=sc.next();
		sc.nextLine();
		System.out.println("Enter password");
		String pass=sc.next();
		sc.nextLine();
		CredentialsBean obj=new CredentialsBean(uid,pass);
		return obj;
	}
	public void showMessages() {
		System.out.println("Select an option.");
		System.out.println("1. Login");
		System.out.println("2. Sign Up");
		System.out.println("3. Quit");
	}
}
