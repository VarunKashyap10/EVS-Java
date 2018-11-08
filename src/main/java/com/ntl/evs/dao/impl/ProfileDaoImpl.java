package com.ntl.evs.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.ntl.evs.bean.ProfileBean;
import com.ntl.evs.dao.ProfileDAO;
import com.utl.evs.util.DBUtil;

public class ProfileDaoImpl implements ProfileDAO {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public ProfileDaoImpl() {
		conn=DBUtil.getDBConnection();

	}
	public ProfileDaoImpl(DataSource ds) {
		try {
			this.conn=ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String createProfile(ProfileBean profileBean) {
		try {
			stmt = conn.createStatement( );
			int z = stmt.executeUpdate("insert into evs_tbl_user_profile(userid,firstname,lastname,dateofbirth,gender,street,location,city,state,pincode,mobileno,emailid) values ('"+profileBean.getUserID()+"','"+profileBean.getFirstName()+"','"+profileBean.getLastName()+"','"+profileBean.getDateOfBirth() +"','"+profileBean.getGender()+"','"+profileBean.getStreet()+"','"+profileBean.getLocation()+"','"+profileBean.getCity()+"','"+profileBean.getState()+"','"+profileBean.getPincode()+"','"+profileBean.getMobileNo()+"','"+profileBean.getEmailID()+"');");
			System.out.println(z);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception err) {
			err.printStackTrace();
		}

		return "U";
	}
	public int deleteProfile(ArrayList<String> profiles) {
		return -1;
	}
	public boolean updateProfile(ProfileBean rofileBean) {
		return false;
	}
	public ProfileBean findById(String userid) {
		ProfileBean pro=new ProfileBean();
		try {
			stmt = conn.createStatement( );
			rs = stmt.executeQuery("select * from evs_tbl_user_profile where userid = '"+userid+"' ;");
			if(rs.next()) {
				pro = new ProfileBean(rs.getString("userid"),rs.getString("firstname"),rs.getString("lastname"),rs.getDate("dateofbirth"),rs.getString("gender"),rs.getString("street"),rs.getString("location"),rs.getString("city"),rs.getString("state"),rs.getString("pincode"),rs.getString("mobileno"),rs.getString("emailid"));
				System.out.println(pro.toString());
			}
			return pro;
		}catch(Exception err) {
			System.out.println(err);
		}
		return null;
	}
	public ArrayList<ProfileBean> findAll(){
		return null;
	}
}
