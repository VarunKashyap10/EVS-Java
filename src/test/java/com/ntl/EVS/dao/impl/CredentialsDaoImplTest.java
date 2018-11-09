package com.ntl.EVS.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import org.junit.Before;
import org.junit.Test;
import com.ntl.evs.bean.CredentialsBean;
import com.ntl.evs.dao.impl.CredentialsDaoImpl;

public class CredentialsDaoImplTest {
	DataSource ds=mock(DataSource.class);
    Connection mockConn=mock(Connection.class);
    Statement mockCreateStmt=mock(Statement.class);
    ResultSet mockResultSet=mock(ResultSet.class);
	CredentialsBean cr=new CredentialsBean("VK9989","qwerty1","A",0);
    @Before
    public void setUp() throws SQLException {
    	when(ds.getConnection()).thenReturn(mockConn);
        when(mockConn.createStatement()).thenReturn(mockCreateStmt);

        when(mockCreateStmt.executeUpdate(anyString())).thenReturn(1);
        //rs.getString("userid"),rs.getString("password"),rs.getString("userType"),rs.getInt("loginStatus")
        when(mockResultSet.getString("userid")).thenReturn("VK9999");
        when(mockResultSet.getString("password")).thenReturn("qwerty1");
        when(mockResultSet.getString("userType")).thenReturn("A");
        when(mockResultSet.getInt("loginStatus")).thenReturn(0);
        when(mockResultSet.next()).thenReturn(Boolean.TRUE);
        when(mockCreateStmt.executeQuery(anyString())).thenReturn(mockResultSet);
    }
    @Test
    public void findByIdTest() {
    	CredentialsDaoImpl c=new CredentialsDaoImpl(ds);
    	assertEquals(cr.getPassword(),c.findById("VK9999").getPassword());
    }
    
    @Test
    public void findAllTest() {
    	CredentialsDaoImpl c=new CredentialsDaoImpl(ds);
    	c.createCredentials(cr);
    	assertNull(c.findAll());
    }
    @Test
    public void createCredentialsTest() {
    	CredentialsDaoImpl c=new CredentialsDaoImpl(ds);
    	assertEquals("U",c.createCredentials(cr));
    }
    @Test
    public void updateCredentialsTest() {

    	CredentialsDaoImpl c=new CredentialsDaoImpl(ds);
    	assertEquals(true,c.updateCredentials(cr));
    }
    
}
