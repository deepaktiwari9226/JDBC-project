package org.jdbcprogram.jdbcApp;
import java.sql.*;
import java.util.Scanner;
public class LoginValidation 
{
	public static void main(String[] args)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qry = "Select username , password from jspider.user where name=?";
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
		String username =rs.getString(1);	
		System.out.println("Welcome  user = "+username);
		Long password = rs.getLong(2);
		System.out.println("Welcome password = "+password);
		}
		else {
			System.out.println("Invalid  name");
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
     System.out.println("closed all costly resource");
	}

}
