package com.ntl.evs.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.ntl.evs.bean.ElectionBean;
import com.ntl.evs.dao.ElectionDAO;
import com.utl.evs.util.DBUtil;

public class ElectionDaoImpl implements ElectionDAO {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	public ElectionDaoImpl() {
		super();
		conn=DBUtil.getDBConnection();
	}
	public ElectionDaoImpl(DataSource ds) {
		super();
		try {
			this.conn=ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public String createElection(ElectionBean electionBean) {
		System.out.println("Create Election");
		try {
			stmt = conn.createStatement( );
			int z = stmt.executeUpdate("insert into evs_tbl_election(electionid,name,electiondate,district,constituency,countingdate) values ('"+electionBean.getElectionID()+"','"+electionBean.getName()+"','"+electionBean.getElectionDate()+"','"+electionBean.getDistrict()+"','"+electionBean.getConstituency()+"','"+electionBean.getCountingDate()+"')");
			System.out.println(z);
			return "SUCCESS";
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception err) {
			err.printStackTrace();
		}

		return "FAIL";
	}
	public int deleteElection(ArrayList<String> elections) {
		
		for(String elecId: elections) {
		try {
			stmt=conn.createStatement();
			int z=stmt.executeUpdate("delete from evs_tbl_election where electionid = '"+elecId+"';");
			return z;
		}catch(Exception err) {
			System.out.println(err);
		}
		
		}
		return 0;
	}
	public boolean updateElection(ElectionBean electionBean) {
		return false;
	}
	public ElectionBean findById(String electionId) {
		ElectionBean elec=new ElectionBean();
		try {
			stmt = conn.createStatement( );
			rs = stmt.executeQuery("select * from evs_tbl_election where electionid = '"+electionId+"' ;");
			if(rs.next()) {
				elec = new ElectionBean(rs.getString("electionid"),rs.getString("name"),rs.getDate("electiondate"),rs.getString("district"),rs.getString("constituency"),rs.getDate("countingdate"));
				System.out.println(elec.toString());
				return elec;
			}
			else {
				System.out.println("query not working");
			}
		}catch(Exception err) {
			System.out.println(err);
		}
		return null;
	}
	public ArrayList<ElectionBean> findAll(){
		ArrayList<ElectionBean> arr=new ArrayList<ElectionBean>();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from evs_tbl_election; ");
			while(rs.next()) {
				arr.add(new ElectionBean(rs.getString("electionid"),rs.getString("name"),rs.getDate("electiondate"),rs.getString("district"),rs.getString("constituency"),rs.getDate("countingdate")));
			}
			return arr;
		}catch(Exception err) {
			System.out.println(err);
		}
		return null;
	}

}
