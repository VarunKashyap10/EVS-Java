package com.ntl.EVS.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;

import com.ntl.evs.bean.PartyBean;
import com.ntl.evs.dao.impl.PartyDaoImpl;

public class PartyDaiImplTest {
	DataSource ds=mock(DataSource.class);
    Connection mockConn=mock(Connection.class);
    Statement mockCreateStmt=mock(Statement.class);
    ResultSet mockResultSet=mock(ResultSet.class);
    PartyBean par=new PartyBean("party1","PartyName","LeaderName","Symbol");
    
    @Before
    public void setUp() throws SQLException {
    	when(ds.getConnection()).thenReturn(mockConn);
    	when(mockConn.createStatement()).thenReturn(mockCreateStmt);
        when(mockCreateStmt.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockCreateStmt.executeUpdate(anyString())).thenReturn(1);
        when(mockResultSet.next()).thenReturn(Boolean.TRUE, Boolean.FALSE);
        //part = new PartyBean(rs.getString("partyid"),rs.getString("name"),rs.getString("leader"),rs.getString("symbol"));
        when(mockResultSet.getString("partyid")).thenReturn("party1");
        when(mockResultSet.getString("name")).thenReturn("PartyName");
        when(mockResultSet.getString("leader")).thenReturn("LeaderName");
        when(mockResultSet.getString("symbol")).thenReturn("Symbol");
    }
    
    @Test
    public void findAllTest() {
    	PartyDaoImpl pd=new PartyDaoImpl(ds);
    	assertEquals(par.getPartyID(),pd.findAll().get(0).getPartyID());
    }
    
    @Test
    public void findByIdTest() {
    	PartyDaoImpl pd=new PartyDaoImpl(ds);
    	assertEquals(par.getName(),pd.findById("party1").getName());
    }
    
    @Test
    public void createPartyTest() {
    	PartyDaoImpl pd=new PartyDaoImpl(ds);
    	assertEquals("SUCCESS",pd.createParty(par));
    }
    
    @Test
    public void deletePartyTest() {
    	PartyDaoImpl pd=new PartyDaoImpl(ds);
    	ArrayList<String> arr=new ArrayList<String>();
    	arr.add("party1");
    	assertEquals(0,pd.deleteParty(arr));
    }
    
    @Test
    public void updatePartyTest() {
    	PartyDaoImpl pd=new PartyDaoImpl(ds);
    	assertFalse(pd.updateParty(par));
    }
}

