package com.ntl.evs.bean;

import java.util.Random;

public class PartyBean {

	private String partyID;
	private String name;
	private String leader;
	private String symbol;
	public PartyBean() {
		partyID="";
		name="";
		leader="";
		symbol="";
	}
	public PartyBean(String name,String leader,String symbol) {
		this.partyID=generatePartyID(name);
		this.name=name;
		this.leader=leader;
		this.symbol=symbol;
	}
	public PartyBean(String pid,String name,String leader,String symbol) {
		this.partyID=pid;
		this.name=name;
		this.leader=leader;
		this.symbol=symbol;
	}
	String generatePartyID(String name) {
		String uid=name.substring(0,2);
		Random rand=new Random();
		int randomSuffix=rand.nextInt(9000);
		randomSuffix+=1000;
		uid+=randomSuffix;
		return uid;
	}
	public String getPartyID() {
		return partyID;
	}
	public void setPartyID(String partyID) {
		this.partyID = partyID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	@Override
	public String toString() {
		return "Party -> PartyID -"+this.getPartyID()+" | Name - "+this.getName()+" | Leader - "+this.getLeader()+" | Symbol - "+this.getSymbol();
	}
}
