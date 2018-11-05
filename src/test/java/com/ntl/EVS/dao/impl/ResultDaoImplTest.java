package com.ntl.EVS.dao.impl;

import static org.junit.Assert.assertNull;
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

import com.ntl.evs.dao.impl.EoDaoImpl;
import com.ntl.evs.dao.impl.ResultDaoImpl;
import com.utl.evs.util.DBUtil;

public class ResultDaoImplTest {
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
    public void findAllTest() {
    	//	public CandidateBean(String cid,String name, String eleId,String  partyId, String dist
    	//,String cons, Date dob,String mobile,String address,String email) {

    	ResultDaoImpl c=new ResultDaoImpl();
    	//ArrayList<ElectionBean> arr=new ArrayList<ElectionBean>();
    	//arr.add(new ElectionBean("as","asdf","asd","asd","asd","asda",Date.valueOf("1997-03-30"),"asdasd","Asd","asd"));
    	assertNull(c.findAll());
    }
}
