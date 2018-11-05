package com.ntl.evs.dao;

import java.util.ArrayList;

import com.ntl.evs.bean.ElectionBean;

public interface ElectionDAO {
	String createElection(ElectionBean electionBean);
	int deleteElection(ArrayList<String> elections);
	boolean updateElection(ElectionBean electionBean);
	ElectionBean findById(String election);
	ArrayList<ElectionBean> findAll();
}
