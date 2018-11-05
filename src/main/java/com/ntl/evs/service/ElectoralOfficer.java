package com.ntl.evs.service;

import java.util.ArrayList;

import com.ntl.evs.bean.ApplicationBean;

public interface ElectoralOfficer {
	
	String generateVoterId(String userId, String constituency);
	ArrayList<ApplicationBean> viewAllVoterIdApplications();
	
}
