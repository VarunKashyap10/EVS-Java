package com.ntl.evs.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.ntl.evs.bean.CredentialsBean;
import com.ntl.evs.dao.CredentialsDAO;
import com.utl.evs.util.DBUtil;

public class CredentialsDaoImpl implements CredentialsDAO {

	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public CredentialsDaoImpl() {
		super();
		conn=DBUtil.getDBConnection();
	}

	
	public CredentialsDaoImpl(DataSource ds) {
		super();
		try {
			this.conn=ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public CredentialsBean findById(String userId) {
		
		CredentialsBean user=null;//=new CredentialsBean();
		
		try {
			stmt = conn.createStatement( );
			rs = stmt.executeQuery("select * from evs_tbl_user_credentials where userid = '"+userId+"' ;");
			if(rs.next()) {
				user = new CredentialsBean(rs.getString("userid"),rs.getString("password"),rs.getString("userType"),rs.getInt("loginStatus"));
				System.out.println(user.toString());
			}
			else {
				System.out.println("User NOT EXISTING");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception err) {
			err.printStackTrace();
		}

		return user;
	}
	
	public String createCredentials(CredentialsBean credentialsBean) {
		//conn=DBUtil.getDBConnection();
		try {
			stmt = conn.createStatement( );
			System.out.println(credentialsBean.toString());
			int z = stmt.executeUpdate("insert into evs_tbl_user_credentials(userid,password,usertype,loginstatus) values ('"+credentialsBean.getUserID()+"','"+credentialsBean.getPassword()+"','"+credentialsBean.getUserType()+"','"+credentialsBean.getLoginStatus()+"')");
			System.out.println(z);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception err) {
			err.printStackTrace();
		}

		return "U";
	}
	
	public int deleteCredentials(ArrayList<String> credentials) {
		return -1;
	}
	
	public boolean updateCredentials(CredentialsBean credentialsBean) {
		//conn=DBUtil.getDBConnection();
		System.out.println("Updating User"+credentialsBean.toString());
		try {
 			stmt=conn.createStatement();
			System.out.println("Changing login status");
			int z=stmt.executeUpdate("update evs_tbl_user_credentials set loginstatus = '"+credentialsBean.getLoginStatus()+"',password='"+ credentialsBean.getPassword() +"' where userid = '"+credentialsBean.getUserID()+"' ;");
			System.out.println(z);
			return true;
		}
		catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<CredentialsBean> findAll() {
		return null;
	}
}
