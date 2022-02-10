package org.jdbcprogram.jdbcApp;
import java.sql.*;
import java.util.Scanner;
public class Name_Using_Roll_Perc_Fetch 
{

	public static void main(String[] args)
	{ 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qry ="Select * from btm.student where name = ? ";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name");
		String name = sc.next();
		sc.close();
     try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
		pstmt = con.prepareStatement(qry);
		pstmt.setString(1, name);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			int roll_no =rs.getInt(1);
			double perc =rs.getDouble(3);
			System.out.println("Roll no ="+roll_no);
			System.out.println("Percentage = "+perc);
		}
		else {
			System.out.println("No data found for name "+name);
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
     System.out.println("Closed all costly resource");
	}
}
