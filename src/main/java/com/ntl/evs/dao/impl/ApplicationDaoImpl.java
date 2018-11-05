package com.ntl.evs.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ntl.evs.bean.ApplicationBean;
import com.ntl.evs.bean.ElectionBean;
import com.ntl.evs.bean.PartyBean;
import com.ntl.evs.dao.ApplicationDAO;
import com.utl.evs.util.DBUtil;

public class ApplicationDaoImpl implements ApplicationDAO{
	Connection conn;
	Statement stmt;
	ResultSet rs;
	public ApplicationDaoImpl() {
		conn=DBUtil.getDBConnection();
	}
	public ApplicationDaoImpl(Connection c) {
		this.conn=c;
	}
	public String createApplication(ApplicationBean applicationBean) {
		try {
			System.out.println("Executing Create");
			stmt = conn.createStatement( );
			int z = stmt.executeUpdate("insert into evs_tbl_application (userid,constituency,passedstatus,approvedstatus,voteid) values ('"+applicationBean.getUserID()+"','"+applicationBean.getConstituency()+"','"+applicationBean.getPassedStatus()+"','"+applicationBean.getApprovedStatus()+"','"+applicationBean.getVoterID()+"');");
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
	public int deleteApplication(ArrayList<String> applications) {
		return 0;
	}
	public boolean updateApplication(ApplicationBean applicationBean) {

		System.out.println("Updating User"+applicationBean.toString());
		try {
 			stmt=conn.createStatement();
			System.out.println("Changing login status");
			int z=stmt.executeUpdate("update evs_tbl_application set passedstatus = '"+applicationBean.getPassedStatus()+"' where userid = '"+applicationBean.getUserID()+"' ;");
			System.out.println(z);
			return true;
		}
		catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return false;
	}
	public ApplicationBean findById(String application) {
		ApplicationBean app=null;//=new CredentialsBean();
		//conn=DBUtil.getDBConnection();
		try {
			stmt = conn.createStatement( );
			rs = stmt.executeQuery("select * from evs_tbl_application where userid = '"+application+"' ;");
			if(rs.next()) {
				app = new ApplicationBean(rs.getString("userid"),rs.getString("constituency"),rs.getInt("passedstatus"),rs.getInt("approvedstatus"),rs.getString("voteid"));
				System.out.println(app.toString());
			}
			else {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception err) {
			err.printStackTrace();
		}

		return app;
		}
	public ArrayList<ApplicationBean> findAll(){
		ArrayList<ApplicationBean> arr=new ArrayList<ApplicationBean>();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from evs_tbl_application; ");
			while(rs.next()) {
				arr.add(new ApplicationBean(rs.getString("userid"),rs.getString("constituency"),rs.getInt("passedstatus"),rs.getInt("approvedstatus"),rs.getString("voteid")));
			}
			return arr;
		}catch(Exception err) {
			System.out.println(err);
		}
		return null;
		}
}
