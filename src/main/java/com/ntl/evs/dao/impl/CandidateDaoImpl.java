package com.ntl.evs.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.ntl.evs.bean.CandidateBean;
import com.ntl.evs.dao.CandidateDAO;
import com.utl.evs.util.DBUtil;

public class CandidateDaoImpl implements CandidateDAO {
	Connection  conn;
	Statement stmt;
	ResultSet rs;
	public CandidateDaoImpl(){
		conn=DBUtil.getDBConnection();
	}
	public CandidateDaoImpl(DataSource ds) {
		try {
			this.conn=ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String createCandidate(CandidateBean candidateBean) {
		//conn=DBUtil.getDBConnection();
		try {
			System.out.println("Executing Create");
			stmt = conn.createStatement( );
			int z = stmt.executeUpdate("insert into evs_tbl_candidate(candidateid,name,electionid,partyid,district,constituency,dateofbirth,mobileno,address,emailid) values ('"+candidateBean.getCandidateID()+"','"+candidateBean.getName()+"','"+candidateBean.getElectionID()+"','"+candidateBean.getPartyID()+"','"+candidateBean.getDistrict()+"','"+candidateBean.getConstituency()+"','"+candidateBean.getDateOfBirth()+"','"+candidateBean.getMobileNo()+"','"+candidateBean.getAddress()+"','"+candidateBean.getEmailID()+"');");
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
	public int deleteCandidate(ArrayList<String> candidates) {
		return 0;
		
	}
	public boolean updateCandidate(CandidateBean candidateBean) {
		return false;
		
	}
	public CandidateBean findById(String candidate) {
		return null;
		
	}
	//(String name, String eleId,String  partyId, String dist,String cons, Date dob,String mobile,String address,String email
	public ArrayList<CandidateBean> findAll(){
		//conn=DBUtil.getDBConnection();
		ArrayList<CandidateBean> arr=new ArrayList<CandidateBean>();
		try {
			System.out.println("fetching candidates");
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from evs_tbl_candidate; ");
			//	public CandidateBean(String cid,String name, String eleId,String  partyId, String dist,String cons, Date dob,String mobile,String address,String email)
			while(rs.next()) {
				arr.add(new CandidateBean(rs.getString("candidateid"),rs.getString("name"),rs.getString("electionid"),rs.getString("partyid"),rs.getString("district"),rs.getString("constituency"),rs.getDate("dateofbirth"),rs.getString("mobileno"),rs.getString("address"),rs.getString("emailid")));
				
			}
			return arr;
		}catch(Exception err) {
			System.out.println(err);
		}
		return null;
		
	}
	
	public ArrayList<CandidateBean> findByElectionName(String election){
		try {
			ArrayList<CandidateBean> arr=new ArrayList<CandidateBean>();
			System.out.println("Fetching by election");
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from evs_tbl_candidate as c, evs_tbl_election as e where c.electionid=e.electionid and e.name='"+election+"';");
			while(rs.next()) {
				arr.add(new CandidateBean(rs.getString("candidateid"),rs.getString("name"),rs.getString("electionid"),rs.getString("partyid"),rs.getString("district"),rs.getString("constituency"),rs.getDate("dateofbirth"),rs.getString("mobileno"),rs.getString("address"),rs.getString("emailid")));
			}
			return arr;
		}catch(Exception err) {
			err.printStackTrace();
			return null;
		}
	}

}
