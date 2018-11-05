package com.ntl.evs.service;

import java.util.ArrayList;

import com.ntl.evs.bean.CandidateBean;
import com.ntl.evs.bean.ElectionBean;
import com.ntl.evs.bean.ResultBean;

public interface Voter {
	
	String castVote(String userId, String electionId, String candidateId);//return 'success','fail','error'
	ArrayList<CandidateBean> viewCandidatesByElectionName(String electionName,String constituency);
	ArrayList<ResultBean> viewListOfElectionsResults();
	String requestVoterId(String userId);
	String viewGeneratedVoterId(String userId, String constituency);
	ArrayList<ElectionBean> viewListOfElections();

}
