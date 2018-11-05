package com.ntl.evs.dao;

import java.util.ArrayList;

import com.ntl.evs.bean.EOBean;

public interface EoDAO {
	String createEO(EOBean eoBean);
	int deleteEO(ArrayList<String> eos);
	boolean updateEO(EOBean eoBean);
	EOBean findById(String eo);
	ArrayList<EOBean> findAll();
}
