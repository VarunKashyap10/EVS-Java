package com.ntl.evs.dao.impl;

import java.util.ArrayList;

import javax.sql.DataSource;

import com.ntl.evs.bean.ResultBean;
import com.ntl.evs.dao.ResultDAO;

public class ResultDaoImpl implements ResultDAO {
	
	public ResultDaoImpl(){
		
	}
	public ResultDaoImpl(DataSource ds){
		
	}

	@Override
	public String createResult(ResultBean resultBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteResult(ArrayList<String> results) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateResult(ResultBean resultBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultBean findById(String result) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ResultBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
