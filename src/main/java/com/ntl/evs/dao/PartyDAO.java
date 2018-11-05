package com.ntl.evs.dao;

import java.util.ArrayList;

import com.ntl.evs.bean.PartyBean;

public interface PartyDAO {
	String createParty(PartyBean partyBean);
	int deleteParty(ArrayList<String> partys);
	boolean updateParty(PartyBean partyBean);
	PartyBean findById(String party);
	ArrayList<PartyBean> findAll();
}
