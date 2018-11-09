package com.ntl.evs.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.ntl.evs.bean.ApplicationBean;
import com.ntl.evs.bean.CandidateBean;
import com.ntl.evs.bean.CredentialsBean;
import com.ntl.evs.bean.ElectionBean;
import com.ntl.evs.dao.ApplicationDAO;
import com.ntl.evs.dao.impl.ApplicationDaoImpl;
import com.ntl.evs.service.Administrator;
import com.ntl.evs.service.Voter;
import com.ntl.evs.service.impl.AdministratorImpl;
import com.ntl.evs.service.impl.VoterImpl;
import com.utl.evs.util.User;

public class NormalUser {
	private static CredentialsBean loginUser=new CredentialsBean();
	static Scanner sc=new Scanner(System.in);
	Administrator ad=new AdministratorImpl();
	public NormalUser() {
		loginUser=null;
	}
	public NormalUser(CredentialsBean user){
		loginUser=user;
	}
	public void display() {
		//NormalUser nu=new NormalUser();
		System.out.println("Welcome "+loginUser.getUserID());
		boolean flag=true;
		while(flag) {
			showMessages();
			System.out.println(loginUser.toString());
			String str=sc.next();
			sc.nextLine();
			flag=evaluateOption(str);
		}
		System.out.println("Exit Normal User");
	}
	public void showMessages() {
		System.out.println("1. Show Details");
		System.out.println("2. Logout");
		System.out.println("3. Delete Current User");
		System.out.println("4. Change Password");
		System.out.println("5. View VoterID");
		System.out.println("6. Request for VoterID");
		System.out.println("7. Cast Vote");
		System.out.println("8. View Election Results");
		System.out.println("9. View contestants based on elections");
		System.out.println("10. View upcoming elections");
	}
	public boolean evaluateOption(String str) {
		switch(str) {
		case "1":
			System.out.println(loginUser.toString());
			return true;
		case "2":
			//logout();
			return !logout();
		case "3":
			delete();
			return false;
		case "4":
			changePassword(loginUser);
			return true;
		case "5":
			viewVoterID();
			return true;
		case "6":
			createApplication();
			return true;
		case "7":
			castVote();
			return true;
		case "8":
			viewResults();
			return true;
		case "9":
			viewCandidatesByElection();
			return true;
		case "10":
			viewUpcomingElections();
			return true;
		default : 
			System.out.println("Invalid choice. Please Reenter");
			return true;
		}
		//return true;
	}
	public boolean logout() {
		User u=new User();
		System.out.println( u.logout(loginUser.getUserID()));
		return true;
	}
	public void delete() {
		
	}
	public boolean changePassword(CredentialsBean user) {
		User u=new User();
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
		if(u.changePassword(user,newPass).equals("SUCCESS")) {
			return true;
		}
		else {
			System.out.println("Error changing password");
		}
		return false;
	}
	public void viewVoterID() {
		try {
		System.out.println("Showing VoterID");
		ApplicationDAO app=new ApplicationDaoImpl();
		ApplicationBean application=app.findById(loginUser.getUserID());
		System.out.println(application.toString());
		}catch(Exception err) {
			err.printStackTrace();
			System.out.println("Create Election ID");
		}
	}
	
	public void createApplication() {
		System.out.println("Creating an application to generate VoterID");
		System.out.println("Enter Constituency");
		String cons=sc.nextLine();
		ApplicationBean app=new ApplicationBean(loginUser.getUserID(),cons,1,0);
		System.out.println(app.toString());
		ApplicationDAO appd=new ApplicationDaoImpl();
		appd.createApplication(app);
		Voter v=new VoterImpl();
		v.requestVoterId(app.getUserID());
	}
	
	public void castVote() {
		System.out.println("Cast your vote");
		System.out.println("Upcoming elections include -- ");
		ArrayList<ElectionBean> elections=ad.viewAllUpcomingElections();
		int i=1;
		for(ElectionBean e:elections) {
			System.out.print(i+". ");
			System.out.println(e);
			i++;
		}
		System.out.println("Enter the election you want to enter.");
		int election=sc.nextInt();
		sc.nextLine();
		ArrayList<CandidateBean> candidates=ad.viewCandidateDetailsByElectionName(elections.get(election-1).getName());
		i=1;
		for(CandidateBean c:candidates) {
			System.out.print(i+". ");
			System.out.println(c.toString());
			i++;
		}
		System.out.println("Select candidate name");
		int candidate=sc.nextInt();
		sc.nextLine();
		Voter v=new VoterImpl();
		v.castVote(loginUser.getUserID(),elections.get(election-1).getElectionID(),candidates.get(candidate-1).getCandidateID());		
	}
	
	public void viewResults() {
		
	}
	public void viewCandidatesByElection() {
		AdminUser a=new AdminUser();
		a.viewCandidateByElection();
	}
	public void viewUpcomingElections() {
		ad.viewAllUpcomingElections();
	}
}
