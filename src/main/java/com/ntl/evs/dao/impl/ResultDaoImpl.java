package com.ntl.evs.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.ntl.evs.bean.PartyBean;
import com.ntl.evs.bean.ResultBean;
import com.ntl.evs.dao.ResultDAO;
import com.utl.evs.util.DBUtil;

public class ResultDaoImpl implements ResultDAO {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	public ResultDaoImpl(){
		conn=DBUtil.getDBConnection();

	}
	public ResultDaoImpl(DataSource ds){
		try {
			this.conn=ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String createResult(ResultBean resultBean) {
		// TODO Auto-generated method stub
		try {
			stmt = conn.createStatement( );
			int z = stmt.executeUpdate("insert into evs_tbl_result(electionid, candidateid, votecount) values ('"+resultBean.getElectionID()+"','"+resultBean.getCandidateID()+"','"+resultBean.getVoteCount()+"');");
			System.out.println(z);
			return "SUCCESS";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception err) {
			err.printStackTrace();
		}

		return "FAIL";
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
	
	public ResultBean getVoteCount(String eleid,String candid) {
		ResultBean result=null;
		try {
			stmt = conn.createStatement( );
			rs = stmt.executeQuery("select * from evs_tbl_result where electionid = '"+eleid+"' and candidateid='"+candid+"' ;");
			if(rs.next()) {
				//part = new PartyBean(rs.getString("partyid"),rs.getString("name"),rs.getString("leader"),rs.getString("symbol"));
				result=new ResultBean(rs.getInt("serialno"),rs.getString("electionid"),rs.getString("candidateid"),rs.getInt("votecount"));
				System.out.println(result.toString());
			}
			else {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception err) {
			err.printStackTrace();
		}

		return result;
	}

}
