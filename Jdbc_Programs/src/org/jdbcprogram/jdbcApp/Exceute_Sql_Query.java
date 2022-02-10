package org.jdbcprogram.jdbcApp;
import java.sql.*;
public class Exceute_Sql_Query {

	public static void main(String[] args) 
	{
		Connection con = null;
		Statement stmt = null;
		String qry1 ="insert into btm.student values(3,'Dev',50.66)";
     try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver Class loaded");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
		System.out.println("Estabhlish connection with database server");
		stmt=con.createStatement();
		System.out.println("Platfrom Created");
		stmt.executeUpdate(qry1);
		System.out.println("Data inserted");
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
    	 System.out.println("Closed all costly resource");
     }
     
	 }
	}
}
