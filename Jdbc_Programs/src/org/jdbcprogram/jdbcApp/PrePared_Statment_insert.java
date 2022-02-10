package org.jdbcprogram.jdbcApp;
import java.sql.*;
public class PrePared_Statment_insert 
{

	public static void main(String[] args)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		String qry = "insert into btm.student value(?,?,?)";
     try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
		pstmt = con.prepareStatement(qry);
		pstmt.setInt(1, 5);
		pstmt.setString(2, "Dhanjee");
		pstmt.setDouble(3 ,76.55);
		pstmt.executeUpdate();
		System.out.println("Data insert using PrepareStatment");
	} 
     catch (ClassNotFoundException | SQLException e)
     {
		e.printStackTrace();
     	}
     finally {
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
     System.out.println("closed all costly resources");
	}

}
