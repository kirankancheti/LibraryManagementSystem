package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

	static Connection conn = null;

	/**
	 * @param args
	 */
	public Connection  getConnection() {
		// Initialize variables for fields by data type

	

		try {

			Class.forName("com.mysql.jdbc.Driver"); 
            // Create a connection to the local MySQL server, with the "company" database selected.
            //        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "mypassword");
            // Create a connection to the local MySQL server, with the NO database selected.
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "kigosa842");
    
			System.out.println("Success!!");
		} catch (SQLException ex) {
			System.out.println("Error in connection establishing: "
					+ ex.getMessage());
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/*
  *
  */
	public void closeConnection(Connection conn) {

		try {
			conn.close();
			System.out.println("Connection closed Success!!");
		} catch (SQLException ex) {
			System.out.println("Error in connection closing: "
					+ ex.getMessage());
		}

	}
}
