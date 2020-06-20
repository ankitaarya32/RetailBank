package com.FFFANS.util;


import java.sql.DriverManager;
import java.sql.*;


public class DatabaseUtil {
	public static Connection getconnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/retail_banking","root","ankit");
        System.out.println("Connection Success");}
    	 catch(ClassNotFoundException e) {
    		 e.printStackTrace();
    	 } 
      catch(SQLException e) {
    	  e.printStackTrace();
      }
     return con; 
      }
	
	
	
	
	
	public static void closeConnection(Connection con) {
		if(con!=null) {
			try {
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

public static void closeStatement(PreparedStatement ps) {
	if(ps!=null) {
		try {
			ps.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
}
