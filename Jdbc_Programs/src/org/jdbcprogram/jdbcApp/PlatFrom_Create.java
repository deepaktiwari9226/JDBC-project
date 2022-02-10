package org.jdbcprogram.jdbcApp;
import java.sql.*;
public class PlatFrom_Create {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt=null;
     try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
       con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
		System.out.println("Estabhlish Connection with database server");
		stmt=con.createStatement();
		System.out.println("Platfrom Created");
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
