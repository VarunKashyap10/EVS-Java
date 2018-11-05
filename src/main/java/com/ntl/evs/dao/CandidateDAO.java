package com.ntl.evs.dao;

import java.util.ArrayList;

import com.ntl.evs.bean.CandidateBean;

public interface CandidateDAO {
	String createCandidate(CandidateBean candidateBean);
	int deleteCandidate(ArrayList<String> candidates);
	boolean updateCandidate(CandidateBean candidateBean);
	CandidateBean findById(String candidate);
	ArrayList<CandidateBean> findAll();
	ArrayList<CandidateBean> findByElectionName(String election);
}
