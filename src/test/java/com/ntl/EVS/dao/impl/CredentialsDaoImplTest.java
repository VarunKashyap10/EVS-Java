package com.ntl.EVS.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.mysql.cj.result.Field;
import com.ntl.evs.bean.CredentialsBean;
import com.ntl.evs.dao.impl.CredentialsDaoImpl;
import com.utl.evs.util.DBUtil;

public class CredentialsDaoImplTest {
 
    DBUtil mockDataSource=mock(DBUtil.class);
    Connection mockConn=mock(Connection.class);
    PreparedStatement mockPreparedStmnt=mock(PreparedStatement.class);
    Statement mockCreateStmt=mock(Statement.class);
    ResultSet mockResultSet=mock(ResultSet.class);
    @Before
    public void setUp() throws SQLException {
        //when(DBUtil.getDBConnection()).thenReturn(mockConn);
        //when(mockDataSource.getDBConnection(anyString(), anyString())).thenReturn(mockConn);
        //doNothing().when(mockConn).commit();
        when(mockConn.createStatement()).thenReturn(mockCreateStmt);
       // doNothing().when(mockCreateStmt).setString(anyInt(), anyString());
        when(mockCreateStmt.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockCreateStmt.executeUpdate(anyString())).thenReturn(1);

        //when(mockPreparedStmnt.getGeneratedKeys()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(Boolean.TRUE, Boolean.FALSE);
        //when(mockResultSet.getInt(Field.GENERATED_KEYS)).thenReturn(userId);
    }
    @Test
    public void findByIdTest() {
    	CredentialsDaoImpl c=new CredentialsDaoImpl();
    	CredentialsBean cr=new CredentialsBean("VK9999","qwerty1","A",0);
    	assertEquals(cr.getPassword(),c.findById("VK9999").getPassword());
    }
    
    @Test
    public void findAll() {
    	CredentialsDaoImpl c=new CredentialsDaoImpl();
    	assertNotNull(c.findAll());
    }
}
