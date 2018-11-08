package com.ntl.EVS.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;

import com.ntl.evs.bean.ProfileBean;
import com.ntl.evs.dao.impl.ProfileDaoImpl;

public class ProfileDaoImplTest {
	DataSource ds=mock(DataSource.class);
    Connection mockConn=mock(Connection.class);
    Statement mockCreateStmt=mock(Statement.class);
    ResultSet mockResultSet=mock(ResultSet.class);
    //ProfileBean(String uid,String fname, String lname,String gend,Date dob,String city,String location,String street,String state,String pin,String mobile,String email ){

    ProfileBean pro=new ProfileBean("VK0000","Varun","Kashyap","male",Date.valueOf("1997-03-30"),"Hyderabad","Hyde","Chengicherla","Telangana","500076","9999999999","kvarun10@gmail.com","");
    @Before
    public void setUp() throws SQLException {
    	when(ds.getConnection()).thenReturn(mockConn);
        when(mockConn.createStatement()).thenReturn(mockCreateStmt);
        when(mockCreateStmt.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockCreateStmt.executeUpdate(anyString())).thenReturn(1);
        when(mockResultSet.next()).thenReturn(Boolean.TRUE,Boolean.FALSE);
        //pro = new ProfileBean(rs.getString("userid"),rs.getString("firstname"),rs.getString("lastname"),
        //rs.getDate("dateofbirth"),rs.getString("gender"),rs.getString("street"),rs.getString("location"),
        //rs.getString("city"),rs.getString("state"),rs.getString("pincode"),rs.getString("mobileno"),
        //rs.getString("emailid"));
        when(mockResultSet.getString("userid")).thenReturn("VK0000");
        when(mockResultSet.getString("firstname")).thenReturn("Varun");
        when(mockResultSet.getString("lastname")).thenReturn("Kashyap");
        when(mockResultSet.getDate("dateofbirth")).thenReturn(Date.valueOf("1997-03-30"));

    }
    
    @Test
    public void createProfileTest() {
    	ProfileDaoImpl p=new ProfileDaoImpl(ds);
    	assertEquals("U",p.createProfile(pro));
    }
    
    @Test
    public void findByIdTest() {
    	ProfileDaoImpl p=new ProfileDaoImpl(ds);
    	assertEquals(pro.getDateOfBirth(),p.findById("VK0000").getDateOfBirth());
    }
    
    @Test
    public void findAllTest() {
    	ProfileDaoImpl p=new ProfileDaoImpl(ds);
    	assertNull(p.findAll());
    }
    
    @Test
    public void updateTest() {
    	ProfileDaoImpl p=new ProfileDaoImpl(ds);
    	assertEquals(false,p.updateProfile(pro));
    }
}
