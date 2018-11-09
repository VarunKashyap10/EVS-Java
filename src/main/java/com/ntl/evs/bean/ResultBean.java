package com.ntl.evs.bean;

public class ResultBean {
	int resultNo;
	String electionID;
	String candidateID;
	int voteCount;

	public ResultBean() {
		super();
		// TODO Auto-generated constructor stub
	}	
	public ResultBean( String electionID, String candidateID, int voteCount) {
		super();
		this.resultNo = -1;
		this.electionID = electionID;
		this.candidateID = candidateID;
		this.voteCount = voteCount;
	}
	
	public ResultBean(int resultNo, String electionID, String candidateID, int voteCount) {
		super();
		this.resultNo = resultNo;
		this.electionID = electionID;
		this.candidateID = candidateID;
		this.voteCount = voteCount;
	}
	public int getResultNo() {
		return resultNo;
	}
	public void setResultNo(int resultNo) {
		this.resultNo = resultNo;
	}
	public String getElectionID() {
		return electionID;
	}
	public void setElectionID(String electionID) {
		this.electionID = electionID;
	}
	public String getCandidateID() {
		return candidateID;
	}
	public void setCandidateID(String candidateID) {
		this.candidateID = candidateID;
	}
	public int getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
