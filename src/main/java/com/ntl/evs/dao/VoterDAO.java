package com.ntl.evs.dao;

public interface VoterDAO {
	String addVoter(String candidateid,String electionid,String voterid);

	boolean checkVoterValidity(String voterid);
	
}
