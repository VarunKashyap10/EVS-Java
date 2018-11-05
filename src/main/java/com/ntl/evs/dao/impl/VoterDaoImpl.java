package com.ntl.evs.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ntl.evs.dao.VoterDAO;
import com.utl.evs.util.DBUtil;

public class VoterDaoImpl implements VoterDAO {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	public String addVoter(String candidateid,String electionid,String voterid) {
		conn=DBUtil.getDBConnection();
		try {
			stmt = conn.createStatement( );
			int z = stmt.executeUpdate("insert into evs_tbl_voter_details(candidateid,electionid,voteid) values ('"+candidateid+"','"+electionid+"','"+voterid+"');");
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
	
	public boolean checkVoterValidity(String voterid) {
		conn=DBUtil.getDBConnection();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from evs_tbl_voter_details where voteid ='"+voterid+"';");
			if(!rs.next()) {
				return true;
			}
			else return false;
		}
		catch(Exception err) {
			System.out.println(err);
			err.printStackTrace();
		}
		return false;
	}
	
}
