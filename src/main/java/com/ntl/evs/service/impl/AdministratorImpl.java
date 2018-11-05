package com.ntl.evs.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import com.ntl.evs.bean.ApplicationBean;
import com.ntl.evs.bean.CandidateBean;
import com.ntl.evs.bean.ElectionBean;
import com.ntl.evs.bean.PartyBean;
import com.ntl.evs.dao.ApplicationDAO;
import com.ntl.evs.dao.CandidateDAO;
import com.ntl.evs.dao.ElectionDAO;
import com.ntl.evs.dao.PartyDAO;
import com.ntl.evs.dao.impl.ApplicationDaoImpl;
import com.ntl.evs.dao.impl.CandidateDaoImpl;
import com.ntl.evs.dao.impl.ElectionDaoImpl;
import com.ntl.evs.dao.impl.PartyDaoImpl;
import com.ntl.evs.service.Administrator;

public class AdministratorImpl implements Administrator{
	
	ElectionDAO elec;
	PartyDAO par;
	CandidateDAO cand;
	ApplicationDAO appd;
	
	public AdministratorImpl() {
		super();
		elec=new ElectionDaoImpl();
		par=new PartyDaoImpl();
		cand=new CandidateDaoImpl();
		appd=new ApplicationDaoImpl();
	}
	
	public AdministratorImpl(ElectionDaoImpl e,CandidateDaoImpl c,ApplicationDaoImpl a,PartyDaoImpl p) {
		super();
		this.elec=e;
		this.par=p;
		this.cand=c;
		this.appd=a;
	}
	
	
	public String addElection(ElectionBean electionBean) {
		try {
		//electionDAO elec=new electionDaoImpl();
		if(elec.createElection(electionBean).equals("SUCCESS")) {
			return "SUCCESS";
		}
		else {
			return "FAIL";
		}
		}catch(Exception err) {
			System.out.println(err);
		}
		return "ERROR";
		
	}
	public ArrayList<ElectionBean> viewAllUpcomingElections(){
		try {
			System.out.println("View Upcoming Elections");
			//electionDAO ele=new electionDaoImpl();
			ArrayList<ElectionBean> arr=elec.findAll();
			Iterator<ElectionBean> arrIterate=arr.iterator();
			Date curr=new Date();
			while(arrIterate.hasNext()) {
				if(arrIterate.next().getElectionDate().compareTo(curr)<0) {
					arrIterate.remove();
				}
			}
			/*
			int i=0;
			for(ElectionBean e:arr) {
				System.out.println(e.getElectionDate());
				Date curr=new Date();
				int test=e.getElectionDate().compareTo(curr);
				System.out.println(test);
				if(test>0) {
					arr.remove(i);
				}
				i++;
			}
			*/
			return arr;			
		}catch(Exception err) {
			err.printStackTrace();
			return null;
		}
		
	}
	public ArrayList<ElectionBean> viewElections(){
		System.out.println("View All Elections ---> ");
		//electionDAO ele=new electionDaoImpl();
		ArrayList<ElectionBean> arr=elec.findAll();

		return arr;
		
	}
	  
	public String addParty(PartyBean partyBean) {
		System.out.println("Adding Party");
		//partyDAO par=new partyDaoImpl();
		return par.createParty(partyBean);
		
	}
	
	
	public ArrayList<PartyBean> viewAllParty(){
		System.out.println("Showing all Partys");
		//partyDAO par=new partyDaoImpl();
		return par.findAll();
		
	}
	
	public String addCandidate(CandidateBean candidateBean) {
		try {
		//candidateDAO cre=new  candidateDaoImpl();
		System.out.println("Creating candidate");
		String str=cand.createCandidate(candidateBean);
		if(str.equals("SUCCESS")) {
			return "SUCCESS";
		}
		else return "FAIL";
		}catch(Exception err) {
			System.out.println(err);
		}
		return "ERROR";	
	}
	
	public ArrayList<CandidateBean> viewCandidateDetailsByElectionName(String electionName){
		try {
			//candidateDAO cre=new candidateDaoImpl();
			//electionDAO elec=new electionDaoImpl();
			ArrayList<CandidateBean> arr=cand.findByElectionName(electionName);
			/*
			Iterator<CandidateBean> arrIterate=arr.iterator();
			//int i=0;
			while(arrIterate.hasNext()) {
				//System.out.println();
				CandidateBean c=arrIterate.next();
				System.out.println(c.toString());
				ElectionBean currentElection=elec.findById(c.getElectionID());
				System.out.println(currentElection.toString());
				if(!currentElection.getName().equals(electionName)) {
					arrIterate.remove();
				}
						
			}
			*/
			/*
			for(CandidateBean candid:arr) {
				ElectionBean currentElection=elec.findById(candid.getElectionID());
				if(!currentElection.getName().equals(electionName)) {
					arr.remove(i);
				}
				i++;
				
			}
			*/
			return arr;
		}catch(Exception err) {
			System.out.println(err);
		}
		
		return null;
		
	}
	public ArrayList<ApplicationBean> viewAllAdminPendingApplications(){
		//applicationDAO appd=new applicationDaoImpl();
		ArrayList<ApplicationBean> appList=appd.findAll();
		Iterator<ApplicationBean> appListIterate=appList.iterator();
		while(appListIterate.hasNext()) {
			if(appListIterate.next().getPassedStatus()!=1) {
				appListIterate.remove();
			}
		}
		
		return appList;
		
	}
	public boolean forwardVoterIDRequest(String userId) {
		//applicationDAO appd=new applicationDaoImpl();
		ApplicationBean app=appd.findById(userId);
		if(app.getPassedStatus()==1) {
			app.setPassedStatus(2);
			appd.updateApplication(app);
			return true;
		}
		return false;
		
	}
	public ArrayList<CandidateBean> viewCandidateDetailsByParty(String partyId){
		//candidateDAO candid=new candidateDaoImpl();
		ArrayList<CandidateBean> arr=cand.findAll();
		int i=0;
		for(CandidateBean c:arr) {
			if(!c.getPartyID().equals(partyId)) {
				arr.remove(i);
			}
			i++;
		}
		return arr;
		
	}
	public Map approveElectionResults(String electionId) {
		return null;
		
	}

}
