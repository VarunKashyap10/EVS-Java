package com.ntl.evs.dao;

import java.util.ArrayList;

import com.ntl.evs.bean.ResultBean;

public interface ResultDAO {
	
	String createResult(ResultBean resultBean);
	int deleteResult(ArrayList<String> results);
	boolean updateResult(ResultBean resultBean);
	ResultBean findById(String result);
	ArrayList<ResultBean> findAll();
	ResultBean getVoteCount(String eleid,String candid);

}
