package com.ntl.evs.dao;


import java.util.ArrayList;

import com.ntl.evs.bean.CredentialsBean;



public interface CredentialsDAO {

	String createCredentials(CredentialsBean credentialsBean) ;
	int deleteCredentials(ArrayList<String> credentials) ;
	boolean updateCredentials(CredentialsBean credentialsBean);
	CredentialsBean findById(String userId);
	ArrayList<CredentialsBean> findAll();
}
