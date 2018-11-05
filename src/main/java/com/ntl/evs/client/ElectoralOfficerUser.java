package com.ntl.evs.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.ntl.evs.bean.ApplicationBean;
import com.ntl.evs.bean.CredentialsBean;
import com.ntl.evs.service.ElectoralOfficer;
import com.ntl.evs.service.impl.ElectoralOfficerImpl;
import com.utl.evs.util.User;

public class ElectoralOfficerUser {
	CredentialsBean officer;
	Scanner sc=new Scanner(System.in);
	User u=new User();
	ElectoralOfficer eo=new ElectoralOfficerImpl();
	public ElectoralOfficerUser() {
		
	}
	public ElectoralOfficerUser(CredentialsBean off) {
		officer = off;
	}
	public void display() {
		boolean flag=true;
		while(flag) {
			showMessages();
			String option=sc.next();
			sc.nextLine();
			flag=evaluateOptions(option);
	}

	}
	boolean evaluateOptions(String option) {
		switch(option) {
		case "1":
			//flag=false;
			return !logout();
		case "2":
			viewVoterRequests();
			return true;
		case "3":
			return !changePassword();
		default:
			System.out.println("Goodbye!");
			return false;
		}
	}
	void showMessages() {
		System.out.println("Select an option");
		System.out.println("1. Logout");
		System.out.println("2. View voter requests from Admin");
		System.out.println("3. Change password");
		
	}
	boolean logout() {
		//User u=new User();
		return( u.logout(officer.getUserID()));
	}
	void viewVoterRequests() {
		try {
			System.out.println("Requests forwarded from Admin are ");
			ArrayList<ApplicationBean> arr =eo.viewAllVoterIdApplications();
			int i=1;
			for(ApplicationBean a:arr) {
				System.out.println(i+". "+a.toString());
				i++;
			}
			System.out.println("Enter Index of application to approve");
			int op=sc.nextInt();
			sc.nextLine();
			if(op<1 || op>arr.size()) {
				System.out.println("Invalid Choice");
				return;
			}
			eo.generateVoterId(arr.get(op-1).getUserID() , arr.get(op-1).getConstituency());
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	boolean changePassword() {
		System.out.println("Enter New Password");
		String newPass=sc.next();
		sc.nextLine();
		System.out.println("Reenter Password");
		String newPass2=sc.next();
		sc.nextLine();
		if(!newPass.equals(newPass2)) {
			System.out.println("Passwords do not match");
			return false;
		}
		if(u.changePassword(officer,newPass).equals("SUCCESS")) {
			return true;
		}
		else {
			System.out.println("Error changing password");
		}
		return false;
	}

}
