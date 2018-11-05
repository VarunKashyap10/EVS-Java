package com.ntl.EVS.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

import com.ntl.evs.bean.ApplicationBean;
import com.ntl.evs.bean.CredentialsBean;
import com.ntl.evs.dao.impl.ApplicationDaoImpl;
import com.ntl.evs.dao.impl.CredentialsDaoImpl;
import com.utl.evs.util.DBUtil;

public class ApplicationDaoImplTest {
    DBUtil mockDataSource=mock(DBUtil.class);
    Connection mockConn=mock(Connection.class);
    PreparedStatement mockPreparedStmnt=mock(PreparedStatement.class);
    Statement mockCreateStmt=mock(Statement.class);
    ResultSet mockResultSet=mock(ResultSet.class);
    @Before
    public void setUp() throws SQLException {
        when(mockConn.createStatement()).thenReturn(mockCreateStmt);
        when(mockCreateStmt.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockCreateStmt.executeUpdate(anyString())).thenReturn(1);
        when(mockResultSet.next()).thenReturn(Boolean.TRUE, Boolean.FALSE);

    }
    
    @Test
    public void findByIdTest() {
    	ApplicationDaoImpl c=new ApplicationDaoImpl();
    	ApplicationBean cr=new ApplicationBean("VK9999","Delhi",1,0,"");
    	assertEquals(cr.getConstituency(),c.findById("VK9999").getConstituency());
    }
    
    @Test
    public void findAllTest() {
    	ApplicationDaoImpl c=new ApplicationDaoImpl();
    	assertEquals(null,c.findAll());
    }
    
    @Test
    public void updateApplicationTest() {
    	ApplicationDaoImpl c=new ApplicationDaoImpl();
    	ApplicationBean ab=new ApplicationBean("VK9999","Delhi",1,0,"");
    	assertEquals(true,c.updateApplication(ab));
    }
    @Test
    public void createApplicationTest() {
    	ApplicationDaoImpl c=new ApplicationDaoImpl();
    	ApplicationBean ab=new ApplicationBean("VK9999","Delhi",1,0,"");
    	assertEquals("U",c.createApplication(ab));
    }
}
