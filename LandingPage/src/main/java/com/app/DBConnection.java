package com.app;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	   private static final String URL = "jdbc:mysql://88.222.214.58:3306/flyinginvite_invitation";
	   private static final String USER = "root";
	   private static final String PASSWORD = "13Viraj@2507";

	    public static Connection getConnection() {
	        Connection con = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(URL, USER, PASSWORD);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return con;
	    }
	    
	   
}
