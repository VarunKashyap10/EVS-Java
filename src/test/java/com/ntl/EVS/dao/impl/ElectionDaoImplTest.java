package com.ntl.EVS.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;

import com.ntl.evs.bean.ElectionBean;
import com.ntl.evs.dao.impl.ElectionDaoImpl;

public class ElectionDaoImplTest {
	DataSource ds=mock(DataSource.class);
    Connection mockConn=mock(Connection.class);
    Statement mockCreateStmt=mock(Statement.class);
    ResultSet mockResultSet=mock(ResultSet.class);
    ElectionBean elec=new ElectionBean("election1","Election123",Date.valueOf("1997-03-30"),"dist","cons",Date.valueOf("1997-03-30"));

    @Before
    public void setUp() throws SQLException {
    	when(ds.getConnection()).thenReturn(mockConn);
        when(mockConn.createStatement()).thenReturn(mockCreateStmt);
        when(mockCreateStmt.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockCreateStmt.executeUpdate(anyString())).thenReturn(1);
        when(mockResultSet.next()).thenReturn(Boolean.TRUE,Boolean.FALSE);
        //elec = new ElectionBean(rs.getString("electionid"),rs.getString("name"),rs.getDate("electiondate")
        //,rs.getString("district"),rs.getString("constituency"),rs.getDate("countingdate"));

        when(mockResultSet.getString("electionid")).thenReturn("election1");
        when(mockResultSet.getString("name")).thenReturn("Election123");
        when(mockResultSet.getDate("electiondate")).thenReturn(Date.valueOf("1997-03-30"));
        when(mockResultSet.getString("district")).thenReturn("dist");
        when(mockResultSet.getString("constituency")).thenReturn("cons");
        when(mockResultSet.getDate("countingdate")).thenReturn(Date.valueOf("1997-03-30"));
    }
    
    @Test
    public void findAllTest() {
    	ElectionDaoImpl c=new ElectionDaoImpl(ds);
    	ArrayList<ElectionBean> arr=new ArrayList<ElectionBean>();
    	arr.add(elec);
    	for(ElectionBean e:arr) {
    		c.createElection(e);
    	}
    	assertEquals(arr.get(0).getElectionID(),c.findAll().get(0).getElectionID());
    }
    
    @Test
    public void findByIdTest() {
    	ElectionDaoImpl e=new ElectionDaoImpl(ds);
    	e.createElection(elec);
    	assertEquals(elec.getName(),e.findById("election1").getName());
    }
    
    @Test
    public void createElectionTest() {
    	ElectionDaoImpl e=new ElectionDaoImpl(ds);
    	assertEquals("SUCCESS",e.createElection(elec));
    }
    
    @Test
    public void deleteElectionsTest() {
    	ElectionDaoImpl e=new ElectionDaoImpl(ds);
    	ArrayList<String> arr=new ArrayList<String>();
    	arr.add("election1");
    	assertEquals(1,e.deleteElection(arr));
    }
}
