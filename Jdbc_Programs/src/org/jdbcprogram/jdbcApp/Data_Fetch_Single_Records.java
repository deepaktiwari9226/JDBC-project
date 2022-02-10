package org.jdbcprogram.jdbcApp;
import java.sql.*;
public class Data_Fetch_Single_Records 
{
	public static void main(String[] args) 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qry = "Select * from btm.student";
     try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
		pstmt =con.prepareStatement(qry);
		rs =pstmt.executeQuery();
		if(rs.next()) {
			int roll_no =rs.getInt("roll_no");
			String name = rs.getString(2);
			double per = rs.getDouble(3);
			System.out.println("Roll no = "+roll_no);
			System.out.println("Name = "+name);
			System.out.println("Percentage = "+per);
		}
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
     finally {
    	 if(rs!=null) {
    		 try {
    			 rs.close();
    		 }
    		 catch(SQLException e) {
    			 e.printStackTrace();
    		 }
    	 }
    	 if(pstmt!=null) {
    		 try {
    			 pstmt.close();
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
     System.out.println("Closed all costly resource");
	}
}
