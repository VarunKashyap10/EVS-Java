package com.utl.evs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBUtil {
	
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	static PreparedStatement ppt;
	static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost/evs";
	static final String USER = "root";
	static final String PASS = "root";
	
	
	public static Connection getDBConnection() {
		System.out.println("GET Database connection");

		try {
			   Class.forName(JDBC_DRIVER);
			   System.out.println("Creating Database");
			   conn = DriverManager.getConnection(DB_URL, USER, PASS);
			   System.out.println(conn);
			   
			}
			catch(SQLException s) {
				System.out.println(s);
			}
			catch(ClassNotFoundException ex) {
			   System.out.println("Error: unable to load driver class!"+ex);
			   System.exit(1);
			   ex.printStackTrace();
			}
		catch(Exception e) {
			System.out.println(e);
		}
		return conn;
 
	}

}
