package com.ntl.evs.dao;

import java.util.ArrayList;

import com.ntl.evs.bean.ApplicationBean;

public interface ApplicationDAO {
	
	String createApplication(ApplicationBean applicationBean);
	int deleteApplication(ArrayList<String> applications);
	boolean updateApplication(ApplicationBean applicationBean);
	ApplicationBean findById(String application);
	ArrayList<ApplicationBean> findAll();
	
}
