package com.ntl.evs.bean;

import java.util.Date;
import java.util.Random;

public class CandidateBean {
	private String candidateID;
	private String name;
	private String electionID;
	private String partyID;
	private String district;
	private String constituency;
	private Date dateOfBirth;
	private String mobileNo;
	private String address;
	private String emailID;
	public CandidateBean() {
		
	}
	public CandidateBean(String name,String eleId,String partyId,String dist,String cons,Date dob,String mobile,String address,String email) {
		this.candidateID=generateCandidateID(name);
		this.name=name;
		this.electionID=eleId;
		this.partyID=partyId;
		this.district=dist;
		this.constituency=cons;
		this.dateOfBirth=dob;
		this.mobileNo=mobile;
		this.address=address;
		this.emailID=email;
	}
	public CandidateBean(String cid,String name,String eleId,String partyId,String dist,String cons,Date dob,String mobile,String address,String email) {
		this.candidateID=cid;
		this.name=name;
		this.electionID=eleId;
		this.partyID=partyId;
		this.district=dist;
		this.constituency=cons;
		this.dateOfBirth=dob;
		this.mobileNo=mobile;
		this.address=address;
		this.emailID=email;
	}
	String generateCandidateID(String name) {
		String uid=name.substring(0,2);
		Random rand=new Random();
		int randomSuffix=rand.nextInt(9000);
		randomSuffix+=1000;
		uid+=randomSuffix;
		return uid;
	}
	public String getCandidateID() {
		return candidateID;
	}
	public void setCandidateID(String candidateID) {
		this.candidateID = candidateID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getElectionID() {
		return electionID;
	}
	public void setElectionID(String electionID) {
		this.electionID = electionID;
	}
	public String getPartyID() {
		return partyID;
	}
	public void setPartyID(String partyID) {
		this.partyID = partyID;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getConstituency() {
		return constituency;
	}
	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	@Override
	public String toString() {
		return "Candidate => Name- "+this.name+" | CandidateID - "+this.candidateID+" | ElectionID - "+this.electionID + " | PartyID"+this.partyID + " | DOB -"+this.dateOfBirth;
	}
}
