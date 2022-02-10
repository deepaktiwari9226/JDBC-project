package org.jdbcprogram.jdbcApp;
import java.sql.*;
public class Delete_Data
{
	public static void main(String[] args)
	{
		Connection con = null;
		Statement stmt = null;
		String qry ="delete from btm.student where roll_no=2";
     try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
		stmt=con.createStatement();
		stmt.execute(qry);
		System.out.println("Data Deletion");
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
