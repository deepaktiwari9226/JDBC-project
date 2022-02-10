package org.jdbcprogram.jdbcApp;

import java.sql.*;

public class Update_Record 
{
	public static void main(String[] args)
	{
		Connection con = null;
		Statement stmt = null;
		String qry ="update btm.student set roll_no=2 where name='Dev'";
    try
    {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
		stmt=con.createStatement();
		stmt.execute(qry);
		System.out.println("Data Updated");
	}
    catch (ClassNotFoundException | SQLException e) 
    {
		e.printStackTrace();
	  }
    finally {
    	if(stmt!=null) {
    		try {
    			stmt.close();
    		}
    		catch(SQLException e) {
    			e.printStackTrace();
    		}
    	}
    	if(con!=null) {
    		try {
    			con.close();
    		}
    		catch(SQLException e) {
    			e.printStackTrace();
    		}
    	}
    }
	}
}
