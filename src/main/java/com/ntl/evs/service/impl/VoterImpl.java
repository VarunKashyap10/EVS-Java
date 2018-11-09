package com.ntl.evs.service.impl;

import java.util.ArrayList;

import com.ntl.evs.bean.ApplicationBean;
import com.ntl.evs.bean.CandidateBean;
import com.ntl.evs.bean.ElectionBean;
import com.ntl.evs.bean.ResultBean;
import com.ntl.evs.dao.ApplicationDAO;
import com.ntl.evs.dao.CandidateDAO;
import com.ntl.evs.dao.ElectionDAO;
import com.ntl.evs.dao.ResultDAO;
import com.ntl.evs.dao.VoterDAO;
import com.ntl.evs.dao.impl.ApplicationDaoImpl;
import com.ntl.evs.dao.impl.CandidateDaoImpl;
import com.ntl.evs.dao.impl.ElectionDaoImpl;
import com.ntl.evs.dao.impl.ResultDaoImpl;
import com.ntl.evs.dao.impl.VoterDaoImpl;
import com.ntl.evs.service.Voter;

public class VoterImpl implements Voter{
	public String castVote(String userId, String electionId, String candidateId) {
		ApplicationDAO appd=new ApplicationDaoImpl();
		ApplicationBean app=appd.findById(userId);
		VoterDAO v=new VoterDaoImpl();
		if(v.checkVoterValidity(app.getVoterID())) {
			String str=v.addVoter(candidateId, electionId,app.getVoterID());
			switch(str) {
			case "SUCCESS":
				ResultDAO r=new ResultDaoImpl();
				int votes=r.getVoteCount(electionId,candidateId).getVoteCount();
				return r.createResult(new ResultBean(electionId,candidateId,(votes+1)));
				
			case "FAIL":
				return "FAIL";
			}
		}
		else {
			return "ALREADY CAST";
		}
		return "FAIL";
	}
	public ArrayList<CandidateBean> viewCandidatesByElectionName(String electionName,String constituency) {
		CandidateDAO candid=new CandidateDaoImpl();
		ElectionDAO elec=new ElectionDaoImpl();
		ArrayList<ElectionBean> arr=elec.findAll();
		ArrayList<CandidateBean> candidates=candid.findAll();
		ArrayList<CandidateBean> result=new ArrayList<CandidateBean>();
		for(ElectionBean e:arr) {
			if(e.getName().equals(electionName)) {
				for(CandidateBean c:candidates) {
					if(c.getElectionID().equals(e.getElectionID()) && c.getConstituency().equals(constituency)) {
						result.add(c);
					}
				}
			}
		}
		return result;
	}
	public ArrayList<ResultBean> viewListOfElectionsResults(){
		return null;
	}
	public String requestVoterId(String userId) {
		ApplicationDAO appd=new ApplicationDaoImpl();
		ApplicationBean app=appd.findById(userId);
		//System.out.println(app.toString());
		if(app.getPassedStatus()==1) {
			app.setPassedStatus(2);
			//System.out.println(app.toString());
			appd.updateApplication(app);
		}
		else 
			System.out.println("Application Error");
		return null;
	}
	public String viewGeneratedVoterId(String userId, String constituency) {
		ApplicationDAO appd=new ApplicationDaoImpl();
		ApplicationBean app=appd.findById(userId);
		if(app.getApprovedStatus()==3) {
			return app.getVoterID();
		}
		return null;
	}
	public ArrayList<ElectionBean> viewListOfElections(){
		ElectionDAO elec=new ElectionDaoImpl();
		ArrayList<ElectionBean> arr=elec.findAll();
		return arr;
	}
}
