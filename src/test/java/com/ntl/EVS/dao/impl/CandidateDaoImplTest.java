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
import java.util.ArrayList;
//import java.util.Date;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;

import com.ntl.evs.bean.CandidateBean;
import com.ntl.evs.bean.ElectionBean;
import com.ntl.evs.bean.PartyBean;
import com.ntl.evs.dao.impl.CandidateDaoImpl;
import com.ntl.evs.dao.impl.ElectionDaoImpl;

public class CandidateDaoImplTest {
	DataSource ds=mock(DataSource.class);
    Connection mockConn=mock(Connection.class);
    Statement mockCreateStmt=mock(Statement.class);
    ResultSet rs=mock(ResultSet.class);
   
    CandidateBean can=new CandidateBean("candidate1","CandidateName","election1","party1","dist","cons",Date.valueOf("1997-03-30"),"9999999999","add","email");
    ElectionBean elec=new ElectionBean("election1","Election123",Date.valueOf("1997-03-30"),"dist","cons",Date.valueOf("1997-03-30"));
    PartyBean par=new PartyBean("party1","Asd","asd","123");
    @Before
    public void setUp() throws SQLException {
    	when(ds.getConnection()).thenReturn(mockConn);
        when(mockConn.createStatement()).thenReturn(mockCreateStmt);
        when(mockCreateStmt.executeQuery(anyString())).thenReturn(rs);
        when(mockCreateStmt.executeUpdate(anyString())).thenReturn(1);
        when(rs.next()).thenReturn(Boolean.TRUE,Boolean.FALSE);
        //arr.add(new CandidateBean(rs.getString("candidateid"),rs.getString("name"),rs.getString("electionid"),
        //rs.getString("partyid"),rs.getString("district"),rs.getString("constituency"),rs.getDate("dateofbirth"),
        //rs.getString("mobileno"),rs.getString("address"),rs.getString("emailid")));

        when(rs.getString("candidateid")).thenReturn("candidate1");
        when(rs.getString("name")).thenReturn("CandidateName");
        when(rs.getString("electionid")).thenReturn("election1");
        when(rs.getString("partyid")).thenReturn("party1");
        when(rs.getString("district")).thenReturn("dist");
        when(rs.getString("constituency")).thenReturn("cons");
        when(rs.getDate("dateofbirth")).thenReturn(Date.valueOf("1997-03-30"));
        when(rs.getString("mobileno")).thenReturn("9999999999");
        when(rs.getString("address")).thenReturn("add");
        when(rs.getString("emailid")).thenReturn("email");



        
    }
    
    @Test
    public void findAllTest() {
    	CandidateDaoImpl c=new CandidateDaoImpl(ds);
    	ArrayList<CandidateBean> arr=new ArrayList<CandidateBean>();
    	arr.add(can);
    	c.createCandidate(arr.get(0));
    	assertEquals(arr.get(0).getCandidateID(),c.findAll().get(0).getCandidateID());
    }
    
    @Test
    public void findByIdTest() {
    	CandidateDaoImpl c=new CandidateDaoImpl(ds);
    	assertNull(c.findById(""));
    }
    
    @Test
    public void findByElectionNameTest() {
    	CandidateDaoImpl c=new CandidateDaoImpl(ds);
    	ArrayList<CandidateBean> arr=new ArrayList<CandidateBean>();
    	arr.add(can);
    	c.createCandidate(arr.get(0));
    	ElectionDaoImpl ele=new ElectionDaoImpl(ds);
    	ele.createElection(elec);
    	assertEquals(arr.get(0).getElectionID(),c.findByElectionName("Election123").get(0).getElectionID());
    }
    
    @Test
    public void createCandidateTest() {
    	CandidateDaoImpl c=new CandidateDaoImpl(ds);
    	assertEquals("SUCCESS",c.createCandidate(can));
    }
    
   

}
