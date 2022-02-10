package org.jdbcprogram.jdbcApp;

import java.sql.*;
import java.util.Scanner;
public class Particular_Record_Fetch_Placeholder
{

	public static void main(String[] args) 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qry  ="Select * from btm.student where roll_no = ?";
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter Roll No");
		int roll_no = sc.nextInt();
		sc.close();
     try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
		pstmt = con.prepareStatement(qry);
		pstmt.setInt(1, roll_no);
		rs =pstmt.executeQuery();
		if(rs.next()) {
			String name = rs.getString(2);
			double perc = rs.getDouble(3);
			System.out.println("Name = "+name);
			System.out.println("Percentage = "+perc);
		}
		else {
			System.out.println("No data found for RollNo"+roll_no);
		}
	}
     catch (ClassNotFoundException | SQLException e) 
     {
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
     System.out.println("Closed all costly resources");
	}
}
