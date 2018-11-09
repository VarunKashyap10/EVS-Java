package com.ntl.evs.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import com.ntl.evs.bean.ApplicationBean;
import com.ntl.evs.bean.ProfileBean;
import com.ntl.evs.dao.ApplicationDAO;
import com.ntl.evs.dao.ProfileDAO;
import com.ntl.evs.dao.impl.ApplicationDaoImpl;
import com.ntl.evs.dao.impl.ProfileDaoImpl;
import com.ntl.evs.service.ElectoralOfficer;

public class ElectoralOfficerImpl implements ElectoralOfficer {
	ApplicationDaoImpl appd;
	
	public ElectoralOfficerImpl(){
		super();
		appd=new ApplicationDaoImpl();
	}
	public ElectoralOfficerImpl(ApplicationDaoImpl a) {
		super();
		this.appd=a;
	}
	public String generateVoterId(String userId, String cons) {
		try {
			ProfileDAO cred = new ProfileDaoImpl();
			ProfileBean user = cred.findById(userId);
			System.out.println(user.toString());
			String vid = user.getFirstName().substring(0, 2);
			vid += cons.substring(0, 2);
			Random rand = new Random();
			int randomSuffix = rand.nextInt(9000);
			randomSuffix += 1000;
			vid += randomSuffix;
			ApplicationBean app=appd.findById(userId);
			app.setPassedStatus(3);
			app.setVoterID(vid);
			app.setApprovedStatus(1);
			appd.updateApplication(app);
			return "SUCCESS";
		}catch(Exception err) {
			//err.printStackTrace();
			System.out.println(err);
			return "ERROR";
		}
	}

	public ArrayList<ApplicationBean> viewAllVoterIdApplications() {
		try {
			//applicationDAO appd=new applicationDaoImpl();
			ArrayList<ApplicationBean> arr=appd.findAll();
			int i=0;
			Iterator<ApplicationBean> arrIterate=arr.iterator();
			while(arrIterate.hasNext()) {
				if(arrIterate.next().getPassedStatus()!=2) {
					arrIterate.remove();
				}
			}
			return arr;
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
}
