package com.ntl.evs.service;

import java.util.ArrayList;
import java.util.Map;

import com.ntl.evs.bean.ApplicationBean;
import com.ntl.evs.bean.CandidateBean;
import com.ntl.evs.bean.ElectionBean;
import com.ntl.evs.bean.PartyBean;

public interface Administrator {
	
	String addElection(ElectionBean electionBean);
	ArrayList<ElectionBean> viewAllUpcomingElections();
	ArrayList<ElectionBean> viewElections();
	String addParty(PartyBean partyBean);
	ArrayList<PartyBean> viewAllParty();
	String addCandidate(CandidateBean candidateBean);
	ArrayList<CandidateBean> viewCandidateDetailsByElectionName(String electionName);
	ArrayList<ApplicationBean> viewAllAdminPendingApplications();
	boolean forwardVoterIDRequest(String userId);
	ArrayList<CandidateBean> viewCandidateDetailsByParty(String partyId);
	Map approveElectionResults(String electionId);	
	
}
