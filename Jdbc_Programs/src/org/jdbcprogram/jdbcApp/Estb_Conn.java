package org.jdbcprogram.jdbcApp;
import java.sql.*;
public class Estb_Conn
{
	public static void main(String[] args) 
	{
     Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver  Class load & Register");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection Estabhlish with database server");
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally {
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



