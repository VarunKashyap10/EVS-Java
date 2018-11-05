package com.ntl.evs.client;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.ntl.evs.bean.ApplicationBean;
import com.ntl.evs.bean.CandidateBean;
import com.ntl.evs.bean.CredentialsBean;
import com.ntl.evs.bean.ElectionBean;
import com.ntl.evs.bean.PartyBean;
import com.ntl.evs.dao.ElectionDAO;
import com.ntl.evs.dao.impl.ElectionDaoImpl;
import com.ntl.evs.service.Administrator;
import com.ntl.evs.service.impl.AdministratorImpl;
import com.utl.evs.util.User;

public class AdminUser {
	static CredentialsBean currentUser;
	Scanner sc = new Scanner(System.in);
	Administrator ad=new AdministratorImpl();
	public AdminUser() {
		
	}
	public AdminUser(CredentialsBean user){
		currentUser=user;
	}
	public void display() {
		System.out.println( currentUser.toString());
		System.out.println("Welcome"+currentUser.getUserID());
		boolean flag=true;
		while(flag) {
			showMessages();
			int x=sc.nextInt();
			sc.nextLine();
			flag=evaluateOptions(x);
			
		}
		
		System.out.println("Thank You. Goodbye!");
	}
	boolean evaluateOptions(int x) {
		switch(x) {
		case 1:
			return !logout();
		case 2:
			createElection();
			return true;
		case 3:
			viewElection();
			return true;
		case 4:
			deleteElections();
			return true;
		case 5:
			viewUpcomingElections();
			return true;
		case 6:
			addCandidate();
			return true;
		case 7:
			viewCandidateByElection();
			return true;
		case 8:
			if(viewPendingRequests())
					System.out.println("Successful");
			return true;
		case 9:
			addParty();
			return true;
		case 10:
			viewPartyByName();
			return true;
		case 11:
			return true;
		case 12:
			NormalUser nu=new NormalUser();
			if(nu.changePassword(currentUser))
				System.out.println("Password Changes successfully");
			else
				System.out.println("Unsuccessful");
			return true;
		default:
			return true;
		}
	}
	
	void showMessages() {
		System.out.println("1. Logout");
		System.out.println("2. Create Election");
		System.out.println("3. View All Elections");
		System.out.println("4. Delete Elections");
		System.out.println("5. View Upcoming Elections");
		System.out.println("6. Add Candidate");
		System.out.println("7. View Candidates in election.");
		System.out.println("8. View Pending Requests.");
		System.out.println("9. Add Party");
		System.out.println("10. View Party Details");
		System.out.println("11. Approve and declare results");
		System.out.println("12. Change password");
	}
	
	boolean logout() {
		User u=new User();
		System.out.println("Successfully logged admin out.");
		return u.logout(currentUser.getUserID());
	}
	
	void createElection() {
		System.out.println("Enter Details of Election.");
		System.out.println("Enter Name : ");
		String name=sc.nextLine();
		System.out.println("Enter Date : ");
		String doe=sc.nextLine();
		System.out.println("Enter District : ");
		String district=sc.nextLine();
		System.out.println("Enter Constituency : ");
		String cons=sc.nextLine();
		System.out.println("Enter Counting Date :");
		String coe=sc.nextLine();
		String[] doee=doe.split("/",3);
		String[] coee=coe.split("/",3);
		Date doe1=Date.valueOf(LocalDate.of(Integer.parseInt(doee[0]),Integer.parseInt(doee[1]),Integer.parseInt(doee[2])));
		Date coe1=Date.valueOf(LocalDate.of(Integer.parseInt(coee[0]),Integer.parseInt(coee[1]),Integer.parseInt(coee[2])));
		ElectionBean election=new ElectionBean(name,doe1,district,cons,coe1);
		System.out.println(election.toString());
		ad.addElection(election);

	}
	void addCandidate() {
		System.out.println("Enter Candidate Details");
		//	public CandidateBean(String name, String eleId,String  partyId, String dist,String cons, 
		//  Date dob,String mobile,String address,String email) {

		boolean flag=true;
		while(flag) {
		try {
		System.out.println("Name : ");
		String name=sc.nextLine();
		System.out.println("ElectionID : ");
		String eid=sc.next();
		sc.nextLine();
		System.out.println("PartyID : ");
		String pid=sc.next();
		sc.nextLine();
		System.out.println("District : ");
		String dist=sc.nextLine();
		System.out.println("Constituency : ");
		String constituency=sc.nextLine();
		System.out.println("Date of Birth : (Format - yyyy/mm/dd )");
		String dob=sc.nextLine();
		System.out.println("Mobile No : ");
		String mobile=sc.nextLine();
		System.out.println("Address : ");
		String address=sc.nextLine();
		System.out.println("Email ID :");
		String email=sc.nextLine();
		String[] doba=dob.split("/",3);
		Date dob1=Date.valueOf(LocalDate.of(Integer.parseInt(doba[0]),Integer.parseInt(doba[1]), Integer.parseInt(doba[2])));
		CandidateBean candid=new CandidateBean(name,eid,pid,dist,constituency,dob1,mobile,address,email);
		ad.addCandidate(candid);
		flag=false;
		}catch(Exception err) {
			System.out.println(err);
			System.out.println("Error in the entered details. Please try again..");
		}
		}

	}
	void  viewElection() {
		ArrayList<ElectionBean> arr=ad.viewElections();
		int i=0;
		for(ElectionBean e:arr) {
			i++;
			System.out.print(i+". ");
			System.out.println(e.toString());
		}
	}
	
	void viewUpcomingElections() {
		ArrayList<ElectionBean> arr=ad.viewAllUpcomingElections();
		int i=0;
		for(ElectionBean e:arr) {
			i++;
			System.out.print(i+". ");
			System.out.println(e.toString());
		}
	}
	void addParty(){
		System.out.println("Enter party details");
		System.out.println("Enter party name");
		String name=sc.nextLine();
		System.out.println("Leader name");
		String leader=sc.nextLine();
		System.out.println("Enter Symbol name");
		String symbol=sc.nextLine();
		PartyBean partyBean=new PartyBean(name,leader,symbol);
		ad.addParty(partyBean);
	}
	void deleteElections() {
		System.out.println("Select election ids followed by commas");
		ElectionDAO ele=new ElectionDaoImpl();
		ArrayList<ElectionBean> arr=ele.findAll();
		int i=0;
		for(ElectionBean e:arr) {
			i++;
			System.out.print(i+". ");
			System.out.println(e.toString());
		}
		String x=sc.nextLine();
		String[] elections=x.split(",");
		ArrayList<String> electionIDs=new ArrayList<String>();
		for(int j=0;j<elections.length;j++) {
			electionIDs.add(elections[j].trim());
		}
		int temp=ele.deleteElection(electionIDs);
		System.out.println(temp);
	}
	
	public void viewCandidateByElection() {
		try {
			System.out.println("Enter Name of Election");
			String electionName=sc.nextLine();
			ArrayList<CandidateBean>arr=ad.viewCandidateDetailsByElectionName(electionName);
			if(arr!=null) {
			System.out.println("Candidates registerered for election- "+electionName+" are-");
			for(CandidateBean candid:arr) {
				System.out.println(candid.toString());
			}
			}
			else {
				System.out.println("NONE");
				System.out.println("No Candidates Registered");
			}
			
		}catch(Exception err) {
			System.out.println("NONE");
			System.out.println("No Candidates Registered");
			err.printStackTrace();
		}
		
	}

	boolean viewPendingRequests() {
		try {
		System.out.println("Showing pending requests");
		ArrayList<ApplicationBean> arr=ad.viewAllAdminPendingApplications();
		int i=1;
		for (ApplicationBean a:arr) {
			System.out.println(i+". "+a.toString());
			i++;
		}
		System.out.println("Enter index of Application to approve.");
		System.out.println("Enter 0 to quit");
		int x=sc.nextInt();
		if(x==0 || x>i)
			return false;
		else 
			return ad.forwardVoterIDRequest(arr.get(x-1).getUserID());
		
			//return true;
		}catch(NullPointerException err) {
			err.printStackTrace();
			System.out.println("No pending requests.");
			return false;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error");
			return false;
		}
	}	

	
	void viewPartyByName() {
		System.out.println("Enter name of party");
		String party=sc.nextLine();
		ad.viewAllParty();
	}
		
}
