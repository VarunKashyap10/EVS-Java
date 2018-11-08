package com.ntl.EVS.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;

import com.ntl.evs.bean.ApplicationBean;
import com.ntl.evs.dao.impl.ApplicationDaoImpl;

public class ApplicationDaoImplTest {
	
	DataSource ds=mock(DataSource.class);
    Connection mockConn=mock(Connection.class);
    Statement mockCreateStmt=mock(Statement.class);
    ResultSet mockResultSet=mock(ResultSet.class);
	ApplicationBean app=new ApplicationBean("VK9999","Delhi",1,0,"");
    @Before
    public void setUp() throws SQLException {
    	when(ds.getConnection()).thenReturn(mockConn);
        when(mockConn.createStatement()).thenReturn(mockCreateStmt);
        when(mockCreateStmt.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockCreateStmt.executeUpdate(anyString())).thenReturn(1);
        when(mockResultSet.next()).thenReturn(Boolean.TRUE, Boolean.FALSE);
        //app = new ApplicationBean(rs.getString("userid"),rs.getString("constituency"),rs.getInt("passedstatus"),
        //rs.getInt("approvedstatus"),rs.getString("voteid"));

        when(mockResultSet.getString("userid")).thenReturn("VK9999");
        when(mockResultSet.getString("constituency")).thenReturn("Delhi");
        when(mockResultSet.getInt("passedstatus")).thenReturn(1);
        when(mockResultSet.getInt("approvedstatus")).thenReturn(0);
        when(mockResultSet.getString("voteid")).thenReturn("");

    }
    
    @Test
    public void findByIdTest() {
    	ApplicationDaoImpl c=new ApplicationDaoImpl(ds);
    	//ApplicationBean cr=new ApplicationBean("VK9999","Delhi",1,0,"");
    	assertEquals(app.getConstituency(),c.findById("VK9999").getConstituency());
    }
    
    @Test
    public void findAllTest() {
    	ApplicationDaoImpl c=new ApplicationDaoImpl(ds);
    	assertEquals(app.getUserID(),c.findAll().get(0).getUserID());
    }
    
    @Test
    public void updateApplicationTest() {
    	ApplicationDaoImpl c=new ApplicationDaoImpl(ds);
    	//ApplicationBean ab=new ApplicationBean("VK9999","Delhi",1,0,"");
    	assertEquals(true,c.updateApplication(app));
    }
    @Test
    public void createApplicationTest() {
    	ApplicationDaoImpl c=new ApplicationDaoImpl(ds);
    	//ApplicationBean ab=new ApplicationBean("VK9999","Delhi",1,0,"");
    	assertEquals("SUCCESS",c.createApplication(app));
    }
}
