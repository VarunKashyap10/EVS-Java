package com.ntl.evs.bean;

public class ApplicationBean {
	private String userID;
	private String constituency;
	private int passedStatus;
	private int approvedStatus;
	private String voterID;
	public ApplicationBean(){
		userID="";
		constituency="";
		passedStatus=0;
		approvedStatus=0;
		voterID="";
	}
	public ApplicationBean(String uid, String cons,int pass,int app) {
		this.userID=uid;
		this.constituency=cons;
		this.passedStatus=pass;
		this.approvedStatus=app;
		this.voterID=null;
	}
	public ApplicationBean(String uid, String cons,int pass,int app,String appid) {
		this.userID=uid;
		this.constituency=cons;
		this.passedStatus=pass;
		this.approvedStatus=app;
		this.voterID=appid;
	}

	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getConstituency() {
		return constituency;
	}
	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}
	public int getPassedStatus() {
		return passedStatus;
	}
	public void setPassedStatus(int passedStatus) {
		this.passedStatus = passedStatus;
	}
	public int getApprovedStatus() {
		return approvedStatus;
	}
	public void setApprovedStatus(int approvedStatus) {
		this.approvedStatus = approvedStatus;
	}
	public String getVoterID() {
		return voterID;
	}
	public void setVoterID(String voterID) {
		this.voterID = voterID;
	}
	@Override
	public String toString() {
		return "Application => UserID - "+this.userID+" | VoterID - "+this.voterID+ " | Constituency - "+this.constituency+ " | PassedStatus - "+this.passedStatus+" | Application Status -"+this.approvedStatus; 
	}

}
