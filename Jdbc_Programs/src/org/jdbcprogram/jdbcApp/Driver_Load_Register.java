package org.jdbcprogram.jdbcApp;

public class Driver_Load_Register {

	public static void main(String[] args)
	{
     try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver class load and register");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	}
}
