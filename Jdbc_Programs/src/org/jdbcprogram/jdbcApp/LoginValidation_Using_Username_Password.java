package org.jdbcprogram.jdbcApp;
import java.sql.*;
import java.util.*;
public class LoginValidation_Using_Username_Password 
{

	public static void main(String[] args) 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qry = "Select username from jspider.user where name=? and password=?";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name");
		String name = sc.next();
		System.out.println("Enter password");
		int password = sc.nextInt();
		sc.close();
    try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
		pstmt = con.prepareStatement(qry);
		pstmt.setString(1, name);
		pstmt.setInt(2, password);
		rs= pstmt.executeQuery();
		if(rs.next()) {
			String username = rs.getString(1);
			System.out.println("Welcome = "+username);
		}
		else {
			System.out.println("Invalid username");
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
